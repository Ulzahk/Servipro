
package Controles.NovedadesEmpleado;

import Modelos.Conectar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ControlNovedadesEmpleado {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlNovedadesEmpleado(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping("novedadesempleado.htm")
    public ModelAndView novedadesEmpleado(){
        ModelAndView mav= new ModelAndView();
        String sql="SELECT * FROM nm_novedades_empleado tbNE JOIN nm_empleadosjsp tbE ON tbE.emplId = tbNE.Id_empleado "
                + "JOIN nm_tipo_novedad tbTN ON tbTN.Id_novedad = tbNE.Id_novedad ";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.setViewName("novedadesempleado");
        mav.addObject("datos",datos);
        return mav;
    }
}
