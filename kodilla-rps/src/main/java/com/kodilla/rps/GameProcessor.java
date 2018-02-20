package com.kodilla.rps;

import java.util.Random;

public class GameProcessor {
    private int userGesture, computerGesture;
    private int userScore = 0, computerScore = 0;
    private Random random = new Random();

    public void startRound(User user){
        userGesture = user.chooseGesture();
        computerGesture = chooseComputerGesture();
        System.out.println("You choose: " + GameProcessor.choiceToString(userGesture));
        System.out.println("Computer choose: " + GameProcessor.choiceToString(computerGesture));
        calculateScoreBoard(userGesture, computerGesture);
    }

    private int chooseComputerGesture(){
        computerGesture = random.nextInt(100)+1;
        if(userGesture == 1) computerGestureBaseOnRange(3,4,2,5,1);
        if(userGesture == 2) computerGestureBaseOnRange(1,5,3,4,2);
        if(userGesture == 3) computerGestureBaseOnRange(2,4,1,5,3);
        if(userGesture == 4) computerGestureBaseOnRange(2,5,1,3,4);
        if(userGesture == 5) computerGestureBaseOnRange(1,3,2,4,5);
        return computerGesture;
    }

    private void computerGestureBaseOnRange(int win1, int win2, int loose1, int loose2, int tie){
        // 50% WIN
        if(computerGesture >0 && computerGesture <=25) computerGesture = win1;
        if(computerGesture >25 && computerGesture <=50) computerGesture = win2;
        // 25% LOOSE
        if(computerGesture >50 && computerGesture <63) computerGesture = loose1;
        if(computerGesture >=63 && computerGesture <=75) computerGesture = loose2;
        // 25% TIE
        if(computerGesture >75) computerGesture = tie;
    }

    public void calculateScoreBoard(int userGesture, int computerGesture){
        System.out.println("_________________________");
        if(userGesture == computerGesture){
            System.out.println("IT`S A TIE IN THIS ROUND");
        } else {
            showRules();
            if(userGesture == 1) addPointToTheWinner(computerGesture,3,4,2,5);
            if(userGesture == 2) addPointToTheWinner(computerGesture,1,5,3,4);
            if(userGesture == 3) addPointToTheWinner(computerGesture,2,4,1,5);
            if(userGesture == 4) addPointToTheWinner(computerGesture,2,5,1,3);
            if(userGesture == 5) addPointToTheWinner(computerGesture,3,1,4,2);
        }
        System.out.println("_________________________");
        System.out.println("YOU: " + userScore + "     |  Computer: " + computerScore + "\n");
    }

    private void addPointToTheWinner(int computerGesture, int userWin1, int userWin2, int computerWin1, int computerWin2){
        if((computerGesture == userWin1) || (computerGesture == userWin2)){
            System.out.println("YOU`VE WON THIS ROUND :)");
            userScore++;
        }
        if((computerGesture == computerWin1) || (computerGesture == computerWin2)){
            System.out.println("COMPUTER`S WON THIS ROUND");
            computerScore++;
        }
    }

    public static String choiceToString(int choice){
        String result = null;
        if(choice == 1) result = "Rock";
        if(choice == 2) result = "Paper";
        if(choice == 3) result = "Scissors";
        if(choice == 4) result = "Lizard";
        if(choice == 5) result = "Spock";
        return result;
    }

    public void summaryTheGame(){
        if(userScore == computerScore){
            System.out.println("\n\t ##############");
            System.out.println("\t # IT`S A TIE #");
            System.out.println("\t ##############");
        }
        if (userScore > computerScore) {
            System.out.println("\n #######################");
            System.out.println(" # YOU ARE THE WINNER! #");
            System.out.println(" #######################");
        }
        if (computerScore > userScore){
            System.out.println("\n##########################");
            System.out.println("# COMPUTER IS THE WINNER #");
            System.out.println("##########################");
        }
    }

    private void showRules(){
        if((userGesture == 1 && computerGesture == 3) ||(userGesture == 3 && computerGesture == 1)){
            System.out.println("Rock crashes Scissors");
        }
        if((userGesture == 2 && computerGesture == 3) ||(userGesture == 3 && computerGesture == 2)){
            System.out.println("Scissors cuts Paper");
        }
        if((userGesture == 1 && computerGesture == 2) ||(userGesture == 2 && computerGesture == 1)){
            System.out.println("Paper covers Rock");
        }
        if((userGesture == 1 && computerGesture == 4) ||(userGesture == 4 && computerGesture == 1)){
            System.out.println("Rock crushes Lizard");
        }
        if((userGesture == 4 && computerGesture == 5) ||(userGesture == 5 && computerGesture == 4)){
            System.out.println("Lizard poisons Spock");
        }
        if((userGesture == 5 && computerGesture == 3) ||(userGesture == 3 && computerGesture == 5)){
            System.out.println("Spock smashes Scissors");
        }
        if((userGesture == 3 && computerGesture == 4) ||(userGesture == 4 && computerGesture == 1)){
            System.out.println("Scissors decapitates Lizard");
        }
        if((userGesture == 4 && computerGesture == 2) ||(userGesture == 2 && computerGesture == 4)){
            System.out.println("Lizard eats Paper");
        }
        if((userGesture == 2 && computerGesture == 5) ||(userGesture == 5 && computerGesture == 2)){
            System.out.println("Paper disproves Spock");
        }
        if((userGesture == 5 && computerGesture == 1) ||(userGesture == 1 && computerGesture == 5)){
            System.out.println("Spock vaporizes Rock");
        }
    }

    public void resetGame(){
        userScore = 0;
        computerScore = 0;
    }

    public int getUserScore() {
        return userScore;
    }

    public int getComputerScore() {
        return computerScore;
    }
}
