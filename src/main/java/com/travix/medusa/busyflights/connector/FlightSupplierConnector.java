package com.travix.medusa.busyflights.connector;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

import com.travix.medusa.busyflights.domain.FlightSupplierResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.validation.GenericValidator;

/**
 * Performs HTTP call to flight suppliers web services.
 * @author marcelo.chiaradia
 *
 */
@Validated
public class FlightSupplierConnector
    extends RestConnector {

    @Autowired
    private GenericValidator<FlightSupplierResponse[]> flightSupplierResponseValidator;

    public FlightSupplierResponse[] crazyAirFlightsSearch(@Valid CrazyAirRequest request) {
        return this.getForObject(FlightSuppliersURLs.CRAZY_AIR_SEARCH_URL, CrazyAirResponse[].class,
            request.getMandatoryArguments(), this.flightSupplierResponseValidator);
    }

    public FlightSupplierResponse[] toughJetFlightsSearch(@Valid ToughJetRequest request) {
        return this.getForObject(FlightSuppliersURLs.TOUGH_JET_SEARCH_URL, ToughJetResponse[].class,
            request.getMandatoryArguments(), this.flightSupplierResponseValidator);
    }
}
