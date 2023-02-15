/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author christopher
 */
public class ListWriter {

    public static void writePersonList(ArrayList<Person> personList, String filename) {

        File file = new File(filename);

        try {

            BufferedWriter fWriter;
            fWriter = new BufferedWriter(new FileWriter(file, true));

            for (Person p : personList) {
                
                fWriter.write(p.flatten());
                fWriter.newLine();
            }
            
            //fWriter.newLine();  // writes a line separator to file
            fWriter.flush();    // flushes the stream
            fWriter.close();    // close the file

            System.out.println("Person List written to file");
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }

    }
}
