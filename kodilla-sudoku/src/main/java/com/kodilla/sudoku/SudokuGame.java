package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class SudokuGame {
    SudokuBoard sudokuBoard;
    Scanner scanner = new Scanner(System.in);

    public boolean resolveSudoku() {
        String answer = "";
        System.out.println("Do you want to play again? (Y/N)");
        answer = scanner.nextLine();
        answer = answer.toUpperCase();

        while(!(answer.equals("Y") || answer.equals("N"))){
            System.out.println("Wrong choice!\nDo you want to play again? (Y/N)");
            answer = scanner.nextLine();
            answer = answer.toUpperCase();
        }
        if(answer.equals("Y")) {
            return false;
        } else {
            return true;
        }
    }

    public String setValueByUser() {
        String  lines = scanner.nextLine();
        lines = lines.toUpperCase();
        String stringReturn = "";

        if(lines.matches("[1-9],[1-9],[1-9]") || lines.equals("SUDOKU")) {
            if(lines.equals("SUDOKU")){
                stringReturn = "SUDOKU";
            } else {
                String[] strs = lines.split(",");
                setValue(Integer.parseInt(strs[0]),Integer.parseInt(strs[1]),Integer.parseInt(strs[2]));
                stringReturn = "AGAIN";
            }
        } else {
            System.out.println("Wrong input text!");
            System.out.println("Enter position and value of element\n" +
                    "eg. 2,1,2 - column 2, row 1, value 2. \nIf you want to solve sudoku type SUDOKU\n");
            setValueByUser();
        }
        return stringReturn;
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
                int tmpValue = (int)iterator.next();
                existInField = false;
                existInAllowed = false;
                boolean remove = false;

                for (SudokuElement sudokuElement: list) {
                    if (tmpValue == sudokuElement.getValue()) {
                        if(!(element.getAllowedValues().size() <= 1)){
                            remove = true;
                        }
                        existInField = true;
                    } else {
                        for (Integer allowedvalue : sudokuElement.getAllowedValues()) {
                            if (tmpValue == allowedvalue) existInAllowed = true;
                        }
                    }
                }

                if(remove){
                    iterator.remove();
                    element.setValueIfAvailable();
                    if (element.getValue() != -1) {
                        continueIterator = false;
                    }
                }

                if (!existInAllowed && !existInField){
                    element.setValue(tmpValue);
                    continueIterator = false;
                    element.getAllowedValues().clear();
                }

                if(existInField && (element.getAllowedValues().size() <= 1) && continueIterator){
                    System.out.println(element.getAllowedValues());
                    throw new SudokuException("problem with value ",list, tmpValue);
                }
            }
        }
    }
}

