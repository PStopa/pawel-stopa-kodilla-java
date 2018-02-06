package com.kodilla.testing.collection;

import org.junit.*;

import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.ArrayList;

public class CollectionTestSuite {
    @Before
    public void before(){
        System.out.println("Test Case: begin");
    }
    @After
    public void after(){
        System.out.println("Test Case: end");
    }
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: begin");
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }
    @Test
    public void testOddNumbersExterminatorEmptyList(){
        //Given
        OddNumbersExterminator numberExterminator = new OddNumbersExterminator();

        //When
        ArrayList<Integer> number = new ArrayList<Integer>();
        System.out.println("Testing empty list");

        //Then
        Assert.assertEquals(number, numberExterminator.exterminate(number));

    }
    @Test
    public void testOddNumbersExterminatorNormalList(){
        //Given
        OddNumbersExterminator numberExterminator = new OddNumbersExterminator();
        ArrayList<Integer> numberSample = new ArrayList<Integer>();
        ArrayList<Integer> numberExpected = new ArrayList<Integer>();

        //When
        for(int i = 0; i <= 10; i++){
            numberSample.add(i);
        }
        for(int i = 0; i <= 10; i=i+2){
            numberExpected.add(i);
        }

        System.out.println("Testing odd number");
        System.out.print("Exterminate Odd number : ");
        //Then
        Assert.assertEquals(numberExpected, numberExterminator.exterminate(numberSample));
    }
}
