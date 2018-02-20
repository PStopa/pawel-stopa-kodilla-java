package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main(String[] args) {
        SecondChallenge challenge = new SecondChallenge();

        try{
            String result = challenge.probablyIWillThrowException(2.0,2.0);
        } catch (Exception e){
            System.out.println("We have a problem... " + e);
        } finally {
            System.out.println("This statement is always visible");
        }
    }
}
