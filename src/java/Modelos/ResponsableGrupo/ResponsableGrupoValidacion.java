
package Modelos.ResponsableGrupo;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class ResponsableGrupoValidacion implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return ResponsableGrupo.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ResponsableGrupo responsableGrupo=(ResponsableGrupo)o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"id_grupo",
        "require.id_grupo","El campo I.D. Grupo es obligatorio");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"id_usuario",
        "required.id_usuario","El campo I.D. Usuarios es obligatorio");
        
    }
}
