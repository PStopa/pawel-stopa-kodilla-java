package com.kodilla.sudoku;

import org.junit.Test;

public class SudokuBoardTestSuite {
    @Test
    public void getElementsOfRow(){
        SudokuGame theGame = new SudokuGame();
        theGame.createEmptyBoard();
        theGame.setValue(2, 1, 2);
        theGame.setValue(4, 1, 5);
        theGame.setValue(6, 1, 1);
        theGame.setValue(8, 1, 9);
        theGame.setValue(1, 2, 8);
        theGame.setValue(4, 2, 2);
        theGame.setValue(6, 2, 3);
        theGame.setValue(9, 2, 6);
        theGame.setValue(2, 3, 3);
        theGame.setValue(5, 3, 6);
        theGame.setValue(8, 3, 7);
        theGame.setValue(3, 4, 1);
        theGame.setValue(7, 4, 6);
        theGame.setValue(1, 5, 5);
        theGame.setValue(2, 5, 4);
        theGame.setValue(8, 5, 1);
        theGame.setValue(9, 5, 9);
        theGame.setValue(3, 6, 2);
        theGame.setValue(7, 6, 7);
        theGame.setValue(2, 7, 9);
        theGame.setValue(5, 7, 3);
        theGame.setValue(8, 7, 8);
        theGame.setValue(1, 8, 2);
        theGame.setValue(4, 8, 8);
        theGame.setValue(6, 8, 4);
        theGame.setValue(9, 8, 7);
        theGame.setValue(2, 9, 1);
        theGame.setValue(4, 9, 9);
        theGame.setValue(6, 9, 7);
        theGame.setValue(8, 9, 6);

        System.out.println("row");
        System.out.println(theGame.sudokuBoard.getElementsOfRow(8,1));

        System.out.println("column");
        System.out.println(theGame.sudokuBoard.getElementsOfColumn(3,1));

        System.out.println("block");
        System.out.println(theGame.sudokuBoard.getElementsOfBlock(4,6));

        System.out.println("element");
        System.out.println(theGame.sudokuBoard.getElement(1,4));


        theGame.printBoard();
    }
}
