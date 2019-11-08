
package Modelos.CargoEmpleado;

import Modelos.CargoEmpleado.CargoEmpleado;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class CargoEmpleadoValidacion implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        
        return CargoEmpleado.class.isAssignableFrom(type);
        
    }

    @Override
    public void validate(Object o, Errors errors) {
        
        CargoEmpleado cargoEmpleado=(CargoEmpleado)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descripcion_cargo",
        "required.descripcion_cargo", "El campo Descripcion Cargo es obligatorio");
        
    }
}
