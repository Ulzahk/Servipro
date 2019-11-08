
package Modelos.Usuarios;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class UsuariosValidacion implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Usuarios.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Usuarios usuarios=(Usuarios)o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"id_usuario",
        "required.id_usuario","El campo Id_usuario es obligatorio");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"id_empleado",
        "required.id_empleado","El campo I.D. Empleado es obligatorio");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"contraseña",
        "required.contraseña","El campo Contraseña es obligatorio");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"id_perfil",
        "required.id_perfil","El campo I.D. Perfil es obligatorio");
    }
    
}
