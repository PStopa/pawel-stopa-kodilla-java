package com.kodilla.testing.forum.statistics;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StatisticsCalculatorTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests CalculateAdvStatistics class.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeTest(){
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testAvgPost0(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userNamesList = new ArrayList<String>();
        userNamesList.add("a");
        userNamesList.add("b");
        userNamesList.add("c");
        when(statisticsMock.usersNames()).thenReturn(userNamesList);
        when(statisticsMock.commentsCount()).thenReturn(30);
        when(statisticsMock.postsCount()).thenReturn(0);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();

        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(0,statisticsCalculator.quantityOfPost);
        Assert.assertEquals(0.0, statisticsCalculator.avgPostPerUser, 0);
        Assert.assertEquals(10.0, statisticsCalculator.avgCommentsPerUser, 0);
        Assert.assertEquals(0.0, statisticsCalculator.avgCommentsPerPost, 0);
    }

    @Test
    public void testAvgPost1000(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userNamesList = new ArrayList<String>();
        userNamesList.add("a");
        userNamesList.add("b");
        when(statisticsMock.usersNames()).thenReturn(userNamesList);
        when(statisticsMock.commentsCount()).thenReturn(500);
        when(statisticsMock.postsCount()).thenReturn(1000);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();

        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(1000,statisticsCalculator.quantityOfPost);
        Assert.assertEquals(500, statisticsCalculator.avgPostPerUser, 0.0001);
        Assert.assertEquals(250, statisticsCalculator.avgCommentsPerUser, 0.0001);
        Assert.assertEquals(0.5, statisticsCalculator.avgCommentsPerPost, 0.0001);
    }

    @Test
    public void testAvgComments0(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userNamesList = new ArrayList<String>();
        userNamesList.add("a");
        userNamesList.add("b");
        when(statisticsMock.usersNames()).thenReturn(userNamesList);
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.postsCount()).thenReturn(10);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();

        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(0,statisticsCalculator.quantityOfComments);
        Assert.assertEquals(5, statisticsCalculator.avgPostPerUser, 0.0001);
        Assert.assertEquals(0, statisticsCalculator.avgCommentsPerUser, 0.0001);
        Assert.assertEquals(0, statisticsCalculator.avgCommentsPerPost, 0.0001);
    }

    @Test
    public void testAvgCommentsLessThanPost(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userNamesList = new ArrayList<String>();
        userNamesList.add("a");
        userNamesList.add("b");
        when(statisticsMock.usersNames()).thenReturn(userNamesList);
        when(statisticsMock.commentsCount()).thenReturn(5);
        when(statisticsMock.postsCount()).thenReturn(10);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();

        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(5, statisticsCalculator.avgPostPerUser, 0.0001);
        Assert.assertEquals(2.5, statisticsCalculator.avgCommentsPerUser, 0.0001);
        Assert.assertEquals(0.5, statisticsCalculator.avgCommentsPerPost, 0.0001);
    }

    @Test
    public void testAvgCommentsMoreThanPost(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userNamesList = new ArrayList<String>();
        userNamesList.add("a");
        userNamesList.add("b");
        when(statisticsMock.usersNames()).thenReturn(userNamesList);
        when(statisticsMock.commentsCount()).thenReturn(20);
        when(statisticsMock.postsCount()).thenReturn(5);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();

        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(2.5, statisticsCalculator.avgPostPerUser, 0.0001);
        Assert.assertEquals(10, statisticsCalculator.avgCommentsPerUser, 0.0001);
        Assert.assertEquals(4, statisticsCalculator.avgCommentsPerPost, 0.0001);
    }

    @Test
    public void testAvgUser0(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userNamesList = new ArrayList<String>();
        when(statisticsMock.usersNames()).thenReturn(userNamesList);
        when(statisticsMock.commentsCount()).thenReturn(10);
        when(statisticsMock.postsCount()).thenReturn(20);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();

        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(0,statisticsCalculator.quantityOfUser);
        Assert.assertEquals(0, statisticsCalculator.avgPostPerUser, 0.0001);
        Assert.assertEquals(0, statisticsCalculator.avgCommentsPerUser, 0.0001);
        Assert.assertEquals(0.5, statisticsCalculator.avgCommentsPerPost, 0.0001);
    }

    @Test
    public void testAvgUser100(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userNamesList = new ArrayList<String>();
        for(int i=0; i<100; i++){
            userNamesList.add("a");
        }
        when(statisticsMock.usersNames()).thenReturn(userNamesList);
        when(statisticsMock.commentsCount()).thenReturn(10);
        when(statisticsMock.postsCount()).thenReturn(20);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();

        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(100,statisticsCalculator.quantityOfUser);
        Assert.assertEquals(0.2, statisticsCalculator.avgPostPerUser, 0.0001);
        Assert.assertEquals(0.1, statisticsCalculator.avgCommentsPerUser, 0.0001);
        Assert.assertEquals(0.5, statisticsCalculator.avgCommentsPerPost, 0.0001);
    }
}
