
package Controles.Empleados;

import Modelos.Conectar;
import Modelos.Empleados.Empleados;
import Modelos.Empleados.EmpleadosValidacion;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("agregarempleados.htm")

public class ControlAgregarEmpleados {
    
    EmpleadosValidacion empleadosValidacion;
    private JdbcTemplate jdbcTemplate;
    
    public ControlAgregarEmpleados(){
        
        this.empleadosValidacion=new EmpleadosValidacion();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView empleados(){
        
        ModelAndView mav=new ModelAndView();
        mav.setViewName("agregarempleados");
        mav.addObject("empleados",new Empleados());
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView empleados(@ModelAttribute("empleados")Empleados emp,
    BindingResult result, SessionStatus status){
        
        this.empleadosValidacion.validate(emp, result);
        if(result.hasErrors()){
            
            ModelAndView mav=new ModelAndView();
            mav.setViewName("agregarempleados");
            mav.addObject("empleados", new Empleados ());
            return mav;
            
        }else{
            
            this.jdbcTemplate.update(
            "insert into empleados (tipo_documento, documento, nombre, telefono, id_ccostos,id_cargo)"
                    + " values"+ "(?,?,?,?,?,?)", emp.getTipo_documento(),emp.getDocumento(),emp.getNombre(),
            emp.getTelefono(),emp.getId_ccostos(),emp.getId_cargo());
            return new ModelAndView("redirect:/empleados.htm");
        }
    }
}
