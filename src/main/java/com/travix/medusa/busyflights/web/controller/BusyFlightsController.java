package com.travix.medusa.busyflights.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.service.BusyFlightsService;

/**
 * Defines the REST API for the BusyFlights application.
 * @author marcelo.chiaradia
 *
 */
@RestController
public class BusyFlightsController {

    @Autowired
    private BusyFlightsService busyFlightsService;

    @RequestMapping(value = "/busyflights/flights", method = RequestMethod.GET)
    public List<BusyFlightsResponse> busyFlights(@Valid BusyFlightsRequest request) {
        return this.busyFlightsService.searchForFlights(request);
    }
}
