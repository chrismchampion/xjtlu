/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myzoo;

/**
 *
 * @author christopher
 */
public class TestNestedFor {
    
    public static void main(String[] args) {
        
        int[][] matrix = new int[5][8];
        int num = 0;
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                matrix[i][j] = num;
                num++;
            }
        }
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(matrix[1][3]);

    }
}


