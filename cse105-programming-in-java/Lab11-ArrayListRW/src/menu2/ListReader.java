/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author christopher
 */
public class ListReader {

    public static void readPersonList(String filename) {

        File file = new File(filename);
        String line = "";

        try {
            BufferedReader fReader = new BufferedReader(new FileReader(filename));

            while ((line = fReader.readLine()) != null) {
                System.out.println(line);
            }
            fReader.close();

        } catch (IOException e) {
            System.out.println("Error reading file " + '"' + filename + '"');
        }
    }
}
