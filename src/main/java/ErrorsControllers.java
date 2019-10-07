
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorsControllers {
    public static final String ISE_VIEW ="error500";
    @ExceptionHandler(Exception.class)
    public String ShowInternalServerError(){
        return ISE_VIEW;
    }
    
}
