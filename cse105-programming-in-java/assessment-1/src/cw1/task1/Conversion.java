/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw1.task1;

import java.util.Scanner;

/**
 *
 * @author christopher Write a program that converts measurements from fathoms
 * to meters. A fathom is an old imperial measure of water depth. 1 fathom =
 * 1.8288m.
 *
 * You program should: Tell the user what it does. Ask the user for an input
 * range [e.g. 1-10] Print a labeled and formatted table showing the values for
 * this range
 */
public class Conversion {

    // CONSTANTS
    private static final double FATHOM_TO_METER = 1.8288;

    public static void main(String[] args) {

        // New instance of Conversion calls constructor
        Conversion conversion = new Conversion();
    }

    public Conversion() {

        // Display welcome message
        displayWelcomeMsg();

        // Get input from user.
        int fathoms = getUserInput();
        // Declare arrays the size of user input value
        int[] fathomArr = new int[fathoms];
        double[] metersArr = new double[fathoms];

        // Calculate fathoms
        convertToMeters(fathomArr, metersArr);

        // Display results
        displayConversionTable(fathomArr, metersArr);
    }

    private int getUserInput() {

        displayInputMsg();
        Scanner userInput = new Scanner(System.in);

        boolean validInput;
        do {
            // Get user input as String and parse to int throws NumberFormatException
            String inputString = userInput.nextLine();
            try {
                int posInt = Integer.parseInt(inputString);
                // return valid user input
                if (posInt > 0) {
                    return posInt;
                }
                // Otherwise display invalid input message
                displayInvalidInputMsg();
                validInput = false;
            } catch (NumberFormatException e) {
                // If String can't be parsed to int, display invalid input message
                displayInvalidInputMsg();
                validInput = false;
            }
        } while (!validInput);

        return -1;
    }

    private void convertToMeters(int[] fathoms, double[] meters) {

        for (int i = 0; i < fathoms.length; i++) {
            // Initialize fathoms array with index at i + 1;
            fathoms[i] = i + 1;
            // Initialize meters array with value of fathoms at i * 1.8288
            meters[i] = (fathoms[i] * FATHOM_TO_METER);
        }
    }

    private void displayConversionTable(int[] fathoms, double[] meters) {

        System.out.println();
        System.out.println("Fathoms" + "\t\t" + "Meters");
        for (int i = 0; i < fathoms.length; i++) {
            // Print the fathoms and meters arrays row by row to the console
            System.out.println(fathoms[i] + "\t\t" + meters[i]);
        }
    }

    private void displayWelcomeMsg() {
        System.out.println("***************************************************************************************");
        System.out.println("Use this program to display a range of fathoms and their corresponding value in meters.");
        System.out.println("Range: 1 to the number entered...");
        System.out.println("***************************************************************************************\n");
    }

    private void displayInputMsg() {
        System.out.print("Enter a positive integer: ");
    }

    private void displayInvalidInputMsg() {
        System.out.println("You didn't enter a postive integer. Please try again: ");
    }
}
