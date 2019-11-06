
package Controles.Configuracion;

import Modelos.Conectar;
import Modelos.Configuracion.Configuracion;
import Modelos.Configuracion.ConfiguracionValidacion;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("agregarconfiguracion.htm")
public class ControlAgregarConfiguracion {
    
    ConfiguracionValidacion configuracionValidacion;
    private JdbcTemplate jdbcTemplate;
    
    public ControlAgregarConfiguracion(){
        
        this.configuracionValidacion=new ConfiguracionValidacion();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView configuracion(){
        
        ModelAndView mav=new ModelAndView();
        mav.setViewName("agregarconfiguracion");
        mav.addObject("configuracion",new Configuracion());
        return mav;
        
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView configuracion(@ModelAttribute("configuracion") Configuracion c,
    BindingResult result, SessionStatus status){
        
        this.configuracionValidacion.validate(c, result);
        if(result.hasErrors()){
            
            ModelAndView mav=new ModelAndView();
            mav.setViewName("agregarconfiguracion");
            mav.addObject("configuracion", new Configuracion());
            return mav;
        }else{
            
            this.jdbcTemplate.update("insert into configuracion "
            +"(desconfiguracion, desconfiguracion_d, nombre_variable, valor, id_modulo)"
            +"values(?,?,?,?,?)",c.getDesconfiguracion(),c.getDesconfiguracion_d(),
            c.getNombre_variable(),c.getValor(),c.getId_modulo());
            return new ModelAndView ("redirect:/configuracion.htm");
        }   
    } 
}
