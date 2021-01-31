package coursework3;

import cw3interfaces.SkillSorterInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.Scanner;

/**
 *
 * @author Christopher Champion, 1719247
 */
public class SkillSorter implements SkillSorterInterface {

    // myGroups list of CommunityGroup objects
    private ArrayList<CommunityGroup> myGroups = new ArrayList<>();

    // Constructor
    public SkillSorter() {

        // Declare 5 community groups
        CommunityGroup group1, group2, group3, group4, group5;
        // Initialize myGroups with groups from file
        myGroups = FileReadWrite.readFile();
        // If no file present -> instantiate 5 groups
        if (myGroups.isEmpty()) {
            group1 = new CommunityGroup("Group 1");
            group2 = new CommunityGroup("Group 2");
            group3 = new CommunityGroup("Group 3");
            group4 = new CommunityGroup("Group 4");
            group5 = new CommunityGroup("Group 5");
            // Add newly created groups to myGroups
            myGroups.add(group1);
            myGroups.add(group2);
            myGroups.add(group3);
            myGroups.add(group4);
            myGroups.add(group5);
        }
    }

    @Override
    public void addVolunteer(Volunteer vol) {

        // Call getSkillsTotal on each group to get current total values before adding a new volunteer
        myGroups.forEach((cg) -> {
            cg.getSkillsTotals();
        });

        // Get new volunteer's skill set and conver to char[]
        String skillSet = vol.getSkillSet();
        char[] skillChars = skillSet.toCharArray();

        // Base Case for 0 of any skill
        int index = getGroupIndexZeroSkill(skillChars);
        // A group with 0 of some skill was found
        if (index != -1) {
            addVolunteerToGroup(vol, index);

            // Case for homogeneous skill set, e.g., "AAA":
        } else if (skillChars[0] == skillChars[1] && skillChars[1] == skillChars[2]) {
            index = getGroupIndexLeastSkill(skillChars[0]);
            addVolunteerToGroup(vol, index);

            // Case for "2-to-1" skill set, e.g., "ABB" and "AAB"
        } else if ((skillChars[0] == skillChars[1] || skillChars[1] == skillChars[2])) {
            boolean rightWeighted = false;
            int gIndex1;
            int gIndex2;
            char skill1 = skillChars[0];
            char skill2;
            // If 'left weighted', e.g., "AAB"
            if (skillChars[0] == skillChars[1]) {
                gIndex1 = getGroupIndexLeastSkill(skillChars[0]);
                gIndex2 = getGroupIndexLeastSkill(skillChars[2]);
                skill2 = skillChars[2];
            } else {
                // Else is 'right weighted', e.g., "ABB"
                gIndex1 = getGroupIndexLeastSkill(skillChars[0]);
                gIndex2 = getGroupIndexLeastSkill(skillChars[1]);
                skill2 = skillChars[1];
                rightWeighted = true;
            }
            index = getGroupIndexCompare(gIndex1, skill1, gIndex2, skill2, rightWeighted);
            addVolunteerToGroup(vol, index);

            // Case for heterogeneous skill set, e.g., "ABC":
        } else {
            int gIndex1 = getGroupIndexLeastSkill(skillChars[0]);
            int gIndex2 = getGroupIndexLeastSkill(skillChars[1]);
            int gIndex3 = getGroupIndexLeastSkill(skillChars[2]);
            index = getGroupIndexCompare(skillChars, gIndex1, gIndex2, gIndex3);
            addVolunteerToGroup(vol, index);
        }
    }

    @Override
    public void moveVolunteer(String skillSet, CommunityGroup from, CommunityGroup to) {
        // Move a volunteer with passed in skill set from one CommunityGroup to another
        // Check if skill set is valid
        if (isValidSkillSet(skillSet)) {
            // If the volunteer exists in 'from' CommunityGroup
            if (volunteerExists(skillSet, from)) {
                // Get its index
                int volAtIndex = getVolunteerIndex(skillSet, from);
                // Get volunteer from 'from' group's list of volunteers
                Volunteer vol = from.getVolunteers().get(volAtIndex);
                // Add it to 'to' group's list of volunteers
                to.getVolunteers().add(vol);
                // Remove it from 'from' group's list
                from.getVolunteers().remove(vol);
                System.out.println("Volunteer " + skillSet + " moved from " + from.getGroupName() + " to " + to.getGroupName());
                System.out.println("---------------------------");
            } else {
                System.out.println("No volunteers in " + from.getGroupName() + " with skill set " + skillSet);
                System.out.println("---------------------------");
            }
        } else {
            System.out.println("Cannot move volunteer " + skillSet + " because you did not enter a valid skill set.");
        }

    }

