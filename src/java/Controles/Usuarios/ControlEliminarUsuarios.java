
package Controles.Usuarios;

import Modelos.Conectar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ControlEliminarUsuarios {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlEliminarUsuarios(){
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    @RequestMapping("eliminarusuarios.htm")
    public ModelAndView usuarios(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        String id_usuario=request.getParameter("id_usuario");
        String sql="select * from empleados join usuarios on empleados.id_empleado=usuarios.id_empleado "
                + "join perfil on usuarios.id_perfil=perfil.id_perfil where id_usuario='"+id_usuario+"'";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos",datos);
        mav.setViewName("eliminarusuarios");
        return mav;
    }
}

