
package Controles.Empleados;

import Modelos.Conectar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ControlEliminarEmpleados {
    
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlEliminarEmpleados(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    
    
    @RequestMapping("eliminarempleados.htm")
    public ModelAndView empleados(HttpServletRequest request){
        ModelAndView mav=new ModelAndView();
        int id_empleado=Integer.parseInt(request.getParameter("id_empleado"));
        String sql="select * from empleados join cargo_empleado on empleados.id_cargo=cargo_empleado.id_cargo  "
        + "join centro_de_costos on empleados.id_ccostos=centro_de_costos.id_ccostos where id_empleado='"+id_empleado+"'";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos", datos);
        mav.setViewName("eliminarempleados");
        return mav;
    }
}
