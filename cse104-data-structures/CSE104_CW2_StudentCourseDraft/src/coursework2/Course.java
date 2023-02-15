/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework2;

import java.util.ArrayList;

/**
 *
 * @author christopher
 */
public class Course {

    // private member variables
    private Student student;
    private String title;
    private double grade;
    
    public Course(Student s, String pTitle, double pGrade) {
        
        this.student = s;
        this.title = pTitle;
        this.grade = pGrade;
    }
    
    // Getter and Setter methods
    public String getTitle() {
        return title;
    }

    public void setTitle(String pTitle) {
        boolean validTitle = false;
        // trim input string to ignore white space
        if (pTitle.equalsIgnoreCase("database") || pTitle.equalsIgnoreCase("data structure")
                || pTitle.equalsIgnoreCase("operating system")
                || pTitle.equalsIgnoreCase("mathematics")
                || pTitle.equalsIgnoreCase("system design")) {
            validTitle = true;
        }

        if (validTitle) {
            this.title = pTitle.toUpperCase();
        } else {
            System.out.println("You did not enter a valid course name");
        }
    }

    public Double getGrade() {
        return grade;
    }

    /*public String getStudent() {
        return student.getName();
    }*/
    
    public void setGrade(double grade) {
        //try {
        //Double.parseDouble();
        //} catch (NumberFormatException e) {
        if (grade > -1 && grade < 101) {
            this.grade = grade;
        } else {
            System.out.println("You did not enter a valid grade.");
        }
    }
}
