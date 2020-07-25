import java.util.*;
public class Course {
	
	// Variables to store course information
	private String courseID;
	private String courseTitle;
	private int creditPoints;
	
	// Arrays to store students of the course and their marks
	private ArrayList<Student> students = new ArrayList<Student>();
	private ArrayList<Integer> marks = new ArrayList<Integer>();
	
	// Constructor
	public Course(String courseID, String courseTitle, int creditPoints) {
		// TODO Auto-generated constructor stub
		this.courseID = courseID;
		this.courseTitle = courseTitle;
		this.creditPoints = creditPoints;
	}
	
	// Getter functions
	public String getCourseID() {
		return courseID;
	}
	
	public String getCourseTitle() {
		return courseTitle;
	}
	
	public int getCreditPoints() {
		return creditPoints;
	}
	
	// Add a student to course
	void addStudent(Student s) {
		this.students.add(s);
	}
	
	// Function to return number of students in course
	public int getNumberOfStudents() {
		return students.size();
	}
	
	// Add score to course
	public void addMarks(int marks) {
		this.marks.add(marks);
	}
	
	// Return Course information
	public String printCourse() {
		return(this.getCourseID() + " " + this.courseTitle + " " + this.getCreditPoints() + " " + this.students.size() + " " + this.courseAverageMarks() + "\n");
	}
	
	// Return average marks in course
	public int courseAverageMarks() {
		int sum = 0;
		int average = 0;
		for(int i = 0; i < this.marks.size(); i++) {
			sum = sum + this.marks.get(i);
		}
		if(this.marks.size() == 0) {
			System.out.println("Do not have any marks in the course. Please check the number of students and courses in scores.txt");
			System.exit(0);
		}
		else
			average = sum/this.marks.size();
		return average;
	}

}
