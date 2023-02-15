/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author christopher
 */
public class Grades {

    // Doesn't it make sense to make an arraylist of the five classes and add students to them, instead of creating a new course each time?!
    static Map<String, ArrayList<Course>> testMap = new HashMap<>();

    public static void main(String[] args) {

        //Map<String, ArrayList<Course>> testMap = new HashMap<>();
        // Create a student
        Student bob = new Student("Bob");
        // Create two courses
        Course math = new Course(bob, "Mathematics", 75.7);
        Course history = new Course(bob, "History", 98.2);
        Course art = new Course(bob, "Art", 99.9);
        Course science = new Course(bob, "Science", 41.1);
        // Add courses to student's course list
        bob.getCourseList().add(math);
        bob.getCourseList().add(history);
        bob.getCourseList().add(art);
        bob.getCourseList().add(science);
        // Add student and list of course object's to hashmap
        testMap.put(bob.getName(), bob.getCourseList());
        //System.out.println(bob.getName());
        //System.out.println(math.getName() + " / " + math.getGrade());
        /*Student bob2 = new Student("Bob");
        Course poop = new Course(bob2, "Poop Class", 10.5);
        bob2.getCourseList().add(poop);
        testMap.put(bob2.getName(), bob2.getCourseList());*/

        // Create a second student
        Student alice = new Student("Alice");
        // Create her courses
        Course algebra = new Course(alice, "Mathematics", 80.5);
        // Add her courses to her course list
        alice.getCourseList().add(algebra);
        // Add student with list of course objects to hashmap
        testMap.put(alice.getName(), alice.getCourseList());

        // Print hashmap size
        System.out.println("The size of the test map is: " + testMap.size());

        for (Map.Entry<String, ArrayList<Course>> entry : testMap.entrySet()) {

            String studentName = entry.getKey();
            List<Course> courseList = entry.getValue();
            int numClasses = courseList.size();
            double gpa = 0.00;
            System.out.println("\nKey = " + studentName);
            System.out.println("Value = " + courseList + "\n");
            System.out.println(studentName + " has " + numClasses + " classes:");

            for (Course c : courseList) {
                System.out.println(c.getTitle() + " : " + c.getGrade());
                gpa += c.getGrade();
            }
            System.out.println(studentName + "'s average is: " + gpa / numClasses);
        }

        //listClasses("Mathematics");
        /* HashMap overwrites value if the same key is used --> used Student.getName() for key */
        //searchStudents("bob");
        //searchByName("bob");
        
        searchDatabase("Bob");
        
        
        
    }
    
    private static void printCourseList(ArrayList<Course> courseList) {
        for (Course c : courseList) {
            System.out.println(c.getTitle() + "/" + c.getGrade());
        }
    }

    private static void searchDatabase(String pKey) {
        if (testMap.containsKey(pKey)) {
            System.out.println("Found key " + pKey);
            ArrayList<Course> courses = testMap.get(pKey);
            
            printCourseList(courses);
        } else {
            System.out.println(pKey + " was not found in the database.");
        }
    }

    private static void searchCourseList(ArrayList<Course> courses) {
        
        
        
    }
    
    private static void listClasses(String pTitle) {

        ArrayList<Course> matchList = new ArrayList<>();
        System.out.println("\nStudent/Class/Grade: " + pTitle + "\n");

        for (Map.Entry<String, ArrayList<Course>> entry : testMap.entrySet()) {

            String keyStudentName = entry.getKey();
            ArrayList<Course> valueCourseList = entry.getValue();

            // Look for matching course in HashMap entry set
            for (Course c : valueCourseList) {
                // if match is found add to match arraylist
                if (c.getTitle().equalsIgnoreCase(pTitle)) {
                    /*System.out.println("\n" + keyStudentName);
                    System.out.print(c.getTitle());
                    System.out.print("/" + c.getGrade());*/
                    matchList.add(c);
                }
            }

            if (!matchList.isEmpty()) {
                System.out.println(matchList.size() + " students are enrolled in " + pTitle);
                // print out list of matches
                for (Course c : matchList) {
                    System.out.println(keyStudentName);
                    System.out.print(c.getTitle() + "/" + c.getGrade());
                }
            }
        }
        // if matchList isn't empty
        if (matchList.isEmpty()) {
            // Course not found in HashMap's entry set
            System.out.println(pTitle + " not found in the database");
        }
    }
}
