
package Controles.Modulos;

import Modelos.Conectar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ControlEliminarModulos {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlEliminarModulos(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping("eliminarmodulos.htm")
    
    public ModelAndView modulos(HttpServletRequest request){
        ModelAndView mav=new ModelAndView();
        int id_modulo=Integer.parseInt(request.getParameter("id_modulo"));
        String sql="select * from modulos where id_modulo='"+id_modulo+"'";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos",datos);
        mav.setViewName("eliminarmodulos");
        return mav;
    }
}
