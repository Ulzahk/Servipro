
package Modelos.TipoNovedad;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class TipoNovedadValidacion implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return TipoNovedad.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        TipoNovedad tipoNovedad=(TipoNovedad)o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"descripcion",
        "required.descripcion","El campo Descripcion es obligatorio");
        
    }
    
}
