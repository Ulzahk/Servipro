
package Controles.ResponsableGrupo;

import Modelos.Conectar;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


public class ControlConfirmarEliminarResponsableGrupo {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlConfirmarEliminarResponsableGrupo(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping("confirmareliminarresponsablegrupo")
    public ModelAndView responsableGrupo(HttpServletRequest request){
        
        int id_responsable=Integer.parseInt(request.getParameter("id_responsable"));
        this.jdbcTemplate.update("delete from nm_responsable_grupo where id_responsable=?",
        id_responsable);
        return new ModelAndView("redirect:/responsablegrupo.htm");
        
    }
}