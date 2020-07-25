# My-School
In this repository you will find implementation of file handling and Exception Handling using Java along with demonstration of OOPs programming. It also demonstrates use of data Structure 'ArrayList'.

MySchool is a Java application for schools. It reads data from files, and creates a report on student results.

program can read from a file specified in command line and store student scores in an integer array
scores.txt
34 C081 C082 C083 C084
S2023 99 75 85 62
S2025 -1 92 67 52
S1909 100 83 45 -1
The file stores data as a text table shown above. Data fields are separated by spaces and new lines. The first row contains course IDs and the first column contains student IDs. The first field in the data, the top left corner, shows the number of rows and the number of columns in one integer. For example ‘34’, the first digit 3 means there are 3 students in this table. The second digit 4 means there are 4 courses.
The table stores every student’s final results in those courses. Results are all integers. A result ‘-1’ means not enrolled in that course. A ‘0’ means the student did enrol but failed to receive any mark. characters in sources.txt will be treated as -1

program can read one more file which stores the information of courses offered by the school. Info includes course ID, course title and credit points. Assume all courses of the school appear in this file and in the first file (student results file). There is no duplicate or redundant courses.
courses.txt
C081 Mathematics 12
C082 Science 12
C083 English 24
C084 Technologies 6

program can produce a text file named as course_report.txt
Given the above courses.txt, course_report.txt should look like below. The fourth column is the number of enrolled students. The fifth column is the average score of each course.
course_report.txt
C081 Mathematics 12 2 99
C082 Science 12 3 83
C083 English 24 3 65
C084 Technologies 6 2 57

program can read one more file from command line. That file stores information about students, that includes student ID, name (no space between first name and last name, but an underscore) and age. You can assume all students appear in this file as well as in the first file (student results file). There is no duplicate records or empty records.
students.txt
S2023 Sue_Vaneer 14
S2025 Robin_Smith 13
S1909 Barry_Banks 15

program can produce a text file report named as student_report.txt
student_report.txt should look like below. The fourth column is the number of courses that student enrolled im. The fifth column is the average GPA. A course result of 80+ receives 4 GPA points. A result of 70-79 receives 3 points. A result in between 60-69 is 2 points. 50-59 gets 1 points. Under 50 has 0 points.
student_report.txt
S2023 Sue_Vaneer 14 54 3.55
S2025 Robin_Smith 13 42 2.42
S1909 Barry_Banks 15 48 2.0
