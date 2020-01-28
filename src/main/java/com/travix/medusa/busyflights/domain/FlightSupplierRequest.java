package com.travix.medusa.busyflights.domain;


/**
 * Common interface for flight supplier requests.
 * @author marcelo.chiaradia
 *
 */
public interface FlightSupplierRequest {

    /**Retrieve the mandatory arguments in order to be used to perform HTTP requests.
     * @return the mandatory arguments
     */
    Object[] getMandatoryArguments();
}