    @Override
    public void deleteVolunteer(String skillSet, CommunityGroup from) {
        // Check if skill set is valid
        if (isValidSkillSet(skillSet)) {
            // Check if volunteer with given skill set exists
            if (volunteerExists(skillSet, from)) {
                // Remove volunteer from Community Group at the index returned by getVolunteerIndex
                int volAtIndex = getVolunteerIndex(skillSet, from);
                // Get the volunteer at that index
                Volunteer vol = from.getVolunteers().get(volAtIndex);
                // Remove from community group
                from.getVolunteers().remove(vol);
                System.out.println("Removed " + skillSet + " from " + from.getGroupName());
                System.out.println("---------------------------");
            } else {
                System.out.println("No volunteers in " + from.getGroupName() + " with skill set " + skillSet);
                System.out.println("---------------------------");
            }
        } else {
            System.out.println("Cannot delete volunteer " + skillSet + " because you did not enter a valid skill set.");
        }
    }

    @Override
    public void deleteAllVolunteers() {
        // Delete all volunteers from all CommunityGroups
        // Get user confirmation
        Scanner in = new Scanner(System.in);
        System.out.print("Delete all volunteers (y/n)? ");
        // If y: clear Volunteer list of all objects for each CommunityGroup
        if (in.nextLine().equalsIgnoreCase("Y")) {
            myGroups.forEach((g) -> {
                g.getVolunteers().clear();
            });
            System.out.println("All volunteers successfully deleted.");
            System.out.println("---------------------------");
        } else {
            System.out.println("Delete operation aborted.");
            System.out.println("---------------------------");
        }
    }

    @Override
    public ArrayList<CommunityGroup> getCommunityGroups() {
        //return an ArrayList of all this application's CommunityGroups
        return myGroups;
    }

    protected void displayGroups() {
        // Display group name, skill set list, and total volunteers
        // line-by-line for each CommunityGroup object in myGroups list
        myGroups.forEach((g) -> {
            System.out.println(g.toString());
        });
        System.out.println("---------------------------");
    }

    protected boolean isValidSkillSet(String formattedString) {
        // Skill set is invalid if user entered more/less than 3 values
        if (formattedString.length() != 3) {
            return false;
        }

        char[] chars = formattedString.toCharArray();
        for (char c : chars) {
            // Skill set is invalid if user enters char other than A-E
            if (c < 'A' || c > 'E') {
                return false;
            }
        }
        return true;
    }

    protected void randomVolunteers(int numVol) {
        // Creates and allocates passed in number of volunteers
        for (int i = 0; i < numVol; i++) {
            Volunteer vol = new Volunteer(getRandomSkillSet());
            addVolunteer(vol);
        }
    }

    private String getRandomSkillSet() {

        int min = 65; // 'A'
        int max = 69; // 'E'
        int range = Math.abs(max - min) + 1;

        // Generate 3 random skills A - E as int values
        int a = (int) (Math.random() * range + (min <= max ? min : max));
        int b = (int) (Math.random() * range + (min <= max ? min : max));
        int c = (int) (Math.random() * range + (min <= max ? min : max));

        // Cast random int values to chars
        char skill1 = (char) a;
        char skill2 = (char) b;
        char skill3 = (char) c;

        // Convert chars to skill set String
        String randSkillSet = String.valueOf(skill1) + String.valueOf(skill2) + String.valueOf(skill3);
        // Return random skill set
        return Volunteer.formatSkillSet(randSkillSet);
    }

    private int getVolunteerIndex(String skillSet, CommunityGroup group) {
        // Return the index of the first volunteer with skillSet found in group
        ListIterator<Volunteer> vIterator = group.getVolunteers().listIterator();

        int i = 0;
        while (vIterator.hasNext()) {
            if (vIterator.next().getSkillSet().equalsIgnoreCase(skillSet)) {
                return i;
            }
            i++;
        }
        // Returns 0 if (!volunteerExists())
        return 0;
    }

    private boolean volunteerExists(String skillSet, CommunityGroup group) {

        ListIterator<Volunteer> vIterator = group.getVolunteers().listIterator();

        boolean exists = false;
        while (vIterator.hasNext()) {
            if (vIterator.next().getSkillSet().equalsIgnoreCase(skillSet)) {
                exists = true;
            }
        }
        // Returns true if passed in 'skillSet' is found in passed in group's list of volunteers
        return exists;
    }

    private void addVolunteerToGroup(Volunteer vol, int index) {
        // Adds volunteer to a group in myGroups at passed in index if group is not at max capacity
        if (myGroups.get(index).getVolunteers().size() < myGroups.get(index).getMaxVol()) {
            myGroups.get(index).getVolunteers().add(vol);
            // Call getSkillsTotals() on group to update values
            myGroups.get(index).getSkillsTotals();
            System.out.println("Volunteer " + vol.getSkillSet() + " added to " + myGroups.get(index).getGroupName());
            System.out.println("---------------------------");
        } else {
            System.out.println("Could not add volunteer.");
            System.out.println(myGroups.get(index).getGroupName() + " has already reached maximum of " + myGroups.get(index).getMaxVol() + " volunteers.");
            System.out.println("---------------------------");
        }
    }

