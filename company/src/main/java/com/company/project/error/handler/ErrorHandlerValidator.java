package com.company.project.error.handler;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlerValidator {
	
    @ExceptionHandler(BindException.class)
    public ResponseEntity<ValidationErrors>  handleException(BindException ex) {
    	
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        ValidationErrors validationErrors = new ValidationErrors();
        for (FieldError fieldError : fieldErrors) {
            validationErrors.addError(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return new ResponseEntity<ValidationErrors>(validationErrors, HttpStatus.BAD_REQUEST);
    }
    
}
