package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.Iterator;

public class SudokuGame {
    SudokuBoard sudokuBoard;

    public boolean resolveSudoku() {
        return true;
    }

    public void setValue(int index, int row, int value) {
        sudokuBoard.getElement(index -1, row-1).setValue(value);
    }

    public void createEmptyBoard() {
        sudokuBoard = new SudokuBoard();
        for (int rowIndex = 0; rowIndex < 9; rowIndex++) {
            SudokuRow sudokuRow = new SudokuRow();
            for (int columnIndex = 0; columnIndex < 9; columnIndex++) {
                sudokuRow.addElement(new SudokuElement(SudokuElement.EMPTY));
            }
            sudokuBoard.addRow(sudokuRow);
        }
    }

    public void printBoard() {
        System.out.println(sudokuBoard);
    }

    public void solve(SudokuElement element, ArrayList<SudokuElement> list) throws SudokuException{
        if (element.getValue() != -1) {
            element.getAllowedValues().clear();
        } else {

            Iterator iterator = element.getAllowedValues().iterator();
            boolean existInField ;
            boolean existInAllowed;
            boolean continueIterator = true;

            while (iterator.hasNext() && continueIterator && element.getValue() == -1) {
                int value = (int)iterator.next();
                existInField = false;
                existInAllowed = false;
                boolean remove = false;

                for (SudokuElement sudokuElement: list) {
                    if (value == sudokuElement.getValue()) {
                        remove = true;
                        existInField = true;
                    } else {
                        for (Integer allowedvalue : sudokuElement.getAllowedValues()) {
                            if (value == allowedvalue) existInAllowed = true;
                        }
                    }
                }

                if(remove){
                    iterator.remove();
                    element.setValueIfAvailable();
                    if (element.getValue() != -1) {
                        continueIterator = false;
                        element.getAllowedValues().clear();
                    }
                }

                if (!existInAllowed && !existInField){
                    element.setValue(value);
                    continueIterator = false;
                    element.getAllowedValues().clear();
                }

                if(existInField && (element.getAllowedValues().size() == 1)){
                    throw new SudokuException("problem z wartością ",list, value);
                }
                if(existInField && !existInAllowed) element.setValueIfAvailable();
            }
        }
    }
}

