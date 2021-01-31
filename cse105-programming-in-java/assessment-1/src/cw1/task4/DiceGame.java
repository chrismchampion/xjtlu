/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw1.task4;

import java.util.Scanner;

/**
 *
 * @author christopher
 */
public class DiceGame {

    // private class variables
    private int[] dice;
    private int score;
    private int totalScore;
    private boolean playGame = true;

    public static void main(String[] args) {

        // New instance of DiceGame calls constructor
        DiceGame game1 = new DiceGame();

    }

    public DiceGame() {

        // Runs until user enters anything other than "y" or "yes"
        while (playGame) {

            // Initialize score with 0
            this.score = 0;
            // Initialize array size with number of die
            dice = new int[4];

            // Roll the dice
            roll(dice);
            // Display score
            calculateScore(dice);
            // Get input for play again
            playGame = playAgain();
        }
        // Display total score after game is over
        System.out.println("Your total points = " + totalScore);
    }

    private boolean playAgain() {

        // Get user input
        boolean playAgain = false;
        String answer;
        Scanner userInput = new Scanner(System.in);
        System.out.println("Would you like to play again (yes/no)?");
        answer = userInput.nextLine();

        // return boolean value based on value of answer String
        // ("y" or "yes" == true), otherwise false.
        if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
            playAgain = true;
        }
        return playAgain;
    }

    private void roll(int[] diceArray) {
        // Every time roll() is called a new random int value from 1 to 6
        // is assigned to each index of the passed in dice array
        for (int i = 0; i < diceArray.length; i++) {
            // Initialize each die with random from 1-6
            diceArray[i] = (int) (Math.random() * 6 + 1);
            System.out.print(diceArray[i] + " ");
        }
    }

    private void calculateScore(int[] diceArray) {

        // Reset scoreArray to 0 every time calculateScore() is called
        int[] scoreArray = {0, 0, 0, 0, 0, 0};
        
        // dieVal is 1 - 6 (loop 6 times)
        for (int dieVal = 1; dieVal <= scoreArray.length; dieVal++) {
            // for diceArray[0] to diceArray[3] (loop 4 times)
            for (int index = 0; index < diceArray.length; index++) {
                // If int value at diceArray index equals 1...6
                if (diceArray[index] == dieVal) {
                    // Increment value of scoreArray at index dieVal-1 by 1, e.g,
                    // diceArray[1,1,1,1] = scoreArray[4,0,0,0,0,0]
                    // diceArray[1,3,3,4] = scoreArray[1,0,2,1,0,0]
                    scoreArray[dieVal - 1]++;
                }
            }
        }
        // Iterate through scoreArray
        for (int index = 0; index < scoreArray.length; index++) {
            // If scoreArray at any index contains int value 2 or more
            if (scoreArray[index] > 1) {
                // then 2 or more numbers match. Assign value at index to score.
                this.score = scoreArray[index];
            }
        }
        // Increment total score with the value of score
        totalScore += this.score;
        // Print this round's score to the console
        System.out.println("Your score = " + this.score);
    }

}
