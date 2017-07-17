package com.travix.medusa.busyflights.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travix.medusa.busyflights.domain.FlightSupplierResponse;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.service.BusyFlightsService;
import com.travix.medusa.busyflights.service.FlightSupplierSearcher;
import com.travix.medusa.busyflights.service.sorting.BusyFlightsFareComparator;
import com.travix.medusa.busyflights.service.transformer.FlightSupplierResponseTransformer;

@Service
public class BusyFlightsServiceImpl
    implements BusyFlightsService {

    @Autowired
    private List<FlightSupplierSearcher> flightSupplierSearchers;
    @Autowired
    private FlightSupplierResponseTransformer flightSupplierResponseTransformer;
    @Autowired
    private ExecutorService executorService;
    @Autowired
    private BusyFlightsFareComparator busyFlightsFareComparator;

    @Override
    public List<BusyFlightsResponse> searchForFlights(BusyFlightsRequest request) {
        List<CompletableFuture<FlightSupplierResponse[]>> futures = this.flightSupplierSearchers.stream()
            .map(searcher -> this.createCompletableFuture(searcher, request)).collect(Collectors.toList());

        return futures.stream().map(CompletableFuture::join).flatMap(Arrays::stream)
            .map(response -> this.flightSupplierResponseTransformer.transform(response)).sorted(busyFlightsFareComparator)
            .collect(Collectors.toList());
    }

    private CompletableFuture<FlightSupplierResponse[]> createCompletableFuture(FlightSupplierSearcher searcher,
        BusyFlightsRequest request) {
        Supplier<FlightSupplierResponse[]> supplier = () -> {
            return searcher.searchOnSupplier(request);
        };
        return CompletableFuture.supplyAsync(supplier);
    }
}
