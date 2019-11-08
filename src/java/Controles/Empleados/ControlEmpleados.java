
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
        String sql="SELECT emp.*, cemp.Descripcion_cargo Cargo, cc.Nombre_ccostos CCostos FROM nm_empleados emp INNER JOIN nm_cargo_empleado cemp ON cemp.Id_cargo = emp.Id_cargo INNER JOIN nm_centro_de_costos cc ON cc.Id_ccostos = emp.Id_ccostos";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos", datos);
        mav.setViewName("empleados");
        return mav;
    }
}
