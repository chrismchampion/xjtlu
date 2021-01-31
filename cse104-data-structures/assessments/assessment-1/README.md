# Data Structures & Algorithms - Assignment 1 (Due date: 12pm-3pm 04/19, at Lab SD546, SD554)

## Learning Outcomes
On successful completion of this assignment, students are expected to
- understand and be able to apply a variety of data structures, together with their internal representation and algorithms;
- be able to select, with justification, appropriate data structures to ensure efficient implementation of an algorithm.

## To Do
Using the techniques learnt from our Data Structures & Algorithms module, develop in **Java** a subclass of List with **type parameter** that includes the methods described below. Specifically, develop an algorithm for each method. Finally, write in Java a program that implements the following methods and a main program that accepts user input to test these methods.

### Find the ath largest value and the bth smallest value in a list
Design a method named findMaxMin, to find and return both the ath largest value and the bth smallest value of the elements of a list. This method takes two int parameters a and b. Return null if both value does not exist. If only one value exist, return null for the value which does not exist, and the other required value.
For example, if list A contains “1”,”5”,”1”,”3”. A.findMaxMin(1,2) should return both “5”(the 1st largest value) and “1”(the 2nd smallest value). If list B contains “a”,”f”,”a”,”d”. B.findMaxMin(2,6) should return “d”(the 2nd largest value) and null(6th smallest value does not exist).
Assume that all elements in the list are comparable to each other, i.e., that it is meaningful to ask whether one element is less than another (in Java terms, assume that all elements implement the Comparable interface).

### Reverse a list
Design a method, reverseList, which takes no parameter and returns a new list containing the same elements of the original list in a reversed order BUT with duplicates removed. For example, if list A contains the strings “accordion”, “banjo”, “accordion”, and “clarinet”, A.reverseList() should return a list contains “clarinet”, “accordion” and “banjo”,
Note that reverseList creates and returns a new list, it does not modify the original list receiving the reverseList message. **Reverse first, then remove duplicates.**

### Does this list contain the same elements as the other list?
Design a method, containList, which takes a list as its parameter and determines whether that list contains the same elements, not necessarily in the same order, as the list that receives the containList message.
1. The containList message returns a boolean result, true if the list contain the parameter list, and false if not. For example, if list A contains the strings “accordion”, “banjo”, and “clarinet”, and list B contains the strings “banjo”, “accordion”, and “clarinet”, then the expression A.containList (B) should yield true. However, A.containList (C), where list C contains the strings “accordion,” “bongo,” and “clarinet,” should return false. If list D contains the strings “banjo”, “banjo”, “accordion”, and “clarinet”, A.containList(D) returns true.
2. Also, before returning the boolean result, the message has to print out a new list which contains the elements of the parameter list but with duplicates removed.
Note: Use Java’s equals message (not “==”) to determine whether elements from the two lists are the same.

### What to do during the assessment hour during the due date?
- Sign for attendance.
- Demonstrate and explain to the lab demonstrator that your program works for these 3 problems for
different types of input e.g. integer, string, etc.
- Hand in a well-documented, stapled program listing (not exceeding 6 pages in total) with the module
title and your name/student number shown on the title page. There should be a 1-page summary on the title page explaining what data structures/algorithms you have designed & used in your programs. You should also sign to declare non-plagiarism.
   
## Marking & Weightage
Criteria of marking: correctness 60%, documentation, conciseness, quality and efficiency of the data structures/algorithms used/developed 40%.
This assignment: 10% of the overall marks.
