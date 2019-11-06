
package Modelos.Empleados;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class EmpleadosValidacion implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Empleados.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Empleados empleados=(Empleados)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tipo_documento",
        "requiered.tipo_documento", "El campo Tipo Documento es obligatorio");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"documento",
        "required.documento", "El campo Documento es obligatorio");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nombre",
        "required.nombre", "El campo Nombre es obligatorio");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"telefono",
        "required.telefono", "El campo Teléfono es obligatorio");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"id_ccostos",
        "required.id_ccostos","El campo I.D. C.Costos es obligatorio" );
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"id_cargo",
        "required.id_cargo","El campo I.D. Cargo es obligatorio");
    }
    
}
