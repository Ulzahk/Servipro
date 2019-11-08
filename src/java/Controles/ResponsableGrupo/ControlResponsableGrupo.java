
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
        String sql="SELECT g.nombre_grupo Grupo, u.Id_usuario Usuario FROM nm_responsable_grupo resg INNER JOIN nm_grupos g ON g.Id_grupo = resg.Id_grupo INNER JOIN nm_usuarios u ON u.Id_usuario = resg.Id_usuario ";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.setViewName("responsablegrupo");
        mav.addObject("datos",datos);
        return mav;
    }
}
