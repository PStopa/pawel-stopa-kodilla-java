package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.OptionalDouble;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage(){
        int tab[] = {1,2,3,4,5};

        double average = ArrayOperations.getAverage(tab);
        double expectedAverage = 3.0;

        Assert.assertEquals(expectedAverage, average, 0.01);
        System.out.println("\nAverage: " + average);
    }
}
