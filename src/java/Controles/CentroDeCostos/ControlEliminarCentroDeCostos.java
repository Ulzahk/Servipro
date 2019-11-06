
package Controles.CentroDeCostos;

import Modelos.Conectar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ControlEliminarCentroDeCostos {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlEliminarCentroDeCostos(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping("eliminarcentrodecostos.htm")
    public ModelAndView centroDeCostos(HttpServletRequest request){
        ModelAndView mav=new ModelAndView();
        int id_ccostos=Integer.parseInt(request.getParameter("id_ccostos"));
        String sql="select * from nm_centro_de_costos where id_ccostos='"+id_ccostos+"'";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos",datos);
        mav.setViewName("eliminarcentrodecostos");
        return mav;
    }
}
