/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortobjectstest;

/**
 *
 * @author christopher
 */
public class Student {
    
    private String name;
    private int age;
    
    public Student(String pName, int pAge) {
        this.name = pName;
        this.age = pAge;
    }

    String getName() {
        return name;
    }

    Integer getAge() {
        return age;
    }
    
}
