
package Controles.Configuracion;

import Modelos.Conectar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ControlConfiguracion {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlConfiguracion(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }

    @RequestMapping("configuracion.htm")
    public ModelAndView configuracion(){
        ModelAndView mav = new ModelAndView();
        String sql="SELECT conf.*, mod.Nombre_modulo Modulo FROM nm_configuracion conf INNER JOIN nm_modulos mod ON mod.Id_modulo = conf.Id_modulo";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos",datos);
        mav.setViewName("configuracion");
        return mav;
    }
}
