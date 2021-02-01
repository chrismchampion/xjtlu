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
public class CardHand {

    // CONSTANT for initializing hand size
    private static final int HAND_SIZE = 10;
    
    private final BandCard[] theCards;
    private int endIndex;
    
    public CardHand(){
        theCards = new BandCard[HAND_SIZE];
        endIndex = -1;
    }

    public boolean isEmpty() {
        // CardHand initialized with endIndex = -1.
        // More efficient than testing with equality oper.
        return endIndex < 0;
    }
    
    // add to the bottom
    public void add(BandCard b){
        theCards[++endIndex] = b;
        System.out.println(b.getName() + " added at index " + endIndex);
    }
    
    // get the top card
    public BandCard getTop(){
        return theCards[0];
    }
    
    public void removeTop(){
        for (int i = 0; i < endIndex; i++) {
            theCards[i] = theCards[i+1];
        }
        System.out.println(theCards[endIndex--].getName() + " removed from top of queue.");
        endIndex--;
    }
    
    
    
}
