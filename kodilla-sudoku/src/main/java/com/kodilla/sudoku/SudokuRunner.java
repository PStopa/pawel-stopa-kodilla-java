package com.kodilla.sudoku;

public class SudokuRunner {
    public static void main(String[] args) {

        boolean gameFinished = false;
        String answer;

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
            int deleteXRow = 0;
            int deleteYColumn = 0;
            SudokuBoard copyBoard = null;


            while (fillElements != 81) {
                iteration++;
                change = 0;
                fillElements = 0;
                SudokuElement elementCopy = null;
                for (int rowIndex = 0; rowIndex < 9; rowIndex++) {
                    for (int columnIndex = 0; columnIndex < 9; columnIndex++) {
                        try {
                            SudokuElement element = theGame.sudokuBoard.getElement(columnIndex, rowIndex);
                            try {
                                elementCopy = element.deepCopy();
                            } catch (CloneNotSupportedException e) {
                                System.out.println(e);
                            }
                            theGame.solve(element, theGame.sudokuBoard.getElementsOfRow(columnIndex, rowIndex));
                            theGame.solve(element, theGame.sudokuBoard.getElementsOfBlock(columnIndex, rowIndex));
                            theGame.solve(element, theGame.sudokuBoard.getElementsOfColumn(columnIndex, rowIndex));
                            if (element.getValue() == -1 && !(element.equals(elementCopy))) {
                                change++;
                            }
                            if (element.getValue() != -1) fillElements++;
                        } catch (SudokuException e) {
                            System.out.println("Problem with Sudoku: " + e);
                            System.out.println("value: " + rowIndex + " " + columnIndex);
                            theGame.sudokuBoard = copyBoard.deepCopy();
                            theGame.sudokuBoard.getElement(deleteYColumn, deleteXRow).getAllowedValues().remove(deleteValue);
                            copyBoard = null;
                            change++;
                            break;
                        }
                    }
                }

                if (change == 0) {
                    copyBoard = theGame.sudokuBoard.deepCopy();
                    SudokuElement element = null;
                    for (int rowI = 0; rowI < 9; rowI++) {
                        for (int columnI = 0; columnI < 9; columnI++) {
                            if (theGame.sudokuBoard.getElement(columnI, rowI).getValue() == -1) {
                                element = theGame.sudokuBoard.getElement(columnI, rowI);
                                deleteXRow = rowI;
                                deleteYColumn = columnI;
                            }
                        }
                    }
                    if (element != null && element.getAllowedValues().size() != 0) {
                        deleteValue = element.getAllowedValues().get(0);
                        element.setValue(deleteValue);
                        element.getAllowedValues().clear();
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
    }
}

