
package Controles.Configuracion;

import Modelos.Conectar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ControlEliminarConfiguracion {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlEliminarConfiguracion(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }

    @RequestMapping("eliminarconfiguracion.htm")
    public ModelAndView configuracion(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        int id_configuracion=Integer.parseInt(request.getParameter("id_configuracion"));
        String sql="select * from configuracion where id_configuracion='"+id_configuracion+"'";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos",datos);
        mav.setViewName("eliminarconfiguracion");
        return mav;
    }
}
