package com.kodilla.good.patterns.airline;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FlightSearcher {
    private FlightsDB flightsDB;

    public FlightSearcher(FlightsDB flightsDB) {
        this.flightsDB = flightsDB;
    }

    public Set<Flight> searchDeparturesFromAirport(String airport){
        Set<Flight> departureAirports = flightsDB.getFlights().stream()
                .filter(departure -> departure.getDepartureAirport().equals(airport))
                .collect(Collectors.toSet());

        if (departureAirports == null) {
            System.out.println("No results found!");
            return null;
        } else {
            System.out.println("Flights from: " +airport);
            departureAirports.forEach(System.out::println);
            return departureAirports;
        }
    }

    public Set<Flight> searchArrivalToAirport(String airport){
        Set<Flight> arrivalAirports = flightsDB.getFlights().stream()
                .filter(arrival-> arrival.getArrivalAirport().equals(airport))
                .collect(Collectors.toSet());

        if (arrivalAirports.isEmpty()) {
            System.out.println("No results found!");
            return null;
        } else {
            System.out.println("Flights to: " + airport);
            arrivalAirports.forEach(System.out::println);
            return arrivalAirports;
        }
    }

    public Set<Flight> searchFlightVia(String departureAirport, String via, String arrivalAirport){
        Set<Flight> departureToViaAirports = flightsDB.getFlights().stream()
                .filter(departure -> departure.getDepartureAirport().equals(departureAirport))
                .filter(departure -> departure.getArrivalAirport().equals(via))
                .collect(Collectors.toSet());

        Set<Flight> viaToArrivalAirports = flightsDB.getFlights().stream()
                .filter(arrival -> arrival.getDepartureAirport().equals(via))
                .filter(arrival -> arrival.getArrivalAirport().equals(arrivalAirport))
                .collect(Collectors.toSet());

        if(departureToViaAirports.isEmpty() || viaToArrivalAirports.isEmpty()) {
            System.out.println("No results found!");
            return null;
        } else {
            System.out.println("Flights from " + departureAirport + ", via " + via + " to " + arrivalAirport + ":");
            Set<Flight> arrivals = new LinkedHashSet<>();
            arrivals.addAll(departureToViaAirports);
            arrivals.addAll(viaToArrivalAirports);
            arrivals.forEach(System.out::println);
            return arrivals;
        }
    }
}
