/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse210lab2;

/**
 *
 * @author C.Champion17
 * @ class LList doubly-linked list
 */
public class LList {

    private BiNode listStart; // always pointing to the start of the list
    private BiNode listEnd; // always pointing to the end of the list

    // DoublyLinkedList Constructor
    public LList() {
        // Node myList = newNode(new BandCard("Goldfrapp", 5, 3, 7, 17, 12));
    }

    // add a BandCard to the start of the List
    public void add(BandCard b) {
        listStart = new BiNode(b, listStart); // call the 2nd node's constructor
        
        if (listEnd == null) { // list was empty
            listEnd = listStart; // there's one BandCard in the list
        }
    }

    // add a BandCard to the end of the List
    // if the list is empty, then add b
    // variable 'n' used to traverse the list and find the last node
    // finish when 'n' is the last node, otherwise, move on through list
    // 'n' is now the last node, so add 'b' by called method in Node.java
    public void addEnd(BandCard b) {
        // if list is empty, just create new BandCard and set as head of list
        if (listStart == null) {
            add(b);
        } else {
            listEnd.addEnd(b);
            listEnd = listEnd.getTail(); // update the pointer
        }
    }

    // get the length of the list
    // use var 'n' to traverse list
    // finishes when n == null (end of list)
    // n != null, so we've found an element, then move on through the list
    public int length() {

        // stores the number of nodes found so far
        int len = 0;

        // this variable traverses each node in the list
        BiNode n = listStart;

        // find the end of the list
        while (n != null) {
            // found a node, so count it and move on
            len++;
            n = n.getTail();
        }
        return len;
    }
    
    public void removeLast( ){
        if (listEnd == null) { // list is empty
            return; // do nothing and exit
        }
        // if list isn't empty
        if (listEnd.prev == null) { // if there's only one BandCard in the list
            listStart = null; // empty the list
            listEnd = null;
        } else { // else list is not empty and more than one node
            listEnd = listEnd.prev; // move the pointer back one
            listEnd.chop(); // cut end of list
        }
    }
    
    public boolean isIn(String s) {
        if (listStart == null) {
            return false;
        } else {
            BiNode n = listStart;
            while (n !=  null) { // not at end
                if (n.getHead().getName().equals(s)) {
                    return true; // found it
                }
                n = n.getTail();
            }
            return false; // end of list;
        }
    }

    // Inner class BiNode - extends Node; adds pointer to prev node
    public class BiNode {

        private BandCard value;
        private BiNode prev;
        private BiNode tail;

        // Node constructor
        public BiNode(BandCard b) {
            value = b;
        }

        // 2nd Node constructor
        public BiNode(BandCard b, BiNode t) {
            value = b;
            tail = t;
            if (t != null) {
                t.prev = this;
            }
        }

        // getter methods
        public BandCard getHead() {
            return value;
        }

        public BiNode getTail() {
            return tail;
        }
        
        public void addEnd(BandCard b) {
            tail = new BiNode(b);
            tail.prev = this;
        }
        
        // sets the current node to be the last in the list
        // by removing pointers to any following nodes
        public void chop() {
            tail = null;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

}
