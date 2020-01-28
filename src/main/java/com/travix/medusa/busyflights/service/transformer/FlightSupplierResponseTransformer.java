package com.travix.medusa.busyflights.service.transformer;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.travix.medusa.busyflights.domain.FlightSupplier;
import com.travix.medusa.busyflights.domain.FlightSupplierResponse;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.service.visitor.FlightSupplierResponseVisitor;
import com.travix.medusa.busyflights.util.DateUtil;

/**
 * Transforms a flight supplier response into a BusyFlightsResponse.
 * @author marcelo.chiaradia
 *
 */
public class FlightSupplierResponseTransformer
    implements FlightSupplierResponseVisitor<BusyFlightsResponse> {

    private static final int DECIMALS_COUNT = 2;

    public BusyFlightsResponse transform(FlightSupplierResponse in) {
        return in.accept(this);
    }

    @Override
    public BusyFlightsResponse visit(CrazyAirResponse in) {
        BigDecimal fare = BigDecimal.valueOf(in.getPrice()).setScale(DECIMALS_COUNT, RoundingMode.HALF_EVEN);
        String departureDate = DateUtil.fromLocalDateTimeToDateTime(in.getDepartureDate());
        String arrivalDate = DateUtil.fromLocalDateTimeToDateTime(in.getArrivalDate());

        return new BusyFlightsResponse(in.getAirline(), FlightSupplier.CrazyAir.toString(), fare,
            in.getDepartureAirportCode(), in.getDestinationAirportCode(), departureDate, arrivalDate);
    }

    @Override
    public BusyFlightsResponse visit(ToughJetResponse in) {
        double finalPrice = in.getBasePrice() - (in.getBasePrice() * in.getDiscount() / 100) + in.getTax();
        BigDecimal fare = BigDecimal.valueOf(finalPrice).setScale(DECIMALS_COUNT, RoundingMode.HALF_EVEN);

        String departureDate = DateUtil.fromInstantToDateTime(in.getOutboundDateTime());
        String arrivalDate = DateUtil.fromInstantToDateTime(in.getInboundDateTime());

        return new BusyFlightsResponse(in.getCarrier(), FlightSupplier.ToughJet.toString(), fare,
            in.getDepartureAirportName(), in.getArrivalAirportName(), departureDate, arrivalDate);
    }
}
