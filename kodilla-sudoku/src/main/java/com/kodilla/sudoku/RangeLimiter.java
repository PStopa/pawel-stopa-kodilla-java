package com.kodilla.sudoku;

public class RangeLimiter {
    public static int findStartOfBlock(int index){
        if (index < 3) {
            return 0;
        } else if (index < 6) {
            return 3;
        } else {
            return 6;
        }
    }
}
