
package Controles.Usuarios;

import Modelos.Conectar;
import Modelos.Usuarios.Usuarios;
import Modelos.Usuarios.UsuariosPerEmp;
import Modelos.Usuarios.UsuariosValidacion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import Utils.Encriptar;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("editarusuarios.htm")
public class ControlEditarUsuarios {
    
    UsuariosValidacion usuariosValidacion;
    private JdbcTemplate jdbcTemplate;
    
    public ControlEditarUsuarios(){
        
        this.usuariosValidacion=new UsuariosValidacion();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView usuarios(HttpServletRequest request){
        
        ModelAndView mav=new ModelAndView();
        String id_usuario = request.getParameter("id_usuario");
        Usuarios datos=this.selectUsuarios(id_usuario);
        mav.setViewName("editarusuarios");
        mav.addObject("usuarios",new Usuarios(id_usuario,datos.getId_empleado(),
        datos.getContraseña(),datos.getId_perfil()));
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView usuarios(@ModelAttribute("usuarios")Usuarios u,
    BindingResult result, SessionStatus status, HttpServletRequest request){
        
        this.usuariosValidacion.validate(u, result);
        if(result.hasErrors()){
            
            ModelAndView mav=new ModelAndView();
            String id_usuario = request.getParameter("id_usuario");
            Usuarios datos=this.selectUsuarios(id_usuario);
            mav.setViewName("editarusuarios");
            mav.addObject("usuarios",new Usuarios(id_usuario,datos.getId_empleado(),
            datos.getContraseña(),datos.getId_perfil()));
            return mav;
            
        }else{
            
            String contraseña = u.getContraseña();
            Encriptar enc = new Encriptar();
            contraseña = enc.getMD5(contraseña);
            String id_usuario = request.getParameter("id_usuario");
            this.jdbcTemplate.update("update nm_usuarios set id_empleado=?, "
            +"contraseña=?, id_perfil=? where id_usuario=?",u.getId_empleado(),
            contraseña,u.getId_perfil(),id_usuario);
            return new ModelAndView("redirect:/usuarios.htm");
            
            
        }
    }
    
    public Usuarios selectUsuarios(String id_usuario){
        
        final Usuarios usua=new Usuarios();
        String quer="select * from nm_usuarios where id_usuario='"+id_usuario+"'";
        return(Usuarios)jdbcTemplate.query(quer, new ResultSetExtractor<Usuarios>(){
            public Usuarios extractData(ResultSet rs)throws SQLException, DataAccessException{
                if(rs.next()){
                    
                    usua.setId_empleado(rs.getInt("id_empleado"));
                    usua.setContraseña(rs.getString("contraseña"));
                    usua.setId_perfil(rs.getInt("id_perfil"));
                    
                }
                return usua;
            }
        });
    }
}
