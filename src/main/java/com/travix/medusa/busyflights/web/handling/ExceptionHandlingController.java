package com.travix.medusa.busyflights.web.handling;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.travix.medusa.busyflights.validation.ValidationResponse;

/**
 * Catches exceptions thrown by controllers and retrieve responses with HttpStatus. 
 * @author marcelo.chiaradia
 *
 */
@RestControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationResponse invalidInput(BindException ex) {
        BindingResult result = ex.getBindingResult();
        List<String> errorMessages = result.getFieldErrors().stream().map(FieldError::getDefaultMessage)
            .collect(Collectors.toList());
        return ValidationResponse.newErrorResponse(errorMessages);
    }
}
