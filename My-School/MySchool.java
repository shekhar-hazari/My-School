//Author: Shekhar Hazari
//Assignment Level: HD

//Importing Libraries
import java.util.*;
import java.io.*;

public class MySchool {
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		// Declare String variables to store file names
		String scoresFile = "";
		String coursesFile = "";
		String studentsFile = "";
		try{
			// Accepting command line arguments as file names
			scoresFile = args[0];
			coursesFile = args[1];
			studentsFile = args[2];
		}
		// If all three files are not passed in command line arguments
		catch(ArrayIndexOutOfBoundsException exc) {
			System.err.println("Check whether all 3 files are passed through command line arguments.");
			System.exit(0);
		}
		
		// Create three scanner streams to read files
		Scanner scoresFileInput = new Scanner(new File(scoresFile));
		Scanner coursesFileInput = new Scanner(new File(coursesFile));
		Scanner studentsFileInput = new Scanner(new File(studentsFile));
		
		// Two writer objects to create reports
		PrintWriter courseReportOutput = new PrintWriter (new BufferedWriter (new FileWriter ("course_report.txt") ));
		PrintWriter studentReportOutput = new PrintWriter (new BufferedWriter (new FileWriter ("student_report.txt") ));
		
		// Create school object
		School school = new School();
		
		// Variable to figure out number of students and number of courses from score.txt
		int info = 0;
		
		// Variable to store marks from score.txt
		int score = -1;
		
		// Read course file
		while(coursesFileInput.hasNext()) {
			try{
				String courseID = coursesFileInput.next();
				String courseTitle = coursesFileInput.next();
				int creditPoints = coursesFileInput.nextInt();
				Course c = new Course(courseID, courseTitle, creditPoints);
				school.addCourse(c);
				}
			catch(InputMismatchException exc) {
				// If creditPoints are any other type except for integer
				System.err.println("Please check credits of all courses (credits should be integer) in courses.txt");
				// Close all input and output streams and exit the program
				courseReportOutput.close();
				studentReportOutput.close();
				scoresFileInput.close();
				coursesFileInput.close();
				studentsFileInput.close();
				System.exit(0);
			}
			catch(NoSuchElementException exc) {
				System.err.println("Some descrepency in course.txt!! Please check all details of all courses are present");
				// If input is not found close all input and output streams
				courseReportOutput.close();
				studentReportOutput.close();
				scoresFileInput.close();
				coursesFileInput.close();
				studentsFileInput.close();
				System.exit(0);
			}
		}
		
		// Read students file
		while (studentsFileInput.hasNext()) {
			try{
				String studentID = studentsFileInput.next();
				String studentName = studentsFileInput.next();
				int age = studentsFileInput.nextInt();
				Student stu = new Student(studentID, studentName, age);
				school.addStudent(stu);
			}
			catch(InputMismatchException exc) {
				// If age is any other type except for integer
				System.err.println("Please check details of all students (ages should be integer) in students.txt");
				// Close all input and output streams and exit the program
				courseReportOutput.close();
				studentReportOutput.close();
				scoresFileInput.close();
				coursesFileInput.close();
				studentsFileInput.close();
				System.exit(0);
			}
			catch(NoSuchElementException exc) {
				// If input is not found close all input and output streams
				System.err.println("Some descrepency in students.txt!! Please check all details of all students are present");
				courseReportOutput.close();
				studentReportOutput.close();
				scoresFileInput.close();
				coursesFileInput.close();
				studentsFileInput.close();
				System.exit(0);
			}
		}
		
		// Reading first token from score.txt to figure out number of students and number of courses in score.txt
		try{info = scoresFileInput.nextInt();
		}
		// If any other token except for integer is read
		catch (InputMismatchException exc){
			// If a double/float is read convert it to integer
			if (scoresFileInput.hasNextDouble()) {
				info = (int) scoresFileInput.nextDouble();
				}
			// If a string token is read Exit program and tell user to check score.txt
			else if(scoresFileInput.hasNext()) {
				System.err.println("Please check the number of students and courses in scores.txt");
				courseReportOutput.close();
				studentReportOutput.close();
				scoresFileInput.close();
				coursesFileInput.close();
				studentsFileInput.close();
				System.exit(0);
			}
		}
		// Getting number of students and Courses from info
		int rows = info/10;
		int columns = info%10;
		
		// Create String arrays to store student IDs and course IDs in sequence which is read from file 
		String[] courseIDs = new String[columns];
		String[] studentIDs = new String[rows];
		
		// Reading course IDs from scores.txt in sequence
		for(int i = 0; i < columns; i++) {
			try{
				courseIDs[i] = scoresFileInput.next();
			}
			catch (NoSuchElementException exc) {
				System.out.println("Check number of students and courses in scores file!! These is some mistake.There is no " + (i+1) + " student.");
				System.err.println(exc);
				break;
			}
		}
		
		// Reading student IDs and scores for courses
		for(int i = 0; i < rows; i++) {
			
			for(int j = 0; j <= columns; j++) {
				// If first column is read store the student ID in array
				if(j == 0) {
					try{
						studentIDs[i] = scoresFileInput.next();
						}
					catch (NoSuchElementException exc) {
						System.out.println("Check number of students and courses in scores file!! These is some mistake.There is no " + (i+1) + " student.");
						System.err.println(exc);
						break;
					}
				}
				// If column is not first column, store marks
				else {
					 try{
						 score = scoresFileInput.nextInt();
					 }
					 // If anything else except for integer is read
					 catch (InputMismatchException exc) {
						 if (scoresFileInput.hasNextDouble()) {
							 score = (int) scoresFileInput.nextDouble();
						 }
						 else if (scoresFileInput.hasNext()) {
							 scoresFileInput.next();
							 score = -1;
						 }
					 }
					 // If no element is present
					 catch (NoSuchElementException exc) {
						 System.err.println(exc);
					 }
					 // If score is greater than -1 store it for the student and the course
					 if(score >= 0) {
						 school.addScore(courseIDs[j-1], studentIDs[i], score);
					 }
				}
			}
		}
		
		// Print top student
		school.topStudent();
		
		// Generate course report and close output stream
		courseReportOutput.print(school.printCourses());
		System.out.println("course_report.txt generated!");
		courseReportOutput.close();
		
		// Generate students_report and close output stream
		studentReportOutput.print(school.printStudents());
		System.out.println("student_report.txt generated!");
		studentReportOutput.close();
		
		// Close all output streams
		scoresFileInput.close();
		coursesFileInput.close();
		studentsFileInput.close();
	}
	
	
}