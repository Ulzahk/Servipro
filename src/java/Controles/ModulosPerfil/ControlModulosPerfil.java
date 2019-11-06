
package Controles.ModulosPerfil;

import Modelos.Conectar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ControlModulosPerfil {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlModulosPerfil(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
       
    }
    
    @RequestMapping("modulosperfil.htm")
    public ModelAndView modulosPerfil(){
        ModelAndView mav=new ModelAndView();
        String sql="select * from modulos_perfil join modulos on modulos_perfil.id_modulo=modulos.id_modulo  "
        + "join perfil on modulos_perfil.id_perfil=perfil.id_perfil";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.setViewName("modulosperfil");
        mav.addObject("datos", datos);
        return mav;
    }
}
