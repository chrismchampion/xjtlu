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
public class Lab4Person {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Person person1 = new Person("Jacky", 32, "123 Main St.");
        //person1.printName();
        
        Person person2  = new Person("Tammy", 22, "321 Fake St.");
        //person2.printName();
        
        Person person3 = new Person("Sirus", 26, "Sector 9, Block B");
        //person3.printName();
        
        //System.out.println(person1.getPersonInfo());
        
        //Person[] people = new Person[3];
        Person[] people = {person1, person2, person3};
        
        for (Person p : people) {
            System.out.println(p.toString());
        }
    }
    
}
