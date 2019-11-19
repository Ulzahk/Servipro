
package Controles.Modulos;

import Modelos.Conectar;
import Modelos.Modulos.Modulos;
import Modelos.Modulos.ModulosValidacion;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("agregarmodulos.htm")
public class ControlAgregarModulos {
    
    ModulosValidacion modulosValidacion;
    private JdbcTemplate jdbcTemplate;
    
    public ControlAgregarModulos(){
        
        this.modulosValidacion=new ModulosValidacion();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView modulos(){
        
        ModelAndView mav=new ModelAndView();
        mav.setViewName("agregarmodulos");
        mav.addObject("modulos", new Modulos());
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView modulos(@ModelAttribute("modulos") Modulos mod,
    BindingResult result, SessionStatus status){
        
        this.modulosValidacion.validate(mod, result);
        if(result.hasErrors()){
            
            ModelAndView mav=new ModelAndView();
            mav.setViewName("agregarmodulos");
            mav.addObject("modulos", new Modulos());
            return mav;
            
        }else{
            
            this.jdbcTemplate.update(
            "insert into nm_modulos (nombre_modulo)values(?)",
            mod.getNombre_modulo());
            return new ModelAndView("redirect:/modulos.htm");
        }
        
    }
}
    
