
package Controles.NovedadesEmpleado;

import Modelos.Conectar;
import Modelos.NovedadesEmpleado.NovedadesEmpleado;
import Modelos.NovedadesEmpleado.NovedadesEmpleadoValidacion;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("agregarnovedadesempleado.htm")
public class ControlAgregarNovedadesEmpleado {
    
    NovedadesEmpleadoValidacion novedadesEmpleadoValidacion;
    private JdbcTemplate jdbcTemplate;
    
    public ControlAgregarNovedadesEmpleado(){
        
        this.novedadesEmpleadoValidacion=new NovedadesEmpleadoValidacion();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView novedadesEmpleado(){
        
        ModelAndView mav=new ModelAndView();
        mav.setViewName("agregarnovedadesempleado");
        mav.addObject("novedadesempleado",new NovedadesEmpleado());
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView novedadesEmpleado(@ModelAttribute("novedadesempleado")NovedadesEmpleado ne,
    BindingResult result, SessionStatus status){
        
        this.novedadesEmpleadoValidacion.validate(ne, result);
        if(result.hasErrors()){
            
            ModelAndView mav=new ModelAndView();
            mav.setViewName("agregarnovedadesempleado");
            mav.addObject("novedadesempleado",new NovedadesEmpleado());
            return mav;
            
        }else{
            
            this.jdbcTemplate.update("insert into novedades_empleado"
            + "(id_empleado,detalle,tipo,fecha)values(?,?,?,?)",ne.getId_empleado(),
            ne.getDetalle(),ne.getTipo(),ne.getFecha());
            return new ModelAndView("redirect:/novedadesempleado.htm");
            
        }
    }
}
