/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse104_tutorial2;

/**
 *
 * @author Ting.Cao
 */


public class Animal {
    private String name;
    private int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void info() {
        System.out.println(name + " age is:  " + age);
    }
}
