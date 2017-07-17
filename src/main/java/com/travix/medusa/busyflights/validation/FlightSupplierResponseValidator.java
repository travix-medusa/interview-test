package com.travix.medusa.busyflights.validation;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;

import com.travix.medusa.busyflights.domain.FlightSupplierResponse;


/**
 * Performs a validation on a flight supplier response.
 * @author marcelo.chiaradia
 *
 */
public class FlightSupplierResponseValidator
    extends GenericValidator<FlightSupplierResponse[]> {

    @Autowired
    private Validator validator;

    @Override
    public ValidationResponse validate(FlightSupplierResponse[] in) {
        ValidationResponse validationResult = super.validate(in);

        if (!validationResult.isSucceeded()) {
            return validationResult;
        }
        List<String> errors = Arrays.stream(in).map(item -> this.validateSingleItem(item)).flatMap(List::stream)
            .collect(Collectors.toList());

        if (!errors.isEmpty()) {
            return ValidationResponse.newErrorResponse(errors);
        }
        return ValidationResponse.newSuccessResponse();
    }

    private List<String> validateSingleItem(FlightSupplierResponse in) {
        Set<ConstraintViolation<FlightSupplierResponse>> violations = this.validator.validate(in);
        return violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
    }
}
