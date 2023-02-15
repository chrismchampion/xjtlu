/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ANDREW.ABEL
 */
package week5problem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Week5Problem {

    private Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {

        Week5Problem probs = new Week5Problem();

    }

    public Week5Problem() {
        /* Constructor, where all methods are called
         * Receives valid input from keyboard, calls display method
         * to draw.  Checks for a new input, redraw if needed
         * if user is finished, displays a goodbye message
         */
        // Pass user input return value to drawTree for treeSize
        drawTree(inputNumber());
        
        while (playAgain()) {
           drawTree(inputNumber());
         }
    }

    private int inputNumber() {

        boolean validInput = false;
        int num = 0;
        
        do {
            try {
                System.out.println("Input a number from 1 - 9:");
                num = userInput.nextInt();
                if (num > 0 && num < 10)
                    validInput = true;
                else
                    System.out.println("Number must be between 1 and 9");
            } catch (InputMismatchException e) {
                System.out.println("Invalid number, please re-enter an integer:");
            }
            userInput.nextLine();
        } while (!validInput);
        
        return num;
    }

    private void drawTree(int countIn) {
        /* A method that will receive an integer and display a tree
        *  corresponding to that number of rows.
         */
        // Checks if user entered a number between 1 and 9     
        System.out.println(" Draw a tree from 1 to " + countIn);
        // number of rows determined by countIn value
        for (int rows = 1; rows <= countIn; rows++) {

            // number of spaces to print starting at row 1, ending at countIn
            // spaces = countIn - number of rows
            for (int spaces = 1; spaces <= countIn - rows; spaces++) {
                System.out.print(" ");
            }

            // print numbers from row number down to 1 for each row
            for (int num = rows; num >= 1; num--) {
                System.out.print(num);
            }

            // Starting at row 2, print from 2 up to row number
            for (int num2 = 2; num2 <= rows; num2++) {
                System.out.print(num2);
            }
            // Print each row on a new line
            System.out.println();
        }
    }

    private boolean playAgain() {

        boolean playAgain = false;
        
        System.out.println("Draw another? (y/n)");
        // get user input and remove white space
        String answer = userInput.nextLine().trim().toLowerCase();
        if (answer.equals("y")) {
            playAgain = true;
        } else if (answer.equals("n")) {
            playAgain = false;
            System.out.println("*************");
            System.out.println("Goodbye!");
        } else {
            System.out.println("Invalid choice, please enter y/n");
        }
                
        return playAgain;
    }

}
