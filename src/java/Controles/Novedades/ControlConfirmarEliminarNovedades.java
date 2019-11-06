
package Controles.Novedades;

import Modelos.Conectar;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


public class ControlConfirmarEliminarNovedades {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlConfirmarEliminarNovedades(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping("confirmareliminarnovedades.htm")
    public ModelAndView novedades(HttpServletRequest request){
        
        int id_novedad=Integer.parseInt(request.getParameter("id_novedad"));
        this.jdbcTemplate.update("delete from novedades where id_novedad=?",id_novedad);
        return new ModelAndView("redirect:/novedades.htm");
    
    }
    
}
