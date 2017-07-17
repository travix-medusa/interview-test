package com.travix.medusa.busyflights;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.travix.medusa.busyflights.connector.FlightSupplierConnector;
import com.travix.medusa.busyflights.service.BusyFlightsService;
import com.travix.medusa.busyflights.service.FlightSupplierSearcher;
import com.travix.medusa.busyflights.service.impl.BusyFlightsServiceImpl;
import com.travix.medusa.busyflights.service.impl.CrazyAirSearcher;
import com.travix.medusa.busyflights.service.impl.ToughJetSearcher;
import com.travix.medusa.busyflights.service.sorting.BusyFlightsFareComparator;
import com.travix.medusa.busyflights.service.transformer.BusyFlightsRequestTransformer;
import com.travix.medusa.busyflights.service.transformer.FlightSupplierResponseTransformer;
import com.travix.medusa.busyflights.validation.FlightSupplierResponseValidator;

@SpringBootApplication
public class BusyFlightsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusyFlightsApplication.class, args);
    }

    @Bean
    public BusyFlightsService busyFlightsService() {
        return new BusyFlightsServiceImpl();
    }

    @Bean
    public FlightSupplierResponseValidator flightSupplierResponseValidator() {
        return new FlightSupplierResponseValidator();
    }

    @Bean
    public Validator validator() {
        return Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Bean
    public ExecutorService executorService() {
        return Executors.newFixedThreadPool(10);
    }

    @Bean
    public FlightSupplierResponseTransformer flightSupplierResponseTransformer() {
        return new FlightSupplierResponseTransformer();
    }

    @Bean
    public BusyFlightsFareComparator busyFlightsFareComparator() {
        return new BusyFlightsFareComparator();
    }

    @Bean
    public FlightSupplierSearcher crazyAirSearcher() {
        return new CrazyAirSearcher();
    }

    @Bean
    public FlightSupplierSearcher toughJetSearcher() {
        return new ToughJetSearcher();
    }

    @Bean
    public BusyFlightsRequestTransformer busyFlightsRequestTransformer() {
        return new BusyFlightsRequestTransformer();
    }

    @Bean
    public FlightSupplierConnector flightSupplierConnector() {
        return new FlightSupplierConnector();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
