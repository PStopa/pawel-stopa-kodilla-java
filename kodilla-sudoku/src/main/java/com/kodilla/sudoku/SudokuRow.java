package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SudokuRow {
    private ArrayList<SudokuElement> elementsOfRow = new ArrayList<>();

    public void addElement(SudokuElement element) {
        elementsOfRow.add(element);
    }

    public ArrayList<SudokuElement> getElementsOfRow() {
        return elementsOfRow;
    }

    @Override
    public String toString() {
        return elementsOfRow.stream()
                .map(SudokuElement::toString)
                .collect(Collectors.joining("|","|","|"));
    }
}
