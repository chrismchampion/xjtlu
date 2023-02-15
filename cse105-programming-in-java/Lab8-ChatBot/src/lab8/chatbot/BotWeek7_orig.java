/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8.chatbot;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

/**
 *
 * @author joelewis
 */
public class BotWeek7_orig {

    private final String name = "Chris";
    private final String country = "USA";
    private final String feeling = "fine";
    private final LocalDate dateOfBirth = LocalDate.of(1986, Month.JUNE, 14);
    private String[] myLikes = {"languages", "music", "travelling", "beer"};
    private int[] likesHowMuch = {3, 1, 7, 4};
    private String[] myDislikes = {"Donald Trump", "getting sick", "Facists", "chicken feet"};
    private int[] dislikesHowMuch = {4, 3, 4, 2};

    //create a no-args constructor
    public BotWeek7_orig() {
        //do you understand what this is doing?
    }

    //Encapsulate the instance variables
    //create getter methods only (Why?) for name, country, age (you will have to calculate-see lecture). 
    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getAge() {
        Period p = Period.between(dateOfBirth, LocalDate.now());
        return Integer.toString(p.getYears());
    }

    //create method to process questions
    public String processQuestion(String question) {

        String response = "I'm sorry, Dave. I'm afraid I can't do that...";
        if (question.toLowerCase().contains("what") && question.toLowerCase().contains("your") && question.toLowerCase().contains("name")) {
            response = "My name is " + name;
        }

        if (question.toLowerCase().contains("where") && question.toLowerCase().contains("you") && question.toLowerCase().contains("from")
                || question.toLowerCase().contains("what") && question.toLowerCase().contains("country")
                || question.toLowerCase().contains("which") && question.toLowerCase().contains("country")) {
            response = "I am from " + country;
        }

        if (question.toLowerCase().contains("how") && question.toLowerCase().contains("are")
                && question.toLowerCase().contains("you") && !question.toLowerCase().contains("old")) {
            response = "I'm fine thanks, and you?";
        }

        if (question.toLowerCase().contains("how") && question.toLowerCase().contains("old")) {
            response = "I'm " + getAge();
        }

        if (question.toLowerCase().contains("like") && question.toLowerCase().contains("most") || question.toLowerCase().contains("favorite")) {
            response = getMostFav();
            //response = getLeastFav();
        }

        if (question.toLowerCase().contains("like") && question.toLowerCase().contains("least") ||
                question.toLowerCase().contains("least favorite") || question.toLowerCase().contains("hate")) {
            response = getStrongestDislike();
            //response = getWeakestDislike();
        }
        
        if (question.toLowerCase().contains("like")) {
            response = getStrongestDislike();
        }

        return response;
    }

    private String getMostFav() {
        int max = 0;
        for (int i = 0; i < likesHowMuch.length; i++) {
            if (likesHowMuch[i] > likesHowMuch[max]) {
                max = i;
            }
        }
        String fav = myLikes[max];
        return "I absolutely adore " + fav + ".";
    }

    private String getLeastFav() {
        int min = 0;
        for (int i = 0; i < likesHowMuch.length; i++) {
            if (likesHowMuch[i] < likesHowMuch[min]) {
                min = i;
            }
        }
        String leastFav = myLikes[min];
        return "I like " + leastFav + ".";
    }
    
    private String getStrongestDislike() {
        int max = 0;
        for (int i = 0; i < likesHowMuch.length; i++) {
            if (dislikesHowMuch[i] > dislikesHowMuch[max]) {
                max = i;
            }
        }
        String strongDislike = myDislikes[max];
        return "I detest " + strongDislike + ".";
    }
    
    private String getWeakestDislike() {
        int min = 0;
        for (int i = 0; i < likesHowMuch.length; i++) {
            if (dislikesHowMuch[i] < dislikesHowMuch[min]) {
                min = i;
            }
        }
        String weakDislike = myDislikes[min];
        return "I'm not a fan of " + weakDislike + ".";
    }

}
