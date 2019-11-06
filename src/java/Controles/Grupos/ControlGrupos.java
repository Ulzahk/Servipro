
package Controles.Grupos;

import Modelos.Conectar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ControlGrupos {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlGrupos(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }

    @RequestMapping("grupos.htm")
    public ModelAndView grupos(){
        ModelAndView mav=new ModelAndView();
        String sql="select * from grupos";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos", datos);
        mav.setViewName("grupos");
        return mav;
    }
}
