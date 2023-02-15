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
 * Class to calculate the area of a circle (a𝑎= 𝜋r2)
 */
public class CalculateCircleArea {
   
    // class constants
    static double PI = Math.PI;
    static double THRESHOLD = 50.0;
    
    public static void main(String[] args) {
       
        // Scanner for kb input
        Scanner keyboard = new Scanner(System.in);
        
        // Get radius from user kb input
        System.out.print("Enter radius of the circle: ");
        double radius = keyboard.nextDouble();
        
        // main method variables
        double area = PI * radius * radius;
        String circleSize;        
        
        // Testing area calculation
        System.out.println("The radius is " + radius);
        System.out.println("The area is " + area);
        
        // Testing circle size
        // area > 50.0 == big circle, else == small circle;
        if (area > THRESHOLD) {
            circleSize = "big circle";
        } else {
            circleSize = "small circle";
        }
        System.out.println("This is a " + circleSize);
    }
    
}
