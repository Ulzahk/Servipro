
package Controles.ResponsableGrupo;

import Modelos.Conectar;
import Modelos.ResponsableGrupo.ResponsableGrupo;
import Modelos.ResponsableGrupo.ResponsableGrupoValidacion;
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
@RequestMapping("editarresponsablegrupo.htm")
public class ControlEditarResponsableGrupo {
    
    ResponsableGrupoValidacion responsableGrupoValidacion;
    private JdbcTemplate jdbcTemplate;
    
    public ControlEditarResponsableGrupo(){
        
        this.responsableGrupoValidacion=new ResponsableGrupoValidacion();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView responsableGrupo(HttpServletRequest request){
        
        ModelAndView mav=new ModelAndView();
        int id_responsable=Integer.parseInt(request.getParameter("id_responsable"));
        ResponsableGrupo datos=this.selectResponsableGrupo(id_responsable);
        mav.setViewName("editarresponsablegrupo");
        mav.addObject("responsablegrupo", new ResponsableGrupo(id_responsable,
        datos.getId_grupo(),datos.getId_usuario()));
        return mav;
        
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView responsableGrupo(@ModelAttribute("responsablegrupo")ResponsableGrupo rg,
    BindingResult result, SessionStatus status, HttpServletRequest request){
        
        this.responsableGrupoValidacion.validate(rg, result);
        if(result.hasErrors()){
            
            ModelAndView mav=new ModelAndView();
            int id_responsable=Integer.parseInt(request.getParameter("id_responsable"));
            ResponsableGrupo datos=this.selectResponsableGrupo(id_responsable);
            mav.setViewName("editarresponsablegrupo");
            mav.addObject("responsablegrupo", new ResponsableGrupo(id_responsable,
            datos.getId_grupo(),datos.getId_usuario()));
            return mav; 
            
        }else{
            
            int id_responsable=Integer.parseInt(request.getParameter("id_responsable"));
            this.jdbcTemplate.update("update responsable_grupo set id_grupo=?, id_usuario=? "
            +"where id_responsable=?",rg.getId_grupo(),rg.getId_usuario(),id_responsable);
            return new ModelAndView("redirect:/responsablegrupo.htm");
        }
        
    }
    
    public ResponsableGrupo selectResponsableGrupo(int id_responsable){
        
        final ResponsableGrupo resg=new ResponsableGrupo();
        String quer="select * from responsable_grupo where id_responsable='"+id_responsable+"'";
        return (ResponsableGrupo)jdbcTemplate.query(quer,new ResultSetExtractor<ResponsableGrupo>(){
            public ResponsableGrupo extractData(ResultSet rs)throws SQLException, DataAccessException{
                if(rs.next()){
                    resg.setId_grupo(rs.getInt("id_grupo"));
                    resg.setId_usuario(rs.getString("id_usuario"));
                }
                return resg;
            }
        });        
    }
}
