
package Modelos.Perfil;

import Modelos.Perfil.Perfil;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PerfilValidacion implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Perfil.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Perfil perfil=(Perfil)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"descripcion_perfil",
        "required.descripcion_perfil","El campo Descripcion Perfil es obligatorio.");
    }
}
