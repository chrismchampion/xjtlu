# Data Structures - Assignment 2 (Due date: 12pm-3pm 05/24/2018, at Lab SD546, SD554)


## Learning Outcomes
On successful completion of this assignment, students are expected to:
- understand and be able to apply a variety of data structures, together with their internal representation and algorithms;
- be able to make informed choices between alternative ways of implementation, justifying choices on grounds such as time and space complexity;
- be able to select, with justification, appropriate data structures to ensure efficient implementation of an algorithm.

### To do: Design and code a JAVA program called ‘Grades’.
- Your system should store student’s name, and his/her course names with grades.
- Your system should allow the user to input, update, delete, list and search students’ grades.
- Each student has a name (assuming no students share the same name) and some course/grade
pairs. If an existing name detected, user can choose to quit or to add new courses to that student.
- Each student has 1 to 5 courses, each course has a unique name and a grade from 0 to 100.
- The course name has to be one of these 5 courses: Database, Data Structure, Operating System,
Mathematics, and System Design.

Your system should provide below functions:
1. **Add** a student with course and grade pairs by:
a. Spelling out the student’s name, and then provide “Course name” and “Grade” of that
course to add a new student.
b. Or add new course/grade pair to an existing student.
2. **Delete**
a. A student by spelling out the student’s name.
b. Or courses of a student by providing student’s name and course names.
3. **Search** a student’s grades by:
a. Providing only the student’s name which will results to a list of course/grade pairs. Plus the
average grade among all courses of that student.
b. Or by providing student’s name and course(s) name(s) which will results to the grade of
that course or grades of multiple courses.
4. **Update** student’s grades by: Providing student’s name, and then provide “Course name” of the
required course and put the new “Grade”.
5. **List** all student/grade pairs of a course by: providing “Course name”. The list should be shown in descending orders of the grades, for same grades, list in ascending alphabetical order of students’ names. Also, the average grade should be shown.

The following shows a typical scenario of user interactions with the system (user commands or inputs are rendered in italics):
- Grades
- Welcome to the students’ grades system, functions provided include the following:
  - Add – to add a new student name together with course/grade info into the system
  - Update – to update the grade of an existing course of a student
  - Search – to enquire about the grades of a specific student in the system
  - Delete–todeleteastudent’sinfo
  - List – to list all grades of a specific course in descending order
  - Quit – to exit from the current level of interactions
- Enter your command here: Add
  - Enter student’s name: Anna
  - Course name: Data Structure
  - Grade: 98
  - Another course name (can be blank): Database
  - Grade: 90
  - Another course name(can be blank):

> New student entered: Anna; Data Structure/98; Database/90.

> Note: automatically exit from current level.


- Enter your command here: Add
  - Enter student’s name: Anna
> Anna is already in the system.

- Enter a new course name (can be blank): Data Structure
> Data Structure is already in the system.

- Enter a new course name (can be blank): Mathematics
  - Grade:90
  - Enter a new course name (can be blank):

> New course entered: Anna; Data Structure/98; Database/90; Mathematics/90.

> Note: automatically exit from current level.


- Enter your command here: Add
  - Enter student’s name: Ben
  - Course name: Data Structure
  - Grade:88
  - Another course name(can be blank): Database
  - Grade:92
  - Another course name(can be blank): Operating System
  - Grade:70
  - Another course name(can be blank):

> New student entered: Ben; Data Structure/88; Database/92; Operating System/70.

> Note: automatically exit from current level.


- Enter your command here: Add
  - Enter student’s name: Tom
  - Course name: Data Structure
  - Grade:88
  - Another course name(can be blank): Operating System
  - Grade: 92
  - Another course name(can be blank): Database
  - Grade: 70
  - Another course name(can be blank):

> New student entered: Tom, Data Structure/88; Database/92; Operating System/70.

> Note: automatically exit from current level.


- Enter your command here: Update
  - Enter student’s name: Tom
  - Course name: Data Structure
  - New Grade: 98

