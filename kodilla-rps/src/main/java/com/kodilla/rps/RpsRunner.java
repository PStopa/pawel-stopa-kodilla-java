package com.kodilla.rps;

public class RpsRunner {
    public static void main(String[] args) {
        boolean endTheRound, endTheGame;
        int roundIterator;

        System.out.println("Welcome to ROCK, PAPER, SCISSOR, LIZARD*, SPOCK* GAME!\n");

        GameProcessor game = new GameProcessor();
        User user = new User();

        do{
            game.resetGame();
            endTheRound = false;
            roundIterator = 0;
            user.setNumberOfRounds();
            System.out.println("\n##########################\n#       Instruction:     #\n#" +
                    "  Press '1' - ROCK      #\n#  Press '2' - PAPER     #\n#  Press '3' - SCISSORS  #" +
                    "\n#  Press '4' - LIZARD    #\n#  Press '5' - SPOCK     #\n##########################");

            while(!endTheRound){
                if(roundIterator == user.getNumberOfRounds()){
                    endTheRound = true;
                } else {
                    System.out.println("\n\t### ROUND " + (roundIterator+1) + " ###");
                    game.startRound(user);
                    roundIterator++;
                }
            }
            game.summaryTheGame();
            endTheGame = user.exitAsk();
        } while(!endTheGame);
    }
}
