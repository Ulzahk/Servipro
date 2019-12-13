
package Modelos.NovedadesEmpleado;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class NovedadesEmpleadoValidacion implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return NovedadesEmpleado.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        NovedadesEmpleado novedadesEmpleado=(NovedadesEmpleado)o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"id_empleado",
        "required.id_empleado", "El campo I.D. Empleado es obligatorio");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "detalle",
        "required.detalle", "El campo Detalle es obligatorio");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fecha",
        "required.fecha","El campo Fecha es obligatorio");
        
    }
    
}
