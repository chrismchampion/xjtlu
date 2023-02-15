/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework2;

import java.util.ArrayList;
import java.util.List;

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
    /*public Student() {
        
    }*/
    
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
}
