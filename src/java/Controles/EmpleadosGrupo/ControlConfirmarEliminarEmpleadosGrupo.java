
package Controles.EmpleadosGrupo;

import Modelos.Conectar;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


public class ControlConfirmarEliminarEmpleadosGrupo {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlConfirmarEliminarEmpleadosGrupo(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping("confirmareliminarempleadosgrupo.htm")
    public ModelAndView empleadosGrupo(HttpServletRequest request){
        
        int id_empleados_grupo=Integer.parseInt(request.getParameter("id_empleados_grupo"));
        this.jdbcTemplate.update("delete from empleados_grupo where id_empleados_grupo=?",id_empleados_grupo);
        return new ModelAndView("redirect:/empleadosgrupo.htm");
        
    }
    
}
