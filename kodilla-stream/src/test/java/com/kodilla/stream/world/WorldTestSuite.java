package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity(){
        //Given
            //Europa
        Continent europa = new Continent("Europa");
        BigDecimal londonPeopleQuantity = new BigDecimal("1234567890");
        BigDecimal warsawPeopleQuantity = new BigDecimal("1324354657");
        Country london = new Country("London", londonPeopleQuantity);
        Country warsaw = new Country("Warsaw", warsawPeopleQuantity);
        europa.addCountry(london);
        europa.addCountry(warsaw);

            //North America
        Continent northAmerica = new Continent("North America");
        BigDecimal losAngelesPeopleQuantity = new BigDecimal("1234563456");
        BigDecimal miamiPeopleQuantity = new BigDecimal("1654432141");
        Country losAngeles = new Country("Los Angeles", losAngelesPeopleQuantity);
        Country miami = new Country("Miami", miamiPeopleQuantity);
        northAmerica.addCountry(losAngeles);
        northAmerica.addCountry(miami);

            //Asia
        Continent asia = new Continent("Asia");
        BigDecimal tokyoPeopleQuantity = new BigDecimal("1234521321");
        BigDecimal seulPeopleQuantity = new BigDecimal("1234212112");
        Country tokyo = new Country("Tokyo", tokyoPeopleQuantity);
        Country seul = new Country("Seul", seulPeopleQuantity);
        asia.addCountry(tokyo);
        asia.addCountry(seul);

            //World
        World world = new World();
        world.addContinents(asia);
        world.addContinents(europa);
        world.addContinents(northAmerica);

        //When
        BigDecimal totalPeople = world.getPeopleQuantity();
        BigDecimal expectedPeopleQuantity = new BigDecimal("7916651577");

        //Then
        Assert.assertEquals(expectedPeopleQuantity, totalPeople);
        Assert.assertEquals(3, world.getContinents().size());
        Assert.assertEquals(2, europa.getCountry().size());
        Assert.assertEquals(2, northAmerica.getCountry().size());
        Assert.assertEquals(2, asia.getCountry().size());
    }
}
