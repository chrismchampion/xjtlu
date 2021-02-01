/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse210lab2;

/**
 *
 * @author C.Champion17
 * @ class List v1.1
 */
public class List {

    private Node listStart; // always pointing to the start of the list
    private Node listEnd; // always pointing to the end of the list

    // LinkedList Constructor
    public List() {
        // Node myList = newNode(new BandCard("Goldfrapp", 5, 3, 7, 17, 12));
    }

    // add a BandCard to the start of the List
    public void add(BandCard b) {
        listStart = new Node(b, listStart); // call the 2nd node's constructor

        if (listEnd == null) { // list was empty
            listEnd = listStart; // there's one BandCard in the list
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
        Node n = listStart;

        // find the end of the list
        while (n != null) {
            // found a node, so count it and move on
            len++;
            n = n.getTail();
        }
        return len;
    }

    // Inner class Node - pointer to head
    public class Node {

        private BandCard head;
        private Node tail;

        // Node constructor
        public Node(BandCard b) {
            head = b;
            tail = null;
        }

        // 2nd Node constructor
        public Node(BandCard b, Node t) {
            head = b;
            tail = t;
        }

        // getter methods
        public BandCard getHead() {
            return head;
        }

        public Node getTail() {
            return tail;
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
                // v1.0 implementation
                // this variable traverses each node in the list, starting at the head
                /*Node n = theList;
            // find the last node in the list...
            while (n.tail != null) {
                n = n.getTail();
            }
            // add new BandCard b to end of list
            n.addEnd(b);*/

                // v1.1 implementation
                listEnd.addEnd(b);
                listEnd = listEnd.getTail(); // update the pointer
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

}
