package coursework3;

import java.util.Scanner;

/*
READ ME: Use this class as your main class, and create your menu here
Your menu should then call the appropriate methods in the SkillSorter class
You need to complete the other classes, including the empty methods.
/**
 *
 * @author Christopher Champion, 1719247
 */
/*
 */
public class CW3Main {

    // Constants
    private final String MENU_TXT1 = "1. Add volunteer";
    private final String MENU_TXT2 = "2. Move volunteer";
    private final String MENU_TXT3 = "3. Delete volunteer";
    private final String MENU_TXT4 = "4. Delete all volunteers";
    private final String MENU_TXT5 = "5. Display groups";
    private final String MENU_TXT6 = "6. Generate random volunteers";
    private final String MENU_TXT7 = "7. Save and exit";

    public static void main(String[] args) {

        CW3Main main = new CW3Main();
    }

    //Construct and run your menu here.
    public CW3Main() {
        menu();
    }

    private void menu() {

        displayMenu();
        // SkillSorter constructor <- Read in file
        SkillSorter skillSorter = new SkillSorter();
        String skills;

        boolean exit = false;
        while (!exit) {

            int choice = -1;
            while (choice == -1) {
                // Error handling for menu choice integer input
                try {
                    choice = Integer.parseInt(getString("Please choose an option (Enter 0 for menu): "));
                } catch (NumberFormatException e) {
                    System.out.println("You did not enter a number.");
                }
            }

            // switch user input
            switch (choice) {

                case 0:
                    displayMenu();
                    break;
                case 1: // Add volunteer         
                    skills = getFormattedSkillStr("Enter skill set of new volunteer: ");
                    if (skillSorter.isValidSkillSet(skills)) {
                        skillSorter.addVolunteer(new Volunteer(skills));
                    } else {
                        System.out.println("Could not create volunteer because " + skills + " is not a valid skill set.");
                    }
                    break;
                case 2: // Move volunteer
                    skills = getFormattedSkillStr("Enter skill set of the volunteer you wish to move: ");
                    System.out.print("Move volunteer from - ");
                    CommunityGroup groupFrom = skillSorter.getCommunityGroups().get(getGroupNumber());
                    System.out.print("Move volunteer to - ");
                    CommunityGroup groupTo = skillSorter.getCommunityGroups().get(getGroupNumber());
                    skillSorter.moveVolunteer(skills, groupFrom, groupTo);
                    break;
                case 3: // Delete volunteer
                    skills = getFormattedSkillStr("Enter skill set of the volunteer you wish to delete: ");
                    System.out.print("Delete volunteer from - ");
                    CommunityGroup group = skillSorter.getCommunityGroups().get(getGroupNumber());
                    skillSorter.deleteVolunteer(skills, group);
                    break;
                case 4: // Delete all volunteers 
                    skillSorter.deleteAllVolunteers();
                    break;
                case 5: // Display groups
                    skillSorter.displayGroups();
                    break;
                case 6: // Populate list with random volunteers
                    String numVol = getString("Enter number of volunteers to add: ");
                    skillSorter.randomVolunteers(Integer.parseInt(numVol));
                    break;
                case 7: // Save and exit -> write to file
                    FileReadWrite.writeFile(skillSorter.getCommunityGroups());
                    exit = true;
                    break;
                default:
                    System.out.println("Please choose from the available options.");
            }

        }
        System.out.println("Program end");
    }

    private void displayMenu() {
        // Prints menu to the console
        String m
                = "---------------------------\n";
        m += "MAIN MENU\n";
        m += "---------------------------\n";
        m += MENU_TXT1 + "\n";
        m += MENU_TXT2 + "\n";
        m += MENU_TXT3 + "\n";
        m += MENU_TXT4 + "\n";
        m += MENU_TXT5 + "\n";
        m += MENU_TXT6 + "\n";
        m += MENU_TXT7;
        m += "\n---------------------------\n";

        System.out.print(m);
    }

    private String getString(String question) {
        // Prints 'question' to the console and returns user input as string
        Scanner scanner = new Scanner(System.in);
        System.out.print(question);

        String userInput = scanner.nextLine();
        return userInput;
    }

    private int getGroupNumber() {
        // Method for entering group number when moving or deleting a volunteer
        int groupInt = 0;
        boolean validGroup = false;

        while (!validGroup) {
            String groupString = getString("Enter group no. (1-5): ");
            // Error handling for non-integer
            try {
                groupInt = Integer.parseInt(groupString);

                if (groupInt > 0 && groupInt < 6) {
                    validGroup = true;
                } else {
                    // Loops if user did not enter a valid group number 1-5
                    System.out.println("You did not enter a valid group number (1-5).");
                }
            } catch (NumberFormatException e) {
                System.out.println("You did not enter a number.");
            }
        }
        // Return selected group's index for retrieving from myGroups list
        return groupInt - 1;
    }

    private String getFormattedSkillStr(String question) {
        // Returns a formatted version of skill set entered by user
        String formatStr;
        String s = getString(question);

        // Remove white spaces and convert to upper case
        formatStr = s.replaceAll("\\s+", "").toUpperCase();

        // Convert formatStr to character array
        char[] chars = formatStr.toCharArray();

        // Bubble Sort char array
        char temp;
        for (int i = 0; i < chars.length; i++) {
            for (int j = 1; j < chars.length - i; j++) {

                if (chars[j - 1] > chars[j]) {
                    temp = chars[j - 1];
                    chars[j - 1] = chars[j];
                    chars[j] = temp;
                }
            }
        }
        // return char[] as string
        return String.valueOf(chars);
    }

}
