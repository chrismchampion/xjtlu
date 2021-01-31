/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse104_tutorial7;

/**
 *
 * @author Ting.Cao
 */
public class QuickSorter {

    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    private int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int index = low - 1; // index of smaller element
        for (int i = low; i < high; i++) {
            // If current element is smaller than or equal to pivot
            if (arr[i] <= pivot) {
                index++;
                // swap arr[i] and arr[j]
                swap(arr, index, i);
            }
        }
        // swap arr[i+1] and arr[high] (or pivot)
        swap(arr, index + 1, high);
        return index + 1;
    }

    private int partition_double(int arr[], int low, int high) {
        return -1;
    }

    // exchange a[i] and a[j]
    private static void swap(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


    public void sort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {10, 7, 8, 9, 1, 5};
        int arr1[] = {4, 10, 7, 8, 9, 1, 5};
        int arr2[] = {10, 9, 8, 7, 6, 5, 4, 3};
        int arr3[] = {1, 2, 3, 4, 5, 6, 8};

        QuickSorter ob = new QuickSorter();
        ob.sort(arr, 0, arr.length - 1);
        ob.sort(arr1, 0, arr1.length - 1);
        ob.sort(arr2, 0, arr2.length - 1);
        ob.sort(arr3, 0, arr3.length - 1);

        System.out.println("sorted array");
        printArray(arr);
        printArray(arr1);
        printArray(arr2);
        printArray(arr3);
    }
}
