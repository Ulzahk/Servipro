
package Controles.Grupos;

import Modelos.Conectar;
import Modelos.Grupos.Grupos;
import Modelos.Grupos.GruposValidacion;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("agregargrupos.htm")
public class ControlAgregarGrupos {
    
    GruposValidacion gruposValidacion;
    private JdbcTemplate jdbcTemplate;
    
    public ControlAgregarGrupos(){
        
        this.gruposValidacion=new GruposValidacion();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView grupos(){
        
        ModelAndView mav=new ModelAndView();
        mav.setViewName("agregargrupos");
        mav.addObject("grupos",new Grupos());
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView grupos(@ModelAttribute("grupos") Grupos grup,
    BindingResult result, SessionStatus status){
        
        this.gruposValidacion.validate(grup, result);
        if(result.hasErrors()){
            
            ModelAndView mav=new ModelAndView();
            mav.setViewName("agregargrupos");
            mav.addObject("grupos", new Grupos());
            return mav;
            
        }else{
            
            this.jdbcTemplate.update("insert into nm_grupos(nombre_grupo)values(?)",
            grup.getNombre_grupo());
            return new ModelAndView("redirect:/grupos.htm");
            
        }
    }
}
