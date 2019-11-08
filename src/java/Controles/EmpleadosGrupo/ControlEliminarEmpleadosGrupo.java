
package Controles.EmpleadosGrupo;

import Modelos.Conectar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



public class ControlEliminarEmpleadosGrupo {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlEliminarEmpleadosGrupo(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping("eliminarempleadosgrupo.htm")
    public ModelAndView empleadoGrupo(HttpServletRequest request){
        
        ModelAndView mav=new ModelAndView();
        int id_empleados_grupo=Integer.parseInt(request.getParameter("id_empleados_grupo"));
        String sql="select * from empleados_grupo join grupos on empleados_grupo.id_grupo=grupos.id_grupo"
                + " join empleados on empleados_grupo.id_empleado=empleados.id_empleado where id_empleados_grupo='"
                +id_empleados_grupo+"'";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.setViewName("eliminarempleadosgrupo");
        mav.addObject("datos", datos);
        return mav;
    }
            
    
}

