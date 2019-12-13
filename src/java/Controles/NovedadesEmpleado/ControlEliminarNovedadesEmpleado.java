
package Controles.NovedadesEmpleado;

import Modelos.Conectar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ControlEliminarNovedadesEmpleado {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlEliminarNovedadesEmpleado(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping("eliminarnovedadesempleado.htm")
    public ModelAndView novedadesEmpleado(HttpServletRequest request){
        ModelAndView mav= new ModelAndView();
        int id_novedad_empleado=Integer.parseInt(request.getParameter("id_novedad_empleado"));
        String sql="SELECT * FROM nm_novedades_empleado tbNE JOIN nm_empleadosjsp tbE ON tbE.emplId = tbNE.Id_empleado "
                + "JOIN nm_tipo_novedad tbTN ON tbTN.Id_novedad = tbNE.Id_novedad where id_novedad_empleado='"+id_novedad_empleado+"'";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.setViewName("eliminarnovedadesempleado");
        mav.addObject("datos",datos);
        return mav;
    }
}
