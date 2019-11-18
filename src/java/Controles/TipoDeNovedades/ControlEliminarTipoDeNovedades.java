package Controles.TipoDeNovedades;

import Modelos.Conectar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ControlEliminarTipoDeNovedades {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlEliminarTipoDeNovedades(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping("eliminartipodenovedades.htm")
    public ModelAndView novedades(HttpServletRequest request){
        
        ModelAndView mav=new ModelAndView();
        int id_novedad=Integer.parseInt(request.getParameter("id_novedad"));
        String sql="select * from nm_tipo_novedad where id_novedad='"+id_novedad+"'";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.setViewName("eliminartipodenovedades");
        mav.addObject("datos",datos);
        return mav;
    }
}
