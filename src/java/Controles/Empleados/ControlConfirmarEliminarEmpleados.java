
package Controles.Empleados;

import Modelos.Conectar;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



public class ControlConfirmarEliminarEmpleados {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlConfirmarEliminarEmpleados(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping("confirmareliminarempleados.htm")
    public ModelAndView empleados(HttpServletRequest request){
        
        int id_empleado=Integer.parseInt(request.getParameter("id_empleado"));
        this.jdbcTemplate.update("delete from nm_empleados where id_empleado=?",id_empleado);
        return new ModelAndView("redirect:/empleados.htm");
        
    }
}