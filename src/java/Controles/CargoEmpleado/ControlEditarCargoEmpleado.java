
package Controles.CargoEmpleado;

import Modelos.CargoEmpleado.CargoEmpleado;
import Modelos.CargoEmpleado.CargoEmpleadoValidacion;
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
@RequestMapping("editarcargoempleado.htm")
public class ControlEditarCargoEmpleado {
    
    CargoEmpleadoValidacion cargoEmpleadoValidacion;
    private JdbcTemplate jdbcTemplate; 
    
    public ControlEditarCargoEmpleado(){
        
        this.cargoEmpleadoValidacion=new CargoEmpleadoValidacion();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView cargoEmpleado(HttpServletRequest request){
        
        ModelAndView mav=new ModelAndView();
        int id_cargo=Integer.parseInt(request.getParameter("id_cargo"));
        CargoEmpleado datos = this.selectCargoEmpleado(id_cargo);
        mav.setViewName("editarcargoempleado");
        mav.addObject("cargoempleado", new CargoEmpleado(id_cargo,datos.getDescripcion_cargo()));
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView cargoEmpleado(@ModelAttribute("cargoempleado") CargoEmpleado ce,
    BindingResult result, SessionStatus status, HttpServletRequest request){
        
        this.cargoEmpleadoValidacion.validate(ce, result);
        if(result.hasErrors()){
            
            ModelAndView mav=new ModelAndView();
            int id_cargo=Integer.parseInt(request.getParameter("id_cargo"));
            CargoEmpleado datos = this.selectCargoEmpleado(id_cargo);
            mav.setViewName("editarcargoempleado");
            mav.addObject("cargoempleado", new CargoEmpleado(id_cargo,datos.getDescripcion_cargo()));
            return mav;
                    
        }else{
            
            int id_cargo=Integer.parseInt(request.getParameter("id_cargo"));
            this.jdbcTemplate.update("update cargo_empleado "+" set descripcion_cargo=? "+
            "where "+"id_cargo=?",ce.getDescripcion_cargo(),id_cargo);
            return new ModelAndView("redirect:/cargoempleado.htm");
            
        }
    }
    
    public CargoEmpleado selectCargoEmpleado(int id_cargo){
        
        final CargoEmpleado cargoemp=new CargoEmpleado();
        String quer="select * from cargo_empleado where id_cargo='"+id_cargo+"'";
        return(CargoEmpleado) jdbcTemplate.query(quer, new ResultSetExtractor<CargoEmpleado>(){
            public CargoEmpleado extractData(ResultSet rs) throws SQLException, DataAccessException{
                
                if(rs.next()){
                    cargoemp.setDescripcion_cargo(rs.getString("descripcion_cargo"));
                }
                return cargoemp;
            }    
        });
    }
}
