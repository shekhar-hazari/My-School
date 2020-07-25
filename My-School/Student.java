import java.util.*;
public class Student {
	
	// Variables to store student information
	private String studentID;
	private String name;
	private int age;
	
	// Variables to store courses taken by the student and marks in them
	private ArrayList<Course> courses = new ArrayList<Course>();
	private ArrayList<Integer> marks = new ArrayList<Integer>();
	
	// Constructor
	public Student(String studentID, String name, int age) {
		// TODO Auto-generated constructor stub
		this.studentID = studentID;
		this.name = name;
		this.age = age;
	}
	
	// Getter functions
	public String getStudentID(){
		return studentID;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	// Add course for a student
	public void addCourse(Course c) {
		this.courses.add(c);
	}
	
	// Add marks for the course
	public void addMarks(int marks) {
		this.marks.add(marks);
	}
	
	// Return Student information
	public String printStudent() {
		return(this.getStudentID() + " " + this.getName() + " " + this.getAge() + " " + this.totalCredits() + " " + String.format("%.2f", this.studentGPA()) + "\n");
	}
	
	// Return average marks of a student
	public int studentaverageMarks() {
		int sum = 0;
		int average = 0;
		for (int i = 0; i < this.marks.size(); i++) {
			sum = sum + this.marks.get(i);
		}
		if (sum > 0) {
			average = sum/this.marks.size();
			return average;
			}
		else return 0;
	}
	
	// Calculating GPA of student
	public float studentGPA() {
		float gpa = 0;
		for (int i = 0; i < this.marks.size(); i++) {
			if(this.marks.get(i) >= 80)
				gpa = gpa + (4 * this.courses.get(i).getCreditPoints());
			else if(this.marks.get(i) >= 70)
				gpa = gpa + (3 * this.courses.get(i).getCreditPoints());
			else if(this.marks.get(i) >= 60)
				gpa = gpa + (2 * this.courses.get(i).getCreditPoints());
			else if(this.marks.get(i) >= 50)
				gpa = gpa + (1 * this.courses.get(i).getCreditPoints());
			else
				gpa = gpa + (0 * this.courses.get(i).getCreditPoints());
		}
		return ( gpa/this.totalCredits());
	}
	
	// Total credits taken by s student
	public int totalCredits() {
		int totalCredits = 0;
		for(int i = 0; i < this.courses.size(); i++) {
			totalCredits = totalCredits + this.courses.get(i).getCreditPoints();
		}
		return totalCredits;
	}

}
