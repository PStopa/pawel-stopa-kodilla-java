package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class LoggerTestSuite {
    @Test
    public void testGetLastLog(){
        //Given
        Logger.getInstance().log("First Log");
        //When
        String log = Logger.getInstance().getLastLog();
        System.out.println("Last log: " + log);
        //Then
        Assert.assertEquals("First Log", log);
    }
}
