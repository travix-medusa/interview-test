package com.travix.medusa.busyflights.domain.crazyair;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.travix.medusa.busyflights.domain.FlightSupplierRequest;
import com.travix.medusa.busyflights.util.DateUtil;

public class CrazyAirRequest
    implements FlightSupplierRequest {

    @NotNull(message = "Origin cannot be null")
    @Size(min = 3, max = 3, message = "Origin max have 3 characters")
    private String origin;
    @NotNull(message = "Destination cannot be null")
    @Size(min = 3, max = 3, message = "Destination max have 3 characters")
    private String destination;
    @NotNull(message = "DepartureDate cannot be null")
    @DateTimeFormat(pattern = DateUtil.ISO_LOCAL_DATE)
    private LocalDate departureDate;
    @NotNull(message = "ReturnDate cannot be null")
    @DateTimeFormat(pattern = DateUtil.ISO_LOCAL_DATE)
    private LocalDate returnDate;
    private int passengerCount;

    public CrazyAirRequest(String origin, String destination, LocalDate departureDate, LocalDate returnDate,
        int passengerCount) {
        super();
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.passengerCount = passengerCount;
    }

    @Override
    public Object[] getMandatoryArguments() {
        List<String> out = new ArrayList<String>();

        out.add(this.origin);
        out.add(this.destination);
        out.add(this.departureDate.toString());
        out.add(this.returnDate.toString());
        out.add(String.valueOf(this.passengerCount));

        return out.toArray();
    }

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

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(final int passengerCount) {
        this.passengerCount = passengerCount;
    }

    @Override
    public String toString() {
        return "CrazyAirRequest [origin=" + origin + ", destination=" + destination + ", departureDate=" + departureDate
            + ", returnDate=" + returnDate + ", passengerCount=" + passengerCount + "]";
    }
}
