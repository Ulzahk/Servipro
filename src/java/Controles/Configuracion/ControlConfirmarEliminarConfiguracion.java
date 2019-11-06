

package Controles.Configuracion;

import Modelos.Conectar;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



public class ControlConfirmarEliminarConfiguracion {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlConfirmarEliminarConfiguracion(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping("confirmareliminarconfiguracion.htm")
    public ModelAndView configuracion(HttpServletRequest request){
        
        int id_configuracion=Integer.parseInt(request.getParameter("id_configuracion"));
        this.jdbcTemplate.update("delete from configuracion where id_configuracion=?",id_configuracion);
        return new ModelAndView("redirect:/configuracion.htm");
    }
}