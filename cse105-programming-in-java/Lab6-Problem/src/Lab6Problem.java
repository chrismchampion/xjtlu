
import java.util.Locale;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ANDREW.ABEL
 */
public class Lab6Problem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Lab6Problem lab6 = new Lab6Problem();
    }

    public Lab6Problem() {

        // Method call to display multiplication table
        //int userInput = getUserInput();
        //displayTimesTable(userInput);
        // Method call for calculate interest 
        //System.out.println(calculateInterest(40000) + " Months to reach limit");
        // Method call to show current account balance
        //currentAccount(10.0);
        // Method call to show current account balance with bonus account
        bonusAccount(10.0);
    }

    private int getUserInput() {

        displayInputMsg();
        boolean validInput;
        Scanner intInput = new Scanner(System.in);

        do {
            String userInput = intInput.nextLine();
            try {
                int i = Integer.parseInt(userInput);
                // If user input can be parsed to positive integer, return it
                if (i > 0) {
                    return i;
                }
                // Otherwise display message and and jump to top
                displayInvalidInputMsg();
                validInput = false;
            } catch (NumberFormatException e) {
                // If string can't be parsed to int, user didn't enter an integer
                // Display message and jump to top
                displayInvalidInputMsg();
                validInput = false;
                //e.printStackTrace();
            }
        } while (!validInput);

        return -1;
    }

    private void displayTimesTable(int multiplier) {

        System.out.println("\n" + multiplier + " x " + multiplier);

        for (int rowNum = 1; rowNum <= multiplier; rowNum++) {
            // Display row number
            System.out.print(rowNum + "\t");

            // Display multiples
            for (int multiple = 2; multiple <= multiplier; multiple++) {

                System.out.print(multiple * rowNum + "\t");
            }

            // Print each row on a new line
            System.out.println();
        }
    }

    private void displayInputMsg() {
        System.out.println("Input a number");
    }

    private void displayInvalidInputMsg() {
        System.out.println("Invalid Input: Please enter a positive integer.");
    }

    private int calculateInterest(double balance) {

        int month = 0;
        while (balance < 50000) {

            balance = balance * 1.04;
            month++;
            System.out.println("Month " + month + " balance is " + balance);

        }
        return month;
    }

    private void currentAccount(double balance) {

        int month = 1;
        int salary = 200;

        while (month <= 12) {

            double bills = Math.random() * 100;

            balance += salary - bills;

            printCurrentAccount(month, bills, salary, balance);

            month++;
        }
        month--;
        System.out.println("Balance after " + month + " months is " + String.format("%1$,.2f", balance));
    }

    private void bonusAccount(double balance) {

        int month = 1;
        int salary = 200;

        while (month <= 12) {

            double bills = Math.random() * 100;

            balance += salary - bills;
            
            if (balance < 0) {
                balance = balance - 1000;
            }
            if (balance > 1000) {
                balance = balance * 1.04;
            }
            printCurrentAccount(month, bills, salary, balance);

            month++;
        }
        month--;
        System.out.println("Balance after " + month + " months is " + String.format("%1$,.2f", balance));
    }

    private void printCurrentAccount(int month, double bills, int salary, double balance) {

        System.out.println("*********************");

        System.out.println("Month:\t\t" + month);
        System.out.println("Bills:\t\t" + String.format("%1$,.2f", bills));
        System.out.println("Salary:\t\t" + salary);
        if (balance < 0) {
            System.out.println("OVERDRAFT FEE: -1000");
        }
        if (balance > 1000) {         
            System.out.println("CONGRATS! You gained 4% interest.");         
        }
        System.out.println("Balance:\t" + String.format("%1$,.2f", balance));

        System.out.println("*********************");
    }
}
