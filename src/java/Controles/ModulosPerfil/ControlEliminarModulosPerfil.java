
package Controles.ModulosPerfil;

import Modelos.Conectar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ControlEliminarModulosPerfil {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlEliminarModulosPerfil(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
       
    }
    
    @RequestMapping("eliminarmodulosperfil.htm")
    public ModelAndView modulosPerfil(HttpServletRequest request){
        ModelAndView mav=new ModelAndView();
        int id_modulo_perfil=Integer.parseInt(request.getParameter("id_modulo_perfil"));
        String sql="select * from nm_modulos_perfil join nm_modulos on nm_modulos_perfil.id_modulo=nm_modulos.id_modulo  "
        + "join nm_perfil on nm_modulos_perfil.id_perfil=nm_perfil.id_perfil where id_modulo_perfil='"+id_modulo_perfil+"'";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.setViewName("eliminarmodulosperfil");
        mav.addObject("datos", datos);
        return mav;
    }
}
