
package Controles.CargoEmpleado;

import Modelos.Conectar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ControlEliminarCargoEmpleado {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlEliminarCargoEmpleado(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }

    @RequestMapping("eliminarcargoempleado.htm")
    public ModelAndView cargoEmpleado(HttpServletRequest request){
      ModelAndView mav=new ModelAndView();
      int id_cargo=Integer.parseInt(request.getParameter("id_cargo"));
      String sql="select * from nm_cargo_empleado where id_cargo='"+id_cargo+"'";
      List datos=this.jdbcTemplate.queryForList(sql);
      mav.addObject("datos",datos);
      mav.setViewName("eliminarcargoempleado");
      return mav;
    }
}
