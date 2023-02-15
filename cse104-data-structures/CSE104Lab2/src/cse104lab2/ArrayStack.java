/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse104lab2;

import java.util.EmptyStackException;
import java.util.List;

/**
 *
 * @author christopher
 */
public class ArrayStack<E> implements Cloneable {

    /**
     * @param args the command line arguments
     */
    private E[] data;
    private int manyItems;

    /** Initialize empty stack with an initial capacity of 10 **/
    public ArrayStack() {
        final int INITIAL_CAPACITY  = 10;
        manyItems = 0;
        data = (E[]) new Object[INITIAL_CAPACITY];
    }

    /** Initialize an empty stack with a specified initial capacity. **/
    public ArrayStack(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("The initialCapacity is negative: " + initialCapacity);
        data = (E[]) new Object[initialCapacity];
        manyItems = 0;
    }
    /**
     * Generate a copy of this stack.
     *
     * @return The return value is a copy of this stack. Subsequent changes to
     * the copy will not affect the original, nor vice versa.
     * @throws java.lang.CloneNotSupportedException
   *
     */
    @Override
    public ArrayStack<E> clone() throws CloneNotSupportedException {
        // CLone an ArrayStack object.
        ArrayStack<E> answer;
        try {
            answer = (ArrayStack<E>) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new EmptyStackException();
            //("This class does not implement Cloneable");
        }
        answer.data = data.clone();
        // Returns a copy of the stack
        return answer;
    }
    
    public void ensureCapacity(int minimumCapacity) {
        E biggerArray[];
        if (data.length < minimumCapacity) {
            biggerArray = (E[]) new Object[minimumCapacity];
            System.arraycopy(data, 0, biggerArray, 0, manyItems);
            data = biggerArray;
        }
    }
    
    public int getCapacity() {
        return data.length;
    }
    
    public boolean isEmpty() {
        return manyItems == 0;
    }
    
    public E peek() throws EmptyStackException {
        // Returns the object at the top of this stack (last item of the array)
        // Throws EmptyStackException if this stack is empty
        if (getCapacity() == 0) {
            throw new EmptyStackException();
        }
        E peekElm = this.data[manyItems-1];
        return peekElm;
    }
    
    public E pop() {
        // Returns the object at the top of thifs stack (the last itme of the array)
        // Throws EmptyStackException if this stack is empty
        
        E trimArr[];
        if (manyItems == 0) {
            throw new EmptyStackException();
        }
        trimArr = (E[]) new Object[manyItems-1];
        E popElm = this.data[manyItems-1];
        manyItems--;
        
        System.arraycopy(data, 0, trimArr, 0, manyItems);
       
        return popElm;
    }
    
    public void push(E element) {
        if (manyItems == data.length) {
            // Ensure twice as much space as we need.
            ensureCapacity((manyItems + 1) * 2);
        }
        data[manyItems] = element;
        manyItems++;
    }
    
    public int size() {
        return manyItems;
    }
    
    public void trimToSize() {
        E[] trimmedArray;
        
        if (data.length != manyItems) {
            trimmedArray = (E[]) new Object[manyItems];
            System.arraycopy(data, 0, trimmedArray, 0, manyItems);
            data = trimmedArray;
        }
    }
    
    public int remainedCapacity() {
        // Returns the remained capacity of the stack
        return getCapacity() - size();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayStack<String> arrayStack = new ArrayStack<>();
        
        for (String s : "This is a test for arraystack".split(" ")) 
            arrayStack.push(s);
    
        while (!arrayStack.isEmpty())
            System.out.print(arrayStack.pop() + " ");

    }

}
