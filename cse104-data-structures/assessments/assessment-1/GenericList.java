package coursework1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author christopher
 * @param <E>
 */
public class GenericList<E> extends ArrayList<E> {

    /**
     * @param <E>
     * @param a
     * @param b
     * @return *
     */
    public <E> List findMaxMin(int a, int b) {
        // Create new lists to preserve original lists
        List newList = new ArrayList<>(this);
        List<E> returnList = new ArrayList();
        // Sort new List asc
        Collections.sort(newList);
        // Initialize max/min elements with null
        E max = null;
        E min = null;
        // If valid input for a
        if (!(a < 1 || a > newList.size())) {
            // assign max value at [a] to E max
            max = (E) newList.get(newList.size() - a);
        } // else {E max remains null}
        // If valid input for b
        if (!(b < 1 || b > newList.size())) {
            // assign min value at [b] to E min
            min = (E) newList.get(b - 1);
        } // else {E min remains null}
        // add (max,min) values to list and return it
        returnList.add(max);
        returnList.add(min);
        return returnList;
    }

    public List<E> reverse() {
        // Create new List to preserver orginal list
        //  instantiate with this object's elements
        List newList = new ArrayList<>(this);
        // Reverse newList - linear time
        Collections.reverse(newList);
        // return List with duplicates removed
        return removeDuplicates(newList);
    }

    public boolean containList(List pList) {
        // Create new Lists to preserve original lists
        List listA = new ArrayList<>(this);
        List listB = new ArrayList<>(pList);
        // Remove duplicates
        listA = removeDuplicates(listA);
        listB = removeDuplicates(listB);
        // Sort lists asc
        Collections.sort(listA);
        try {
            // throws ClassCastException if user enters different type values
            Collections.sort(listB);
        } catch (ClassCastException e) {
            System.out.println("Please enter values of the same type (e.g. only integers).");

        }
        // Print elements of passed-in List (duplicates removed) before returning boolean value
        printList(listB);
        // Method defined in List interace, takes Collection of elements as parameter
        // returns true if the list contains all elements of the specified Collection
        return listA.containsAll(listB);
    }

    // Method to print list
    public void printList() {
        System.out.print("[");
        for (int i = 0; i < this.size(); i++) {
            // Print comma after every element but last
            if (i != this.size() - 1) {
                System.out.print(this.get(i) + ", ");
                // Print last element
            } else {
                System.out.print(this.get(i));
            }
        }
        System.out.println("]");
    }

    // Member accessible method to print list
    private void printList(List pList) {
        System.out.print("[");
        for (int i = 0; i < pList.size(); i++) {
            // Print comma after every element but last
            if (i != pList.size() - 1) {
                System.out.print(pList.get(i) + ", ");
            } else {
                // Print last element
                System.out.print(pList.get(i));
            }
        }
        System.out.println("]");
    }

    private List removeDuplicates(List pList) {
        // Remove duplicates from pList by converting to Set
        // LinkedHashSet defines doubly-linked list that maintains insertion-order
        Set<E> set = new LinkedHashSet<>(pList);
        // Convert Set back to List and return
        return new ArrayList<>(set);
    }

}
