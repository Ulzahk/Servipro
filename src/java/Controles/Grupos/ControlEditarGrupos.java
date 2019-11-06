
package Controles.Grupos;

import Modelos.Conectar;
import Modelos.Grupos.Grupos;
import Modelos.Grupos.GruposValidacion;
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
@RequestMapping("editargrupos.htm")
public class ControlEditarGrupos {
    
    GruposValidacion gruposValidacion;
    private JdbcTemplate jdbcTemplate;
    
    public ControlEditarGrupos(){
        
        this.gruposValidacion=new GruposValidacion();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView grupos(HttpServletRequest request){
        
        ModelAndView mav=new ModelAndView();
        int id_grupo=Integer.parseInt(request.getParameter("id_grupo"));
        Grupos datos=this.selectGrupos(id_grupo);
        mav.setViewName("editargrupos");
        mav.addObject("grupos", new Grupos(id_grupo,datos.getNombre_grupo()));
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView grupos(@ModelAttribute("grupos") Grupos grup,
    BindingResult result, SessionStatus status, HttpServletRequest request){
        
        this.gruposValidacion.validate(grup, result);
        if(result.hasErrors()){
            
            ModelAndView mav=new ModelAndView();
            int id_grupo=Integer.parseInt(request.getParameter("id_grupo"));
            Grupos datos=this.selectGrupos(id_grupo);
            mav.setViewName("editargrupos");
            mav.addObject("grupos", new Grupos(id_grupo,datos.getNombre_grupo()));
            return mav;
            
        }else{
            
            int id_grupo=Integer.parseInt(request.getParameter("id_grupo"));
            this.jdbcTemplate.update("update grupos set nombre_grupo=? where id_grupo=?",
            grup.getNombre_grupo(),id_grupo);
            return new ModelAndView("redirect:/grupos.htm");
        }
    }
    
    public Grupos selectGrupos(int id_grupo){
        
        final Grupos grupo=new Grupos();
        String quer="select * from  grupos where id_grupo='"+id_grupo+"'";
        return (Grupos)jdbcTemplate.query(quer,new ResultSetExtractor<Grupos>(){
            public Grupos extractData(ResultSet rs)throws SQLException, DataAccessException{
               if(rs.next()){
                   
                   grupo.setNombre_grupo(rs.getString("nombre_grupo"));
               }
               return grupo;
            }
        });
    }
}
