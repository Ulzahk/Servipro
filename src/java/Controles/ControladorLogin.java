
package Controles;

import Servicios.ServicioLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControladorLogin {
    @Autowired
    public ServicioLogin servicioLogin;
    
    @RequestMapping(value="login.htm")
    public String home(){
        return "login.htm";
    }
}
