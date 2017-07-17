package com.travix.medusa.busyflights.service.transformer;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;

/**
 * Transforms a BusyFlightsRequest into an specific flight supplier request.
 * @author marcelo.chiaradia
 *
 */
public class BusyFlightsRequestTransformer {

    public CrazyAirRequest toCrazyAirRequest(BusyFlightsRequest in) {
        return new CrazyAirRequest(in.getOrigin(), in.getDestination(), in.getDepartureDate(), in.getReturnDate(),
            in.getNumberOfPassengers());
    }

    public ToughJetRequest toToughJetRequest(BusyFlightsRequest in) {
        return new ToughJetRequest(in.getOrigin(), in.getDestination(), in.getDepartureDate(), in.getReturnDate(),
            in.getNumberOfPassengers());
    }
}
