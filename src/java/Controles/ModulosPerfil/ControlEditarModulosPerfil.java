
package Controles.ModulosPerfil;

import Modelos.Conectar;
import Modelos.ModulosPerfil.ModulosPerfil;
import Modelos.ModulosPerfil.ModulosPerfilValidacion;
import java.sql.ResultSet;
import java.sql.SQLException;
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
@RequestMapping("editarmodulosperfil.htm")
public class ControlEditarModulosPerfil {
    
    ModulosPerfilValidacion modulosPerfilValidacion;
    private JdbcTemplate jdbcTemplate;
    
    public ControlEditarModulosPerfil(){
        
        this.modulosPerfilValidacion=new ModulosPerfilValidacion();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView modulosPerfil(HttpServletRequest request){
        
        ModelAndView mav=new ModelAndView();
        int id_modulo_perfil=Integer.parseInt(request.getParameter("id_modulo_perfil"));
        ModulosPerfil datos=this.selectModulosPerfil(id_modulo_perfil);
        mav.setViewName("editarmodulosperfil");
        mav.addObject("modulosperfil", new ModulosPerfil(id_modulo_perfil,datos.getId_modulo(),
        datos.getId_perfil()));
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView modulosPerfil(@ModelAttribute("modulosperfil") ModulosPerfil mp,
    BindingResult result, SessionStatus status, HttpServletRequest request){
        
        this.modulosPerfilValidacion.validate(mp, result);
        if(result.hasErrors()){
            
            ModelAndView mav=new ModelAndView();
            int id_modulo_perfil=Integer.parseInt(request.getParameter("id_modulo_perfil"));
            ModulosPerfil datos=this.selectModulosPerfil(id_modulo_perfil);
            mav.setViewName("editarmodulosperfil");
            mav.addObject("modulosperfil", new ModulosPerfil(id_modulo_perfil,datos.getId_modulo(),
            datos.getId_perfil()));
            return mav;
            
        }else{
            
            int id_modulo_perfil=Integer.parseInt(request.getParameter("id_modulo_perfil"));
            this.jdbcTemplate.update("update modulos_perfil set id_modulo=?, id_perfil=? "
            + "where id_modulo_perfil=?",mp.getId_modulo(),mp.getId_perfil(),
            id_modulo_perfil);
            return new ModelAndView("redirect:/modulosperfil.htm");
        }
    }
    
    public ModulosPerfil selectModulosPerfil(int id_modulo_perfil){
        
        final ModulosPerfil modp=new ModulosPerfil();
        String quer="select * from modulos_perfil where id_modulo_perfil='"+id_modulo_perfil+"'";
        return (ModulosPerfil) jdbcTemplate.query(quer, new ResultSetExtractor<ModulosPerfil>(){
          public ModulosPerfil extractData(ResultSet rs)throws SQLException, DataAccessException{
              if(rs.next()){
                  modp.setId_modulo(rs.getInt("id_modulo"));
                  modp.setId_perfil(rs.getInt("id_perfil"));
              }
              return modp;
          }  
        });
    }
}
