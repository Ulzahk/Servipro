package Controles.TipoDeNovedades;

import Modelos.Conectar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ControlTipoDeNovedades {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlTipoDeNovedades(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping("tipodenovedades.htm")
    public ModelAndView novedades(){
        ModelAndView mav=new ModelAndView();
        String sql="select * from nm_tipo_novedad";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.setViewName("tipodenovedades");
        mav.addObject("datos",datos);
        return mav;
    }
}

