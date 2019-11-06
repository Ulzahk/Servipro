
package Controles.EmpleadosGrupo;

import Modelos.Conectar;
import Modelos.EmpleadosGrupo.EmpleadosGrupo;
import Modelos.EmpleadosGrupo.EmpleadosGrupoValidacion;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("agregarempleadosgrupo.htm")
public class ControlAgregarEmpleadosGrupo {
    
    EmpleadosGrupoValidacion empleadosGrupoValidacion;
    private JdbcTemplate jdbcTemplate;
    
    public ControlAgregarEmpleadosGrupo(){
        
        this.empleadosGrupoValidacion=new EmpleadosGrupoValidacion();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView empleadosGrupo(){
        
        ModelAndView mav=new ModelAndView();
        mav.setViewName("agregarempleadosgrupo");
        mav.addObject("empleadosgrupo", new EmpleadosGrupo());
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView empleadosGrupo(@ModelAttribute("empleadosgrupo")EmpleadosGrupo eg,
    BindingResult result, SessionStatus status){
        
        this.empleadosGrupoValidacion.validate(eg, result);
        if(result.hasErrors()){
            ModelAndView mav=new ModelAndView();
            mav.setViewName("agregarempleadosgrupo");
            mav.addObject("empleadosgrupo", new EmpleadosGrupo());
            return mav; 
        }else{
            this.jdbcTemplate.update("insert into empleados_grupo(id_grupo, id_empleado) "
            +" values(?,?)",eg.getId_grupo(),eg.getId_empleado());
            return new ModelAndView("redirect:/empleadosgrupo.htm");
        }
    }
    
    
}
