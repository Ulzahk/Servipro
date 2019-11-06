
package Controles.Usuarios;

import Modelos.Conectar;
import Modelos.Usuarios.Usuarios;
import Modelos.Usuarios.UsuariosValidacion;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("agregarusuarios")
public class ControlAgregarUsuarios {
    
    UsuariosValidacion usuariosValidacion;
    private JdbcTemplate jdbcTemplate;
    
    public ControlAgregarUsuarios(){
        
        this.usuariosValidacion=new UsuariosValidacion();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
               
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView usuarios(){
        
        ModelAndView mav=new ModelAndView();
        mav.setViewName("agregarusuarios");
        mav.addObject("usuarios", new Usuarios());
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView usuarios(@ModelAttribute("usuarios")Usuarios u,
    BindingResult result, SessionStatus status){
        
        this.usuariosValidacion.validate(u, result);
        if(result.hasErrors()){
            
            ModelAndView mav=new ModelAndView();
            mav.setViewName("agregarusuarios");
            mav.addObject("usuarios", new Usuarios());
            return mav;
            
        }else{
            
            this.jdbcTemplate.update("insert into usuarios(id_usuario,id_empleado,contraseña,id_perfil) "
            +"values(?,?,?,?)",u.getId_usuario(),u.getId_empleado(),u.getContraseña(),
            u.getId_perfil());
            return new ModelAndView("redirect:/usuarios.htm");
        }
    }
    
    
}
