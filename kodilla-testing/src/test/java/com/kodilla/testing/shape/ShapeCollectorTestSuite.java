package com.kodilla.testing.shape;

import org.junit.*;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testAddFigure(){
        //Given
        Shape circle = new Circle("circle", 5);
        ShapeCollector shapeList = new ShapeCollector();

        //When
        shapeList.addFigure(circle);

        //Then
        Assert.assertEquals(circle, shapeList.getFigure(0));
    }

    @Test
    public void testRemoveFigure(){
        //Given
        Shape triangle = new Triangle("triangle", 4, 3);
        ShapeCollector shapeList = new ShapeCollector();
        shapeList.addFigure(triangle);

        //When
        boolean result = shapeList.removeFigure(triangle);

        //Then
        Assert.assertTrue(result);
    }

    @Test
    public void testGetFigure(){
        //Given
        Shape square = new Square("square", 5);
        ShapeCollector shapeList = new ShapeCollector();

        //When
        shapeList.addFigure(square);
        Shape retrievedShape = shapeList.getFigure(0);

        //Then
        Assert.assertEquals(square, retrievedShape);
    }

    @Ignore
    public void testShowFigures(){
        //Given
        Shape square = new Square("square", 5);
        Shape triangle = new Triangle("triangle", 4, 3);
        Shape circle = new Circle("circle", 5);
        ShapeCollector shapeList = new ShapeCollector();

        //When
        shapeList.addFigure(square);
        shapeList.addFigure(triangle);
        shapeList.addFigure(circle);

        //Then
        shapeList.showFigures();
    }
}
