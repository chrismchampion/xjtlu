/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.util.Comparator;

/**
 *
 * @author Ting.Cao
 */
public class MergeSorter {
    
    private static final int CUTOFF = 7;  // cutoff to insertion sort
    
    public static <E> void sort(E[] data, Comparator<? super E> comp) {   
        mergeSort(data, 0, data.length - 1, comp);
    }

    // sort from a[lo] to a[hi] using insertion sort
    private static <E> void insertionSort(E[] a, int low, int high,Comparator<? super E> comp ) {
        //student's code here.
    }
    


    private static <E> void mergeSort(E[] data,int low, int high, Comparator<? super E> comp) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        
        //Sort the first and the second half
        mergeSort(data, low, mid, comp);
        mergeSort(data, mid + 1, high, comp);
        merge(data, low, mid, high, comp);
    }

    private static <E> void merge(E[] a, int low, int mid, int high, Comparator<? super E> comp) {
        //student's code here.
    }

    private static <E> void show(E[] a) {
        for (E a1 : a) {
            System.out.print(a1 + ", ");
        }
    }
    public static void main(String[] args) {
        
        Integer[] values = new Integer[]{1, 42, 12, 3, 5, 90, 123, 20, 77, 3, 72, 5};
        Comparator<Integer> comp = new Comparator<Integer>() {
            public int compare(Integer d1, Integer d2) {
                return d1.compareTo(d2);
            }
        };
        MergeSorter.sort(values, comp);
        show(values);
        
    }

}


