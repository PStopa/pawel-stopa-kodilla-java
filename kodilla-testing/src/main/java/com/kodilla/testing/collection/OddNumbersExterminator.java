package com.kodilla.testing.collection;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;
public class OddNumbersExterminator {
    public ArrayList exterminate(ArrayList<Integer> numbers){

        ArrayList<Integer> exterminateNumber = new ArrayList<Integer>();

        if(numbers.size() == 0) {
            return numbers;
        } else {
            for(Integer number: numbers){
                if(number % 2 == 0) {
                    exterminateNumber.add(number);
                    System.out.print(number + " ");
                }
            }
            System.out.println();
            return exterminateNumber;
        }

    }
}