> Student: Tom, Data Structure grade updated from 88 to 98.

> Note: automatically exit from current level.


- Enter your command here: Search
  - Enter student’s name: Tom
  - Course name (can be blank): Data Structure

> Student: Tom, Data Structure/98.

> Note: automatically exit from current level.


- Enter your command here: Search
  - Enter student name:Tom
  - Course name (can be blank):

> Student: Tom, Data Structure/98; Database/92; Operating System/70; Average/87.

> Note: automatically exit from current level.


- Enter your command here: List
  - Enter course name: Data Structure

> Data Structure: Anna/98; Tom/98; Ben/88; Average/95.

> Note: automatically exit from current level.


- Enter your command here: Delete
  - Enter student name: Anna
  - Course name (can be blank, if blank, delete all courses):

> Student deleted: Anna; Data Structure/98; Database/90; Mathematics/90.

> Note: automatically exit from current level.


- Enter your command here: Delete
  - Enter student name: Ben
  - Course name (can be blank, if blank, delete all courses): Database

> Course deleted: Ben; Database/90.

> Note: automatically exit from current level.


- Enter your command here: Search
  - Enter student name: Anna

> No Anna found.

> Note: automatically exit from current level.


- Enter your command here: Quit

> Bye-Bye


Take notes on the following:
- Capitalization makes no difference. For example ‘Add and ‘add’ can be considered as the same.
- The above scenario is just an example. It is not the standard format for your system.
- Above scenario did not consider input validation, however in your system, you should validate the
inputs.
- It is up to you to decide what algorithms and data structures to use to keep track of
Student/Couse/Grade info in the system, and where to find such info.


### What to do during the assessment hour during the due date?
a) Sign for attendance.
b) Demonstrate and explain to the lab demonstrator that your program works for the problems
prescribed above.
c) Hand in a well-documented/commented, stapled report (not exceeding 4 pages, without counting
your .java files) with the module title and your name/student number shown on the title page. Your report should explain your system structure (UML etc.), what data structures/algorithms (rendered in pseudo code) you have designed and how they are tested, debugged and used in your programs. Explain how error handling is done in your program. You should also analyse the complexity of your data structures and algorithms used. Lastly, sign to declare non-plagiarism.

Please note that at the end of the report you should include an appendix that should contain your .java files.


## Marking
Criteria of marking: correctness 45%, documentation, quality and efficiency of the data structures/algorithms used/developed 55%.
This assignment: 10% of the overall marks.




# Assignment 2 – Grades Program Report

## Structures used: ArrayList, HashMap
## Class Synopsis: Grades, Menu, Course, Student, Database (NameGrade (inner class))

### Grades
- Contains main method which instantiates Grades program.
- Constructor creates instance of Menu.

### Menu
- Declares and instantiates instance of Database.
- Constructor calls run() method.
- Run method prints menu to the console and waits for user input. Calls Database instance’s add(), update(), search(), ... , methods based on String input into the console. Loops while String input not equal to “quit” (Note: not case sensitive).

### Course
- Private member variables: String title, double grade;
- Used to instantiate Course objects.
- Course object stores title and grade values.
- Contains getter/setter and toString() methods.

### Student
- Private member variables: int MAX_COURSE, String name, ArrayList<Course> courseList;
- Used to instantiate Student objects.
- Student object stores student name value and list of courses the student is enrolled in.
- Constant variable MAX_COURSE=5 used to compare against counter when adding courses to student’s course list.
- Contains getter/Setter methods.

### Database
- Contains ArrayList of Student objects
- Contains HashMap of student names (K=key) and an ArrayList of their corresponding courses (V=value). Keys and values are kept in storage “buckets”, with unique keys being mapped to a corresponding value.
- Contains add(), search(), update(), delete(), list() methods called from menu:
  - Excluding the list() method, all methods get student name from user and check for its existence as a key value in the HashMap (using .containsKey(pName)) before proceeding.
  - The .containsKey(Object key) method computes a hash value of the provided pName String and checks if the HashMap contains a key value equal to it. If found, the method returns true. According to the Java API documentation for HashMap, constant-time performance is provided for basic operations like get and put. Since .containsKey() can be equated to a get operation, the time complexity is O(1). 
