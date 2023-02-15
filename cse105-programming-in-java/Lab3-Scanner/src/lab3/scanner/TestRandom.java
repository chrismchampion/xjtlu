/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3.scanner;

/**
 *
 * @author christopher
 */
public class TestRandom {
    
    public static void main(String[] args){
        
        /*double random = 0;
        while (random < 10){
            random = (Math.random()*10+1);
            System.out.println("rand is" + random);
        }*/
        
        int[] array = {3, 0, 5, 1, 2};
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
            for (int j = 0; j < array.length; j++) {
                if (array[i] < array[j]) {
                    temp = array[j];
                }
            }
        }
        System.out.println(temp);
    
    }
}
