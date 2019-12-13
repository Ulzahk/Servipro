/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles.NovedadesEmpleado2;

import Modelos.Conectar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author PRACTICANTE
 */
 
    
public class ControlNovedadesEmpleado2 {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlNovedadesEmpleado2(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
       
    @RequestMapping("novedadesempleado2.htm")
    public ModelAndView perfil (){
        ModelAndView mav = new ModelAndView();
        String sql="SELECT * FROM dbo.nm_novedades_empleado2";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos",datos);
        mav.setViewName("novedadesempleado2");
        return mav;
    }
}

