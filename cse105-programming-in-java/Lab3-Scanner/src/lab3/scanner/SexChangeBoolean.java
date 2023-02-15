/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3.scanner;

import java.util.Scanner;

/**
 *
 * @author C.Champion17
 * Class to enter personal info and print introduction
 */
public class SexChangeBoolean {

    /**
     * @param args the command line arguments
     */
    // private class constants
    private static final String GENDER_PRONOUN_M = "his";
    private static final String GENDER_PRONOUN_F = "her";
    private static final String GENDER_OBJECT_M = "he";
    private static final String GENDER_OBJECT_F = "she";
    
    // private class variables
    private static String name;
    private static String origin;
    private static int age;
    private static int studentNumber;
    private static String favFood;
    private static String job;

    public static void main(String[] args) {

        // Initialize scanner for user input
        Scanner input = new Scanner(System.in);
        
        // vars
        boolean genderFemale;
        // Replaced with boolean 'genderFemale'
        //boolean genderMale = true;
        //String maleOrFemale;
        
        // Use user input to initialize variables
        System.out.println("Input name"); name = input.next();

        System.out.println("Input age"); age = input.nextInt();
        
        System.out.println("Input student number"); studentNumber = input.nextInt();
        
        System.out.println("Input job"); job = input.next();
        
        System.out.println("Input home town"); origin = input.next();
             
        System.out.println("Female? True or False?"); genderFemale = input.nextBoolean();
        
        // Replaced with boolean 'genderFemale'
        //System.out.print("Are you male or female? "); maleOrFemale = input.next(); 
        // Set genderMale boolean value to 'false' if user inputs "f" or "female"
        /*if (maleOrFemale.equalsIgnoreCase("f") || maleOrFemale.equalsIgnoreCase("female")) {
            genderMale = false;
        }*/
        
        
        // print introduction
        // Replaced with boolean 'genderFemale'
        //printIntro(genderMale);
        printIntro(genderFemale);
    }  
    
    // Method prints introduction text based on parameter value of boolean genderMale
    public static void printIntro(boolean pGenderFemale) {
        String genderObject;
        //String genderPronoun;
        if (pGenderFemale == true) {
            genderObject = GENDER_OBJECT_F;
            //genderPronoun = GENDER_PRONOUN_M;
        } else {
            genderObject = GENDER_OBJECT_M;
            //genderPronoun = GENDER_PRONOUN_F;
        }
        System.out.println("\nThis is " + capitalizeString(name) + " and " + genderObject + " is a " + job);
        System.out.println(capitalizeString(genderObject) + " is from " + capitalizeString(origin) + ".");
        //System.out.println(capitalizeString(genderPronoun) + " favorite food is " + favFood + ".");
        System.out.println("Name: " + capitalizeString(name) + ", Age: " + age + ", Student number: " + studentNumber);
    }
    
    // Method capitalizes first letter of string paramter and returns string
    public static String capitalizeString(String pString) {       
        pString = pString.substring(0, 1).toUpperCase() + pString.substring(1);
        return pString;
    }
    
}
