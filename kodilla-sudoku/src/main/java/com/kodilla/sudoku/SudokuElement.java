package com.kodilla.sudoku;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SudokuElement extends Prototype {
    private List<Integer> allowedValues = new ArrayList<>();
    public static int EMPTY = -1;
    private int value;

    public SudokuElement(int value) {
        this.value = value;
        for (int i=1; i<10; i++) {
            if (i!=value) allowedValues.add(i);
        }
    }

    public SudokuElement(int value, int v1){
        this.value = value;
        allowedValues.add(v1);
    }

    public SudokuElement(int value, int v1, int v2){
        this.value = value;
        allowedValues.add(v1);
        allowedValues.add(v2);
    }

    public SudokuElement(int value, int v1, int v2, int v3){
        this.value = value;
        allowedValues.add(v1);
        allowedValues.add(v2);
        allowedValues.add(v3);
    }

    public List<Integer> getAllowedValues() {
        return allowedValues;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
            this.value = value;
    }

    public void setValueIfAvailable() {
        if((allowedValues.size() == 1) && (getValue() == -1)) {
            setValue(allowedValues.get(0));
            allowedValues.clear();
        }
    }

    @Override
    public String toString() {
        if(value == -1) {
            return "   ";
        } else {
            return " " + Integer.toString(value) + " ";
        }
    }

    @Override
    public boolean equals(Object o) {
        SudokuElement that = (SudokuElement) o;
        if(value == that.getValue() && allowedValues.containsAll(that.allowedValues)){
            return true;
        } else {
            return false;
        }
    }

    public SudokuElement deepCopy() throws CloneNotSupportedException{
        SudokuElement clonedElement = (SudokuElement)super.clone();
        clonedElement.allowedValues = new ArrayList<>();
        clonedElement.allowedValues.addAll(allowedValues);
        clonedElement.value = this.value;
        return clonedElement;
    }
}
