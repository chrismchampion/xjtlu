package coursework2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author christopher
 */
public class Database {

    // private member variables
    private ArrayList<Student> studentList = new ArrayList<>();
    private HashMap<String, ArrayList<Course>> studentMap = new HashMap<>();

    // constructor
    public Database() {

    }

    // NameGrade inner class for storing Student name and Course grade
    class NameGrade {

        private String name;
        private Double grade;

        // NameGrade constructor
        // passed in values retrieved from Student objects in studentList
        public NameGrade(String name, Double grade) {
            this.name = name;
            this.grade = grade;
        }

        // getter methods
        public String getName() {
            return name;
        }

        public Double getGrade() {
            return grade;
        }

    }

    // package accessible add method called from Menu
    protected void add() {

        String name = getString("Enter student's name: ");
        // If Student name key exists in the HashMap
        if (studentMap.containsKey(name)) {
            // Add Course value to existing student name key
            addToExistingStudent(name);
        } else {
            // Create Couse value to new student name key
            addNewStudent(name);
        }
    }

    // package accessible search method called from Menu
    protected void search() {

        String name = getString("Enter student's name: ");
        // If Student name key exists in the HashMap
        if (studentMap.containsKey(name)) {
            // Retrieve Student object by name key and list Courses
            searchCourseList(name);
        } else {
            System.out.println(name + " does not exist in the database.");
        }
    }

    // package accessible update method called from Menu
    protected void update() {

        String name = getString("Enter student's name: ");
        // If Student name key exists in the HashMap
        if (studentMap.containsKey(name)) {
            // Retrieve Student object by name key and set Course grade to new value
            updateCourseGrade(name);
        } else {
            System.out.println(name + " does not exist in the database.");
        }
    }

    // package accessible delete method called from Menu
    protected void delete() {

        String name = getString("Enter student's name: ");
        // If Student name key exists in the HashMap
        if (studentMap.containsKey(name)) {
            // Retrieve Student object by name key and remove from HashMap and studentList
            deleteStudent(name);
        } else {
            System.out.println(name + " does not exist in the database.");
        }
    }

    // package accessible list method called from Menu
    protected void list() {

        // Get course title via console input 
        String courseTitle = getCourseTitle();
        // New array list to store Student objects enrolled in specified course
        ArrayList<Student> courseEnrollmentList = new ArrayList<>();

        // Iterate over Student list
        for (Student s : studentList) {
            // Check enrollment status of each Student based on course title console input
            if (isEnrolled(s.getName(), courseTitle)) {
                // Add all Students enrolled in specified course to the enrollment list
                courseEnrollmentList.add(s);
            }
        }

        // If Student objects enrolled in specified course exist
        if (courseEnrollmentList.size() > 0) {

            // New array list to store Student name and corresponding Course grade for specified Course title
            ArrayList<NameGrade> nameGradeList = new ArrayList<>();
            // For each Student object enrolled in specified course
            for (Student sEnroll : courseEnrollmentList) {
                // Get name from Student object and grade from corresponding Course object
                String name = sEnroll.getName();
                Course cs = getCourse(sEnroll, courseTitle);
                Double grade = cs.getGrade();
                // Store values in instance of NameGrade
                NameGrade nameGrade = new NameGrade(name, grade);
                // Add to list of NameGrade objects
                nameGradeList.add(nameGrade);
            }
            System.out.println("Students enrolled in " + courseTitle);

            // Sort list based on NameGrade Comparator
            Collections.sort(nameGradeList, new Comparator<NameGrade>() {
                @Override
                public int compare(NameGrade ng1, NameGrade ng2) {

                    Double grade1 = ng1.getGrade();
                    Double grade2 = ng2.getGrade();
                    // First compare grade values in descending order
                    int gradeCmp = grade2.compareTo(grade1);
                    // Returns -1 if grade2 < grade1
                    // Returns 1 if grade2 > grade1
                    // Returns 0 if grade2 == grade1
                    if (gradeCmp != 0) {
                        return gradeCmp;
                    }
                    // Then compare names in ascending order
                    String name1 = ng1.getName();
                    String name2 = ng2.getName();
                    // Return list sorted by Grade (desc) then Name (asc)
                    return name1.compareTo(name2);
                }
            });
            // Print sorted NameGrade list
            for (NameGrade ng : nameGradeList) {
                System.out.println(ng.getName() + ";" + ng.getGrade());
            }
            // Print average grade
            printAverage(nameGradeList);
        } else {
            System.out.println("No students enrolled in " + courseTitle);
        }

    }

