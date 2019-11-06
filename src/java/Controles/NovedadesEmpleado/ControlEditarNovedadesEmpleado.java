
package Controles.NovedadesEmpleado;

import Modelos.Conectar;
import Modelos.NovedadesEmpleado.NovedadesEmpleado;
import Modelos.NovedadesEmpleado.NovedadesEmpleadoValidacion;
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
@RequestMapping("editarnovedadesempleado.htm")
public class ControlEditarNovedadesEmpleado {
    
    NovedadesEmpleadoValidacion novedadesEmpleadoValidacion;
    private JdbcTemplate jdbcTemplate;
    
    ControlEditarNovedadesEmpleado(){
        
        this.novedadesEmpleadoValidacion=new NovedadesEmpleadoValidacion();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView novedadesEmpleado(HttpServletRequest request){
        
        ModelAndView mav=new ModelAndView();
        int id_novedad_empleado=Integer.parseInt(request.getParameter("id_novedad_empleado"));
        NovedadesEmpleado datos=this.selectNovedadesEmpleado(id_novedad_empleado);
        mav.setViewName("editarnovedadesempleado");
        mav.addObject("novedadesempleado",new NovedadesEmpleado(id_novedad_empleado,
        datos.getId_empleado(),datos.getDetalle(),datos.getTipo(),datos.getFecha()));
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView novedadesEmpleado(@ModelAttribute("novedadesempleado")NovedadesEmpleado ne,
    BindingResult result, SessionStatus status, HttpServletRequest request ){
        
        this.novedadesEmpleadoValidacion.validate(ne, result);
        if(result.hasErrors()){
            
            ModelAndView mav=new ModelAndView();
            int id_novedad_empleado=Integer.parseInt(request.getParameter("id_novedad_empleado"));
            NovedadesEmpleado datos=this.selectNovedadesEmpleado(id_novedad_empleado);
            mav.setViewName("editarnovedadesempleado");
            mav.addObject("novedadesempleado", new NovedadesEmpleado(id_novedad_empleado,
            datos.getId_empleado(),datos.getDetalle(),datos.getTipo(),datos.getFecha()));
            return mav;
            
        }else{
            
            int id_novedad_empleado=Integer.parseInt(request.getParameter("id_novedad_empleado"));
            this.jdbcTemplate.update("update nm_novedades_empleado set id_empleado=?, "
            + "detalle=?, tipo=?, fecha=? where id_novedad_empleado=?",ne.getId_empleado(),
            ne.getDetalle(),ne.getTipo(),ne.getFecha(),id_novedad_empleado);
            return new ModelAndView("redirect:/novedadesempleado.htm");
            
        }
    }
    
    public NovedadesEmpleado selectNovedadesEmpleado(int id_novedad_empleado){
        
        final NovedadesEmpleado nove=new NovedadesEmpleado();
        String quer="select * from nm_novedades_empleado where id_novedad_empleado='"
        +id_novedad_empleado+"'";
        return (NovedadesEmpleado)jdbcTemplate.query(quer, new ResultSetExtractor<NovedadesEmpleado>(){
            public NovedadesEmpleado extractData(ResultSet rs)throws SQLException,DataAccessException{
               if(rs.next()){
                   nove.setId_empleado(rs.getInt("id_empleado"));
                   nove.setDetalle(rs.getString("detalle"));
                   nove.setTipo(rs.getInt("tipo"));
                   nove.setFecha(rs.getString("fecha"));
               } 
               return nove;
            }
        });
    }
}
