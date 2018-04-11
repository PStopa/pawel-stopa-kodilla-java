package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.Random;

public class SudokuRunner {
    public static void main(String[] args) {

        boolean gameFinished = false;
        String answer;
        Random generator = new Random();

        while (!gameFinished) {
            answer = "";
            SudokuGame theGame = new SudokuGame();
            theGame.createEmptyBoard();
            System.out.println("\n--=== S U D O K U  S O L V E R ===--\n");
            System.out.println("Enter position and value of element\n" +
                    "eg. 2,1,2 - column 2, row 1, value 2. \nIf you want to solve sudoku type SUDOKU\n");
            theGame.printBoard();

            while (!answer.equals("SUDOKU")) {
                System.out.println("Enter your element:");
                answer = theGame.setValueByUser();
                theGame.printBoard();
            }


            System.out.println("\n\n SUDOKU SOLVED\n");

            int fillElements = 0;
            int iteration = 0;
            int change;
            int deleteValue = 0;
            int deleteIndex = 0;
            int deleteXRow = 0;
            int deleteYColumn = 0;
            SudokuBoard copyBoard = null;

            while (fillElements != 81) {
                iteration++;
                change = 0;
                fillElements = 0;
                SudokuElement elementCopy = null;
                SudokuElement element = null;
                for (int rowIndex = 0; rowIndex < 9; rowIndex++) {
                    for (int columnIndex = 0; columnIndex < 9; columnIndex++) {
                        try {
                            element = theGame.sudokuBoard.getElement(columnIndex, rowIndex);
                            try {
                                elementCopy = element.deepCopy();
                            } catch (CloneNotSupportedException e) {
                                System.out.println(e);
                            }
                            ArrayList<SudokuElement> getElementsOfRow = theGame.sudokuBoard.getElementsOfRow(columnIndex, rowIndex);
                            ArrayList<SudokuElement> getElementsOfColumn = theGame.sudokuBoard.getElementsOfColumn(columnIndex, rowIndex);
                            ArrayList<SudokuElement> getElementsOfBlock = theGame.sudokuBoard.getElementsOfBlock(columnIndex, rowIndex);

                            theGame.solve(element, getElementsOfRow);
                            theGame.solve(element, getElementsOfColumn);
                            theGame.solve(element, getElementsOfBlock);
                            if (!(element.equals(elementCopy))) {
                                change++;
                            }
                            if (element.getValue() != -1) fillElements++;
                        } catch (SudokuException e) {
                            if(copyBoard == null){
                                System.out.println("This sudoku can`t be solved :(");
                                theGame.printBoard();
                                System.out.println(element.getAllowedValues());
                                System.out.println("value: " + deleteValue + ",row " + rowIndex + " ,column" + columnIndex);
                                System.exit(0);
                                break;
                            } else {
                                theGame.sudokuBoard = copyBoard.deepCopy();
                                theGame.sudokuBoard.getElement(deleteYColumn, deleteXRow).getAllowedValues().remove(deleteIndex);
                                theGame.sudokuBoard.getElement(deleteYColumn, deleteXRow).setValueIfAvailable();
                                copyBoard = null;
                                change++;
                            }
                        }
                    }
                }

                if (change == 0) {
                    copyBoard = theGame.sudokuBoard.deepCopy();
                    element = null;

                    boolean continueRandom = true;
                  /////
                    while(continueRandom) {
                        int row = generator.nextInt(8);
                        int column = generator.nextInt(8);
                        element = theGame.sudokuBoard.getElement(column,row);
                        if(element.getValue() == -1){
                            continueRandom = false;
                            deleteXRow = row;
                            deleteYColumn = column;
                            int bound = element.getAllowedValues().size();
                            try{
                                deleteIndex = generator.nextInt(bound);
                            } catch (IllegalArgumentException e) {
                                System.out.println(e);
                            }
                            deleteValue = element.getAllowedValues().get(deleteIndex);
                            element.setValue(deleteValue);
                            element.getAllowedValues().clear();
                        }
                    }
                }

            }
            theGame.printBoard();

            if(iteration < 30){
                System.out.println("\nDIFFICULT: IT`S EASY");
            } else if(iteration < 50) {
                System.out.println("\nDIFFICULT: IT`S MEDIUM");
            } else if(iteration > 50) {
                System.out.println("\nDIFFUCULT: IT`S HARD!");
            }

            gameFinished = theGame.resolveSudoku();
        }
        System.out.println("Thank you and see you again!");
    }
}

