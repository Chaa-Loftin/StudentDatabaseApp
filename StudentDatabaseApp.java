package studentDatabaseApplication;
import java.util.Scanner;
public class StudentDatabaseApp {

	public static void main(String[] args) {
		
		
		// Ask how many new students the user would like to add
		
		System.out.print("Enter the number of students that you would like to enroll: ");
		Scanner input = new Scanner(System.in);
		int numOfStudents = input.nextInt();
		Student students[] = new Student[numOfStudents];
				
		// Create an array of objects for new students
		
		for ( int i = 0; i < numOfStudents; i++) {
			students[i] = new Student();
			students[i].enroll();
			students[i].payTuition();
			students[i].displayStudentInfo();
			
			
		}

	}

}
