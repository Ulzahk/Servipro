
package Modelos.Modulos;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ModulosValidacion implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        
        return Modulos.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        
        Modulos modulos=(Modulos)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nombre_modulo",
        "required.nombre_modulo", "El campo Nombre Modulo es obligatorio");
    }
    
}
