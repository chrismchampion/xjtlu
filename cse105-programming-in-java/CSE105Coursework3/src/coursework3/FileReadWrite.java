/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author christopher
 */
public class FileReadWrite {
    
    public static ArrayList<CommunityGroup> readGroupFile(String filename) {

        ArrayList<CommunityGroup> groups = new ArrayList<>();
        
        File file = new File(filename);
        String line = "";

        try {
            BufferedReader fReader = new BufferedReader(new FileReader(filename));

            //while ((line = fReader.readLine()) != null) {
            // Only read the first line which is reserverd for groups
            // If file already exists, add the groups to groups ArrayList
            if ((line = fReader.readLine()) != null) {
            
                System.out.println(line);
                String groupList[] = line.split(",");
                String group1 = groupList[0];
                String group2 = groupList[1];
                String group3 = groupList[2];
                String group4 = groupList[3];
                String group5 = groupList[4];
                
                CommunityGroup cg1 = new CommunityGroup(group1);
                CommunityGroup cg2 = new CommunityGroup(group2);
                CommunityGroup cg3 = new CommunityGroup(group3);
                CommunityGroup cg4 = new CommunityGroup(group4);
                CommunityGroup cg5 = new CommunityGroup(group5);
                
                groups.add(cg1);
                groups.add(cg2);
                groups.add(cg3);
                groups.add(cg4);
                groups.add(cg5);
            }
            fReader.close();

        } catch (IOException e) {
            System.out.println("Error reading file " + '"' + filename + '"');
        }
        
        return groups;
    }
    
    public static void writeGroupFile(ArrayList<Volunteer> volList, String filename) {
        
        File file = new File(filename);
        
        try {
            BufferedWriter fWriter = new BufferedWriter(new FileWriter(file, true));
            
            Iterator<Volunteer> vIterator = volList.iterator();
            while (vIterator.hasNext()) {
                Volunteer vol = vIterator.next();
                fWriter.write(vol.getSkillSet());
                fWriter.newLine();
            }
            System.out.println("Changes saved to " + filename);
        } catch (IOException e) {
            System.out.println("ERROR writing changes to " + filename);
        }
        
        
    }
    
    public static void initGroupFile(ArrayList<CommunityGroup> groupList, String filename) {
        
        File file = new File(filename);

        try {

            BufferedWriter fWriter;
            //fWriter = new BufferedWriter(new FileWriter(file, true));
            fWriter = new BufferedWriter(new FileWriter(file, false));

            Iterator<CommunityGroup> groupIt = groupList.iterator();
            while (groupIt.hasNext()) {
                CommunityGroup cg = groupIt.next();
                if (groupIt.hasNext()) {
                    fWriter.write(cg.getName() + ",");
                } else {
                    fWriter.write(cg.getName());
                }
                
            }          
            fWriter.newLine();  // writes a line separator to file
            fWriter.flush();    // flushes the stream
            fWriter.close();    // close the file

            System.out.println("Group list written to file");
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }
}
