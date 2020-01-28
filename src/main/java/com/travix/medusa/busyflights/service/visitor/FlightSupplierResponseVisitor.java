package com.travix.medusa.busyflights.service.visitor;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;

public interface FlightSupplierResponseVisitor<T> {

    T visit(CrazyAirResponse in);

    T visit(ToughJetResponse in);
}
