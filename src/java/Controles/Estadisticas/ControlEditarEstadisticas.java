
package Controles.Estadisticas;

import Modelos.Conectar;
import Modelos.Estadisticas.Estadisticas;
import Modelos.Estadisticas.EstadisticasValidacion;
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
@RequestMapping("editarestadisticas.htm")
public class ControlEditarEstadisticas {
    
    EstadisticasValidacion estadisticasValidacion;
    private JdbcTemplate jdbcTemplate;
    
    public ControlEditarEstadisticas(){
        this.estadisticasValidacion= new EstadisticasValidacion();
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView estadisticas(HttpServletRequest request){
        
        ModelAndView mav=new ModelAndView();
        int id_estadistica=Integer.parseInt(request.getParameter("id_estadistica"));
        Estadisticas datos=this.selectEstadisticas(id_estadistica);
        mav.setViewName("editarestadisticas");
        mav.addObject("estadisticas", new Estadisticas(id_estadistica, datos.getId_empleado(),
        datos.getId_dia1(), datos.getId_dia2(), datos.getId_dia3(), datos.getId_dia4(), datos.getId_dia5(),
        datos.getId_dia6(), datos.getId_dia7(), datos.getId_dia8(), datos.getId_dia9(), datos.getId_dia10(),
        datos.getId_dia11(), datos.getId_dia12(), datos.getId_dia13(), datos.getId_dia14(), datos.getId_dia15(),
        datos.getId_dia16(), datos.getId_dia17(), datos.getId_dia18(), datos.getId_dia19(), datos.getId_dia20(),
        datos.getId_dia21(), datos.getId_dia22(), datos.getId_dia23(), datos.getId_dia24(), datos.getId_dia25(),
        datos.getId_dia26(), datos.getId_dia27(), datos.getId_dia28(), datos.getId_dia29(), datos.getId_dia30()));
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView estadisticas(@ModelAttribute("estadisticas") Estadisticas est,
    BindingResult result, SessionStatus status, HttpServletRequest request){
        
        this.estadisticasValidacion.validate(est, result);
        if(result.hasErrors()){
            
            ModelAndView mav=new ModelAndView();
            int id_estadistica=Integer.parseInt(request.getParameter("id_estadistica"));
            Estadisticas datos=this.selectEstadisticas(id_estadistica);
            mav.setViewName("editarestadisticas");
            mav.addObject("estadisticas", new Estadisticas(id_estadistica, datos.getId_empleado(),
            datos.getId_dia1(), datos.getId_dia2(), datos.getId_dia3(), datos.getId_dia4(), datos.getId_dia5(),
            datos.getId_dia6(), datos.getId_dia7(), datos.getId_dia8(), datos.getId_dia9(), datos.getId_dia10(),
            datos.getId_dia11(), datos.getId_dia12(), datos.getId_dia13(), datos.getId_dia14(), datos.getId_dia15(),
            datos.getId_dia16(), datos.getId_dia17(), datos.getId_dia18(), datos.getId_dia19(), datos.getId_dia20(),
            datos.getId_dia21(), datos.getId_dia22(), datos.getId_dia23(), datos.getId_dia24(), datos.getId_dia25(),
            datos.getId_dia26(), datos.getId_dia27(), datos.getId_dia28(), datos.getId_dia29(), datos.getId_dia30()));
            return mav;
            
        }else{
            
            int id_estadistica=Integer.parseInt(request.getParameter("id_estadistica"));
            this.jdbcTemplate.update("update nm_estadistica set id_empleado=?, id_dia1=?, id_dia2=?, "
                    + "id_dia3=?, id_dia4=?, id_dia5=?, id_dia6=?, id_dia7=?, id_dia8=?, id_dia9=?, "
                    + "id_dia10=?, id_dia11=?, id_dia12=?, id_dia13=?, id_dia14=?, id_dia15=?, id_dia16=?, "
                    + "id_dia17=?, id_dia18=?, id_dia19=?, id_dia20=?, id_dia21=?, id_dia22=?, id_dia23=?, "
                    + "id_dia24=?, id_dia25=?, id_dia26=?, id_dia27=?, id_dia28=?, id_dia29=?, id_dia30=?  "
                    + "where id_estadistica=?", est.getId_empleado(), est.getId_dia1(), est.getId_dia2(), 
                    est.getId_dia3(), est.getId_dia4(), est.getId_dia5(), est.getId_dia6(), est.getId_dia7(), est.getId_dia8(), 
                    est.getId_dia9(), est.getId_dia10(), est.getId_dia11(), est.getId_dia12(), est.getId_dia13(), 
                    est.getId_dia14(), est.getId_dia15(), est.getId_dia16(), est.getId_dia17(), est.getId_dia18(), 
                    est.getId_dia19(), est.getId_dia20(), est.getId_dia21(), est.getId_dia22(), est.getId_dia23(), 
                    est.getId_dia24(), est.getId_dia25(), est.getId_dia26(), est.getId_dia27(), est.getId_dia28(),
                    est.getId_dia29(), est.getId_dia30(), id_estadistica);
            return new ModelAndView("redirect:/estadisticas.htm");
        }
    }
    
    public Estadisticas selectEstadisticas (int id_estadistica){
        final Estadisticas est = new Estadisticas();
        String quer="select * from nm_estadistica where id_estadistica='"+id_estadistica+"'";
        return (Estadisticas) jdbcTemplate.query(quer, new ResultSetExtractor<Estadisticas>(){
            public Estadisticas extractData(ResultSet rs)throws SQLException, DataAccessException{
                if(rs.next()){
                    est.setId_empleado(rs.getInt("id_empleado"));
                    est.setId_dia1(rs.getInt("id_dia1"));
                    est.setId_dia2(rs.getInt("id_dia2"));
                    est.setId_dia3(rs.getInt("id_dia3"));
                    est.setId_dia4(rs.getInt("id_dia4"));
                    est.setId_dia5(rs.getInt("id_dia5"));
                    est.setId_dia6(rs.getInt("id_dia6"));
                    est.setId_dia7(rs.getInt("id_dia7"));
                    est.setId_dia8(rs.getInt("id_dia8"));
                    est.setId_dia9(rs.getInt("id_dia9"));
                    est.setId_dia10(rs.getInt("id_dia10"));
                    est.setId_dia11(rs.getInt("id_dia11"));
                    est.setId_dia12(rs.getInt("id_dia12"));
                    est.setId_dia13(rs.getInt("id_dia13"));
                    est.setId_dia14(rs.getInt("id_dia14"));
                    est.setId_dia15(rs.getInt("id_dia15"));
                    est.setId_dia16(rs.getInt("id_dia16"));
                    est.setId_dia17(rs.getInt("id_dia17"));
                    est.setId_dia18(rs.getInt("id_dia18"));
                    est.setId_dia19(rs.getInt("id_dia19"));
                    est.setId_dia20(rs.getInt("id_dia20"));
                    est.setId_dia21(rs.getInt("id_dia21"));
                    est.setId_dia22(rs.getInt("id_dia22"));
                    est.setId_dia23(rs.getInt("id_dia23"));
                    est.setId_dia24(rs.getInt("id_dia24"));
                    est.setId_dia25(rs.getInt("id_dia25"));
                    est.setId_dia26(rs.getInt("id_dia26"));
                    est.setId_dia27(rs.getInt("id_dia27"));
                    est.setId_dia28(rs.getInt("id_dia28"));
                    est.setId_dia29(rs.getInt("id_dia29"));
                    est.setId_dia30(rs.getInt("id_dia30"));
                }
                return est;
            }
        });
    }
}
