/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblesort;

/**
 *
 * @author christopher
 */
public class CSE102BubbleSortAlg {
    
    public static void main(String []args) {
        
        int[] ints = {6,1,2,3,4,5};
        bubbleSort(ints);
    }
    
    public static void bubbleSort(int[] array) {
        
        for (int i = 0; i < 6; i++) {
            for (int j = 5; j > i + 1; j--) {
                if (array[j] < array[j-1]) {
                    System.out.println(array[j] + "<" + array[j-1]);
                } else {
                    System.out.println("fuuuuuuu");
                }
                
            }
        }
        
    }
}
