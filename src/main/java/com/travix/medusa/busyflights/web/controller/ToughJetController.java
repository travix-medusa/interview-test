package com.travix.medusa.busyflights.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;

/**
 * Convenient controller to get ToughJet flights. For mocking purpose.
 * @author marcelo.chiaradia
 *
 */
@RestController
public class ToughJetController {

    @RequestMapping(value = "/toughjet/flights", method = RequestMethod.GET)
    public List<ToughJetResponse> toughJetFlights(BusyFlightsRequest request) {
        List<ToughJetResponse> out = new ArrayList<ToughJetResponse>();

        out.add(new ToughJetResponse("Gol", 200.21, 100.32, 20, "EZE", "GIG", "2017-07-08T09:28:27.141Z",
            "2017-07-09T09:28:27.141Z"));
        out.add(new ToughJetResponse("Gol", 250.21, 110.32, 15, "EZE", "GIG", "2017-07-08T09:28:27.141Z",
            "2017-07-09T09:28:27.141Z"));
        out.add(new ToughJetResponse("AA", 99.21, 40.32, 5, "EZE", "GIG", "2017-07-08T09:28:27.141Z",
            "2017-07-09T09:28:27.141Z"));
        out.add(new ToughJetResponse("AA", 120.21, 45.32, 7, "EZE", "GIG", "2017-07-08T09:28:27.141Z",
            "2017-07-09T09:28:27.141Z"));
        out.add(new ToughJetResponse("Latam", 77.21, 33.32, 15, "EZE", "GIG", "2017-07-08T09:28:27.141Z",
            "2017-07-09T09:28:27.141Z"));
        out.add(new ToughJetResponse("Latam", 125.21, 70.32, 35, "EZE", "GIG", "2017-07-08T09:28:27.141Z",
            "2017-07-09T09:28:27.141Z"));

        return out;
    }
}
