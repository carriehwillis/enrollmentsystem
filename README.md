# final

====================== OBJECTIVE =======================

Write a complete program for a university registration system.

Ask the user for:
- Course ID number and course name
- Faculty name and his/her rank
- Maximum class size allowed

When all done, your program will print out the roster of the class as follows:

Course: CHEM 414 - Organic Chemistry
Faculty: Professor John Smith
Followed by a list of the students’ names and ID numbers.

===================== CLASS SIZE =======================

Your program will select the actual class size randomly
Class size must be between 1/2 of the maximum and the maximum, inclusive (between max/2 and max)
So if the class maximum size entered by the user is 30, then your actual class size is between 15-30 inclusive.
Students names are then obtained from an existing enrollment.txt (a text file is provided)
Note: A sample program to read a certain number from a text file is included.


======================= CLASSES ========================

The minimum set of classes in your program must include:

• A Student class.
Each student will have a name and a unique ID.
The ID is selected randomly and must be unique

• A Faculty class.
Each faculty will have a name, a rank (Professor, Associate Professor Assistant Professor).
There must be a menu driven item for the user to select the faculty ranking.
As an example:
o Enter a faculty name:
o Select The faculty rank
§ Enter 1 for Professor
§ Enter 2 for Associate Professor
§ Enter 3 for Assistant Professor

• A Course class
Course class has the course ID Number, Room assigned, and class start and end time

• A Registrar class, which will include a main method

======================= RUBRIC =========================

Grading will be based on the following criteria:
• The use of Inheritance
• Design
• Efficiency, readability, and comments
• Functionality
