
package Controles.Novedades;

import Modelos.Conectar;
import Modelos.Novedades.Novedades;
import Modelos.Novedades.NovedadesValidacion;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("agregarnovedades.htm")
public class ControlAgregarNovedades {
    
    NovedadesValidacion novedadesValidacion;
    private JdbcTemplate jdbcTemplate;
    
    public ControlAgregarNovedades(){
        
        this.novedadesValidacion=new NovedadesValidacion();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView novedades(){
        
        ModelAndView mav=new ModelAndView();
        mav.setViewName("agregarnovedades");
        mav.addObject("novedades", new Novedades());
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView novedades(@ModelAttribute("novedades")Novedades n,
    BindingResult result, SessionStatus status){
        
        this.novedadesValidacion.validate(n, result);
        if(result.hasErrors()){
            
            ModelAndView mav=new ModelAndView();
            mav.setViewName("agregarnovedades");
            mav.addObject("novedades",new Novedades());
            return mav;
            
        }else{
            
            this.jdbcTemplate.update("insert into nm_novedades(descripcion, alias) "
            +"values(?,?)", n.getDescripcion(), n.getAlias());
            return new ModelAndView("redirect:/novedades.htm");
                    
        }
    }
}
