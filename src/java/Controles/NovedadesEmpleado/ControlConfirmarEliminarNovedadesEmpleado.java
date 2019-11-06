
package Controles.NovedadesEmpleado;

import Modelos.Conectar;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


public class ControlConfirmarEliminarNovedadesEmpleado {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlConfirmarEliminarNovedadesEmpleado(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping("confirmareliminarnovedadesempleado.htm")
    public ModelAndView novedadesEmpleado(HttpServletRequest request){
        
        int id_novedad_empleado=Integer.parseInt(request.getParameter("id_novedad_empleado"));
        this.jdbcTemplate.update("delete from novedades_empleado where id_novedad_empleado=?",
        id_novedad_empleado);
        return new ModelAndView("redirect:/novedadesempleado.htm");
    }
}
