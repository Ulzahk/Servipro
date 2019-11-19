
package Modelos.EmpleadosGrupo;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class EmpleadosGrupoValidacion implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return EmpleadosGrupo.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        EmpleadosGrupo empleadosGrupo=(EmpleadosGrupo)o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"id_grupo",
        "required.id_grupo", "El campo I.D. Grupo es obligatorio");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"id_empleado",
        "required.id_empleado", "El campo I.D. Empleado es obligatorio");
    }
    
}
