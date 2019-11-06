
package Controles.ResponsableGrupo;

import Modelos.Conectar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ControlResponsableGrupo {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlResponsableGrupo(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping("responsablegrupo.htm")
    public ModelAndView responsableGrupo(){
        ModelAndView mav=new ModelAndView();
        String sql="select * from responsable_grupo";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.setViewName("responsablegrupo");
        mav.addObject("datos",datos);
        return mav;
    }
}
