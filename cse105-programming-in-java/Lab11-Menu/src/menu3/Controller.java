/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author ANDREW.ABEL
 */
public class Controller {

    private final int OPT1 = 1;
    private final int OPT2 = 2;
    private final int OPT3 = 3;
    private final int OPT4 = 4;
    private final int OPT5 = 5;
    private final int OPT6 = 6;
    private final String MENU_TXT1 = "View All People";
    private final String MENU_TXT2 = "View One Person";
    private final String MENU_TXT3 = "Add Person";
    private final String MENU_TXT4 = "Remove Person";
    private final String MENU_TXT5 = "Clear All Data";
    private final String MENU_TXT6 = "Save and Exit";

    private final String FILE_NAME = "PeopleList.txt";

    // Creates a list of people
    ArrayList<Person> people = new ArrayList<>();

    public static void main(String[] args) {

        Controller lab = new Controller();
    }

    public Controller() {

        people = FileReadWrite.readPersonFile(FILE_NAME);

        // Calls the menu
        menu();
    }

    private void menu() {
        // Will loop in this method until the user chooses to exit
        // Create main interface here
        String starBorder = "*****************";
        String hyphenBorder = "---------------------------";
        System.out.println(starBorder);
        System.out.println("Class List System");
        System.out.println(starBorder);
        boolean exit = false;

        while (!exit) {

            System.out.println("\n" + menuToString());
            int choice = getMenuChoice();

            // switch case
            switch (choice) {

                case 1:
                    System.out.println(hyphenBorder);
                    System.out.println(MENU_TXT1 + ":");
                    displayAllPeople();
                    System.out.println(hyphenBorder);
                    break;
                case 2:
                    System.out.println(hyphenBorder);
                    System.out.println(MENU_TXT2 + ":");
                    displayOnePerson();
                    System.out.println(hyphenBorder);
                    break;
                case 3:
                    System.out.println(hyphenBorder);
                    System.out.println(MENU_TXT3 + ":");
                    addOnePerson();
                    System.out.println(hyphenBorder);
                    break;
                case 4:
                    System.out.println(hyphenBorder);
                    System.out.println(MENU_TXT4 + ":");
                    removeOnePerson();
                    System.out.println(hyphenBorder);
                    break;
                case 5:
                    System.out.println(hyphenBorder);
                    System.out.println(MENU_TXT5 + ":");
                    removeAll();
                    System.out.println(hyphenBorder);
                    break;
                case 6:
                    System.out.println(hyphenBorder);
                    System.out.println(MENU_TXT6);
                    saveToFile();
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option: Please try again.");
            }

        }

        System.out.println("Program end");
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

    private void displayAllPeople() {
        // A method that will simply display all people 
        // Any form of loop is acceptable
        if (people.isEmpty()) {
            System.out.println("The list is empty.");
            System.out.println("Try adding a person.");
        } else {
            people.forEach((p) -> {
                System.out.println(p.flatten());
            });
        }
    }

    private void removeOnePerson() {
        // This method will remove one object from an arraylist
        // Important to use an iterator so that there are no errors
        // Try using Iterator with Optional (Week 12 lec notes)
        String nameInput = getString("Enter person's name: ");
        Iterator<Person> pIterator = people.iterator();

        while (pIterator.hasNext()) {
            String name = pIterator.next().getName();
            if (name.equalsIgnoreCase(nameInput)) {
                pIterator.remove();
                System.out.println(name + " removed from the list.");
            }
        }
    }

    private void addOnePerson() {
        // This method will add a person to the iterator
        // It will use the getString method to get information
        // Will also have to parse as extra validation
        String nameInput = getString("Enter person's name: ");
        int ageInput = Integer.parseInt(getString("Enter " + nameInput + "'s age: "));
        String addressInput = getString("Enter " + nameInput + "'s address: ");
        boolean maritalStatusInput = Boolean.parseBoolean(getString("Enter " + nameInput + "'s marital status (true/false): "));

        Person p = new Person(nameInput, ageInput, addressInput, maritalStatusInput);
        people.add(p);
    }

    private void removeAll() {
        // This method will remove all objects from an arraylist
        // Important to use an iterator so that there are no errors
        if (!people.isEmpty()) {
            Iterator<Person> pIterator = people.iterator();

            while (pIterator.hasNext()) {
                pIterator.next();
                pIterator.remove();
            }
            System.out.println("Person list deleted");
        } else {
            System.out.println("The list is already empty.");
        }

    }

    private void displayOnePerson() {
        // This method will display one object from an arraylist
        // input a string, and search for it   
        String nameInput = getString("Enter person's name: ");
        boolean exists = false;

        Iterator<Person> pIterator = people.iterator();
        while (pIterator.hasNext()) {
            Person p = pIterator.next();
            if (p.getName().equalsIgnoreCase(nameInput)) {
                exists = true;
                System.out.println(p.toString());
            }
        }
        if (!exists) {
            System.out.println("Person named " + nameInput + " not found.");
        }
    }

    private void saveToFile() {

        FileReadWrite.writePersonFile(people, FILE_NAME);
        System.out.println("Changes saved to: " + FILE_NAME);
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

    private String menuToString() {

        String m = OPT1 + "=" + MENU_TXT1 + "\n";
        m += OPT2 + "=" + MENU_TXT2 + "\n";
        m += OPT3 + "=" + MENU_TXT3 + "\n";
        m += OPT4 + "=" + MENU_TXT4 + "\n";
        m += OPT5 + "=" + MENU_TXT5 + "\n";
        m += OPT6 + "=" + MENU_TXT6;

        return m;
    }

}
