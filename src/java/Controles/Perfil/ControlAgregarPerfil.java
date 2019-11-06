
package Controles.Perfil;

import Modelos.Conectar;
import Modelos.Perfil.Perfil;
import Modelos.Perfil.PerfilValidacion;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("agregarperfil")
public class ControlAgregarPerfil {
    
    PerfilValidacion perfilValidacion;
    private JdbcTemplate jdbcTemplate;
    
    public ControlAgregarPerfil(){
        
        this.perfilValidacion=new PerfilValidacion();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView perfil(){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("agregarperfil");
        mav.addObject("perfil", new Perfil());
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView perfil(@ModelAttribute("perfil")Perfil p,
    BindingResult result, SessionStatus status){
      
        this.perfilValidacion.validate(p, result);
        if(result.hasErrors()){
            
            ModelAndView mav=new ModelAndView();
            mav.setViewName("agregarperfil");
            mav.addObject("perfil", new Perfil());
            return mav;
        }else{
            this.jdbcTemplate.update(
            "insert into perfil(descripcion_perfil)values(?)",
            p.getDescripcion_perfil());
            return new ModelAndView("redirect:/perfil.htm");
        }  
    }  
}