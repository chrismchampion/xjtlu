/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse104_tutorial7;

public class HeapSorter {

    // exchange a[i] and a[j]
    private static void swap(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public void sort(int arr[]) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        //One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            //Move current root to end
            swap(arr, 0, i);
            //call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    private void heapify(int arr[], int n, int i) {
        int largest = i;  // Initialize largest as root
        int l = 2 * i + 1;  // left = 2*i + 1
        int r = 2 * i + 2;  // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    private static void printArray(int arr[]) {
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

        HeapSorter ob = new HeapSorter();
        ob.sort(arr);
        ob.sort(arr1);
        ob.sort(arr2);
        ob.sort(arr3);

        System.out.println("Sorted array:");
        printArray(arr);
        printArray(arr1);
        printArray(arr2);
        printArray(arr3);
    }
}
