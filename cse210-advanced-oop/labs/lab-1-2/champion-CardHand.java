/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.xjtlu.csse.y3s2.cse210.c.champion17.lab1.v11;

/**
 * Hand of cards for Battle of the Bands player
 * A Card Hand is a sequence of Band Cards
 * 
 * CarHand is basically a queue: There are operations to:
 * 1. add card to bottom of hand (enqueue)
 * 2. look at card at top of hand (peek)
 * 3. remove card from top of hand (dequeue)
 * 4. test if hand is empty (losing condition)
 *
 * @author C.Champion17
 * @version 1.1
 */
public class CardHand {

	// Class Invariants
	// Our use of an array and two pointers relies upon the following property:
	// 0 <= startIndexHead <= endIndexTail <= HAND_SIZE
	// e.g., if startIndexHead < 0, code throws ArrayOutOfBoundsException when, for example, calling getTop()
	// Our implementation guarantees this will never happen, i.e. impossible to get any instance of CardHand into a state where startIndexHead < 0
	// (this would not be true if startIndexHead was not private!).
	// private instance var without any public/package setter method is an example of a class invariant,
	// i.e., property is true on creation (in constructor), and "preserved" by all public methods.
	
	// Would like: startIndexHead <= endIndexTail <= HAND_SIZE also to be a class invariant.
	// Is true on initialization, but possible to call methods in such a way that the following holds:
	// endIndexTail < startIndexHead
	// Similarly possible: PACK_SIZE < endIndexTail. How and why?
	
	// CONSTANT for initializing hand size
	private static final int HAND_SIZE = 10;

	private final BandCard[] hand;
	private int startIndexHead;
	private int endIndexTail;


	public CardHand() {
		// from PPT (wrong?)
		//hand = new BandCard[BandPack.PACK_SIZE];
		hand = new BandCard[HAND_SIZE];
		startIndexHead = 0;
		endIndexTail = 0;
	}

	public boolean isEmpty() {
		// CardHand initialized with endIndex = -1.
		// More efficient than testing with equality oper.
		return endIndexTail <= 0;
	}

	// add to the bottom of hand (enqueue), i.e. tail of queue
	// by first incrementing pointer to tail and then assigning the value to that pos. in card array
	// implementation assumes will only be called when the hand IS NOT FULL
	// this makes sense as the game is over as soon as one player's hand is full
	public void add(BandCard b) {
		// version 1.0 implementation
		/*hand[++endIndexTail] = b;
		System.out.println(b.getName() + " added at index " + endIndexTail);*/
		
		// version 1.1 implementation
		// if there's no room, make room
		if (endIndexTail == HAND_SIZE) {
			// how many times?
			int len = endIndexTail - startIndexHead;
			for (int i = 0; i < len; i++) {
				hand[i] = hand[startIndexHead + i];
			}
			// move the pointers
			startIndexHead = 0;
			endIndexTail = len;
		}
		// add the card
		System.out.println(b.getName() + " added at index " + endIndexTail);
		hand[endIndexTail++] = b;
		
	}

	// get the top card
	// implementation assumes will only be called when the hand IS NOT EMPTY
	// this makes sense as the trump game is over as soon as one player's hand is empty
	public BandCard getTop() {
		return hand[startIndexHead];
	}

	// implementation assumes will only be called when the hand IS NOT EMPTY
	// this makes sense as the trump game is over as soon as one player's hand is empty
	public void removeTop() {
		// increment start pointer to point to head of queue + 1
		// i.e. head = currHead + 1
		System.out.println(hand[startIndexHead].getName() + " removed from top of queue.");
		startIndexHead++;
	}

}
