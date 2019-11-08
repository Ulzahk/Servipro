
package Controles.Estadisticas;

import Modelos.Conectar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


public class ControladorEstadisticas {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControladorEstadisticas(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    @RequestMapping("estadisticas.htm")
    public ModelAndView consulta(){
        ModelAndView mav=new ModelAndView();
        String sql="select * from nm_empleados";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.setViewName("estadisticas");
        mav.addObject("datos",datos);
        return mav; 
    }
}
