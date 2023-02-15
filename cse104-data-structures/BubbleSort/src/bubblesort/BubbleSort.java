/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblesort;

import java.util.Scanner;

/**
 *
 * @author christopher
 */
public class BubbleSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int counter;
        int[] array;
        int totalAmt = 0;
        boolean validInput = false;
        int min = 2;
        int max = 5;
        Scanner kbInput = new Scanner(System.in);

        // GET USER INPUT
        System.out.println("Enter a number between 2-5 for loop counter: ");
        counter = kbInput.nextInt();

        // VALIDATE USER INPUT
        do {
            if (counter < min) {
                System.out.println("You must enter a number greater than 1");
                counter = kbInput.nextInt();
            } else if (counter > max) {
                System.out.println("You must enter a number less than 6");
                counter = kbInput.nextInt();
            } else {
                validInput = true;
            }
        } while (!validInput);

        // INITIALIZE ARRAY THE SIZE OF COUNTER
        array = new int[counter];

        // ASSIGN USER INPUT TO ARRAY INDEXES
        for (int i = 1; i <= counter; i++) {
            System.out.print("Enter int " + i + ": ");
            int checkInput = kbInput.nextInt();
            if (checkInput < 0) {
                array[i - 1] = 0;
            } else {
                array[i - 1] = checkInput;
            }
        }

        // PRINT ARRAY BEFORE SORT
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        // BUBBLE SORT ARRAY
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {

                if (array[j - 1] > array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }

        // PRINT ARRAY AFTER SORT
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        
        // PRINT TOTAL AMT
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            totalAmt += array[i];
            
        } System.out.print("Total amount is " + totalAmt);

    }

}
