package com.travix.medusa.busyflights.service;

import java.util.List;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;

/**
 * Retrieves flights from the flight suppliers and produce an aggregated result form their responses.
 * @author marcelo.chiaradia
 *
 */
public interface BusyFlightsService {

    List<BusyFlightsResponse> searchForFlights(BusyFlightsRequest request);
}
