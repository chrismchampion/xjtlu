package coursework2;

import java.util.Scanner;

/**
 *
 * @author christopher
 */
public class Menu {

    // Instance of Database for calling its methods in menu
    Database db = new Database();

    // constructor
    public Menu() {
        run();
    }

    // run menu
    private void run() {

        Scanner menuIn = new Scanner(System.in);
        displayMenu();
        displayInputMsg();

        boolean exit = false;
        while (!exit) {

            String input = menuIn.nextLine();

            // switch user input
            switch (input.toLowerCase()) {

                case "add":
                    db.add();
                    displayInputMsg();
                    break;
                case "update":
                    db.update();
                    displayInputMsg();
                    break;
                case "search":
                    db.search();
                    displayInputMsg();
                    break;
                case "delete":
                    db.delete();
                    displayInputMsg();
                    break;
                case "list":
                    db.list();
                    displayInputMsg();
                    break;
                case "quit":
                    exit = true;
                    break;
                default:
                    System.out.println("Please choose from the available options: Add, Update, Search, Delete, List, Quit");
                    displayInputMsg();
            }
        }
        System.out.println("Goodbye");
    }

    // Prints main menu to the console
    private void displayMenu() {
        String m
                = "---------------------------\n";
        m += "GRADES DATABASE\n";
        m += "Welcome to the students' grade system.\n";
        m += "---------------------------\n";
        m += "Add - to add a new student name together with course/grade info into the system" + "\n";
        m += "Update - to update the grade of an existing course of a student" + "\n";
        m += "Search - to enquire about the grades of a specific student in the system" + "\n";
        m += "Delete - to delete a student's info" + "\n";
        m += "List - to list all grades of a specific course in descending order" + "\n";
        m += "Quit - to exit from the current level of interactions";
        m += "\n---------------------------\n";
        System.out.print(m);
    }
    
    private void displayInputMsg() {
        System.out.print("\nEnter your command here: ");
    }
}
