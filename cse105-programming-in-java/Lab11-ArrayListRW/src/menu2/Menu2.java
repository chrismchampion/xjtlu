/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu2;

import java.util.ArrayList;

/**
 *
 * @author christopher
 */
public class Menu2 {
    
    public Menu2() {
        
    }
    
    public static void main(String[] args) {
        
        Person andrew = new Person("Andrew", 32, "XJTLU", false);
        Person laura = new Person("Laura", 34, "Nottingham", false);
        Person jennifer = new Person("Jennifer", 32, "Dundee", false);
        Person zhengzheng = new Person("Zhengzheng", 32, "Hefei", false);
        Person mohammed = new Person("Mohammed", 32, "Riyadh", false);
        Person david = new Person("David", 11, "Scotland", false);
        
        ArrayList<Person> people = new ArrayList<Person>();
        people.add(andrew);
        people.add(laura);
        people.add(jennifer);
        people.add(zhengzheng);
        people.add(mohammed);
        people.add(david);
        people.size();
        //people.sort();
        
        String filename = "PeopleList.txt";
        ListWriter.writePersonList(people, filename);
        ListReader.readPersonList(filename);
        
        myMethod();
        System.out.println("Exited myMethod after throwing exceptiong w/o entering loop.");
    }
    
    public static void myMethod() {
        int val = 0;
        if (val == 0)
            throw new IndexOutOfBoundsException();
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
