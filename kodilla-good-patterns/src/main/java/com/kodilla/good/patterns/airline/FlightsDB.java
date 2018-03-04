package com.kodilla.good.patterns.airline;

import java.util.HashSet;
import java.util.Set;

public class FlightsDB {
    private Set<Flight> flights;

    public FlightsDB(Set<Flight> flights) {
        this.flights = flights;
    }

    public Set<Flight> getFlights() {
        return flights;
    }
}
