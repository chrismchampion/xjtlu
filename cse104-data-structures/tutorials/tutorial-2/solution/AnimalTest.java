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
public class AnimalTest {
    public static void main(String[] argv) {
        Animal[] animal = new Animal[2];
        Animal cat = new Animal("cat", 1);
        Animal dog = new Animal("dog", 2);
        animal[0] = dog;
        animal[1] = cat;
        // when array variable calles the method or attributes from the object, it will become a real java object
        System.out.println(animal.length);
        dog.info();
        animal[0].info();
        animal[1].info();
    } 
}
