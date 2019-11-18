package Controles.Facturacion;

import Modelos.Conectar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ControlEliminarFacturacion {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlEliminarFacturacion(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping("eliminarfacturacion.htm")
    public ModelAndView tipoNovedad(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        int id_tipo_novedad=Integer.parseInt(request.getParameter("id_tipo_novedad"));
        String sql="select * from nm_facturacion where id_tipo_novedad='"+id_tipo_novedad+"'";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.setViewName("eliminarfacturacion");
        mav.addObject("datos",datos);
        return mav;
    }
}

