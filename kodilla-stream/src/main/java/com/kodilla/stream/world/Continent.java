package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public class Continent {
    List<Country> country = new ArrayList<>();
    private String continentName;

    public Continent(String continentName) {
        this.continentName = continentName;
    }

    public void addCountry(Country country){
        this.country.add(country);
    }

    public List<Country> getCountry(){
        return new ArrayList<>(country);
    }
}
