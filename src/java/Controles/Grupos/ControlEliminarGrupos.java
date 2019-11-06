
package Controles.Grupos;

import Modelos.Conectar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ControlEliminarGrupos {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlEliminarGrupos(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }

    @RequestMapping("eliminargrupos.htm")
    public ModelAndView grupos(HttpServletRequest request){
        ModelAndView mav=new ModelAndView();
        int id_grupo=Integer.parseInt(request.getParameter("id_grupo"));
        String sql="select * from nm_grupos where id_grupo='"+id_grupo+"'";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos", datos);
        mav.setViewName("eliminargrupos");
        return mav;
    }
}
