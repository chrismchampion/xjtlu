#CSE105 Coursework 1 Semester 1 2017-8

There are five tasks. Each task is worth 20 points. The assessment contributes 15% to your final grade on this module.

Each task should be in its own Class. See important notes on submission format at the end: you must submit INDIVIDUAL .TXT FILES, not .java files.

##Task 1: Conversion
Write a program that converts measurements from fathoms to metres. A fathom is an old imperial measure of water depth. 1 fathom = 1.8288m.
You program should:
- Tell the user what it does.
- Ask the user for an input range [eg 1-10]
- Print a labeled and formatted table showing the values for this range, eg

Fathoms Metres
1 1.8288
2 ......
3 ......
4 ......
5 ......
6 ......
7 .....
8 ......
9 ......
10 18.288


##Task 2: A Story
Write a program that writes a story, specially personalised for the user.
For example:
The program should ask the user to input:
- His/her name
- His/her gender
- His/her age
 The name of a city
- The name of a university
 
- A profession
- Another person’s name
After the user has entered all these items, the program should display a story, inserting the user’s input at the appropriate location, eg:
There once was a person called James who lived in Suzhou. At the age of 19, James went to university at Harvard. When he graduated, he became an accountant, and married another accountant called Susan.
This is just an example. You should change some of the information you ask for (MINIMUM 6 ITEMS), and write a different story.

##Task 3: Time
Write a program that asks the user to enter a number of seconds. The program should then calculate the number of days, minutes, hours and seconds represented by the input value.
eg
input: 90,061
output: 1 day, 1 hour, 1 minute, 1 second.

##Task 4: Game simulation
Dice simulation
Program a game played with 4 dice.
On each play, the program generates 4 random whole numbers from 1 to 6. Each one represents the score on 1 dice.
If 2 dice match, the player scores 2 points.
If 3 dice match, the player scores 3 points.
If 4 dice match, the player scores 4 points.
The program ask whether the user wants to play again. If not, the total score for the game so far is displayed.
Bonus task 4A
Display a small window (a Frame) which displays one image each for the four dice in Task 4 above. The images should change to represent the values of the dice in each play. The dice can be standard, with 1 to 6 dots, or pictorial, with a different image on each face. You can draw a dice with dots using the methods of a Graphics object, or you can display an image from file – up to you.

##Submission
You must submit your work with
- Each task has one class.
- Each class is in one text file.

IMPORTANT: READ THIS!
You must submit .txt files. The java files you write in Netbeans are .java files. So, when you have finished the tasks and you want to submit, you should
- copy the .java files from the src folder in your Netbeans project folder.
- RENAME them, so from my_code.java
to my_code.txt
- Submit the individual txt files on ICE. DO NOT compress, RAR or zip them into an archive.
Submit on the CSE105 page on ICE before 6.00pm, 29th October 2017.
This assignment is individual work. Plagiarism (e.g. copying materials from other sources without proper acknowledgement) is a serious academic offence. Plagiarism will not be tolerated and will be dealt with in accordance with the University Code of Practice on Assessment. Individual students may be called upon to explain parts of their code; if they are unable to do so, marks will be deducted proportionally. However, for the bonus task, 4A, you may re-use/adapt code from the Labs this semester.
