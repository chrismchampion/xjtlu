package coursework3;

import java.util.Scanner;

/*READ ME: Use this class as your main class, and create your menu here
Your menu should then call the appropriate methods in the SkillSorter class
You need to complete the other classes, including the empty methods.
/*
 */
public class CW3Main {

    private final String MENU_TXT1 = "1. Add volunteer";
    private final String MENU_TXT2 = "2. Move volunteer";
    private final String MENU_TXT3 = "3. Delete volunteer";
    private final String MENU_TXT4 = "4. Delete all volunteers";
    private final String MENU_TXT5 = "5. Display groups";
    private final String MENU_TXT6 = "6. Save and Exit";   

    public static void main(String[] args) {

        CW3Main main = new CW3Main();
    }

    public CW3Main() {

        menu();
    }

    private void menu() {
        //Construct and run your menu here.
        //You MUST call methods in SkillSorter from your menu
        //and complete the methods in SkillSorter 
        //DO NOT write the methods, eg addVolunteer, in THIS class.
        //Call and use the ones in SkillSorter.

        SkillSorter menuOps = new SkillSorter();
        boolean exit = false;

        while (!exit) {

            System.out.println(menuToString());
            int choice = getMenuChoice();

            // switch case
            switch (choice) {

                case 1: // Add volunteer
                    System.out.println(MENU_TXT1 + ":");
                    //menuOps.addVolunteer(vol);
                    //menuOps.addVolunteerToGroup(menuOps.getGroup1());
                    String groupName = getString("Enter group name: ");
                    menuOps.addVolunteerToGroup(menuOps.getGroupByName(groupName));
                    break;
                case 2: // Move volunteer
                    System.out.println(MENU_TXT2 + ":");
                    //menuOps.moveVolunteer(, from, to);
                    break;
                case 3: // Delete volunteer
                    System.out.println(MENU_TXT3 + ":");
                    //menuOps.deleteVolunteer(, from);
                    break;
                case 4: // Delete all volunteers
                    System.out.println(MENU_TXT4 + ":");
                    menuOps.deleteAllVolunteers();
                    break;
                case 5: // Display groups
                    System.out.println(MENU_TXT5 + ":");
                    menuOps.getCommunityGroups();
                    break;
                case 6: // Save and Exit
                    System.out.println(MENU_TXT6 + ":");
                    FileReadWrite.writeGroupFile(menuOps.getGroup1().getVolunteerList(), menuOps.getFileName());
                    FileReadWrite.writeGroupFile(menuOps.getGroup2().getVolunteerList(), menuOps.getFileName());
                    FileReadWrite.writeGroupFile(menuOps.getGroup3().getVolunteerList(), menuOps.getFileName());
                    FileReadWrite.writeGroupFile(menuOps.getGroup4().getVolunteerList(), menuOps.getFileName());
                    FileReadWrite.writeGroupFile(menuOps.getGroup5().getVolunteerList(), menuOps.getFileName());
                    exit = true;
                    break;
                default:
                    System.out.println("\nINVALID OPTION: Please try again.\n");
            }

        }

        System.out.println("Program end");

    }

    private String menuToString() {
        
        String m =
        "---------------------------\n";
        m += "MAIN MENU\n";
        m += "---------------------------\n";       
        m += MENU_TXT1 + "\n";
        m += MENU_TXT2 + "\n";
        m += MENU_TXT3 + "\n";
        m += MENU_TXT4 + "\n";
        m += MENU_TXT5 + "\n";
        m += MENU_TXT6;
        m += "\n---------------------------";
        
        return m;
    }

    private int getMenuChoice() {
        // A menu item choice menu.  Will receive an input, if it is a 
        // numeric value, converts it to a number and returns it
        // Should have validation!
        Scanner s = new Scanner(System.in);

        System.out.print("\nPlease choose an option: ");
        String in = s.nextLine();
        // Converts to integer
        int choice = 0;
        try {
            choice = Integer.parseInt(in);
        } catch (NumberFormatException e) {
            System.out.println("\nYou did not enter a number.\n");
        }

        return choice;
    }

    private String getString(String question) {
        // A very important basic method
        // Receives a question, gets next line
        // Returns it
        // Useful for adding or removing
        Scanner s = new Scanner(System.in);

        System.out.print(question);
        String in = s.nextLine();
        // Returns a string
        return in;
    }
}
