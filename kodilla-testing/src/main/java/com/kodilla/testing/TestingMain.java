package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        Calculator calc = new Calculator();
        int outcome;
        int a = 2;
        int b = 4;
        outcome = calc.add(a, b);

        if (outcome == (a+b)){
            System.out.println("Add test - OK!");
        } else {
            System.out.println("Add test - Error!");
        }

        outcome = calc.subtract(a, b);
        if (outcome == (a-b)){
            System.out.println("Subtract test - OK!");
        } else {
            System.out.println("Subtract test - Error!");
        }

    }
}
