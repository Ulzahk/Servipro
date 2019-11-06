
package Controles.EmpleadosGrupo;

import Modelos.Conectar;
import Modelos.EmpleadosGrupo.EmpleadosGrupo;
import Modelos.EmpleadosGrupo.EmpleadosGrupoValidacion;
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
@RequestMapping("editarempleadosgrupo")
public class ControlEditarEmpleadosGrupo {
    
    EmpleadosGrupoValidacion empleadosGrupoValidacion;
    private JdbcTemplate jdbcTemplate;
    
    public ControlEditarEmpleadosGrupo(){
        
        this.empleadosGrupoValidacion=new EmpleadosGrupoValidacion();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView empleadosGrupo(HttpServletRequest request){
        
        ModelAndView mav=new ModelAndView();
        int id_empleados_grupo=Integer.parseInt(request.getParameter("id_empleados_grupo"));
        EmpleadosGrupo datos=this.selectEmpleadosGrupo(id_empleados_grupo);
        mav.setViewName("editarempleadosgrupo");
        mav.addObject("empleadosgrupo",new EmpleadosGrupo(id_empleados_grupo,datos.getId_grupo(),
        datos.getId_empleado()));
        return mav;
        
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView empleadosGrupo(@ModelAttribute("empleadosgrupo")EmpleadosGrupo eg,
    BindingResult result, SessionStatus status, HttpServletRequest request){
        
        this.empleadosGrupoValidacion.validate(eg, result);
        if(result.hasErrors()){
            ModelAndView mav=new ModelAndView();
            int id_empleados_grupo=Integer.parseInt(request.getParameter("id_empleados_grupo"));
            EmpleadosGrupo datos=this.selectEmpleadosGrupo(id_empleados_grupo);
            mav.setViewName("editarempleadosgrupo");
            mav.addObject("empleadosgrupo",new EmpleadosGrupo(id_empleados_grupo,datos.getId_grupo(),
            datos.getId_empleado()));
            return mav; 
        }else{
            
            int id_empleados_grupo=Integer.parseInt(request.getParameter("id_empleados_grupo"));
            this.jdbcTemplate.update("update nm_empleados_grupo set id_grupo=?, id_empleado=? where "
            + "id_empleados_grupo=? ",eg.getId_grupo(),eg.getId_empleado(),id_empleados_grupo);
            return new ModelAndView("redirect:/empleadosgrupo-htm"); 
            
        }
    }
    
    public EmpleadosGrupo selectEmpleadosGrupo(int id_empleados_grupo){
        
        final EmpleadosGrupo ego=new EmpleadosGrupo();
        String quer="select * from nm_empleados_grupo where id_empleados_grupo='"+id_empleados_grupo+"'";
        return (EmpleadosGrupo)jdbcTemplate.query(quer, new ResultSetExtractor<EmpleadosGrupo>(){
            public EmpleadosGrupo extractData(ResultSet rs)throws SQLException, DataAccessException{
                if(rs.next()){
                    ego.setId_grupo(rs.getInt("id_grupo"));
                    ego.setId_empleado(rs.getInt("id_empleado"));
                }
                return ego;
            }
        });
    }
}
