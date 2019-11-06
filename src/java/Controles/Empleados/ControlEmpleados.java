
package Controles.Empleados;

import Modelos.Conectar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ControlEmpleados {
    
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlEmpleados(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    
    
    @RequestMapping("empleados.htm")
    public ModelAndView empleados(){
        ModelAndView mav=new ModelAndView();
        String sql="select * from empleados join cargo_empleado on empleados.id_cargo=cargo_empleado.id_cargo  "
        + "join centro_de_costos on empleados.id_ccostos=centro_de_costos.id_ccostos";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos", datos);
        mav.setViewName("empleados");
        return mav;
    }
}
