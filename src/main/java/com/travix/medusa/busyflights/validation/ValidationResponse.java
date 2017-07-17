package com.travix.medusa.busyflights.validation;

import java.util.List;


/**
 * The result of perform a validation on a bean object.
 * @author marcelo.chiaradia
 *
 */
public class ValidationResponse {

    private ValidationStatus status;
    private List<String> errors;

    public static ValidationResponse newSuccessResponse() {
        return new ValidationResponse(ValidationStatus.VALIDATION_SUCCEEDED, null);
    }

    public static ValidationResponse newErrorResponse(List<String> errors) {
        return new ValidationResponse(ValidationStatus.VALIDATION_ERROR, errors);
    }

    private ValidationResponse(ValidationStatus status, List<String> errors) {
        super();
        this.status = status;
        this.errors = errors;
    }

    public boolean isSucceeded() {
        return ValidationStatus.VALIDATION_SUCCEEDED.equals(this.status);
    }

    public ValidationStatus getStatus() {
        return status;
    }

    public List<String> getErrors() {
        return errors;
    }

    @Override
    public String toString() {
        return "ValidationResponse [status=" + status + ", errors=" + errors + "]";
    }
}
