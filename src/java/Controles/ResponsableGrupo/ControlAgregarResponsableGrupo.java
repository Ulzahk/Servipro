
package Controles.ResponsableGrupo;

import Modelos.Conectar;
import Modelos.ResponsableGrupo.ResponsableGrupo;
import Modelos.ResponsableGrupo.ResponsableGrupoValidacion;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("agregarresponsablegrupo.htm")
public class ControlAgregarResponsableGrupo {
    
    ResponsableGrupoValidacion responsableGrupoValidacion;
    private JdbcTemplate jdbcTemplate;
    
    public ControlAgregarResponsableGrupo(){
        
        this.responsableGrupoValidacion=new ResponsableGrupoValidacion();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView responsableGrupo(){
        
        ModelAndView mav=new ModelAndView();
        mav.setViewName("agregarresponsablegrupo");
        mav.addObject("responsablegrupo", new ResponsableGrupo());
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView responsableGrupos(@ModelAttribute("responsablegrupo")ResponsableGrupo rg,
    BindingResult result, SessionStatus status){
        
        this.responsableGrupoValidacion.validate(rg, result);
        if(result.hasErrors()){
            
            ModelAndView mav=new ModelAndView();
            mav.setViewName("agregarresponsablegrupo");
            mav.addObject("responsablegrupo", new ResponsableGrupo());
            return mav;
            
        }else{
            
            this.jdbcTemplate.update("insert into nm_responsable_grupo(id_grupo, id_usuario)"
            + "values(?,?)",rg.getId_grupo(),rg.getId_usuario());
            return new ModelAndView("redirect:/responsablegrupo.htm");
            
        }
    }
}
