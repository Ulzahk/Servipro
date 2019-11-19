
package Controles.CentroDeCostos;

import Modelos.CentroDeCostos.CentroDeCostos;
import Modelos.CentroDeCostos.CentroDeCostosValidacion;
import Modelos.Conectar;
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
@RequestMapping("editarcentrodecostos")
public class ControlEditarCentroDeCostos {
    
    CentroDeCostosValidacion centroDeCostosValidacion;
    private JdbcTemplate jdbcTemplate;
    
    public ControlEditarCentroDeCostos(){
        
        this.centroDeCostosValidacion=new CentroDeCostosValidacion();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView centroDeCostos(HttpServletRequest request){
        
        ModelAndView mav=new ModelAndView();
        int id_ccostos=Integer.parseInt(request.getParameter("id_ccostos"));
        CentroDeCostos datos=this.selectCentroDeCostos(id_ccostos);
        mav.setViewName("editarcentrodecostos");
        mav.addObject("centrodecostos", new CentroDeCostos(id_ccostos,datos.getNombre_ccostos()));
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView centroDeCostos(@ModelAttribute("centrodecostos")CentroDeCostos cdc,
    BindingResult result, SessionStatus status, HttpServletRequest request){
        
        this.centroDeCostosValidacion.validate(cdc, result);
        if(result.hasErrors()){
            
            ModelAndView mav=new ModelAndView();
            int id_ccostos=Integer.parseInt(request.getParameter("id_ccostos"));
            CentroDeCostos datos=this.selectCentroDeCostos(id_ccostos);
            mav.setViewName("editarcentrodecostos");
            mav.addObject("centrodecostos", new CentroDeCostos(id_ccostos,datos.getNombre_ccostos()));
            return mav;
        }else{
            
            int id_ccostos=Integer.parseInt(request.getParameter("id_ccostos"));
            this.jdbcTemplate.update("update nm_centro_de_costos "+"set nombre_ccostos=? "+
            "where "+"id_ccostos=?",cdc.getNombre_ccostos(),id_ccostos);
            return new ModelAndView("redirect:/centrodecostos.htm"); 
        }
    }
    
    public CentroDeCostos selectCentroDeCostos(int id_ccostos){
        
        final CentroDeCostos centrod=new CentroDeCostos();
        String quer="select * from nm_centro_de_costos where id_ccostos='"+id_ccostos+"'";
        return (CentroDeCostos) jdbcTemplate.query(quer, new ResultSetExtractor<CentroDeCostos>(){
            public CentroDeCostos extractData(ResultSet rs)throws SQLException, DataAccessException{
                if(rs.next()){
                    centrod.setNombre_ccostos(rs.getString("nombre_ccostos"));
                    
                }
                return centrod;
            }
        });
    }
}
