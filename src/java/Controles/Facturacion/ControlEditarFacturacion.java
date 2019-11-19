package Controles.Facturacion;

import Modelos.Conectar;
import Modelos.TipoNovedad.TipoNovedad;
import Modelos.TipoNovedad.TipoNovedadValidacion;
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
@RequestMapping("editarfacturacion.htm")
public class ControlEditarFacturacion {
    
    TipoNovedadValidacion tipoNovedadValidacion;
    private JdbcTemplate jdbcTemplate;
    
    public ControlEditarFacturacion(){
        
        this.tipoNovedadValidacion=new TipoNovedadValidacion();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView tipoNovedad(HttpServletRequest request){
        
        ModelAndView mav=new ModelAndView();
        int id_tipo_novedad=Integer.parseInt(request.getParameter("id_tipo_novedad"));
        TipoNovedad datos=this.selectTipoNovedad(id_tipo_novedad);
        mav.setViewName("editarfacturacion");
        mav.addObject("tiponovedad",new TipoNovedad(id_tipo_novedad,datos.getDescripcion()));
        return mav;
        
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView tipoNovedad(@ModelAttribute("tiponovedad")TipoNovedad tn,
    BindingResult result, SessionStatus status, HttpServletRequest request){
        
        this.tipoNovedadValidacion.validate(tn, result);
        if(result.hasErrors()){
            
            ModelAndView mav=new ModelAndView();
            int id_tipo_novedad=Integer.parseInt(request.getParameter("id_tipo_novedad"));
            TipoNovedad datos=this.selectTipoNovedad(id_tipo_novedad);
            mav.setViewName("editarfacturacion");
            mav.addObject("tiponovedad",new TipoNovedad(id_tipo_novedad,datos.getDescripcion()));
            return mav;
            
        }else{
            
            int id_tipo_novedad=Integer.parseInt(request.getParameter("id_tipo_novedad"));
            this.jdbcTemplate.update("update nm_facturacion set descripcion=? where id_tipo_novedad=?",
            tn.getDescripcion(),id_tipo_novedad);
            return new ModelAndView("redirect:/facturacion.htm");
        }
    }
    
    public TipoNovedad selectTipoNovedad(int id_tipo_novedad){
        
        final TipoNovedad tipon=new TipoNovedad();
        String quer="select * from nm_facturacion where id_tipo_novedad='"+id_tipo_novedad+"'";
        return (TipoNovedad)jdbcTemplate.query(quer, new ResultSetExtractor<TipoNovedad>(){
            public TipoNovedad extractData(ResultSet rs) throws SQLException, DataAccessException{
                if(rs.next()){
                    tipon.setDescripcion(rs.getString("descripcion"));
                }
                return tipon;
            }
        });
    }
}

