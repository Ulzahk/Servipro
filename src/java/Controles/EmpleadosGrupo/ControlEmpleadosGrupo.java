
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
        String sql="select * from empleados_grupo join grupos on empleados_grupo.id_grupo=grupos.id_grupo"
                + " join empleados on empleados_grupo.id_empleado=empleados.id_empleado";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.setViewName("empleadosgrupo");
        mav.addObject("datos", datos);
        return mav;
    }
            
    
}
