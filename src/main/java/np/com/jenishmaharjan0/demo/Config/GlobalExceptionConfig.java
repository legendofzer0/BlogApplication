package np.com.jenishmaharjan0.demo.Config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionConfig {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex){
        Map<String,String> error =new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach((fieldError)->{
            error.put(fieldError.getField(),fieldError.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(error);
    }
//    @ExceptionHandler(MissingServletRequestParameterException.class){
//        public ResponseEntity<Object> handleMissingServletRequestException(MissingServletRequestParameterException ex){
//        Map<String,String> error =new HashMap<>();
//        error.put("message","Missing required parameter");
//        ex.getBindingResult().getFieldErrors().forEach((fieldError)->{
//            error.put(fieldError.getField(),fieldError.getDefaultMessage());
//        });
//        return ResponseEntity.badRequest().body(error);}
//    }
}

