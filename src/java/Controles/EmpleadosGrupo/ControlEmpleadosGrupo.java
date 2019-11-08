
package Controles.EmpleadosGrupo;

import Modelos.Conectar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



public class ControlEmpleadosGrupo {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlEmpleadosGrupo(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping("empleadosgrupo.htm")
    public ModelAndView empleadoGrupo(){
        
        ModelAndView mav=new ModelAndView();
        String sql="SELECT empg.Id_empleados_grupo, g.nombre_grupo Grupo, emp.Nombre Empleado FROM nm_empleados_grupo empg INNER JOIN nm_grupos g ON g.Id_grupo = empg.Id_grupo INNER JOIN nm_empleados emp ON emp.Id_empleado = empg.Id_empleado";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.setViewName("empleadosgrupo");
        mav.addObject("datos", datos);
        return mav;
    }
            
    
}
