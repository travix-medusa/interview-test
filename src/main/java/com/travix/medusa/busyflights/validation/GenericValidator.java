package com.travix.medusa.busyflights.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Performs a validation on an object of a given type, based on its internal annotated properties.
 * @author marcelo.chiaradia
 *
 * @param <T> The type of the object to be validated.
 */
public abstract class GenericValidator<T> {

    @Autowired
    protected Validator validator;

    public ValidationResponse validate(T in) {
        List<String> errors = new ArrayList<String>();

        if (in == null) {
            errors.add("Invalid bean, cannot be null");
        }

        Set<ConstraintViolation<T>> violations = this.validator.validate(in);
        errors = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());

        errors.addAll(this.validateInternalProperties(in));

        if (!errors.isEmpty()) {
            return ValidationResponse.newErrorResponse(errors);
        }
        return ValidationResponse.newSuccessResponse();
    }

    protected abstract List<String> validateInternalProperties(T in);
}
