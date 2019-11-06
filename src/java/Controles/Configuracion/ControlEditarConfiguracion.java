
package Controles.Configuracion;

import Modelos.Conectar;
import Modelos.Configuracion.Configuracion;
import Modelos.Configuracion.ConfiguracionValidacion;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("editarconfiguracion.htm")
public class ControlEditarConfiguracion {
    
    ConfiguracionValidacion configuracionValidacion;
    private JdbcTemplate jdbcTemplate;
    
    public ControlEditarConfiguracion(){
        
        this.configuracionValidacion=new ConfiguracionValidacion();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView configuracion(HttpServletRequest request){
        
        ModelAndView mav=new ModelAndView();
        int id_configuracion=Integer.parseInt(request.getParameter("id_configuracion"));
        Configuracion datos=this.selectConfiguracion(id_configuracion);
        mav.setViewName("editarconfiguracion");
        mav.addObject("configuracion",new Configuracion(id_configuracion,datos.getDesconfiguracion(),
        datos.getDesconfiguracion_d(),datos.getNombre_variable(),datos.getValor(),
        datos.getId_modulo()));
        return mav;
 
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView configuracion(@ModelAttribute("configuracion") Configuracion c,
    BindingResult result, SessionStatus status, HttpServletRequest request){
        
        this.configuracionValidacion.validate(c, result);
        if(result.hasErrors()){
            
            ModelAndView mav=new ModelAndView();
            int id_configuracion=Integer.parseInt(request.getParameter("id_configuracion"));
            Configuracion datos=this.selectConfiguracion(id_configuracion);
            mav.setViewName("editarconfiguracion");
            mav.addObject("configuracion",new Configuracion(id_configuracion,datos.getDesconfiguracion(),
            datos.getDesconfiguracion_d(),datos.getNombre_variable(),datos.getValor(),
            datos.getId_modulo()));
            return mav;
        }else{
            
            int id_configuracion=Integer.parseInt(request.getParameter("id_configuracion"));
            this.jdbcTemplate.update("update configuracion set desconfiguracion=?, "
            +"desconfiguracion_d=?, nombre_variable=?, valor=?, id_modulo=? where "
            +"id_configuracion=?", c.getDesconfiguracion(),c.getDesconfiguracion_d(),
            c.getNombre_variable(),c.getValor(),c.getId_modulo(),id_configuracion);
            return new ModelAndView("redirect:/configuracion.htm");
        }
    }
    
    public Configuracion selectConfiguracion(int id_configuracion){
        
        final Configuracion conf=new Configuracion();
        String quer=" select * from configuracion where id_configuracion='"+id_configuracion+"'";
        return (Configuracion)jdbcTemplate.query(quer, new ResultSetExtractor<Configuracion>(){
            public Configuracion extractData(ResultSet rs)throws SQLException, DataAccessException{
                if(rs.next()){
                    conf.setDesconfiguracion(rs.getString("desconfiguracion"));
                    conf.setDesconfiguracion_d(rs.getString("desconfiguracion_d"));
                    conf.setNombre_variable(rs.getString("nombre_variable"));
                    conf.setValor(rs.getInt("valor"));
                    conf.setId_modulo(rs.getInt("id_modulo"));
                }
                return conf;
            } 
        });
    } 
}
