package com.kodilla.rps;

import org.junit.*;

public class RpsTestSuit {
    @Before
    public void before(){
        System.out.println("\nTest Case: begin");
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
        System.out.println("\nTest Suite: end");
    }

    @Test
    public void testChoiceToString(){
        //Given
        String expectedRock = "Rock";
        String expectedPaper = "Paper";
        String expectedScissors = "Scissors";

        //When
        String resultRock = GameProcessor.choiceToString(1);
        String resultPaper = GameProcessor.choiceToString(2);
        String resultScissors = GameProcessor.choiceToString(3);

        //Then
        Assert.assertEquals(expectedRock, resultRock);
        Assert.assertEquals(expectedPaper, resultPaper);
        Assert.assertEquals(expectedScissors, resultScissors);
    }

    @Test
    public void testCalculateScoreBoard(){
        //Given
        GameProcessor game = new GameProcessor();

        //When
        game.calculateScoreBoard(1,3);

        //Then
        Assert.assertEquals(1,game.getUserScore());
        Assert.assertEquals(0,game.getComputerScore());
    }

    @Test
    public void testPlayersWin(){
        //Given
        GameProcessor game = new GameProcessor();

        //When
        game.calculateScoreBoard(1,3);
        game.calculateScoreBoard(1,3);
        game.calculateScoreBoard(1,2);

        //Then
        Assert.assertEquals(2,game.getUserScore());
        Assert.assertEquals(1,game.getComputerScore());
    }

    @Test
    public void testResetGame(){
        //Given
        GameProcessor game = new GameProcessor();

        //When
        game.calculateScoreBoard(1,3);
        game.calculateScoreBoard(1,2);

        //Then
        Assert.assertEquals(1,game.getUserScore());
        Assert.assertEquals(1,game.getComputerScore());

        game.resetGame();
        Assert.assertEquals(0,game.getUserScore());
        Assert.assertEquals(0,game.getComputerScore());
    }
}
