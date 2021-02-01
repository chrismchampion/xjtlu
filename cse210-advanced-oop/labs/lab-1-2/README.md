# CSE210 Advanced Object-oriented Programming - Lab 1 & 2

## Lab 1

### Tasks

Implement CardHand.java v1.0 (using just one pointer for the last element). Note that you need to have BandCard.java.
- Test the four methods

Implement CardHand.java v1.1 (using two pointers)
- Test the four methods
- Check the class invariants

### Test

- CardHand class is given
- Set a Hand size, e.g., 10
- Initialise BandCard with your own data. For simplicity, in testing your code you may choose to print just the integer value for one field.

- Example – test the correctness:
  - Initialise an empty hand;
  - Add 5 cards by using the add() method;
  - Remove 3 cards using the removeTop() method;
  - Add another 5 cards;
  - Remove 2 cards;
  - Add another 3 cards.

## Lab 2

Implement the following classes with all the methods discussed in the lectures.

- LinkedList.java (hint: one pointer for the whole list; Node as an inner class).
- Doubly Linked List (hint: two pointers for the list, BiNode as an inner class and two pointers for each node).

Testing
- Initialise the list with some arbitrary values (you also can reuse the BandCard class you developed).
- Test all methods (e.g., add(), addEnd(), length(), etc).