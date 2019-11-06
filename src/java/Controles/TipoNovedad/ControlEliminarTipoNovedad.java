
package Controles.TipoNovedad;

import Modelos.Conectar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ControlEliminarTipoNovedad {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlEliminarTipoNovedad(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping("eliminartiponovedad.htm")
    public ModelAndView tipoNovedad(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        int id_tipo_novedad=Integer.parseInt(request.getParameter("id_tipo_novedad"));
        String sql="select * from tipo_novedad where id_tipo_novedad='"+id_tipo_novedad+"'";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.setViewName("eliminartiponovedad");
        mav.addObject("datos",datos);
        return mav;
    }
}