- The NameGrade inner class was created in Database and is used in the list() method to create objects that can store a student’s name and the grade of one of the classes they are enrolled in.

### Database class protected (package accessible) methods:
- #add() : void
  - Calls addToExistingStudent(pName) if HashMap contains key,
  - Otherwise calls addNewStudent(pName).
- #search() : void
  - Calls searchCourseList(pName) if HashMap contains key
- #update() :  void
  - Calls updateCourseGrade(pName) if HashMap contains key
- #delete() : void
  - Calls deleteStudent(pName) if HashMap contains key
- #list() : void
  - Pseudo code:
// Get course name from user.
// Iterate over array list of Student objects --> time complexity = O(n).
// If Student is enrolled in given course, add Student object to new “course enrollment” // array list. --> ArrayList add time complexity = O(1), worst-case list copy/resize = O(n).
// For each Student added to the “course enrollment” list, get their name and the grade // of the corresponding Course and add to new array list of NameGrade objects.
// Use Collections.sort() with Comparator to sort list by grades (descending) and names // (ascending). [Note: Collections.sort() offers similar performance to a mergesort. Time // complexity = O(n*log(n)).]
// Print sorted list.

### Database class private (member accessible) methods:
- -deleteStudent(String) : void
  - Called by delete() method.
  - Pseudo code:
// Get student object from student list based on user input.
// Get course title from user.
// If course title left blank, call the HashMap .remove(K=student name) method
// to delete the K->V mapping in the map [= O(1)]. Delete the student from the database’s ArrayList of student objects [= O(n)].
// If course title provided, get the student object’s course list and remove [= O(n)].

- -updateCourseGrade(String) : void
  - Called by update() method.
  - Pseudo code:
// Get student object from student list based on user input.
// Get course title from user.
// Check if user-selected student is enrolled in user-selected course, if true call Course object’s setGrade(Double) method.

- -searchCourseList(String) : void
  - Called by search() method.
  - Pseudo code:
// Get Student object from student list based on user input.
// Create new array list to store Course objects specified by user-input if found.
// Set enrollment counter to 0.
// Get course title from user.
// If student is enrolled in course specified by user, add to enrollment list and increment // counter.
// If counter > 0, print enrollment list; otherwise, print all Courses from student’s course // list.

- -addNewStudent(String) : void
  - Called by add() method.
  - Pseudo code:
// Create new Student object and Course objects based on user-input.
// Must pass condition of not exceeding MAX_COURSE count of 5.
// Add to student’s course list and update the HashMap using the .put(K=student name, // V=course list) method [=constant time, O(1)].
// Print student’s course list.

- -addToExistingStudent(String) : void
  - Called by add() method.
  - Pseudo code:
// Similar to addNewStudent(String) except the Student object is retrieved by iterating // over the Database class’s Student object ArrayList instead of being created new.

- -isEnrolled(String, String) : boolean
  - Uses HashMap’s get(Object key) method to return the Course list mapped to the passed-in student name key. Returns true if passed-in course title value exists in the list.

- -printAverage(ArrayList<E>) : void
  - Uses generics to call Course.getGrade() or NameGrade.getGrade() depending on the class name of the objects in the passed-in List parameter. Calculates and prints average.

- -getStudent(String) : Student
  - Iterates over the database’s list of student objects. Returns the Student object with matching student name based on passed-in String parameter.

- -getCourse(Student, String) : Course
  - Iterates over a Student object’s list of courses. Returns the course object with matching course name based on passed-in String parameter.

- -getCourseTItle() : String
  - Console input validation method to restrict title using String.equalsIgnoreCase().

- -getGrade() : Double
  - Console input validation method uses try-catch (NumberFormatException)

- -getString(String) : String
  - General console input method using Scanner.nextLine() method.