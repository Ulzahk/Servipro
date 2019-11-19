package Controles;

import Modelos.Conectar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ControlNomina {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlNomina(){
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("nomina.htm")
    public ModelAndView nomina(){
        ModelAndView mav=new ModelAndView();
        String sql="select * from nm_usuarios";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.setViewName("nomina");
        mav.addObject("datos",datos);
        return mav;
    } 
    
}
