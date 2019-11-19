
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
        String sql="select * from nm_responsable_grupo join nm_grupos"
                + " on nm_responsable_grupo.id_grupo=nm_grupos.id_grupo join nm_usuarios"
                + " on nm_responsable_grupo.id_usuario=nm_usuarios.id_usuario";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.setViewName("responsablegrupo");
        mav.addObject("datos",datos);
        return mav;
    }
}
