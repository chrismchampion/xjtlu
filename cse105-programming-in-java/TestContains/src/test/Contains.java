/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author christopher
 */
public class Contains {
    
    public static void main(String[] args) {
        
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        
        
        list1.add("Billy");
        list1.add("Bob");
        list1.add("Thorton");
        //list1.add("Maple");
        
        list2.add("Billy");
        list2.add("Bob");
        list2.add("Thorton");
        list2.add("Candy");
        
        System.out.print("List 1: ");
        for (String str : list1) {
            System.out.print(str + " ");
        }
        
        System.out.print("\nList 2: ");
        for (String str : list2) {
            System.out.print(str + " ");
        }
        
        if (Collections.indexOfSubList(list2, list1) == 0) {
            System.out.println("\n\nList 1 is a subset of List 2");
        } else {
            System.out.println("\n\nList 1 is NOT a subset of List 2");
        }
        //System.out.println(Collections.indexOfSubList(list2, list1));
    }
}
