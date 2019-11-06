
package Controles.Perfil;

import Modelos.Conectar;
import Modelos.Perfil.Perfil;
import Modelos.Perfil.PerfilValidacion;
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
@RequestMapping("editarperfil.htm")

public class ControlEditarPerfil {
    
    PerfilValidacion perfilValidacion;
    private JdbcTemplate jdbcTemplate;
    
    public ControlEditarPerfil(){
        
        this.perfilValidacion=new PerfilValidacion();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView perfil (HttpServletRequest request){
        
        ModelAndView mav=new ModelAndView();
        int id_perfil=Integer.parseInt(request.getParameter("id_perfil"));
        Perfil datos=this.selectPerfil(id_perfil);
        mav.setViewName("editarperfil");
        mav.addObject("perfil", new Perfil(id_perfil,datos.getDescripcion_perfil()));
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView perfil(@ModelAttribute("perfil") Perfil p,
    BindingResult result, SessionStatus status, HttpServletRequest request){
        
        this.perfilValidacion.validate(p, result);
        if(result.hasErrors()){
            
            ModelAndView mav=new ModelAndView();
            int id_perfil=Integer.parseInt(request.getParameter("id_perfil"));
            Perfil datos = this.selectPerfil(id_perfil);
            mav.setViewName("editarperfil");
            mav.addObject("perfil", new Perfil(id_perfil,datos.getDescripcion_perfil()));
            return mav;
            
        }else{
            
            int id_perfil=Integer.parseInt(request.getParameter("id_perfil"));
            this.jdbcTemplate.update("update perfil "+" set descripcion_perfil=? "+
            "where "+"id_perfil=?",p.getDescripcion_perfil(),id_perfil);
            return new ModelAndView("redirect:/perfil.htm");
        }
      }
    
    public Perfil selectPerfil(int id_perfil){
        
        final Perfil per=new Perfil();
        String quer="select * from perfil where id_perfil='"+ id_perfil+"'";
        return(Perfil) jdbcTemplate.query (quer,new ResultSetExtractor<Perfil>(){
           public Perfil extractData(ResultSet rs) throws SQLException, DataAccessException{
             if(rs.next()){
                 per.setDescripcion_perfil(rs.getString("descripcion_perfil"));
             }
             return per;
           }
        });
    } 
}
