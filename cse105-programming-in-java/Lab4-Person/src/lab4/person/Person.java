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
public class Person {
    
    String name;
    int age;
    String address;
    
    public Person(String pName, int pAge, String pAddress) {
        
        name = pName;
        age = pAge;
        address = pAddress;
        
    }
    
    protected void printName() {
        System.out.println("Created called " + name + " created");
    }
    
    @Override
    public String toString() {
        String header = "ToString Details:";
        String nameIs = "Person name is";
        String ageIs = "Person age is";
        String addressIs = "Person address is";
        
        return "\n" + header + "\n" + nameIs + " " + name +
                "\n" + ageIs + " " + age +
                "\n" + addressIs + " " + address;
    }
}
