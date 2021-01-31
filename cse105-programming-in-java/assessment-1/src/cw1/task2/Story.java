/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw1.task2;

import java.util.Scanner;

/**
 *
 * @author christopher
 */
public class Story {

    // private class variables
    private String name;
    private boolean isMale = false;
    private int age;
    private String country;
    private boolean isStudent = false;
    private String university;
    private String occupation;
    private String favoriteFood;

    public static void main(String[] args) {

        // New instance of Story calls constructor
        Story myStory = new Story();
        // Print Story to the console
        System.out.println(myStory.toString());
    }

    public Story() {

        // Initialize class variables with user input (i.e. name, age, country, etc.)
        askQuestions();
    }

    private void askQuestions() {

        setName();
        setGender();
        setAge();
        setCountry();
        setIsStudent();
        if (isStudent) {
            setUniversity();
        } else {
            setOccupation();
        }
        setFavoriteFood();
    }

    @Override
    public String toString() {
        // Concatenates class variables with story strings and returns as String
        String genderPronoun;
        if (isMale) {
            genderPronoun = "He";
        } else {
            genderPronoun = "She";
        }

        String story = "\n*****************************";
        story += "\nThis is a story about " + name + ".";

        if (isStudent) {
            story += "\n" + name + " is a student at " + university + ".";
        } else {
            story += "\n" + name + " is a " + occupation + ".";
        }

        story += "\n" + genderPronoun + " is " + age + " and lives in " + country + ".";
        story += "\n" + name + "'s favorite food is " + favoriteFood + ".";

        return story;
    }

    private String getStringInput() {
        Scanner stringInput = new Scanner(System.in);
        return stringInput.nextLine();
    }

    // SETTER METHODS
    public void setName() {
        System.out.println("What's your name?");
        String n = getStringInput().toLowerCase();
        n = Character.toString(n.charAt(0)).toUpperCase() + n.substring(1);
        this.name = n;
    }

    public void setGender() {
        System.out.println("Are you male? (y/n)");
        String gender = getStringInput();
        isMale = gender.trim().toLowerCase().startsWith("y") || gender.trim().toLowerCase().startsWith("m");
    }

    public void setAge() {
        System.out.println("How old are you?");
        this.age = Integer.parseInt(getStringInput());
    }

    public void setCountry() {
        System.out.println("What country do you live in?");
        String c = getStringInput().toLowerCase();
        c = Character.toString(c.charAt(0)).toUpperCase() + c.substring(1);
        this.country = c;
    }

    public void setIsStudent() {
        System.out.println("Are you a student?");
        String student = getStringInput();
        isStudent = student.trim().toLowerCase().startsWith("y");
    }

    public void setUniversity() {
        System.out.println("Where do you study");
        this.university = getStringInput();
    }

    public void setOccupation() {
        System.out.println("What's your occupation?");
        this.occupation = getStringInput();
    }

    public void setFavoriteFood() {
        System.out.println("Whats your favorite food?");
        this.favoriteFood = getStringInput();
    }

    // GETTER METHODS
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public String getUniversity() {
        return university;
    }
}
