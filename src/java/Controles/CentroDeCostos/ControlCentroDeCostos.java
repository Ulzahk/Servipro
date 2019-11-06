
package Controles.CentroDeCostos;

import Modelos.Conectar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ControlCentroDeCostos {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlCentroDeCostos(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping("centrodecostos.htm")
    public ModelAndView centroDeCostos(){
        ModelAndView mav=new ModelAndView();
        String sql="select * from centro_de_costos";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos",datos);
        mav.setViewName("centrodecostos");
        return mav;
    }
}
