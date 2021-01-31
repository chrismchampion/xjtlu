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
  - Note: automatically exit from current level.

- Enter your command here: Add
  - Enter student’s name: Anna
> Anna is already in the system.
  - Enter a new course name (can be blank): Data Structure
Data Structure is already in the system.
o Enter a new course name (can be blank): Mathematics o Grade:90
o Enter a new course name (can be blank):
New course entered: Anna; Data Structure/98; Database/90; Mathematics/90.
o Note: automatically exit from current level.
 Enter your command here: Add
o Enter student’s name: Ben
o Coursename:DataStructure
o Grade:88
o Anothercoursename(canbeblank):Database
o Grade:92
o Anothercoursename(canbeblank):OperatingSystem o Grade:70
o Anothercoursename(canbeblank):
New student entered: Ben; Data Structure/88; Database/92; Operating System/70.
o Note: automatically exit from current level.
 Enter your command here: Add
o Enter student’s name: Tom
o Coursename:DataStructure
o Grade:88
o Anothercoursename(canbeblank):OperatingSystem o Grade:92
o Anothercoursename(canbeblank):Database
o Grade:70
o Anothercoursename(canbeblank):
New student entered: Tom, Data Structure/88; Database/92; Operating System/70.
o Note: automatically exit from current level.
 Enter your command here: Update o Enter student’s name: Tom
o Coursename:DataStructure o NewGrade:98
Student: Tom, Data Structure grade updated from 88 to 98.
o Note: automatically exit from current level.
 Enter your command here: Search o Enterstudent’sname:Tom
o Course name (can be blank): Data Structure

Student: Tom, Data Structure/98.
o Note: automatically exit from current level.
 Enter your command here: Search o Enterstudentname:Tom
o Course name (can be blank):
Student: Tom, Data Structure/98; Database/92; Operating System/70; Average/87.
o Note: automatically exit from current level.
 Enter your command here: List
o Enter course name: Data Structure
Data Structure: Anna/98; Tom/98; Ben/88; Average/95.
o Note: automatically exit from current level.
 Enter your command here: Delete o Enterstudentname:Anna
o Couse name (can be blank, if blank, delete all courses):
Student deleted: Anna; Data Structure/98; Database/90; Mathematics/90.
o Note: automatically exit from current level.
 Enter your command here: Delete o Enter student name: Ben
o Couse name (can be blank, if blank, delete all courses): Database Course deleted: Ben; Database/90.
o Note: automatically exit from current level.
 Enter your command here: Search o Enterstudentname:Anna
No Anna found.
o Note: automatically exit from current level.  Enter your command here: Quit
 Bye-Bye
Take notes on the following:
 Capitalization makes no difference. For example ‘Add and ‘add’ can be considered as the same.
 The above scenario is just an example. It is not the standard format for your system.
 Above scenario did not consider input validation, however in your system, you should validate the
inputs.
 It is up to you to decide what algorithms and data structures to use to keep track of
Student/Couse/Grade info in the system, and where to find such info.
What to do during the assessment hour during the due date?
a) Sign for attendance.
b) Demonstrate and explain to the lab demonstrator that your program works for the problems
prescribed above.
c) Hand in a well-documented/commented, stapled report (not exceeding 4 pages, without counting
your .java files) with the module title and your name/student number shown on the title page. Your report should explain your system structure (UML etc.), what data structures/algorithms (rendered in pseudo code) you have designed and how they are tested, debugged and used in your programs. Explain how error handling is done in your program. You should also analyse the complexity of your data structures and algorithms used. Lastly, sign to declare non-plagiarism.

Please note that at the end of the report you should include an appendix that should contain your .java files.
Marking
Criteria of marking: correctness 45%, documentation, quality and efficiency of the data structures/algorithms used/developed 55%.
This assignment: 10% of the overall marks.
