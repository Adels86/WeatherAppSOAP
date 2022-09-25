package net.atos.weatherSoap.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserOrderNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(UserOrderNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String UserOrderNotFoundHandler(UserOrderNotFoundException e){
        return e.getMessage();
    }
}
