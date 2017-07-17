package com.travix.medusa.busyflights.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.travix.medusa.busyflights.connector.FlightSupplierConnector;
import com.travix.medusa.busyflights.domain.FlightSupplierResponse;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.service.transformer.BusyFlightsRequestTransformer;

/**
 * Performs a flight search on a flight supplier.
 * @author marcelo.chiaradia
 *
 */
public abstract class FlightSupplierSearcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlightSupplierSearcher.class);

    @Autowired
    protected FlightSupplierConnector flightSupplierConnector;
    @Autowired
    protected BusyFlightsRequestTransformer busyFlightsRequestTransformer;

    public FlightSupplierResponse[] searchOnSupplier(BusyFlightsRequest request) {
        try {
            return this.search(request);
        } catch (Exception e) {
            LOGGER.error("Flight search error: " + e);
        }
        return new FlightSupplierResponse[0];
    }

    protected abstract FlightSupplierResponse[] search(BusyFlightsRequest request);
}
