
package Controles.TipoNovedad;

import Modelos.Conectar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ControlTipoNovedad {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlTipoNovedad(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping("tiponovedad.htm")
    public ModelAndView tipoNovedad(){
        ModelAndView mav = new ModelAndView();
        String sql="select * from tipo_novedad";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.setViewName("tiponovedad");
        mav.addObject("datos",datos);
        return mav;
    }
}
