
package Controles.Modulos;

import Modelos.Conectar;
import Modelos.Modulos.Modulos;
import Modelos.Modulos.ModulosValidacion;
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
@RequestMapping("editarmodulos.htm")
public class ControlEditarModulos {
    
    ModulosValidacion modulosValidacion;
    private JdbcTemplate jdbcTemplate;
    
    public ControlEditarModulos(){
        
        this.modulosValidacion=new ModulosValidacion();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView modulos(HttpServletRequest request){
        
        ModelAndView mav=new ModelAndView();
        int id_modulo=Integer.parseInt(request.getParameter("id_modulo"));
        Modulos datos=this.selectModulos(id_modulo);
        mav.setViewName("editarmodulos");
        mav.addObject("modulos", new Modulos(id_modulo,datos.getNombre_modulo()));
        return mav;
        
    }
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView modulos(@ModelAttribute("modulos") Modulos mod,
    BindingResult result, SessionStatus status, HttpServletRequest request){
        
        this.modulosValidacion.validate(mod, result);
        if(result.hasErrors()){
            
            ModelAndView mav=new ModelAndView();
            int id_modulo=Integer.parseInt(request.getParameter("id_modulo"));
            Modulos datos=this.selectModulos(id_modulo);
            mav.setViewName("editarmodulos");
            mav.addObject("modulos",new Modulos(id_modulo,datos.getNombre_modulo()));
            return mav;
        }else{
            int id_modulo=Integer.parseInt(request.getParameter("id_modulo"));
            this.jdbcTemplate.update("update nm_modulos set nombre_modulo=? "+
            "where id_modulo=?",mod.getNombre_modulo(),id_modulo);
            return new ModelAndView("redirect:/modulos.htm");
        }
    }
    
    public Modulos selectModulos(int id_modulo){
        
        final Modulos modu=new Modulos();
        String quer="select * from nm_modulos where id_modulo='"+id_modulo+"'";
        return (Modulos)jdbcTemplate.query(quer, new ResultSetExtractor<Modulos>(){
            public Modulos extractData(ResultSet rs)throws SQLException, DataAccessException{
                if(rs.next()){
                    modu.setNombre_modulo(rs.getString("nombre_modulo"));
                }
                return modu;
            }
        });
    }
}
