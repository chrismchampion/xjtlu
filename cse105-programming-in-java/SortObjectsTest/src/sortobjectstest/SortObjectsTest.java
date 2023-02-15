/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortobjectstest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author christopher
 */
public class SortObjectsTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Student alice = new Student("Alice", 22);
        Student janice = new Student("Janice", 18);
        Student bob = new Student("Bob", 32);
        Student andy = new Student("Andy", 32);

        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(alice);
        studentList.add(bob);
        studentList.add(andy);
        studentList.add(janice);

        // Print array list of Student objects before descending sort
        //for (Student s : studentList) {
        //    System.out.println(s.getName() + " is " + s.getAge());
        //}

        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //System.out.println("\nComparator returned o1>o2 = " + o1.getAge().compareTo(o2.getAge()));
                //System.out.println("o1 " + o1.getName() + " is " + o1.getAge());
                //System.out.println("o2 " + o2.getName() + " is " + o2.getAge());
                // Ascending sort
                //return o1.getAge().compareTo(o2.getAge());
                // Descending sort
                //return o2.getAge().compareTo(o1.getAge());
                
                Integer age1 = o1.getAge();
                Integer age2 = o2.getAge();
                
                int ageCmp = age2.compareTo(age1);
                
                if (ageCmp != 0) {
                    return ageCmp;
                }
                
                String name1 = o1.getName();
                String name2 = o2.getName();
                return name1.compareTo(name2);
            }

        });

        // Print array list of Student objects after  descending sort
        for (Student s : studentList) {
            System.out.println(s.getName() + " is " + s.getAge());
        }

    }

}
