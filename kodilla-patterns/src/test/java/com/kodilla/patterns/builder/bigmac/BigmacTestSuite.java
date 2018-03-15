package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testBigmacNew() {
        //Given
        Bigmac bigMac = new Bigmac.BigmacBuilder()
                .roll("Sesame")
                .sauce("Barbecue")
                .burgers(2)
                .ingredients("Bacon")
                .ingredients("Chili")
                .ingredients("Lettuce")
                .build();
        System.out.println(bigMac);
        //When
        int howManyIngredients = bigMac.getIngredients().size();
        int howManyBurgers = bigMac.getBurgers();
        String sauce = bigMac.getSauce();
        //Then
        Assert.assertEquals(3, howManyIngredients);
        Assert.assertEquals("Barbecue", sauce);
        Assert.assertEquals(2, howManyBurgers);
    }
}
