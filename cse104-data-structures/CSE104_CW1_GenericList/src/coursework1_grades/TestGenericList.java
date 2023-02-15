/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework1_grades;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author christopher
 */
public class TestGenericList {

    // private member variables
    private final GenericList<String> strings = new GenericList<>();
    private final GenericList<Integer> integers = new GenericList<>();
    private final GenericList<Boolean> booleans = new GenericList<>();

    // constructor
    public TestGenericList() {
        menu();
    }

    public static void main(String[] args) {
        TestGenericList tester = new TestGenericList();
    }

    // Launch menu called by constructor
    private void menu() {

        Scanner input = new Scanner(System.in);
        displayMenu();

        boolean exit = false;
        while (!exit) {
            int choice = -1;
            while (choice == -1) {
                // Error handling for menu choice integer input
                try {
                    choice = Integer.parseInt(input.next());
                } catch (NumberFormatException e) {
                    System.out.println("You did not enter a number.");
                }
            }

            // switch user input
            switch (choice) {
                // Add values to member GenericLists
                case 1:
                    System.out.println("Enter '!' when finished");
                    boolean stop = false;
                    while (!stop) {
                        String in = input.next();
                        if (in.equals("!")) {
                            stop = true;
                            displayMenu();
                        }
                        // Add true, false to GenericList<Boolean>
                        if (in.equals("true") || in.equals("false")) {
                            Boolean b = Boolean.parseBoolean(in);
                            booleans.add(b);
                        }
                        // If parsing string input to Integer successful,
                        // add to GenericList<Integer>
                        try {
                            Integer i = Integer.parseInt(in);
                            integers.add(i);
                            // Add all other input to GenericList<String>
                        } catch (NumberFormatException e) {
                            if (!in.equals("!") && !in.equals("true") && !in.equals("false")) {
                                strings.add(in);
                            }
                        }
                    }
                    break;
                // Print member GenericLists to console
                case 2:
                    printAllLists();
                    break;
                // Print max/min for member GenericLists to console
                case 3:
                    try {
                        System.out.print("Enter integer value for max: ");
                        Integer max = Integer.parseInt(input.next());
                        System.out.print("Enter integer value for min: ");
                        Integer min = Integer.parseInt(input.next());
                        List stringsMaxMin = strings.findMaxMin(max, min);
                        List integersMaxMin = integers.findMaxMin(max, min);
                        List booleansMaxMin = booleans.findMaxMin(max, min);
                        System.out.println();
                        printStringList();
                        System.out.print("\tMax/Min: [" + stringsMaxMin.get(0) + ", " + stringsMaxMin.get(1) + "]\n");
                        printIntegerList();
                        System.out.print("\tMax/Min: [" + integersMaxMin.get(0) + ", " + integersMaxMin.get(1) + "]\n");
                        printBooleanList();
                        System.out.print("\tMax/Min: [" + booleansMaxMin.get(0) + ", " + booleansMaxMin.get(1) + "]\n");
                    } catch (NumberFormatException e) {
                        System.out.println("You did not enter a number.");
                        displayMenu();
                    }
                    break;
                // Print member GenericLists to console in reverse
                case 4:
                    printAllListsReversed();
                    break;
                // Check if one of the member GenericLists contains user input list
                case 5:
                    System.out.println("Enter values to check (enter '!' when finished): ");
                    List valList = new ArrayList<>();
                    boolean finished = false;
                    while (!finished) {
                        String in = input.next();
                        switch (in) {
                            case "!":
                                finished = true;
                                break;
                            case "true":
                            case "false":
                                valList.add(Boolean.parseBoolean(in));
                                break;
                            default:
                                // if for bools true/false parse and add
                                try {
                                    valList.add(Integer.parseInt(in));
                                } catch (NumberFormatException e) {
                                    valList.add(in);
                                }
                                break;
                        }
                    }
                    printAllListsContain(valList);
                    break;
                // Print main menu to console
                case 6:
                    displayMenu();
                    break;
                // Exit switch case
                case 7:
                    exit = true;
                    break;
                // Print demo data to conosle
                case 8:
                    runDemo();
                    exit = true;
                    break;
                default:
                    System.out.println("Please choose from the available options.");

            }

        }
        System.out.println("Goodbye");
    }

