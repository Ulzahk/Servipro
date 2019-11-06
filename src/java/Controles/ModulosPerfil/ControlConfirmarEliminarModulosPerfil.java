
package Controles.ModulosPerfil;

import Modelos.Conectar;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


public class ControlConfirmarEliminarModulosPerfil {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlConfirmarEliminarModulosPerfil(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping("confirmareliminarmodulosperfil.htm")
    public ModelAndView modulosPerfil(HttpServletRequest request){
        
        int id_modulo_perfil=Integer.parseInt(request.getParameter("id_modulo_perfil"));
        this.jdbcTemplate.update("delete from nm_modulos_perfil where id_modulo_perfil=?",id_modulo_perfil);
        return new ModelAndView("redirect:/modulosperfil.htm");
        
    }
}
