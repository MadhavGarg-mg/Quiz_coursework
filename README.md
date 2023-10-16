CSC1035 Project 2 (Team Project)
================================

This is a quiz application with several features. This includes allowing the user to create, read, update and delete
questions from a questions' database. They are also able to import and export a list of questions based on certain 
conditions. Finally, the user can create a quiz based on a set of chosen parameters which they can then answer
and produce a final score.

## How to use the program:
When first running the program the user is presented with a menu
as shown below

```
------Quizzes------
Menu:
1)Create Question
2)Update Question
3)Delete Question
4)Create Quiz
5)Print list of Questions from a file
6)Export list of Questions to a file
7)Exit
```
In this menu the user is presented with options 1-7, any other input the
program will either exit or prompt the user to enter a valid input

### Create Question:
If the user selects create question they are prompted to enter the following
details that are required in order to create a question as shown below
```
Enter Question: 
Enter Topic:
Enter Type:
Enter Answer:
```
Additionally, if the user enters an invalid type or topic they will be asked to 
re-enter until their entry is valid

### Update Question:
If the user selects update question they will be prompted to enter the id
of the question they wish to update

```
Enter id
```
They will then be asked to enter the same information as when they create a question
as shown above

### Delete Question:
If the user selects delete question they will be prompted to enter 
the id of the question they wish to delete
```
Enter id
```
After this they will also be asked to enter the question information 
corresponding to that ID, similar to create Question

### Create Quiz:
If the user selects Create Quiz they will be shown a sub menu

```
------Create Quiz-------
Menu: Create Quiz based on
1)Topic
2)Type
3)Topic and Type
```
This prompts the user to decide whether they want to base their 
quiz on a topic, type or both
Once decided the user is asked to input their desired topic or type
and this is then checked
Example:
```
Enter Topic:english
Input invalid, please re-enter...
Enter Topic:maths
```

Next the user is presented with another sub menu to decide the length of
the quiz which is limited to 5,10,15,20
```
Choose Length:
--> 5
--> 10
--> 15
--> 20
```
This is also checked and if a user inputs an incorrect length then
they are prompted to re-enter until a valid entry is inputted

### The Quiz:
When the quiz is created it is then ready for the user to fill out
They are presented with a question which they can then input an answer.
If the user enters an incorrect answer they are shown the correct answer
and if the user enters a correct answer they are shown a well done message

Example: Correct answer
```
Question 2: [What is the next number in the sequence: 156,164,172... ]
Answer:
180
Correct! Well done
```

Example: Incorrect answer
```
Sorry this is the incorrect answer
The correct answer was: [9]
```

### Quiz report:
Once the user has completed the quiz they are presented with a report
on how they did. This includes a list of the answers the user 
answered incorrectly and their correct answers. Then it prints a list of 
correct answers. Then finally the users overall result is printed
Example:
```
Thanks for playing!
Generating quiz report...
------Quiz Report------
| Incorrect Questions |
[What is 120+45?]
Correct answer: [165]
[What is 54 divided by 6?]
Correct answer: [9]
| Correct Questions |
[What is the next number in the sequence: 156,164,172... ]
[hello]
[What is 121 divided by 11?]
Final score: 3/5
```

### Print list of Questions from a file
The user is prompted to enter the file name of the list they 
want to import
```
Enter file name you want to import:
```
If the file entered does not exist then the user is displayed this 
message
```
File not found
```
### Export list of Questions to a file
If a user selects this option then they are asked which file they want to export
to, like when importing a list
The user is then presented with a sub menu where they can choose to base the
list they are exporting on topic, type or both
```
Export list:
1)By Topic
2)By Type
3)By Topic and Type
```
The user is then prompted to enter input depending on what criteria
they chose to base their list on

## Assumptions:
--> The id of questions corresponds to a unique question so there can be no 
duplicates, and this id must be of type int

--> If a question is an MCQ then the multiple choice answers are contained within
the same column as the question

--> When entering a question in order to get it right the user is required
to input the exact answer however this answer is not case-sensitive.

--> If a user specifies a quiz that does not have enough questions to meet 
its length then it will display the number of questions that do exist

--> If a user wants to update part of a question they must update every detail
which they can keep the same or change depending on their preference