    // Prints main menu to the console
    private void displayMenu() {
        String m
                = "---------------------------\n";
        m += "MAIN MENU\n";
        m += "---------------------------\n";
        m += "1. Add values to list (Boolean, Integer, String)" + "\n";
        m += "2. Display lists" + "\n";
        m += "3. Find max/min" + "\n";
        m += "4. Reverse list" + "\n";
        m += "5. Check if list contains values" + "\n";
        m += "6. Main menu" + "\n";
        m += "7. Exit" + "\n";
        m += "8. Run with demo data";
        m += "\n---------------------------\n";
        System.out.print(m);
    }

    // Instantiates lists with demo data and prints to console
    private void runDemo() {
        integers.addAll(Arrays.asList(1, 5, 1, 3));
        strings.addAll(Arrays.asList("accordion", "banjo", "accordion", "clarinet"));
        booleans.addAll(Arrays.asList(true, false, true, false));
        printAllLists();
        System.out.println("---------------------------");
        System.out.println("/* FIND MAX/MIN */");
        System.out.println("Strings [MAX=2, MIN=6]:\t\t" + strings.findMaxMin(2, 6));   // returns [banjo, null]
        System.out.println("Integers [MAX=1, MIN=2]:\t" + integers.findMaxMin(1, 2));   // returns [5, 1]
        System.out.println("---------------------------");
        System.out.println("/* REVERSE LIST */");
        System.out.println("Strings (1. rvrs, 2. no dupl):\t" + strings.reverse());  // returns ["clarinet", "accordion", "banjo"]
        System.out.println("---------------------------");
        System.out.println("/* LIST CONTAINS */");
        List c = new GenericList();
        List d = new GenericList();
        c.addAll(Arrays.asList("accordion", "bongo", "clarinet"));
        d.addAll(Arrays.asList("banjo", "banjo", "accordion", "clarinet"));
        boolean listContains;
        strings.printList();
        System.out.print("   contains ");
        listContains = strings.containList(c);     // returns false
        System.out.print(" is " + listContains);
        System.out.print("\n   contains ");
        listContains = strings.containList(d);     // returns true
        System.out.print(" is " + listContains + "\n");
        System.out.println("---------------------------");
    }

    // Prints private member GenericLists to console
    private void printAllLists() {
        System.out.print("GenericList<String>\t\t");
        strings.printList();
        System.out.print("GenericList<Integer>\t\t");
        integers.printList();
        System.out.print("GenericList<Boolean>\t\t");
        booleans.printList();
    }

    // Prints reverse of member GenericLists in reverse to console
    // Original lists are not modified
    private void printAllListsReversed() {
        System.out.println("Strings (1. rvrs, 2. no dupl):\t" + strings.reverse());
        System.out.println("Integers (1. rvrs, 2. no dupl):\t" + integers.reverse());
        System.out.println("Booleans (1. rvrs, 2. no dupl):\t" + booleans.reverse());
    }

    // Prints List contains = true/false based on passed-in List parameter
    private void printAllListsContain(List pValList) {
        boolean listContains;
        printStringList();
        System.out.print("   contains ");
        listContains = strings.containList(pValList);
        System.out.print(" is " + listContains + "\n");
        printIntegerList();
        System.out.print("   contains ");
        listContains = integers.containList(pValList);
        System.out.print(" is " + listContains + "\n");
        printBooleanList();
        System.out.print("   contains ");
        listContains = booleans.containList(pValList);
        System.out.print(" is " + listContains + "\n");

    }

    // Prints GenericList<String> to console
    private void printStringList() {
        System.out.print("GenericList<String>\t\t");
        strings.printList();
    }

    // Prints GenericList<Integer> to console
    private void printIntegerList() {
        System.out.print("GenericList<Integer>\t\t");
        integers.printList();
    }

    // Prints GenericList<Boolean> to console
    private void printBooleanList() {
        System.out.print("GenericList<Boolean>\t\t");
        booleans.printList();
    }

}
