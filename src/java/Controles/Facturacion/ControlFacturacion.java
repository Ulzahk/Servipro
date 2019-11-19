package Controles.Facturacion;

import Modelos.Conectar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ControlFacturacion {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlFacturacion(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping("facturacion.htm")
    public ModelAndView tipoNovedad(){
        ModelAndView mav = new ModelAndView();
        String sql="select * from nm_facturacion";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.setViewName("facturacion");
        mav.addObject("datos",datos);
        return mav;
    }
}
