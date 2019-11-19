
package Controles.Modulos;

import Modelos.Conectar;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


public class ControlConfirmarEliminarModulos {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlConfirmarEliminarModulos(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping("confirmareliminarmodulos.htm")
    public ModelAndView modulos(HttpServletRequest request){
        
        int id_modulo=Integer.parseInt(request.getParameter("id_modulo"));
        this.jdbcTemplate.update("delete from nm_modulos where id_modulo=?",id_modulo);
        return new ModelAndView("redirect:/modulos.htm");
        
    }
}