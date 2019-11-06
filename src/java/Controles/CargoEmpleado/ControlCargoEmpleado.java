
package Controles.CargoEmpleado;

import Modelos.Conectar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ControlCargoEmpleado {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlCargoEmpleado(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }

    @RequestMapping("cargoempleado.htm")
    public ModelAndView cargoEmpleado(){
      ModelAndView mav=new ModelAndView();
      String sql="select * from nm_cargo_empleado";
      List datos=this.jdbcTemplate.queryForList(sql);
      mav.addObject("datos",datos);
      mav.setViewName("cargoempleado");
      return mav;
    }
}
