/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3.scanner;

import java.util.Scanner;

/**
 *
 * @author ANDREW.ABEL
 */
public class Cracker {

    int comb1;
    int comb2;
    int comb3;
    int comb4;
    boolean guess1;
    boolean guess2;
    boolean guess3;
    boolean guess4;
    int numCorrect = 0;

    public static void main(String[] args) {

        Cracker crack = new Cracker(4, 2, 1, 9);

    }

    public Cracker(int pComb1, int pComb2, int pComb3, int pComb4) {

        //Define the answer
        this.comb1 = pComb1;
        this.comb2 = pComb2;
        this.comb3 = pComb3;
        this.comb4 = pComb4;

        while (numCorrect < 4) {
            guess1 = getInput(comb1, 1);
            guess2 = getInput(comb2, 2);
            guess3 = getInput(comb3, 3);
            guess4 = getInput(comb4, 4);

            printResults();
            printScore();
        }

    }

    // Method to check input
    private boolean getInput(int combination, int round) {

        boolean correctGuess = false;
        
        // Create Scanner and take first input
        Scanner numIn = new Scanner(System.in);
        System.out.println("***********************************");
        System.out.println("Input Integer " + round);
        int userInputInteger = numIn.nextInt();

        // Check input
        if (userInputInteger < combination) {
            System.out.println("Integer " + round + " is too low");
        } else if (userInputInteger > combination) {
            System.out.println("Integer " + round + " is too high");
        } else {
            correctGuess = true;
            System.out.println("Integer " + round + " is correct");
        }
        System.out.println("***********************************");
        return correctGuess;
    }

    private int countCorrect(boolean guess1, boolean guess2, boolean guess3, boolean guess4) {

        int correctGuesses = 0;
        boolean[] guesses = {guess1, guess2, guess3, guess4};

        for (boolean guess : guesses) {
            if (guess) {
                correctGuesses++;
            }
        }
        return correctGuesses;
    }

    private void printResults() {
        System.out.println("Integer 1 result: " + guess1);
        System.out.println("Integer 2 result: " + guess2);
        System.out.println("Integer 3 result: " + guess3);
        System.out.println("Integer 4 result: " + guess4);

    }

    private void printScore() {
        numCorrect = countCorrect(guess1, guess2, guess3, guess4);

        if (numCorrect == 4) {
            System.out.println("Congratulations! You cracked the code!");
        } else {
            System.out.println("You got "
                    + countCorrect(guess1, guess2, guess3, guess4)
                    + " correct!");
        }

    }
}
