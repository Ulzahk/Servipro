
package Servicios;

import Modelos.Conectar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ServicioLogin {
    
    private JdbcTemplate jdbcTemplate;
    
    public ServicioLogin(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    
    public List logeo(String id_usuario, String contraseña){
        List lista=this.jdbcTemplate.queryForList("Select * from nm_usuarios "
                + "where id_usuario=? and contraseña=?", id_usuario, contraseña);
        return lista;
    }
}
