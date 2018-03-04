package com.kodilla.good.patterns.airline;

import org.junit.*;

import java.util.HashSet;
import java.util.Set;

public class FlightSearcherTestSuit {
    private static FlightsDB flights;
    private static int testCounter = 0;

    @BeforeClass
    public static void getFlights() {
        System.out.println("Test Suite: begin");
        Set<Flight> flightsSet = new HashSet<>();
        Flight f1 = new Flight("Warszawa", "Kraków");
        Flight f2 = new Flight("Warszawa", "Wrocław");
        Flight f3 = new Flight("Wrocław", "Gdańsk");
        Flight f4 = new Flight("Wrocław", "Warszawa");
        Flight f5 = new Flight("Katowice", "Wrocław");
        Flight f6 = new Flight("Gdańsk", "Kraków");
        Flight f7 = new Flight("Poznań", "Warszawa");
        Flight f8 = new Flight("Kraków", "Poznań");
        Flight f9 = new Flight("Rzeszów", "Kraków");
        Flight f10 = new Flight("Lublin", "Kraków");
        flightsSet.add(f1);
        flightsSet.add(f2);
        flightsSet.add(f3);
        flightsSet.add(f4);
        flightsSet.add(f5);
        flightsSet.add(f6);
        flightsSet.add(f7);
        flightsSet.add(f8);
        flightsSet.add(f9);
        flightsSet.add(f10);
        flights = new FlightsDB(flightsSet);
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("\nTest Suite: end");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("\nPreparing to execute test #" + testCounter);
    }

    @Test
    public void testSearchDeparturesFromAirport(){
        //Given
        Set<Flight> expectedFlights = new HashSet<>();
        Flight expectedDeparture = new Flight("Warszawa","Kraków");
        Flight flight2 = new Flight("Warszawa", "Wrocław");
        expectedFlights.add(expectedDeparture);
        expectedFlights.add(flight2);

        //When
        FlightSearcher flightSearcher = new FlightSearcher(flights);
        Set<Flight> testedFlightsSet = flightSearcher.searchDeparturesFromAirport(expectedDeparture.getDepartureAirport());

        //Then
        Assert.assertEquals(expectedFlights, testedFlightsSet);
    }

    @Test
    public void testSearchArrivalToAirport(){
        //Given
        Set<Flight> expectedFlights = new HashSet<>();
        Flight expectedDeparture = new Flight("Warszawa","Kraków");
        Flight flight2 = new Flight("Gdańsk", "Kraków");
        Flight flight3 = new Flight("Rzeszów", "Kraków");
        Flight flight4 = new Flight("Lublin", "Kraków");
        expectedFlights.add(expectedDeparture);
        expectedFlights.add(flight2);
        expectedFlights.add(flight3);
        expectedFlights.add(flight4);

        //When
        FlightSearcher flightSearcher = new FlightSearcher(flights);
        Set<Flight> testedFlightsSet = flightSearcher.searchArrivalToAirport(expectedDeparture.getArrivalAirport());

        //Then
        Assert.assertEquals(expectedFlights, testedFlightsSet);
    }

    @Test
    public void testSearchFlightVia(){
        //Given
        Set<Flight> expectedFlights = new HashSet<>();
        Flight expectedDeparture = new Flight("Lublin", "Kraków");
        Flight flight2 = new Flight("Kraków", "Poznań");
        expectedFlights.add(expectedDeparture);
        expectedFlights.add(flight2);

        //When
        FlightSearcher flightSearcher = new FlightSearcher(flights);
        Set<Flight> testedFlightsSet = flightSearcher.searchFlightVia("Lublin", "Kraków", "Poznań");

        //Then
        Assert.assertEquals(expectedFlights, testedFlightsSet);
    }
}
