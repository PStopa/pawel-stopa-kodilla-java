package com.kodilla.stream.array;

import java.util.OptionalDouble;
import java.util.stream.*;

public interface ArrayOperations {
    static double getAverage(int[] numbers){
        IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .forEach(n -> System.out.print(n + " "));

        OptionalDouble average = IntStream.range(0, numbers.length)
                                    .map(n -> numbers[n])
                                    .average();
        return average.getAsDouble();
    }


}
