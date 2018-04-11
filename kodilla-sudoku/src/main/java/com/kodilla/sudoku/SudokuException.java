package com.kodilla.sudoku;

import java.util.ArrayList;

public class SudokuException extends Exception {

    public SudokuException(String message, ArrayList<SudokuElement> list, int value) {
        //System.out.println(message + list + "\n" + ", value: " + value);
    }
}