    // Returns the index of the first group with zero of one of the chars in passed in skillChars[]
    private int getGroupIndexZeroSkill(char[] skillChars) {

        // for each char in skillChars array
        for (int skillIndex = 0; skillIndex < skillChars.length; skillIndex++) {
            // for each group
            for (int gIndex = 0; gIndex < myGroups.size(); gIndex++) {
                // If a group's total skills for one of the passed in chars' == 0, return that group's index
                if (myGroups.get(gIndex).getTotalSkillsArray()[skillChars[skillIndex] - 'A'] == 0) {
                    return gIndex;
                }
            }
        }
        // Returns -1 if all groups have at least one of every skill
        return -1;
    }

    // For homogeneous case "AAA" or, e.g., 'CC' in "ACC":
    // Returns the index of the group with the least amount of passed in char
    private int getGroupIndexLeastSkill(char skill) {

        int[] arrayOfVals = new int[5];
        int[] sortedVals = new int[5];
        int index = 0;
        int totalsArrayIndex = skill - 'A';

        // Get the total value of passed in char for each CommunityGroup
        for (CommunityGroup cg : myGroups) {
            int val = cg.getTotalSkillsArray()[totalsArrayIndex];
            arrayOfVals[index] = val;
            index++;
        }

        // Add the total values to a new array for sorting
        for (int i = 0; i < 5; i++) {
            sortedVals[i] = arrayOfVals[i];
        }
        // Sort the new array
        Arrays.sort(sortedVals);
        // Get value at 0 index of sorted arrays = least occurring skill
        int min = sortedVals[0];
        // Return the index of the first group found matching the min. value
        for (int i = 0; i < arrayOfVals.length; i++) {
            if (arrayOfVals[i] == min) {
                return i;
            }
        }
        // Will always return an index
        return -1;
    }

    // For heterogeneous case, e.g., "ABC":
    // Returns the index of the group with the least amount of total skills for passed in chars
    private int getGroupIndexCompare(char[] skillChars, int gIndex1, int gIndex2, int gIndex3) {
        // gIndex corresponds to the group with the least amount of a certain skill, e.g. "A", "B", "C"
        // If Group 1 has least amount of passed in "A"s among all groups  - get its total amount of "A"s
        // If Group 2 has least amount of passed in "B"s among all groups  - get its total amount of "B"s
        // If Group 3 has least amount of passed in "C"s among all groups  - get its total amount of "C"s
        int group1TotalSkill = myGroups.get(gIndex1).getTotalSkill(skillChars[0]);
        int group2TotalSkill = myGroups.get(gIndex2).getTotalSkill(skillChars[1]);
        int group3TotalSkill = myGroups.get(gIndex3).getTotalSkill(skillChars[2]);

        // Return index of group with the smallest overall total to add volunteer to that group
        if (group1TotalSkill < group2TotalSkill
                && group1TotalSkill < group3TotalSkill) {
            return gIndex1;

        } else if (group2TotalSkill < group1TotalSkill
                && group2TotalSkill < group3TotalSkill) {
            return gIndex2;
        } else {
            return gIndex3;
        }
    }

    // For "2-to-1" case, e.g., "ABB" and "AAB":
    // Returns the index of the group with the least amount of total skills for passed in chars, taking repeating char into consideration
    private int getGroupIndexCompare(int gIndex1, char skill1, int gIndex2, char skill2, boolean rightWeighted) {

        // Get the index of the groups with the least amount of "A", "B"
        int group1TotalSkill = myGroups.get(gIndex1).getTotalSkill(skill1);
        int group2TotalSkill = myGroups.get(gIndex2).getTotalSkill(skill2);

        // If second skill repeats, e.g., "ABB", "CDD", etc.
        if (rightWeighted) {
            // Return index of second group if its total skill2 <= half of it's total skill1
            if (group2TotalSkill <= (double) (group1TotalSkill * 0.5)) {
                return gIndex2;
                // Return index of second group if has enough skill2 but less than 25% fewer volunteers than the first group
            } else if (myGroups.get(gIndex2).getTotalSkills() < (double) (myGroups.get(gIndex1).getTotalSkills() * 0.75)) {
                return gIndex2;
            } else {
                // Otherwise return index of first group, since second group has a sufficient amount of skill2
                return gIndex1;
            }
            // If first skill repreats, e.g., "AAB", "DDE", etc.
        } else {
            // Same logic as above in reverse: 
            if (group1TotalSkill <= (double) (group2TotalSkill * 0.5)) {
                return gIndex1;
            } else if (myGroups.get(gIndex1).getTotalSkills() < (double) (myGroups.get(gIndex2).getTotalSkills() * 0.75)) {
                return gIndex1;
            } else {
                return gIndex2;
            }
        }
    }
}
