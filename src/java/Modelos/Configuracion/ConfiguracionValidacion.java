
package Modelos.Configuracion;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class ConfiguracionValidacion implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Configuracion.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Configuracion configuracion=(Configuracion)o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"desconfiguracion",
        "required.desconfiguracion","El campo Desconfiguracion es obligatorio");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"desconfiguracion_d",
        "required.desconfiguracion_d","El campo Desconfiguracion D. es obligatorio");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nombre_variable",
        "required.nombre_variable","El campo Nombre Variable es obligatorio");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"valor",
        "required.valor","El campo Valor es obligatorio");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"id_modulo",
        "required.id_modulo","El campo I.D. Modulo es obligatorio");
        
    }
    
}
