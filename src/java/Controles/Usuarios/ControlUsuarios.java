
package Controles.Usuarios;

import Modelos.Conectar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ControlUsuarios {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlUsuarios(){
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    @RequestMapping("usuarios.htm")
    public ModelAndView usuarios(){
        ModelAndView mav = new ModelAndView();
        String sql="select * from nm_usuarios";
        /*String sql="select * from empleados join usuarios on empleados.id_empleado=usuarios.id_empleado "
                + "join perfil on usuarios.id_perfil=perfil.id_perfil";*/
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos",datos);
        mav.setViewName("usuarios");
        return mav;
    }
}
