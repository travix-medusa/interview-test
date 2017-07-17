package com.travix.medusa.busyflights.domain;

import com.travix.medusa.busyflights.service.visitor.FlightSupplierResponseVisitor;


/**
 * Common interface for flight supplier responses.
 * @author marcelo.chiaradia
 *
 */
public interface FlightSupplierResponse {

    <T> T accept(FlightSupplierResponseVisitor<T> visitor);
}