    // private member methods
    // Delete student by Student name
    private void deleteStudent(String pName) {

        // Retrieve Student object from list by name
        Student s = getStudent(pName);
        // If Student object was found in student list
        if (s != null) {
            // Get course title from console String input
            String courseTitle = getCourseTitle();
            // User instructed to leave course blank to delete Student
            if (courseTitle.isEmpty()) {
                // Remove mapping from the HashMap
                studentMap.remove(s.getName());
                // Delete Student from student list
                studentList.remove(s);
                System.out.println("Student deleted: " + s.getName());
                printCourseList(s.getCourseList());
                // Delete specified Course based on course title input
            } else {
                // Retrieve specified course from Student's course list based on title provided
                Course cs = getCourse(s, courseTitle);
                // Inform user of Course object removal via console output
                if (s.getCourseList().remove(cs)) {
                    System.out.println("Course deleted: " + s.getName() + "; " + cs.toString());
                }
            }
        } else {
            System.out.println("Error retrieving " + pName + " from the database's student list!");
        }

    }

    // Update Course grade value by Student name
    private void updateCourseGrade(String pName) {

        // Retrieve Student object from list by name
        Student s = getStudent(pName);
        // If Student object was found in student list
        if (s != null) {
            // Get course title from console String input
            String courseTitle = getCourseTitle();
            // Check if student is enrolled in specified Course
            if (isEnrolled(s.getName(), courseTitle)) {
                Double courseGrade = getGrade();
                Course cs = getCourse(s, courseTitle);

                if (cs != null) {
                    // Update grade for found Course object
                    // Value in studentMap is automatically updated
                    cs.setGrade(courseGrade);
                }
            } else {
                System.out.println(pName + " is not enrolled in " + courseTitle);
            }
        } else {
            System.out.println("Error retrieving " + pName + " from the database's student list!");
        }
    }

    // Search Student object's course list by entering student name
    private void searchCourseList(String pName) {

        // Retrieve Student object from list by name
        Student s = getStudent(pName);
        // New array list to store Student objects enrolled in specified course
        ArrayList<Course> enrollmentList = new ArrayList<>();
        // Counter value incremented every time a course is found through console input
        int enrollCount = 0;
        // If Student object was found in student list
        if (s != null) {
            // Get course title from console String input
            String courseTitle = getCourseTitle();
            // Loop until user enters blank
            while (!courseTitle.isEmpty()) {
                // Check if student is enrolled in specified course
                if (isEnrolled(s.getName(), courseTitle)) {
                    // Add Course to enrollment list
                    enrollmentList.add(getCourse(s, courseTitle));
                    // increase enrollment counter
                    enrollCount++;
                    // Inform user of enrollment status and ask for next input
                    System.out.println(s.getName() + " is enrolled in " + courseTitle);
                    courseTitle = getCourseTitle();
                } else {
                    // Inform user of enrollment status and ask for next input
                    System.out.println(pName + " is not enrolled in " + courseTitle);
                    courseTitle = getCourseTitle();
                }
            }
            // Print Student's entire course list and average (if user entered blank)
            if (enrollCount == 0) {
                printCourseList(s.getCourseList());
                printAverage(s.getCourseList());
            } else {
                // Print list of requested courses
                printCourseList(enrollmentList);
            }
        } else {
            System.out.println("Error retrieving " + pName + " from the database's student list!");
        }
    }

    // Create a new Student object, add to student list and create mapping
    private void addNewStudent(String pName) {

        Student s = new Student(pName);
        Course cs;
        String courseTitle = getCourseTitle();

        // Loop until user enters blank and MAX_COURSE limit not reached
        while (!courseTitle.isEmpty() && s.getCourseList().size() < s.getMaxCourse()) {
            Double courseGrade = getGrade();
            cs = new Course(courseTitle, courseGrade);
            // Add new course to student's course list
            s.getCourseList().add(cs);
            courseTitle = getCourseTitle();
        }
        // Inform user when MAX_COURSE limit is reached
        if (s.getCourseList().size() == s.getMaxCourse()) {
            System.out.println(pName + " is already enrolled in the maximum of " + s.getMaxCourse() + " courses.");
        }

        // If user entered valid course/grade pairs into the console
        if (!s.getCourseList().isEmpty()) {
            // Add new student to student list
            studentList.add(s);
            System.out.print("New student entered: " + s.getName() + ";");
            // Create student name/course list mapping
            studentMap.put(s.getName(), s.getCourseList());
            // Print course list
            printCourseList(s.getCourseList());
        } else {
            System.out.println("Could not add " + pName + ". Required data: Course name, Grade");
        }
    }

