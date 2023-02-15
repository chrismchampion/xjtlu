/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.person;

/**
 *
 * @author christopher
 */
public class ArrayWork {
    
    public static void main(String[] args) {
        
        // Test int array
        /*
        int[] intArray = new int[5];
        intArray[0] = 27;
        intArray[1] = 28;
        intArray[2] = 29;
        intArray[3] = 30;
        intArray[4] = 31;

        for (int i : intArray) {
            System.out.println(i);
        }
        */
        
        // Arrays contain values for person obj constructor names, ages, and addresses
        String[] names = {"John", "Jakob", "Marilyn", "Thomas", "Marie", "Lena"};
        int[] ages = {63, 22, 31, 18, 23, 46};
        String[] addresses = {"44904 N Spring Dr", "Viktoriaallee 33", "22 Pleasant Dr", 
                                "Xingbo Jie", "Karlsgraben 22", "30 Rockefeller"};
        
        // Array to hold 6 new person objects
        Person[] people = new Person[6];
        
        // Pass values to person constructor for 6 person objects and add to people array
        for (int i = 0; i < 6; i++) {
            people[i] = new Person(names[i], ages[i], addresses[i]);
        }
        
        // Print people array details
        for (Person p: people) {
            System.out.println(p.toString());
        }
    }
}
