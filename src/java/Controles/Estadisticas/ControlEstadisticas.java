
package Controles.Estadisticas;

import Modelos.Conectar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


public class ControlEstadisticas {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlEstadisticas(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    @RequestMapping("estadisticas.htm")
    public ModelAndView consulta(){
        ModelAndView mav=new ModelAndView();
        String sql="select Id_estadistica, Nombre, dia1.Alias Alias1, dia2.Alias Alias2, dia3.Alias Alias3, dia4.Alias Alias4, dia5.Alias Alias5, "
                                        + " dia6.Alias Alias6, dia7.Alias Alias7, dia8.Alias Alias8, dia9.Alias Alias9, dia10.Alias Alias10, "
                                        + " dia11.Alias Alias11, dia12.Alias Alias12, dia13.Alias Alias13, dia14.Alias Alias14, dia15.Alias Alias15, "
                                        + " dia16.Alias Alias16, dia17.Alias Alias17, dia18.Alias Alias18, dia19.Alias Alias19, dia20.Alias Alias20, "
                                        + " dia21.Alias Alias21, dia22.Alias Alias22, dia23.Alias Alias23, dia24.Alias Alias24, dia25.Alias Alias25, "
                                        + " dia26.Alias Alias26, dia27.Alias Alias27, dia28.Alias Alias28, dia29.Alias Alias29, dia30.Alias Alias30  "
                                        + " from nm_estadistica join nm_empleados "
                                        + " on nm_estadistica.id_empleado=nm_empleados.id_empleado join nm_tipo_novedad dia1"
                                        + " on nm_estadistica.id_dia1 = dia1.id_novedad join nm_tipo_novedad dia2 "
                                        + " on nm_estadistica.id_dia2 = dia2.id_novedad join nm_tipo_novedad dia3 "
                                        + " on nm_estadistica.id_dia3 = dia3.id_novedad join nm_tipo_novedad dia4 "
                                        + " on nm_estadistica.id_dia4 = dia4.id_novedad join nm_tipo_novedad dia5 "
                                        + " on nm_estadistica.id_dia5 = dia5.id_novedad join nm_tipo_novedad dia6 "
                                        + " on nm_estadistica.id_dia6 = dia6.id_novedad join nm_tipo_novedad dia7 "
                                        + " on nm_estadistica.id_dia7 = dia7.id_novedad join nm_tipo_novedad dia8 "
                                        + " on nm_estadistica.id_dia8 = dia8.id_novedad join nm_tipo_novedad dia9 "
                                        + " on nm_estadistica.id_dia9 = dia9.id_novedad join nm_tipo_novedad dia10 "
                                        + " on nm_estadistica.id_dia10 = dia10.id_novedad join nm_tipo_novedad dia11 "
                                        + " on nm_estadistica.id_dia11 = dia11.id_novedad join nm_tipo_novedad dia12 "
                                        + " on nm_estadistica.id_dia12 = dia12.id_novedad join nm_tipo_novedad dia13 "
                                        + " on nm_estadistica.id_dia13 = dia13.id_novedad join nm_tipo_novedad dia14 "
                                        + " on nm_estadistica.id_dia14 = dia14.id_novedad join nm_tipo_novedad dia15 "
                                        + " on nm_estadistica.id_dia15 = dia15.id_novedad join nm_tipo_novedad dia16 "
                                        + " on nm_estadistica.id_dia16 = dia16.id_novedad join nm_tipo_novedad dia17 "
                                        + " on nm_estadistica.id_dia17 = dia17.id_novedad join nm_tipo_novedad dia18 "
                                        + " on nm_estadistica.id_dia18 = dia18.id_novedad join nm_tipo_novedad dia19 "
                                        + " on nm_estadistica.id_dia19 = dia19.id_novedad join nm_tipo_novedad dia20 "
                                        + " on nm_estadistica.id_dia20 = dia20.id_novedad join nm_tipo_novedad dia21 "
                                        + " on nm_estadistica.id_dia21 = dia21.id_novedad join nm_tipo_novedad dia22 "
                                        + " on nm_estadistica.id_dia22 = dia22.id_novedad join nm_tipo_novedad dia23 "
                                        + " on nm_estadistica.id_dia23 = dia23.id_novedad join nm_tipo_novedad dia24 "
                                        + " on nm_estadistica.id_dia24 = dia24.id_novedad join nm_tipo_novedad dia25 "
                                        + " on nm_estadistica.id_dia25 = dia25.id_novedad join nm_tipo_novedad dia26 "
                                        + " on nm_estadistica.id_dia26 = dia26.id_novedad join nm_tipo_novedad dia27 "
                                        + " on nm_estadistica.id_dia27 = dia27.id_novedad join nm_tipo_novedad dia28 "
                                        + " on nm_estadistica.id_dia28 = dia28.id_novedad join nm_tipo_novedad dia29 "
                                        + " on nm_estadistica.id_dia29 = dia29.id_novedad join nm_tipo_novedad dia30 "
                                        + " on nm_estadistica.id_dia30 = dia30.id_novedad";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.setViewName("estadisticas");
        mav.addObject("datos",datos);
        return mav; 
    }
}
