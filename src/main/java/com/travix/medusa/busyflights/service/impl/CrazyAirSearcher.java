package com.travix.medusa.busyflights.service.impl;

import com.travix.medusa.busyflights.domain.FlightSupplierResponse;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.service.FlightSupplierSearcher;

public class CrazyAirSearcher
    extends FlightSupplierSearcher {

    @Override
    protected FlightSupplierResponse[] search(BusyFlightsRequest in) {
        return this.flightSupplierConnector.crazyAirFlightsSearch(this.busyFlightsRequestTransformer.toCrazyAirRequest(in));
    }

}
