
package Controles.Estadisticas;

import Modelos.Conectar;
import Modelos.Estadisticas.Estadisticas;
import Modelos.Estadisticas.EstadisticasValidacion;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class ControlAgregarEstadisticas {
    
    EstadisticasValidacion estadisticasValidacion;
    private JdbcTemplate jdbcTemplate;
    
    public ControlAgregarEstadisticas(){
        
        this.estadisticasValidacion=new EstadisticasValidacion();
        Conectar con= new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView estadisticas(){
        
        ModelAndView mav= new ModelAndView();
        mav.setViewName("agregarestadisticas");
        mav.addObject("estadisticas", new Estadisticas());
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView estadisticas (@ModelAttribute("estadisticas")Estadisticas est,
            BindingResult result, SessionStatus status){
        
        this.estadisticasValidacion.validate(est, result);
        if(result.hasErrors())
        {
            
            ModelAndView mav= new ModelAndView();
            mav.setViewName("agregarestadisticas");
            mav.addObject("estadisticas", new Estadisticas());
            return mav;
            
        }
        else
        {
            this.jdbcTemplate.update(
            "insert into nm_estadistica (id_empleado, id_dia1, id_dia2, id_dia3, id_dia4, id_dia5, "
                    + "id_dia6, id_dia7, id_dia8, id_dia9, id_dia10, id_dia11, id_dia12, id_dia13, "
                    + "id_dia14, id_dia15, id_dia16, id_dia17, id_dia18, id_dia19, id_dia20, id_dia21, "
                    + "id_dia22, id_dia23, id_dia24, id_dia25, id_dia26, id_dia27, id_dia28, id_dia29, "
                    + "id_dia30 value (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                    est.getId_empleado(), est.getId_dia1(), est.getId_dia2(), est.getId_dia3(), est.getId_dia4(), 
                    est.getId_dia5(), est.getId_dia6(), est.getId_dia7(), est.getId_dia8(), est.getId_dia9(), est.getId_dia10(),
                    est.getId_dia11(), est.getId_dia12(), est.getId_dia13(), est.getId_dia14(), est.getId_dia15(), 
                    est.getId_dia16(), est.getId_dia16(), est.getId_dia17(), est.getId_dia18(), est.getId_dia19(), 
                    est.getId_dia20(), est.getId_dia21(), est.getId_dia22(), est.getId_dia23(), est.getId_dia24(), 
                    est.getId_dia25(), est.getId_dia26(), est.getId_dia26(), est.getId_dia27(), est.getId_dia28(), 
                    est.getId_dia29(), est.getId_dia30());
            return new ModelAndView("redirect:/estadisticas.htm");
        }
    }
}
