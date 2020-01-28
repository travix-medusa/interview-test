package com.travix.medusa.busyflights.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;

/**
 * Convenient controller to get CrazyAir flights. For mocking purpose.
 * @author marcelo.chiaradia
 *
 */
@RestController
public class CrazyAirController {

    @RequestMapping(value = "/crazyair/flights", method = RequestMethod.GET)
    public List<CrazyAirResponse> crazyAirFlights(BusyFlightsRequest request) {
        List<CrazyAirResponse> out = new ArrayList<CrazyAirResponse>();

        out.add(new CrazyAirResponse("Gol", 100.21, "E", "EZE", "GIG", "2017-07-08T11:44:44.797", "2017-07-09T11:44:44.797"));
        out.add(new CrazyAirResponse("Gol", 90.21, "B", "EZE", "GIG", "2017-07-08T11:44:44.797", "2017-07-09T11:44:44.797"));
        out.add(new CrazyAirResponse("AA", 230.21, "B", "EZE", "GIG", "2017-07-08T11:44:44.797", "2017-07-09T11:44:44.797"));
        out.add(new CrazyAirResponse("Latam", 65.21, "E", "EZE", "GIG", "2017-07-08T11:44:44.797", "2017-07-09T11:44:44.797"));
        out.add(new CrazyAirResponse("Latam", 300.21, "B", "EZE", "GIG", "2017-07-08T11:44:44.797",
            "2017-07-09T11:44:44.797"));

        return out;
    }
}
