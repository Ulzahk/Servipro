package Controles.Facturacion;

import Modelos.Conectar;
import Modelos.TipoNovedad.TipoNovedad;
import Modelos.TipoNovedad.TipoNovedadValidacion;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("agregarfacturacion.htm")
public class ControlAgregarFacturacion {
    
    TipoNovedadValidacion tipoNovedadValidacion;
    private JdbcTemplate jdbcTemplate;
    
    public ControlAgregarFacturacion(){
        
        this.tipoNovedadValidacion=new TipoNovedadValidacion();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView tipoNovedad(){
        
        ModelAndView mav=new ModelAndView();
        mav.setViewName("agregarfacturacion");
        mav.addObject("tiponovedad",new TipoNovedad());
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView tipoNovedad(@ModelAttribute("tiponovedad")TipoNovedad tn,
    BindingResult result, SessionStatus status){
        
        this.tipoNovedadValidacion.validate(tn, result);
        if(result.hasErrors()){
            
            ModelAndView mav=new ModelAndView();
            mav.setViewName("agregarfacturacion");
            mav.addObject("tiponovedad",new TipoNovedad());
            return mav;
            
        }else{
            
            this.jdbcTemplate.update("insert into nm_facturacion(descripcion) values(?)",
            tn.getDescripcion());
            return new ModelAndView("redirect:/facturacion.htm");
            
        }
    }
}

