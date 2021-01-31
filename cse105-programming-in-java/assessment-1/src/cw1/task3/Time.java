/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw1.task3;

import java.util.Scanner;

/**
 *
 * @author christopher
 */
public class Time {

    // CONSTANTS
    private static final int SECOND = 1;
    private static final int MINUTE = 60;
    private static final int HOUR = 3600;
    private static final int DAY = 86400;
    private static final int YEAR = DAY * 365;
    private static final int MONTH = YEAR / 12;

    // private class variables
    private int second;
    private int minute;
    private int hour;
    private int day;
    private int month;
    private int year;
    // Used to get and store user input
    private long seconds;

    public static void main(String[] args) {

        // Call to constructor initializes vars and gets user input
        Time myTime = new Time();
        // Calculate user input and print to console
        myTime.run();
    }

    public Time() {

        // Print user welcome message to console
        displayWelcomeMsg();
        // Initialize class variables to 0
        this.second = 0;
        this.minute = 0;
        this.hour = 0;
        this.day = 0;
        this.month = 0;
        this.year = 0;
        // Get user input and store the value in the 'seconds' variable
        setSeconds();
    }

    public void run() {

        // Do calculations with user input
        calculateTime(seconds);
        // Display the results
        System.out.println(getTimeToString());
    }

    private void calculateTime(long seconds) {
        // If passed paramter long is >= CONSTANT value,
        // subtract CONSTANT value and reassign remaining value to long.
        // Increment private class variables according to number of passes
        // through each while loop.
        while (seconds >= YEAR) {
            seconds = seconds - YEAR;
            year++;
        }
        while (seconds >= MONTH) {
            seconds = seconds - MONTH;
            month++;
        }
        while (seconds >= DAY) {
            seconds = seconds - DAY;
            day++;
        }
        while (seconds >= HOUR) {
            seconds = seconds - HOUR;
            hour++;
        }
        while (seconds >= MINUTE) {
            seconds = seconds - MINUTE;
            minute++;
        }
        while (seconds >= SECOND) {
            seconds--;
            second++;
        }
    }

    private void displayWelcomeMsg() {
        // Print welcome message to the console when program starts
        System.out.println("***************************************************************************************");
        System.out.println("This program will convert time in seconds into days, hours, minutes, and seconds.");
        System.out.println("***************************************************************************************\n");
        System.out.print("Enter an amount in seconds: ");
    }

    // SETTER METHODS
    private void setSeconds() {
        this.seconds = getUserInput();
    }

    // GETTER METHODS
    private long getUserInput() {
        Scanner stringInput = new Scanner(System.in);
        return Long.parseLong(stringInput.nextLine());
    }

    private String getSecondsToString() {
        return String.valueOf(seconds);
    }

    private String getUnitOfTimeToString(String timeUnit, int singular) {
        // Add an "s" to the end of passed String parameter if passed time parameter is not equal to 1
        // e.g. "0 seconds, 1 second, 2 seconds"; return String parameter
        if (singular != 1) {
            timeUnit += "s";
        }
        return timeUnit;
    }

    private String getTimeToString() {
        // Concatenates class variables with story strings and returns as String
        return getSecondsToString() + " Output: "
                + year + " " + getUnitOfTimeToString("year", year) + ", "
                + month + " " + getUnitOfTimeToString("month", month) + ", "
                + day + " " + getUnitOfTimeToString("day", day) + ", "
                + hour + " " + getUnitOfTimeToString("hour", hour) + ", "
                + minute + " " + getUnitOfTimeToString("minute", minute) + " and "
                + second + " " + getUnitOfTimeToString("second", second);
    }
}
