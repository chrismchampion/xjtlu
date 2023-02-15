package menu1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author christopher
 */
public class StringWriter {

    public static void writeSingleString(String s) {

        File file = new File("SomeFile.txt");

        try {

            BufferedWriter fWriter;
            fWriter = new BufferedWriter(new FileWriter(file, true));
            fWriter.write(s); // write string contents to file
            fWriter.newLine();  // writes a line separator to file

            fWriter.flush();    // flushes the stream
            fWriter.close();    // close the file

            System.out.println("String written to file");

        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }

    public static void writeStringArray(String[] sArray) {

        File file = new File("StringArrayFile.txt");
        
        try {

            BufferedWriter fWriter;
            fWriter = new BufferedWriter(new FileWriter(file, true));

            if (sArray.length > 1) {
                for (int i = 0; i < sArray.length - 1; i++) {
                    fWriter.write(sArray[i] + ",");     // write string plus comma separator
                }
            }
            fWriter.write(sArray[sArray.length - 1]);   // write the last string in the array

            fWriter.newLine();  // writes a line separator to file
            fWriter.flush();    // flushes the stream
            fWriter.close();    // close the file

            System.out.println("Array written to file");
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }
}
