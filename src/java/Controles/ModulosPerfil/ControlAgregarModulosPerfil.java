
package Controles.ModulosPerfil;

import Modelos.Conectar;
import Modelos.ModulosPerfil.ModulosPerfil;
import Modelos.ModulosPerfil.ModulosPerfilValidacion;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("agregarmodulosperfil.htm")
public class ControlAgregarModulosPerfil {
    
    ModulosPerfilValidacion modulosPerfilValidacion;
    private JdbcTemplate jdbcTemplate;
    
    public ControlAgregarModulosPerfil(){
        
        this.modulosPerfilValidacion=new ModulosPerfilValidacion();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView modulosPerfil(){
        
        ModelAndView mav=new ModelAndView();
        mav.setViewName("agregarmodulosperfil");
        mav.addObject("modulosperfil", new ModulosPerfil());
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView modulosPerfil(@ModelAttribute("modulosperfil") ModulosPerfil mp,
    BindingResult result, SessionStatus status){
        
        this.modulosPerfilValidacion.validate(mp, result);
        if(result.hasErrors()){
            
            ModelAndView mav=new ModelAndView();
            mav.setViewName("agregarmodulosperfil");
            mav.addObject("modulosperfil", new ModulosPerfil());
            return mav;
            
        }else{
            
            this.jdbcTemplate.update("insert into nm_modulos_perfil(id_modulo, id_perfil)"
            +"values(?,?)", mp.getId_modulo(), mp.getId_perfil());
            return new ModelAndView("redirect:/modulosperfil.htm");
                    
        }
    }
    
}
