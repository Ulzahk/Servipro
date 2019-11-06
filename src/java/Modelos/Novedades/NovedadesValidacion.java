
package Modelos.Novedades;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class NovedadesValidacion implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return Novedades.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Novedades novedades=(Novedades)o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"descripcion",
        "request.descripcion","El campo Descripcion es obligatorio");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"alias",
        "request.alias","El campo Alias es obligatorio");
        
    }
    
}
