/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author C.Champion17
 */
public class Tester {
    
    public static void main(String args[]) {
            
        // Initialise an empty hand
        CardHand myHand = new CardHand();
        
        // Add 5 cards by using the add() method
        BandCard bc1 = new BandCard("Goldfrapp", 5, 3, 7, 17, 12);
        BandCard bc2 = new BandCard("Metallica", 2, 2, 2, 2, 2);
        BandCard bc3 = new BandCard("Boys Noize", 3, 3, 3, 3, 3);
        BandCard bc4 = new BandCard("HVOB", 4, 4, 4, 4, 4);
        BandCard bc5 = new BandCard("TRST", 5, 5, 5, 5, 5);
        
        myHand.add(bc1);
        myHand.add(bc2);
        myHand.add(bc3);
        myHand.add(bc4);
        myHand.add(bc5);
        
        // Remove 3 cards using the removeTop() method
        myHand.removeTop();
        myHand.removeTop();
        myHand.removeTop();
        
        // Add another 5 cards
        BandCard bc6 = new BandCard("Francois and the Atlas Mountains", 1, 1, 1, 1, 2);
        BandCard bc7 = new BandCard("Grauzone", 2, 2, 2, 4, 4);
        BandCard bc8 = new BandCard("Tina Turner", 3, 3, 3, 6, 6);
        BandCard bc9 = new BandCard("Einstuerzende Neubauten", 4, 4, 4, 8, 8);
        BandCard bc10 = new BandCard("Mya", 5, 5, 5, 5, 5);
        
        myHand.add(bc6);
        myHand.add(bc7);
        myHand.add(bc8);
        myHand.add(bc9);
        myHand.add(bc10);
    }

    
}
