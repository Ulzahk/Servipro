
package Controles.Grupos;

import Modelos.Conectar;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ControlConfirmarEliminarGrupos {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlConfirmarEliminarGrupos(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping("confirmareliminargrupos.htm")
    public ModelAndView grupos(HttpServletRequest request){
        
        int id_grupo=Integer.parseInt(request.getParameter("id_grupo"));
        this.jdbcTemplate.update("delete from grupos where id_grupo=?",id_grupo);
        return new ModelAndView("redirect:/grupos.htm");
        
    }
}