    // Create new Course object(s) and add to student's course list
    private void addToExistingStudent(String pName) {

        // Retrieve Student object from list by name
        Student s = getStudent(pName);
        // Counter value incremented every time a valid course/grade pair is entered into the console
        int courses = 0;
        // If Student object was found in student list
        if (s != null) {

            Course cs;

            System.out.println(pName + " is already in the system.");
            String courseTitle = getCourseTitle();

            // Inform user when MAX_COURSE limit is reached
            if (s.getCourseList().size() == s.getMaxCourse()) {
                System.out.println(pName + " is already enrolled in the maximum of " + s.getMaxCourse() + " courses.");
            }

            // Loop until user enters blank and MAX_COURSE limit not reached
            while (!courseTitle.isEmpty() && s.getCourseList().size() < s.getMaxCourse()) {
                // Check if the student is already enrolled in course with that name
                if (isEnrolled(s.getName(), courseTitle)) {
                    System.out.println(pName + " already enrolled in " + courseTitle);
                    courseTitle = getCourseTitle();
                } else {
                    // Create new Course object and add to student's course list
                    Double courseGrade = getGrade();
                    cs = new Course(courseTitle, courseGrade);
                    s.getCourseList().add(cs);
                    // Increment course counter
                    courses++;
                    courseTitle = getCourseTitle();
                }
            }
            // If user entered 1+ valid course/grade pairs
            if (courses > 0) {
                System.out.print("New course entered: " + s.getName() + ";");
                // Update the student map with studet name/updated course list mapping
                studentMap.put(s.getName(), s.getCourseList());
                // Print course list
                printCourseList(s.getCourseList());
            }
        } else {
            System.out.println("Could not find " + pName + " in database's student list!");
        }
    }

    // Returns true if Course (title) is mapped to Student (name)
    private boolean isEnrolled(String pStudentName, String pCourseTitle) {
        // Get list of Courses (V) mapped to provided student name (K)
        ArrayList<Course> courses = studentMap.get(pStudentName);
        // Iterate over student's associated courses and search for matching course title
        for (Course c : courses) {
            if (c.getTitle().equalsIgnoreCase(pCourseTitle)) {
                return true;
            }
        }
        return false;
    }

    // private member methods for printing to the console
    // Calculate and print average grade
    private <E> void printAverage(ArrayList<E> pGenList) {
        double gpa = 0.00;
        for (E e : pGenList) {
            String className = e.getClass().getSimpleName().toLowerCase();
            if (className.contains("course")) {
                Course cs = (Course) e;
                gpa += cs.getGrade();
            } else if (className.contains("grade")) {
                NameGrade ng = (NameGrade) e;
                gpa += ng.getGrade();
            }
        }
        gpa = gpa / pGenList.size();
        String avg = String.format("%.2f", gpa);
        System.out.println("Average:\t" + avg);
    }

    // Prints list of Course objects to the console
    private void printCourseList(ArrayList<Course> pCourseList) {
        for (Course c : pCourseList) {
            System.out.print(" " + c.toString());
        }
    }

    // private getter methods
    
    // Get Student object from student list by name
    private Student getStudent(String pName) {
        for (Student s : studentList) {
            if (s.getName().equalsIgnoreCase(pName)) {
                return s;
            }
        }
        return null;
    }

    // Get Course object from Student's course list by name
    private Course getCourse(Student pStudent, String pCourseTitle) {

        ArrayList<Course> courses = pStudent.getCourseList();
        for (Course c : courses) {
            if (c.getTitle().equalsIgnoreCase(pCourseTitle)) {
                return c;
            }
        }
        return null;
    }

    // Console input validation for course title
    private String getCourseTitle() {

        String title;

        title = getString("Course name (enter blank to exit): ");

        if (title.equalsIgnoreCase("database") || title.equalsIgnoreCase("data base")) {
            return "Database";
        } else if (title.equalsIgnoreCase("data structure")) {
            return "Data Structure";
        } else if (title.equalsIgnoreCase("operating system") || title.equalsIgnoreCase("operatingsystem")
                || title.equalsIgnoreCase("o/s") || title.equalsIgnoreCase("os")) {
            return "Operating System";
        } else if (title.equalsIgnoreCase("mathematics") || title.equalsIgnoreCase("math")) {
            return "Mathematics";
        } else if (title.equalsIgnoreCase("systemdesign") || title.equalsIgnoreCase("System Design")) {
            return "System Design";
        } else if (!title.isEmpty()) {
            System.out.println("Please enter one of the following courses: Database, Data Structure, Operating System, Mathematics, System Design");
            title = getCourseTitle();
        }
        return title;
    }

    // Console input validation for grade
    private Double getGrade() {

        Double grade;
        grade = 0.0;
        boolean validGrade = false;

        while (!validGrade) {
            try {
                grade = Double.parseDouble(getString("Grade: "));
                if (grade < 0 || grade > 100) {
                    System.out.println("Please enter a grade from 0 to 100.");
                    grade = getGrade();
                }
                validGrade = true;
            } catch (NumberFormatException e) {
                System.out.println("You did not enter a valid grade.");
            }
        }
        return grade;
    }

    // Console input method
    private String getString(String consoleOut) {
        Scanner s = new Scanner(System.in);
        // Print console output
        System.out.print(consoleOut);
        // Get console input
        String consoleIn = s.nextLine();
        // Return console input
        return consoleIn;
    }
}
