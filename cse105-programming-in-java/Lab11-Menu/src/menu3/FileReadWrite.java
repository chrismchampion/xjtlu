/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author christopher
 */
public class FileReadWrite {

    public FileReadWrite() {
        
    }
    
    public static ArrayList<Person> readPersonFile(String filename) {

        ArrayList<Person> people = new ArrayList<>();
        
        File file = new File(filename);
        String line = "";

        try {
            BufferedReader fReader = new BufferedReader(new FileReader(filename));

            while ((line = fReader.readLine()) != null) {
                //System.out.println(line);
                String[] csList = line.split(",");
                String name = csList[0];
                int age = Integer.parseInt(csList[1]);
                String address = csList[2];
                boolean married = Boolean.parseBoolean(csList[3]);
                Person p = new Person(name, age, address, married);
                people.add(p);
            }
            fReader.close();

        } catch (IOException e) {
            System.out.println("Error reading file " + '"' + filename + '"');
        }
        
        return people;
    }
    
    public static void writePersonFile(ArrayList<Person> personList, String filename) {
        
        File file = new File(filename);

        try {

            BufferedWriter fWriter;
            //fWriter = new BufferedWriter(new FileWriter(file, true));
            fWriter = new BufferedWriter(new FileWriter(file, false));

            for (Person p : personList) {
                
                fWriter.write(p.flatten());
                fWriter.newLine();
            }
            
            //fWriter.newLine();  // writes a line separator to file
            fWriter.flush();    // flushes the stream
            fWriter.close();    // close the file

            System.out.println("Person list written to file");
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }
}
