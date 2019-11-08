
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
        /*String sql="select * from nm_usuarios";*/
        String sql="SELECT u.Id_usuario, u.Contraseña, emp.Nombre Empleado, emp.Documento Documento, p.Descripcion_perfil Perfil FROM nm_usuarios u INNER JOIN nm_empleados emp ON emp.Id_empleado = u.Id_empleado INNER JOIN nm_perfil p ON u.Id_perfil = p.Id_perfil";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos",datos);
        mav.setViewName("usuarios");
        return mav;
    }
}
