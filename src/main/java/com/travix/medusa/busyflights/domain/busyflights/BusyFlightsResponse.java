package com.travix.medusa.busyflights.domain.busyflights;

import java.math.BigDecimal;

public class BusyFlightsResponse {

    private String airline;
    private String supplier;
    private BigDecimal fare;
    private String departureAirportCode;
    private String destinationAirportCode;
    private String departureDate;
    private String arrivalDate;

    public BusyFlightsResponse(String airline, String supplier, BigDecimal fare, String departureAirportCode,
        String destinationAirportCode, String departureDate, String arrivalDate) {
        super();
        this.airline = airline;
        this.supplier = supplier;
        this.fare = fare;
        this.departureAirportCode = departureAirportCode;
        this.destinationAirportCode = destinationAirportCode;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public String getAirline() {
        return airline;
    }

    public BigDecimal getFare() {
        return fare;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    @Override
    public String toString() {
        return "BusyFlightsResponse [airline=" + airline + ", supplier=" + supplier + ", fare=" + fare
            + ", departureAirportCode=" + departureAirportCode + ", destinationAirportCode=" + destinationAirportCode
            + ", departureDate=" + departureDate + ", arrivalDate=" + arrivalDate + "]";
    }

    public String getSupplier() {
        return supplier;
    }
}
