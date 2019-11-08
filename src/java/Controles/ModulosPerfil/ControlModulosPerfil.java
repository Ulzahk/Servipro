
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
        String sql="SELECT modp.Id_modulo_perfil, p.Descripcion_perfil Perfil, m.Nombre_modulo Modulo FROM nm_modulos_perfil modp INNER JOIN nm_modulos m ON modp.Id_modulo=m.Id_modulo INNER JOIN nm_perfil p ON modp.Id_perfil = p.Id_perfil";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos", datos);
        mav.setViewName("modulosperfil");
        return mav;
    }
}
