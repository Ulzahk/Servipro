
package Controles.CargoEmpleado;

import Modelos.Conectar;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


public class ControlConfirmarEliminarCargoEmpleado {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlConfirmarEliminarCargoEmpleado(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping("confirmareliminarcargoempleado.htm")
    public ModelAndView cargoEmpleado(HttpServletRequest request){
        
        int id_cargo=Integer.parseInt(request.getParameter("id_cargo"));
        this.jdbcTemplate.update("delete from cargo_empleado "+"where "+"id_cargo=?",id_cargo);
        return new ModelAndView("redirect:/cargoempleado.htm");
    }
}
