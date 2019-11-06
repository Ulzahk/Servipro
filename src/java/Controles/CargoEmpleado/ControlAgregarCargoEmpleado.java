
package Controles.CargoEmpleado;

import Modelos.CargoEmpleado.CargoEmpleado;
import Modelos.CargoEmpleado.CargoEmpleadoValidacion;
import Modelos.Conectar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("agregarcargoempleado.htm")
public class ControlAgregarCargoEmpleado {
    
    CargoEmpleadoValidacion cargoEmpleadoValidacion;
    private JdbcTemplate jdbcTemplate;
    
    public ControlAgregarCargoEmpleado(){
        
        this.cargoEmpleadoValidacion=new CargoEmpleadoValidacion();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView cargoEmpleado(){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("agregarcargoempleado");
        mav.addObject("cargoempleado",new CargoEmpleado());
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView cargoEmpleado(@ModelAttribute("cargoempleado") CargoEmpleado ce,
    BindingResult result, SessionStatus status){
        
        this.cargoEmpleadoValidacion.validate(ce, result);
        if(result.hasErrors()){
            
            ModelAndView mav=new ModelAndView();
            mav.setViewName("agregarcargoempleado");
            mav.addObject("cargoempleado",new CargoEmpleado());
            return mav;
                   
        }else{
            
            this.jdbcTemplate.update(
            "insert into nm_cargo_empleado(descripcion_cargo)values(?)",
            ce.getDescripcion_cargo());
            return new ModelAndView("redirect:/cargoempleado.htm");
        }
    }
    
    
    
    
    
    
}
