
package Controles.NovedadesEmpleado;

import Modelos.Conectar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ControlEliminarNovedadesEmpleado {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlEliminarNovedadesEmpleado(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping("eliminarnovedadesempleado.htm")
    public ModelAndView novedadesEmpleado(HttpServletRequest request){
        ModelAndView mav= new ModelAndView();
        int id_novedad_empleado=Integer.parseInt(request.getParameter("id_novedad_empleado"));
        String sql="SELECT nov.*, emp.Nombre Empleado, emp.Documento Documento FROM nm_novedades_empleado nov INNER JOIN nm_empleados emp ON emp.Id_empleado = nov.Id_empleado where id_novedad_empleado='"+id_novedad_empleado+"'";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.setViewName("eliminarnovedadesempleado");
        mav.addObject("datos",datos);
        return mav;
    }
}
