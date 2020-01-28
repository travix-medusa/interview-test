package com.travix.medusa.busyflights.domain.toughjet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.travix.medusa.busyflights.domain.FlightSupplierRequest;
import com.travix.medusa.busyflights.util.DateUtil;

public class ToughJetRequest
    implements FlightSupplierRequest {

    @NotNull(message = "From cannot be null")
    @Size(min = 3, max = 3, message = "From must have 3 characters")
    private String from;
    @NotNull(message = "To cannot be null")
    @Size(min = 3, max = 3, message = "From must have 3 characters")
    private String to;
    @NotNull(message = "OutboundDate cannot be null")
    @DateTimeFormat(pattern = DateUtil.ISO_LOCAL_DATE)
    private LocalDate outboundDate;
    @NotNull(message = "InboundDate cannot be null")
    @DateTimeFormat(pattern = DateUtil.ISO_LOCAL_DATE)
    private LocalDate inboundDate;
    private int numberOfAdults;

    public ToughJetRequest(String from, String to, LocalDate outboundDate, LocalDate inboundDate, int numberOfAdults) {
        super();
        this.from = from;
        this.to = to;
        this.outboundDate = outboundDate;
        this.inboundDate = inboundDate;
        this.numberOfAdults = numberOfAdults;
    }

    @Override
    public Object[] getMandatoryArguments() {
        List<String> out = new ArrayList<String>();

        out.add(this.from);
        out.add(this.to);
        out.add(this.outboundDate.toString());
        out.add(this.inboundDate.toString());
        out.add(String.valueOf(this.numberOfAdults));

        return out.toArray();
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(final String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(final String to) {
        this.to = to;
    }

    public LocalDate getOutboundDate() {
        return outboundDate;
    }

    public void setOutboundDate(final LocalDate outboundDate) {
        this.outboundDate = outboundDate;
    }

    public LocalDate getInboundDate() {
        return inboundDate;
    }

    public void setInboundDate(final LocalDate inboundDate) {
        this.inboundDate = inboundDate;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(final int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    @Override
    public String toString() {
        return "ToughJetRequest [from=" + from + ", to=" + to + ", outboundDate=" + outboundDate + ", inboundDate="
            + inboundDate + ", numberOfAdults=" + numberOfAdults + "]";
    }
}
