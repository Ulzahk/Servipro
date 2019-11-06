
package Controles.CentroDeCostos;

import Modelos.Conectar;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ControlConfirmarEliminarCentroDeCostos {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlConfirmarEliminarCentroDeCostos(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping("confirmareliminarcentrodecostos.htm")
    public ModelAndView centroDeCostos(HttpServletRequest request){
        
        int id_ccostos=Integer.parseInt(request.getParameter("id_ccostos"));
        this.jdbcTemplate.update("delete from nm_centro_de_costos "+"where "+"id_ccostos=?",id_ccostos);
        return new ModelAndView("redirect:/centrodecostos.htm");
        
    }
    
}
