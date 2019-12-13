
package Controles.NovedadesEmpleado;

import Modelos.Conectar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ControlNovedadesEmpleado {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlNovedadesEmpleado(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping("novedadesempleado.htm")
    public ModelAndView novedadesEmpleado(){
        ModelAndView mav= new ModelAndView();
        String sql="SELECT nov.*, emp.Nombre Empleado, emp.Documento Documento FROM nm_novedades_empleado nov INNER JOIN nm_empleados emp ON emp.Id_empleado = nov.Id_empleado ";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.setViewName("novedadesempleado");
        mav.addObject("datos",datos);
        return mav;
    }
}
