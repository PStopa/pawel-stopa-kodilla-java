package com.kodilla.sudoku;

import org.junit.Test;

import java.util.ArrayList;

public class SudokuBoardTestSuite {
    @Test
    public void getElementsOfRowTest(){
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

    @Test
    public void solveMethodTest(){
        SudokuElement element = new SudokuElement(-1);
        element.getAllowedValues().clear();
        element.getAllowedValues().add(1);
        element.getAllowedValues().add(7);
        element.getAllowedValues().add(6);
       // element.getAllowedValues().add(2);
        SudokuElement elementL1 = new SudokuElement(1);
        elementL1.getAllowedValues().clear();
        SudokuElement elementL2 = new SudokuElement(8);
        elementL2.getAllowedValues().clear();
        //elementL2.getAllowedValues().add(3);

        ArrayList<SudokuElement> list = new ArrayList<>();
        list.add(elementL1);
        list.add(elementL2);
        SudokuGame theGame = new SudokuGame();
        try{
            theGame.solve(element, list);
            element.setValueIfAvailable();
            System.out.println(element.getAllowedValues() + "allowed");
            System.out.println(element.getValue() + " value");

        } catch(SudokuException e) {
            System.out.println("problem");
            System.out.println(element.getAllowedValues() + "allowed");
            System.out.println(element.getValue() + " value");
            System.exit(0);
        }
    }

    @Test
    public void elementEqualsTest(){
        SudokuElement element1 = new SudokuElement(-1, 3);
        SudokuElement element2 = new SudokuElement(-1, 3,4);

        System.out.println(element1.equals(element2));

    }
}
