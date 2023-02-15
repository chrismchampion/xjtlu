/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3.scanner;

import java.util.Scanner;

/**
 *
 * @author christopher
 */
public class ScannerInput1 {

    /**
     * @param args the command line arguments
     */
    static Scanner keyboard = new Scanner(System.in);
    static Scanner numPad = new Scanner(System.in);
    
    public static void main(String[] args) {
        // vars
        String input = "";
        double number1;
        double number2;
        double calculation;
        
        // Print name question
        System.out.println("What is your name?");
        input = keyboard.nextLine();
        
        // Print user input
        System.out.println("Your input was " + input);
        
        // Print command to enter number1
        System.out.println("Input the first number?");
        number1 = numPad.nextDouble();
        
        // Print command to enter number2
        System.out.println("Input the second number?");
        number2 = numPad.nextDouble();
        
        calculation = number1 * number2;
        
        // Print calculation
        System.out.println("Calculation : " + number1 + " * " + number2 + " = " + calculation);
    }
    
}
