
package Controles.CentroDeCostos;

import Modelos.CentroDeCostos.CentroDeCostos;
import Modelos.CentroDeCostos.CentroDeCostosValidacion;
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
@RequestMapping("agregarcentrodecostos.htm")
public class ControlAgregarCentroDeCostos {
    
    CentroDeCostosValidacion centroDeCostosValidacion;
    private JdbcTemplate jdbcTemplate;
    
    public ControlAgregarCentroDeCostos(){
        
        this.centroDeCostosValidacion=new CentroDeCostosValidacion();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView centroDeCostos(){
        
        ModelAndView mav=new ModelAndView();
        mav.setViewName("agregarcentrodecostos");
        mav.addObject("centrodecostos", new CentroDeCostos());
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView centroDeCostos(@ModelAttribute ("centrodecostos") CentroDeCostos cdc,
    BindingResult result, SessionStatus status){
        
        this.centroDeCostosValidacion.validate(cdc, result);
        if(result.hasErrors()){
            
            ModelAndView mav=new ModelAndView();
            mav.setViewName("agregarcentrodecostos");
            mav.addObject("centrodecostos", new CentroDeCostos());
            return mav;
            
        }else{
            
            this.jdbcTemplate.update(
            "insert into centro_de_costos(nombre_ccostos)values(?)",
            cdc.getNombre_ccostos());
            return new ModelAndView("redirect:/centrodecostos.htm");
        } 
    }
}
