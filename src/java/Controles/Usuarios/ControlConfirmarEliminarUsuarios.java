
package Controles.Usuarios;

import Modelos.Conectar;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


public class ControlConfirmarEliminarUsuarios {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlConfirmarEliminarUsuarios(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping("confirmareliminarusuarios.htm")
    public ModelAndView usuarios(HttpServletRequest request){
        
        String id_usuario=request.getParameter("id_usuario");
        this.jdbcTemplate.update("delete from nm_usuarios where id_usuario=?",id_usuario);
        return new ModelAndView("redirect:/usuarios.htm");
        
    }
    
}