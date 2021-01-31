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
 * @author Christopher Champion, 1719247
 */
public class FileReadWrite {

    // Static methods for reading and writing to file "CW3File.txt"
    public static ArrayList<CommunityGroup> readFile() {

        ArrayList<CommunityGroup> groupListFromFile = new ArrayList<>();

        File file = new File("CW3File.txt");
        String line = "";

        try {
            BufferedReader fReader = new BufferedReader(new FileReader("CW3File.txt"));

            // While line exists, add the groups to groups ArrayList
            while ((line = fReader.readLine()) != null) {

                String groupNames[] = line.split("\t");
                CommunityGroup cg = new CommunityGroup(groupNames[0]);

                for (int i = 1; i < groupNames.length; i++) {
                    cg.getVolunteers().add(new Volunteer(groupNames[i]));
                }

                groupListFromFile.add(cg);
            }
            fReader.close();
            System.out.println("Groups imported from file " + '"' + "CW3File.txt" + '"');
        } catch (IOException e) {
            System.out.println("Created new file " + '"' + "CW3File.txt" + '"');
        }

        return groupListFromFile;
    }

    public static void writeFile(ArrayList<CommunityGroup> groupList) {

        File file = new File("CW3File.txt");

        try {
            // false overwrites file from beginning
            BufferedWriter fw = new BufferedWriter(new FileWriter(file, false));

            Iterator<CommunityGroup> cgIterator = groupList.iterator();

            while (cgIterator.hasNext()) {

                CommunityGroup cg = cgIterator.next();
                fw.write(cg.getGroupName() + "\t");

                if (!cg.getVolunteers().isEmpty()) {
                    ArrayList volunteerList = cg.getVolunteers();
                    // Write the skill set + "," for each volunteer up to the last one
                    for (int i = 0; i < volunteerList.size() - 1; i++) {
                        String skillSet = cg.getVolunteers().get(i).getSkillSet();
                        fw.write(skillSet + "\t");
                    }
                    // Get the last volunteer object and write its skill set without comma separator
                    int lastVolIndex = (volunteerList.size()) - 1;
                    Volunteer lastVol = cg.getVolunteers().get(lastVolIndex);
                    fw.write(lastVol.getSkillSet());
                }

                fw.newLine();
            }
            fw.flush();
            fw.close();          // close the file
            System.out.println("Groups written to file" + " " + '"' + "CW3File.txt" + '"');
        } catch (IOException e) {
            System.out.println("ERROR: Could not save groups to file.");
        }
    }

}
