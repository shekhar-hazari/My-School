// Import Libraries
import java.util.ArrayList;

public class School {
	// Variables to store courses and students in school
	private ArrayList<Course> courses = new ArrayList<Course>();
	private ArrayList<Student> students = new ArrayList<Student>();

	public School() {
		// TODO Auto-generated constructor stub
	}
	
	// Add course to school
	public void addCourse(Course c) {
		this.courses.add(c);
	}
	
	// Add student to school
	public void addStudent(Student s) {
		this.students.add(s);
	}
	
	// Getter functions
	public Student getStudent(String sID) {
		boolean found = false;
		int index = 0;
		for (int i = 0; i < this.students.size(); i++) {
			if(sID.equals(this.students.get(i).getStudentID())) {
				found = true;
				index = i;
				break;
			}
		}
		if (found)
			return this.students.get(index);
		else return null;
	}
	
	public Course getCourse(String cID) {
		boolean found = false;
		int index = 0;
		for (int i = 0; i < this.courses.size(); i++) {
			if(cID.equals(this.courses.get(i).getCourseID())) {
				found = true;
				index = i;
				break;
			}
		}
		if (found)
			return this.courses.get(index);
		else return null;
	}
	
	// Adding a score to both courses and students
	public void addScore(String courseID, String studentID, int marks) {
		Course course = this.getCourse(courseID);
		Student student = this.getStudent(studentID);
		if (course != null && student != null) {
			student.addCourse(course);
			student.addMarks(marks);
			course.addStudent(student);
			course.addMarks(marks);
		}
	}
	
	// Return course information
	public String printCourses() {
		String s = "";
		for (int i = 0; i < this.courses.size(); i++) {
			s = s + (courses.get(i).printCourse());
		}
		return(s);
	}
	
	// Return students information
	public String printStudents() {
		String s = "";
		for (int i = 0; i < this.students.size(); i++) {
			s = s + (students.get(i).printStudent());
		}
		return s;
	}
	
	// Function to print top student on console
	public void topStudent() {
		int maxAverage = 0;
		int index = 0;
		for (int i = 0; i < this.students.size(); i++) {
			if (maxAverage < this.students.get(i).studentaverageMarks()) {
				maxAverage = this.students.get(i).studentaverageMarks();
				index = i;
			}
		}
		System.out.println("The top student is " + this.students.get(index).getStudentID() + " with an average " + maxAverage);
	}

}