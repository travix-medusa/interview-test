package com.travix.medusa.busyflights.domain.busyflights;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.travix.medusa.busyflights.util.DateUtil;

public class BusyFlightsRequest {

    @NotNull(message = "Origin cannot be null")
    @Size(min = 3, max = 3, message = "Origin must have 3 characters")
    private String origin;
    @NotNull(message = "Destination cannot be null")
    @Size(min = 3, max = 3, message = "Destination must have 3 characters")
    private String destination;
    @NotNull(message = "DepartureDate cannot be null")
    @DateTimeFormat(pattern = DateUtil.ISO_LOCAL_DATE)
    private LocalDate departureDate;
    @NotNull(message = "ReturnDate cannot be null")
    @DateTimeFormat(pattern = DateUtil.ISO_LOCAL_DATE)
    private LocalDate returnDate;
    @Max(value = 4, message = "numberOfPassengers cannot be greater than 4")
    private int numberOfPassengers;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(final String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(final String destination) {
        this.destination = destination;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(final LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(final LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(final int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public String toString() {
        return "BusyFlightsRequest [origin=" + origin + ", destination=" + destination + ", departureDate=" + departureDate
            + ", returnDate=" + returnDate + ", numberOfPassengers=" + numberOfPassengers + "]";
    }
}
