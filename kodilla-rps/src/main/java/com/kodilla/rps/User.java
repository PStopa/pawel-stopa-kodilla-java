package com.kodilla.rps;

import java.util.Scanner;

public class User{
    private int numberOfRounds;
    private String username;
    private Scanner scanner = new Scanner(System.in);

    public User() {
        System.out.print("Enter your name: ");
        username = scanner.nextLine();
    }

    public void setNumberOfRounds(){
        System.out.print("Enter number of rounds: ");
        numberOfRounds = scanner.nextInt();
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public int chooseGesture(){
        System.out.print(username + ", what`s your choice: ");
        return scanner.nextInt();
    }

    public boolean exitAsk(){
        System.out.println("_________________________\nPress 'X' - end the game\n" +
                           "Press 'N' - new game\n_________________________");
        System.out.print(username + ", what`s your choice: ");

        String endTheGame = scanner.next();
        endTheGame = endTheGame.toLowerCase();
        if(endTheGame.equals("x")) {
            System.out.println("\nGoodbye " + username + "!...");
            return true;
        } else {
            System.out.println("\n\n\t\t NEW GAME!\n_________________________");
            return false;
        }
    }
}
