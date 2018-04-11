package com.kodilla.sudoku;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SudokuBoard {
    private ArrayList<SudokuRow> rowsOfBoard = new ArrayList<>();

    public void addRow(SudokuRow row) {
        rowsOfBoard.add(row);
    }

    public ArrayList<SudokuRow> getRowsOfBoard() {
        return rowsOfBoard;
    }

    public SudokuElement getElement(int column, int row){
        return rowsOfBoard.get(row).getElementsOfRow().get(column);
    }

    public ArrayList<SudokuElement> getElementsOfRow(int column, int row){
        ArrayList<SudokuElement> list = new ArrayList<>();
        for(int i=0; i<9; i++) {
            if (i != column) {
                list.add(getElement(i, row));
            }
        }
        return list;
    }

    public ArrayList<SudokuElement> getElementsOfColumn(int column, int row){
        ArrayList<SudokuElement> list = new ArrayList<>();
        for(int i=0; i<9; i++) {
            if(i != row) {
                list.add(getElement(column, i));
            }
        }
        return list;
    }

    public ArrayList<SudokuElement> getElementsOfBlock(int column, int row){
        int startRowIndex = RangeLimiter.findStartOfBlock(row);
        int startColumnIndex = RangeLimiter.findStartOfBlock(column);

        ArrayList<SudokuElement> list = new ArrayList<>();
           for(int i = startRowIndex; i < startRowIndex+3; i++ ) {
            for(int j = startColumnIndex; j < startColumnIndex+3; j++) {
                if(!(i==row && j==column)) list.add(getElement(j,i));
            }
        }
        return list;
    }

    @Override
    public String toString() {
        return rowsOfBoard.stream()
                .map(SudokuRow::toString)
                .collect(Collectors.joining("\n- - - - - - - - - - - - - - - - - - -\n",
                        "- - - - - - - - - - - - - - - - - - -\n","\n- - - - - - - - - - - - - - - - - - -"));
    }

    public SudokuBoard deepCopy(){
        SudokuBoard clonedBoard = new SudokuBoard();
        clonedBoard.rowsOfBoard = new ArrayList<>();

       for(int i=0; i<9; i++){
           clonedBoard.rowsOfBoard.add(i, new SudokuRow());

           for(int j=0; j<9 ; j++){
               SudokuElement elementCopy = null;
               try{
                   elementCopy = this.rowsOfBoard.get(i).getElementsOfRow().get(j).deepCopy();
               } catch (CloneNotSupportedException e) {
                   System.out.println("Problem with deep copy of Element");
               }
               clonedBoard.rowsOfBoard.get(i).getElementsOfRow().add(j, elementCopy);
           }
       }
       return clonedBoard;
    }
}
