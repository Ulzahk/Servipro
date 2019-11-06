
package Controles.TipoNovedad;

import Modelos.Conectar;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


public class ControlConfirmarEliminarTipoNovedad {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlConfirmarEliminarTipoNovedad(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping("confirmareliminartiponovedad.htm")
    public ModelAndView tipoNovedad(HttpServletRequest request){
        
        int id_tipo_novedad=Integer.parseInt(request.getParameter("id_tipo_novedad"));
        this.jdbcTemplate.update("delete from tipo_novedad where id_tipo_novedad=?",
        id_tipo_novedad);
        return new ModelAndView("redirect:/tiponovedad.htm");
                
    }
    
}
