
package Controles.Novedades;

import Modelos.Conectar;
import Modelos.Novedades.Novedades;
import Modelos.Novedades.NovedadesValidacion;
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
@RequestMapping("editarnovedades.htm")
public class ControlEditarNovedades {
    
    NovedadesValidacion novedadesValidacion;
    private JdbcTemplate jdbcTemplate;
    
    public ControlEditarNovedades(){
        
        this.novedadesValidacion=new NovedadesValidacion();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView novedades(HttpServletRequest request){
        
        ModelAndView mav=new ModelAndView();
        int id_novedad=Integer.parseInt(request.getParameter("id_novedad"));
        Novedades datos=this.selectNovedades(id_novedad);
        mav.setViewName("editarnovedades");
        mav.addObject("novedades", new Novedades(id_novedad,datos.getDescripcion(),
        datos.getAlias()));
        return mav;
        
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView novedades(@ModelAttribute("novedades")Novedades n,
    BindingResult result, SessionStatus status, HttpServletRequest request){
        
        this.novedadesValidacion.validate(n, result);
        if(result.hasErrors()){
            
            ModelAndView mav=new ModelAndView();
            int id_novedad=Integer.parseInt(request.getParameter("id_novedad"));
            Novedades datos=this.selectNovedades(id_novedad);
            mav.setViewName("editarnovedades");
            mav.addObject("novedades", new Novedades(id_novedad,datos.getDescripcion(),
            datos.getAlias()));
            return mav;
            
        }else{
            
            int id_novedad=Integer.parseInt(request.getParameter("id_novedad"));
            this.jdbcTemplate.update("update novedades set descripcion=?, alias=? "
            +"where id_novedad=?",n.getDescripcion(),n.getAlias(),id_novedad);
            return new ModelAndView("redirect:/novedades.htm");
            
        }  
    }
    
    public Novedades selectNovedades(int id_novedad){
        
        final Novedades nov=new Novedades();
        String quer="select * from nm_novedades where id_novedad='"+id_novedad+"'";
        return (Novedades) jdbcTemplate.query(quer, new ResultSetExtractor<Novedades>(){
          public Novedades  extractData(ResultSet rs)throws SQLException, DataAccessException{
              if(rs.next()){
                  nov.setDescripcion(rs.getString("descripcion"));
                  nov.setAlias(rs.getString("alias"));
              }
              return nov;
          }
        }); 
    }
}
