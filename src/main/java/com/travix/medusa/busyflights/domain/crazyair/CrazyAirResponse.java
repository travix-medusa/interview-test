package com.travix.medusa.busyflights.domain.crazyair;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.travix.medusa.busyflights.domain.FlightSupplierResponse;
import com.travix.medusa.busyflights.service.visitor.FlightSupplierResponseVisitor;

public class CrazyAirResponse
    implements FlightSupplierResponse {

    @NotNull
    private String airline;
    private double price;
    @NotNull
    private String cabinclass;
    @Size(min = 3, max = 3)
    @NotNull
    private String departureAirportCode;
    @Size(min = 3, max = 3)
    @NotNull
    private String destinationAirportCode;
    @NotNull
    private String departureDate;
    @NotNull
    private String arrivalDate;

    public CrazyAirResponse() {
        super();
    }

    public CrazyAirResponse(String airline, double price, String cabinclass, String departureAirportCode,
        String destinationAirportCode, String departureDate, String arrivalDate) {
        super();
        this.airline = airline;
        this.price = price;
        this.cabinclass = cabinclass;
        this.departureAirportCode = departureAirportCode;
        this.destinationAirportCode = destinationAirportCode;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    @Override
    public <T> T accept(FlightSupplierResponseVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(final String airline) {
        this.airline = airline;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public String getCabinclass() {
        return cabinclass;
    }

    public void setCabinclass(final String cabinclass) {
        this.cabinclass = cabinclass;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(final String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public void setDestinationAirportCode(final String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(final String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(final String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    @Override
    public String toString() {
        return "CrazyAirResponse [airline=" + airline + ", price=" + price + ", cabinclass=" + cabinclass
            + ", departureAirportCode=" + departureAirportCode + ", destinationAirportCode=" + destinationAirportCode
            + ", departureDate=" + departureDate + ", arrivalDate=" + arrivalDate + "]";
    }
}
