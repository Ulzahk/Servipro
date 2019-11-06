
package Controles.Perfil;

import Modelos.Conectar;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ControlConfirmarEliminarPerfil {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlConfirmarEliminarPerfil(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    
    
    @RequestMapping("confirmareliminarperfil.htm")
    public ModelAndView perfil(HttpServletRequest request){
        {
            int id_perfil=Integer.parseInt(request.getParameter("id_perfil"));
            this.jdbcTemplate.update("delete from nm_perfil "+ "where "+"id_perfil=?",id_perfil);
            return new ModelAndView("redirect:/perfil.htm");
        }
    } 
}

