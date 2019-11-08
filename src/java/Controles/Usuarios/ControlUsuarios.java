
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
        String sql="SELECT u.Id_usuario, u.Contraseña, emp.Nombre Empleado, emp.Documento Documento, p.Descripcion_perfil Perfil FROM nm_usuarios u INNER JOIN nm_empleados emp ON emp.Id_empleado = u.Id_empleado INNER JOIN nm_perfil p ON u.Id_perfil = p.Id_perfil ";
      /*String sql="select * from empleados join usuarios on empleados.id_empleado=usuarios.id_empleado "
                + "join perfil on usuarios.id_perfil=perfil.id_perfil";*/
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos",datos);
        mav.setViewName("usuarios");
        return mav;
    }
    
    
//    public ModelAndView selusuarios(){
//        ModelAndView mav = new ModelAndView();
//        String infoempsql="SELECT u.Id_usuario, u.Contraseña, emp.Nombre Empleado FROM nm_usuarios u INNER JOIN nm_empleados emp ON emp.Id_empleado = u.Id_empleado";
//        List infoemp = this.jdbcTemplate.queryForList(infoempsql);
//        mav.addObject("infoemp",infoemp);
//        mav.setViewName("usuarios");
//        return mav;
//    } 
//    
}

