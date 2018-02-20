package com.kodilla.exception.test;

import java.util.HashMap;

public class RouteNotFoundExceptionRunner {

    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        boolean result;
        HashMap<String, Boolean> flightMap = new HashMap<>();
        flightMap.put("Warsaw", true);
        flightMap.put("London", true);
        flightMap.put("Manchester", false);

        if(flightMap.get(flight.getDepartureAirport()) && flightMap.get(flight.getArrivalAirport())) {
            result = true;
        } else {
            throw new RouteNotFoundException("Route is not found! ");
        }
        return result;
    }


    public static void main(String[] args) {
        RouteNotFoundExceptionRunner runner = new RouteNotFoundExceptionRunner();
        Flight flight = new Flight("Warsaw", "Manchester");

        try {
            runner.findFlight(flight);
        } catch (RouteNotFoundException e) {
            System.out.println("Route not found! " + e);
        } finally {
            System.out.println("Processing other logic!");
        }

    }
}
