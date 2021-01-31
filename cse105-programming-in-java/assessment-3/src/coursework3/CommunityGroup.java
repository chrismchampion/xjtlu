package coursework3;

import cw3interfaces.CommunityGroupInterface;
import java.util.ArrayList;

/**
 *
 * @author Christopher Champion, 1719247
 */
public class CommunityGroup implements CommunityGroupInterface {

    // Constants
    private final int MAX_VOL = 500;

    // private class variables
    private String groupName;
    private int totalA, totalB, totalC, totalD, totalE;
    private ArrayList<Volunteer> myVolunteers = new ArrayList<>();

    // Constructor
    public CommunityGroup(String pGroupName) {
        this.groupName = pGroupName;
    }

    @Override
    public int howManyVolunteers() {
        //return the total number of volunteers in this community group
        return myVolunteers.size();
    }

    @Override
    public String getSkillsTotals() {
        // return the total number of each skill in a String, example:
        //Skill A: 13, Skill B: 20, Skill C: 23, Skill D: 5, Skill E: 41

        // Initialize total skill int vars to 0
        totalA = 0;
        totalB = 0;
        totalC = 0;
        totalD = 0;
        totalE = 0;
        // For each volunteer
        for (Volunteer vol : myVolunteers) {
            // Get its skill set
            String skillSet = vol.getSkillSet();
            // Convert to char array
            char[] skills = skillSet.toCharArray();
            // Increase total skill in var for each skill in char[]
            for (int i = 0; i < skills.length; i++) {

                switch (skills[i]) {
                    case 'A':
                        totalA++;
                        break;
                    case 'B':
                        totalB++;
                        break;
                    case 'C':
                        totalC++;
                        break;
                    case 'D':
                        totalD++;
                        break;
                    case 'E':
                        totalE++;
                        break;
                }

            }

        }
        // Return totals as string
        return "Skill A: " + totalA + ", "
                + "Skill B: " + totalB + ", "
                + "Skill C: " + totalC + ", "
                + "Skill D: " + totalD + ", "
                + "Skill E: " + totalE;
    }

    @Override
    public String toString() {
        return groupName + " " + getSkillsTotals() + " " + "Total Volunteers: " + howManyVolunteers();
    }

    protected int getTotalSkill(char skill) {
        // Return a group's total for passed in skill char
        switch (skill) {
            case 'A':
                return totalA;
            case 'B':
                return totalB;
            case 'C':
                return totalC;
            case 'D':
                return totalD;
            case 'E':
                return totalE;
        }
        return 0;
    }

    protected String getGroupName() {
        return groupName;
    }

    protected ArrayList<Volunteer> getVolunteers() {
        return myVolunteers;
    }
    
    public int getTotalSkills() {
        return totalA + totalB + totalC + totalD + totalE;
    }

    public int[] getTotalSkillsArray() {
        int[] totals = {totalA, totalB, totalC, totalD, totalE};
        return totals;
    }

    public int getMaxVol() {
        return MAX_VOL;
    }

}
