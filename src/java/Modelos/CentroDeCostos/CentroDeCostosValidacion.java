
package Modelos.CentroDeCostos;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class CentroDeCostosValidacion implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        
        return CentroDeCostos.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        
        CentroDeCostos centroDeCostos=(CentroDeCostos)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre_ccostos",
        "required.nombre_ccosto", "El campo Nombre C.Costos es obligatorio");
        
    }
    
}
