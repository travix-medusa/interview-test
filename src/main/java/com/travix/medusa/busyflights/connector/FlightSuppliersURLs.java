package com.travix.medusa.busyflights.connector;

public interface FlightSuppliersURLs {

    String CRAZY_AIR_SEARCH_URL = "http://localhost:8080/crazyair/flights?origin={origin}&destination={destination}&departureDate={departureDate}&returnDate={returnDate}&passengerCount={passengerCount}";

    String TOUGH_JET_SEARCH_URL = "http://localhost:8080/toughjet/flights?from={from}&to={to}&outboundDate={outboundDate}&inboundDate={inboundDate}&numberOfAdults={numberOfAdults}";

}
