/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8.chatbot;

import java.util.Scanner;

/**
 *
 * @author christopher
 */
public class ChatBot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BotWeek7_orig myBot = new BotWeek7_orig();
        
        System.out.println("Ask the chatbot a question!");
        
        String question;
        boolean gameOver = false;
        
        Scanner kbInput = new Scanner(System.in);
        
        while (!gameOver) {
            question = kbInput.nextLine();
            System.out.println(myBot.processQuestion(question));
        }
        
    }
    
}
