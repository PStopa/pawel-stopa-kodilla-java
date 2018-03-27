package com.kodilla.sudoku;

public class SudokuRunner {
    public static void main(String[] args) {

        boolean gameFinished = false;

        while(!gameFinished) {
            SudokuGame theGame = new SudokuGame();
            theGame.createEmptyBoard();

            //sugestion for the first game
            theGame.setValue(1, 1, 4);
            theGame.setValue(1, 3, 1);
            theGame.setValue(1, 4, 9);
            theGame.setValue(2, 2, 5);
            theGame.setValue(3, 1, 6);
            theGame.setValue(5, 1, 7);
            theGame.setValue(7, 1, 3);
            theGame.setValue(2, 4, 7);

            // FIRST GAME
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

            /* SECOND GAME
            theGame.setValue(1, 1, 5);
            theGame.setValue(2, 1, 3);
            theGame.setValue(5, 1, 7);
            theGame.setValue(1, 2, 6);
            theGame.setValue(4, 2, 1);
            theGame.setValue(5, 2, 9);
            theGame.setValue(6, 2, 5);
            theGame.setValue(2, 3, 9);
            theGame.setValue(3, 3, 8);
            theGame.setValue(8, 3, 6);
            theGame.setValue(1, 4, 8);
            theGame.setValue(5, 4, 6);
            theGame.setValue(9, 4, 3);
            theGame.setValue(1, 5, 4);
            theGame.setValue(4, 5, 8);
            theGame.setValue(6, 5, 3);
            theGame.setValue(9, 5, 1);
            theGame.setValue(1, 6, 7);
            theGame.setValue(5, 6, 2);
            theGame.setValue(9, 6, 6);
            theGame.setValue(2, 7, 6);
            theGame.setValue(7, 7, 2);
            theGame.setValue(8, 7, 8);
            theGame.setValue(4, 8, 4);
            theGame.setValue(5, 8, 1);
            theGame.setValue(6, 8, 9);
            theGame.setValue(9, 8, 5);
            theGame.setValue(5, 9, 8);
            theGame.setValue(8, 9, 7);
            theGame.setValue(9, 9, 9);
            */

            int fillElements = 0;
            int iteration = 0;
            //for(int i=0;i<100;i++){
            while(fillElements!=81){
                iteration++;
                fillElements = 0;
                SudokuElement elementCopy = null;
                for(int rowIndex=0; rowIndex < 9; rowIndex++){
                    for(int columnIndex=0; columnIndex<9; columnIndex++) {
                        try {
                            SudokuElement element = theGame.sudokuBoard.getElement(columnIndex, rowIndex);
                            try{
                                elementCopy = element.deepCopy();
                            } catch (CloneNotSupportedException e) {
                                System.out.println(e);
                            }

                            theGame.solve(element, theGame.sudokuBoard.getElementsOfRow(columnIndex, rowIndex));
                            theGame.solve(element, theGame.sudokuBoard.getElementsOfColumn(columnIndex, rowIndex));
                            theGame.solve(element, theGame.sudokuBoard.getElementsOfBlock(columnIndex,rowIndex));

                            if(element.getValue() == -1 && element.equals(elementCopy)) {
                                element.setValue(element.getAllowedValues().get(0));
                            }

                            if(element.getValue() != -1) fillElements++;
                        } catch (SudokuException e) {
                            System.out.println("Problem with Sudoku: " + e);
                            break;
                        }
                    }
                }
            }
            System.out.println("fill elements: " + fillElements);
            System.out.println("iteration: " + iteration);

            String allowedInField = theGame.sudokuBoard.getElement(3, 2).getAllowedValues().toString();
            System.out.println(allowedInField);

            theGame.printBoard();
            gameFinished = theGame.resolveSudoku();
        }
    }
}

