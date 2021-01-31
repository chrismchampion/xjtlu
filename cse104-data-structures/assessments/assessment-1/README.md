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


# GenericList<E> Class


The **GenericList<E>** class defines the following methods:

## +findMaxMin(int a, int b) : List<E>

Parameters: <E> type parameter; declared before return type for working with List collection elements, int a, int b parameters; find the “a-th” max value and “b-th” min value.
Return type: List (of E elements)

A new List object “newList” is initialized with the elements of the List that calls the method. This is to preserve the contents of the GenericList object that calls this method. Another List of elements “returnList” is created for holding max/min values. The “newList” object is passed to the Java Collection Framework’s sort() method as a parameter and sorts its elements in ascending order. Since all three GenericLists are type-bound to wrapper classes that implement the Comparable<T> interface, Collections.sort() can be utilized and offers similar performance to a mergesort. Next E max/min objects are initialized with null and the int a/b parameters are checked for validity. If valid, the “a-th” largest and “b-th” smallest element  are retrieved from “newList” and assigned to E max/E min. Finally, E max and E min values are both added to “returnList” and the List is returned.

## +reverse() : List<E>

Parameters: None
Return type: List (of E elements)

Similar to findMaxMin(), a new List object is created to preserve the original list. The “newList” object is passed as a parameter to the Collection Framework’s reverse() method, which reverses the elements of the specified list in linear time. “newList” is then passed to **removeDuplicates()** and returned.

## -removeDuplicates(List) : List

Parameters: List (of E elements)
Return type: List (of E elements)

Private class method used in the reverse() and containList() methods. A new LinkedHashSet is initialized with the passed-in List object’s elements. The Set is then returned as a new ArrayList. All duplicate elements of the passed-in list are removed in the LinkedHashSet, since collections that implement the Set<E> interface cannot contain duplicate elements. LinkedHashSet defines a doubly-linked list and was chosen for its performance, which is comparable to List’s add, contains, and remove operations (constant time; O(1)), and because it stores elements in the order of their insertion. For example, HashSet and TreeSet also remove duplicate elements, but HashSet stores elements in random order. TreeSet maintains order, but is slower because of the sorting operation it performs upon element insertion.

## +containList(List) : Boolean

Parameters: List (of E elements)
Return type: Boolean

This method applies a similar strategy as previously stated, using the removeDuplicates() and Collections.sort() methods. As per this assignment’s requirements, the method prints the passed-in list’s elements (without duplicates) to the console before returning true or false. The Collections.containsAll(Collection<?> c) method is used to generate the Boolean return value and returns true if the GenericList that calls the containList() method contains all of the elements in the passed-in list.

## TestGenericList Class
The **TestGenericList class** reads from and writes to instances of GenericList.
The class contains three instances of GenericList, each with a different type parameter (ensures type-safety at runtime by enabling compiler to perform type checking at compile time): GenericList<Integer>, GenericList<String>, GenericList<Boolean>.
Elements can be added to the lists manually via the console by selecting the “add values” option in the console menu.  User input is parsed from String to Integer (if possible) and added to the <Integer> list, String to Boolean (if possible) and added to the <Boolean> list. Otherwise, added to the <String> list.
This class tests the findMaxMin(), reverse(), and containList() methods from the GenericList class. The methods can be tested with values input by the user in the console, or with hard-coded values from the Assignment 1 task sheet by choosing the “run with demo data” option from the console menu. Finally, the class contains several print() methods to help maintain the format of console output either when a user enters data manually, or modifies the hard-coded values within the runDemo() method.
