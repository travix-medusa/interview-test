package com.travix.medusa.busyflights.domain.toughjet;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.travix.medusa.busyflights.domain.FlightSupplierResponse;
import com.travix.medusa.busyflights.service.visitor.FlightSupplierResponseVisitor;

public class ToughJetResponse
    implements FlightSupplierResponse {

    @NotNull
    private String carrier;
    private double basePrice;
    private double tax;
    private double discount;
    @NotNull
    @Size(min = 3, max = 3)
    private String departureAirportName;
    @NotNull
    @Size(min = 3, max = 3)
    private String arrivalAirportName;
    @NotNull
    private String outboundDateTime;
    @NotNull
    private String inboundDateTime;

    public ToughJetResponse() {
        super();
    }

    public ToughJetResponse(String carrier, double basePrice, double tax, double discount, String departureAirportName,
        String arrivalAirportName, String outboundDateTime, String inboundDateTime) {
        super();
        this.carrier = carrier;
        this.basePrice = basePrice;
        this.tax = tax;
        this.discount = discount;
        this.departureAirportName = departureAirportName;
        this.arrivalAirportName = arrivalAirportName;
        this.outboundDateTime = outboundDateTime;
        this.inboundDateTime = inboundDateTime;
    }

    @Override
    public <T> T accept(FlightSupplierResponseVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(final String carrier) {
        this.carrier = carrier;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(final double basePrice) {
        this.basePrice = basePrice;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(final double tax) {
        this.tax = tax;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(final double discount) {
        this.discount = discount;
    }

    public String getDepartureAirportName() {
        return departureAirportName;
    }

    public void setDepartureAirportName(final String departureAirportName) {
        this.departureAirportName = departureAirportName;
    }

    public String getArrivalAirportName() {
        return arrivalAirportName;
    }

    public void setArrivalAirportName(final String arrivalAirportName) {
        this.arrivalAirportName = arrivalAirportName;
    }

    public String getOutboundDateTime() {
        return outboundDateTime;
    }

    public void setOutboundDateTime(final String outboundDateTime) {
        this.outboundDateTime = outboundDateTime;
    }

    public String getInboundDateTime() {
        return inboundDateTime;
    }

    public void setInboundDateTime(final String inboundDateTime) {
        this.inboundDateTime = inboundDateTime;
    }

    @Override
    public String toString() {
        return "ToughJetResponse [carrier=" + carrier + ", basePrice=" + basePrice + ", tax=" + tax + ", discount="
            + discount + ", departureAirportName=" + departureAirportName + ", arrivalAirportName=" + arrivalAirportName
            + ", outboundDateTime=" + outboundDateTime + ", inboundDateTime=" + inboundDateTime + "]";
    }
}
