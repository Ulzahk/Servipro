package Controles.Perfil;

import Modelos.Conectar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ControlEliminarPerfil {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlEliminarPerfil(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
       
    @RequestMapping("eliminarperfil.htm")
    public ModelAndView perfil (HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        int id_perfil=Integer.parseInt(request.getParameter("id_perfil"));
        String sql="select * from nm_perfil where id_perfil='"+id_perfil+"'";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos",datos);
        mav.setViewName("eliminarperfil");
        return mav;
    }
}