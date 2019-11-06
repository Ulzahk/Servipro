
package Modelos.Grupos;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class GruposValidacion implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Grupos.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Grupos grupos=(Grupos)o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nombre_grupo",
        "required.nombre_grupo", "El Nombre Grupo es obligatorio");
    }
}
