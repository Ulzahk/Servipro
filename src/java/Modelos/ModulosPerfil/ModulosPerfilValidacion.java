
package Modelos.ModulosPerfil;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class ModulosPerfilValidacion implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return ModulosPerfil.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {

        ModulosPerfil modulosPerfil=(ModulosPerfil)o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"id_modulo",
        "required.id_modulo","El campo I.D. Modulo es obligatorio");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"id_perfil",
        "required.id_perfil","El campo I.D. Perfil es obligatorio");
    }
}
