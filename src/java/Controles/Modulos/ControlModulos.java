
package Controles.Modulos;

import Modelos.Conectar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ControlModulos {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlModulos(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping("modulos.htm")
    
    public ModelAndView modulos(){
        ModelAndView mav=new ModelAndView();
        String sql="select * from nm_modulos";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos",datos);
        mav.setViewName("modulos");
        return mav;
    }
}
