package coursework2;

import java.util.ArrayList;

/**
 *
 * @author christopher
 */
public class Student {

    // constants
    private final int MAX_COURSE = 5;

    // private member variables
    private String name;
    private ArrayList<Course> courseList = new ArrayList<>();

    // constructor 
    public Student(String pName) {
        this.name = pName;
    }

    // Getter and Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public int getMaxCourse() {
        return MAX_COURSE;
    }
}
