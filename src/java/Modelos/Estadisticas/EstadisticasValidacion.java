
package Modelos.Estadisticas;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class EstadisticasValidacion  implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return Estadisticas.class.isAssignableFrom(type);
                
    }

    @Override
    public void validate(Object o, Errors errors) {
        Estadisticas estadisticas = (Estadisticas)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id_empleado", 
                "requiered.id_empleado", "El campo id_empleado es obligatorio");
    }
    
}