
package Controles.Novedades;

import Modelos.Conectar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ControlNovedades {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlNovedades(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping("novedades.htm")
    public ModelAndView novedades(){
        ModelAndView mav=new ModelAndView();
        String sql="select * from nm_novedades";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.setViewName("novedades");
        mav.addObject("datos",datos);
        return mav;
    }
}
