
package Controles.Perfil;

import Modelos.Conectar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ControlPerfil {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlPerfil(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
       
    @RequestMapping("perfil.htm")
    public ModelAndView perfil (){
        ModelAndView mav = new ModelAndView();
        String sql="select * from perfil;";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos",datos);
        mav.setViewName("perfil");
        return mav;
    }
}
