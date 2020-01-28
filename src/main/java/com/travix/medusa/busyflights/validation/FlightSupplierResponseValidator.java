package com.travix.medusa.busyflights.validation;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;

import com.travix.medusa.busyflights.domain.FlightSupplierResponse;


/**
 * Performs a validation on a flight supplier response.
 * @author marcelo.chiaradia
 *
 */
public class FlightSupplierResponseValidator
    extends GenericValidator<FlightSupplierResponse[]> {

    @Override
    protected List<String> validateInternalProperties(FlightSupplierResponse[] in) {
        return Arrays.stream(in).map(item -> this.validateSingleItem(item)).flatMap(List::stream)
            .collect(Collectors.toList());
    }

    private List<String> validateSingleItem(FlightSupplierResponse in) {
        Set<ConstraintViolation<FlightSupplierResponse>> violations = this.validator.validate(in);
        return violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
    }
}
