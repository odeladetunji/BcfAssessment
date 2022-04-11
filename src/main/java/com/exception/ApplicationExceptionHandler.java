package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(Exception.class)
    private ResponseEntity<ErrorMessage> globalExceptionHandler(Exception ex, WebRequest webRequest){
        ex.printStackTrace();
        ErrorMessage errorMessage = null;
        if (ex.getMessage().equalsIgnoreCase("Bad credentials")) {
            errorMessage = new ErrorMessage(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    new Date(),
                    "Wrong login credentials enterred",
                    webRequest.getDescription(false)
            );
        }else {
            errorMessage = new ErrorMessage(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    new Date(),
                    ex.getMessage(),
                    webRequest.getDescription(false)
            );
        }

        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ApiException.class)
    private ResponseEntity<ErrorMessage> resourceNotFoundException(Exception ex, WebRequest webRequest){
        ex.printStackTrace();
        ErrorMessage errorMessage = null;
        if (ex.getMessage().equalsIgnoreCase("Bad credentials")) {
            errorMessage = new ErrorMessage(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    new Date(),
                    "Wrong login credentials enterred",
                    webRequest.getDescription(false)
            );
        }else {
            errorMessage = new ErrorMessage(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    new Date(),
                    ex.getMessage(),
                    webRequest.getDescription(false)
            );
        }
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AuthenticationError.class)
    private ResponseEntity<ErrorMessage> AuthenticationError(Exception ex, WebRequest webRequest){
        ex.printStackTrace();
        ErrorMessage errorMessage = new ErrorMessage(
                HttpStatus.UNAUTHORIZED.value(),
                new Date(),
                "UnAthorized: Invalid token",
                webRequest.getDescription(false)
        );

        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.UNAUTHORIZED);
    }
}
