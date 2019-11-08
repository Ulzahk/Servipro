
package Controles.Empleados;

import Modelos.Conectar;
import Modelos.Empleados.Empleados;
import Modelos.Empleados.EmpleadosValidacion;
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
@RequestMapping("editarempleados.htm")
public class ControlEditarEmpleados {
    
    EmpleadosValidacion empleadosValidacion;
    private JdbcTemplate jdbcTemplate;
    
    public ControlEditarEmpleados(){
        
        this.empleadosValidacion=new EmpleadosValidacion();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView empleados(HttpServletRequest request){
        
        ModelAndView mav=new ModelAndView();
        int id_empleado=Integer.parseInt(request.getParameter("id_empleado"));
        Empleados datos=this.selectEmpleados(id_empleado);
        mav.setViewName("editarempleados");
        mav.addObject("empleados",new Empleados(id_empleado,datos.getTipo_documento(),
        datos.getDocumento(),datos.getNombre(),datos.getTelefono(),datos.getId_ccostos(),
        datos.getId_cargo()));
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView empleados(@ModelAttribute("empleados") Empleados emp,
    BindingResult result, SessionStatus status, HttpServletRequest request){
        
        this.empleadosValidacion.validate(emp, result);
        if(result.hasErrors()){
            ModelAndView mav=new ModelAndView();
            int id_empleado=Integer.parseInt(request.getParameter("id_empleado"));
            Empleados datos=this.selectEmpleados(id_empleado);
            mav.setViewName("editarempleados");
            mav.addObject("empleados", new Empleados(id_empleado,datos.getTipo_documento(),
            datos.getDocumento(),datos.getNombre(),datos.getTelefono(),datos.getId_ccostos(),
            datos.getId_cargo()));
            return mav;
            
        }else{
            
            int id_empleado=Integer.parseInt(request.getParameter("id_empleado"));
            this.jdbcTemplate.update("update empleados "+"set tipo_documento=?, "+
            "documento=?, nombre=?, telefono=?, id_ccostos=?, id_cargo=? where "+
            "id_empleado=?",emp.getTipo_documento(),emp.getDocumento(),emp.getNombre(),
            emp.getTelefono(),emp.getId_ccostos(),emp.getId_cargo(),id_empleado);
            return new ModelAndView("redirect:/empleados.htm");
        }
    }
    
    public Empleados selectEmpleados(int id_empleado){
        
        final Empleados emple=new Empleados();
        String quer="select * from empleados where id_empleado='"+id_empleado+"'";
        return (Empleados) jdbcTemplate.query(quer, new ResultSetExtractor<Empleados>(){
           public Empleados extractData(ResultSet rs)throws SQLException, DataAccessException{
               if(rs.next()){
                   emple.setTipo_documento(rs.getString("tipo_documento"));
                   emple.setDocumento(rs.getString("documento"));
                   emple.setNombre(rs.getString("nombre"));
                   emple.setTelefono(rs.getString("telefono"));
                   emple.setId_ccostos(rs.getInt("id_ccostos"));
                   emple.setId_cargo(rs.getInt("id_cargo"));
               }
               return emple;
           } 
        });
    }
}
