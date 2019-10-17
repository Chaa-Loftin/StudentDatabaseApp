package studentDatabaseApplication;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
	
	
	private String firstName;
	private String lastName;
	private int gradeYear;
	private ArrayList<String> courses = new ArrayList<String>();
	private String studentID; 
	private int tuitionBalance = 0;
	private static int courseCost = 600;
	private static int id = 1000;
	
	//constructor using name and year
	
	public Student() {
		Scanner input = new Scanner(System.in);
		
		//Prompt user to enter students firstName, lastName, and gradeYear
		
		
		System.out.print("Enter the student's first name: ");
		this.firstName = input.nextLine();
		
		System.out.print("Enter the student's last name: ");
		this.lastName = input.nextLine();
		
		System.out.print("\n1 - Freshman \n2 - Sophomore"
				+ "\n3 - Junior \n4 - Senior \nEnter Student class level: ");
		this.gradeYear = input.nextInt();
		
		// Set student's individual ID bases on gradeYear and static var
		
		setStudentID();
		
		// Display what we have so far
		
		System.out.println(firstName + " " + lastName + " " + gradeYear + " " + studentID);
		
		
		
		
	}
	
	// Generate id
	
	private void setStudentID() {
		
		// studentID will be equal to the gradeYear + the unique id
		// increase id each time in order to ensure that it's unique
		id++;
		this.studentID = gradeYear + "" + id;
		
		
	}

	//method to enroll in student in courses 
	
	public void enroll() {
		// use a while loop that will only stop when 0 is entered
		// Enter each course into arrayList after checking if it exists
		// increase Tuition
		
		
		while(true) {
			
			String course;
			
			System.out.print("Enter the course to enroll(enter Q to quit): ");
			
			Scanner input = new Scanner(System.in);
			course = input.nextLine();
			
			if(!course.equalsIgnoreCase("q") && !courses.contains(course)) {
				
				courses.add(course);
				tuitionBalance += courseCost;
				
				System.out.println("Success! New tuition balance is $" + tuitionBalance);
				System.out.println("The updated course list is " + courses);
				
				
			} else if(courses.contains(course)) {
				
				System.out.println("The student is already enrolled in this course");
				System.out.println("tuition balance is " + tuitionBalance);
				
				
			} else {
				System.out.println("Q has been entered. System will now exit. Tuition balance is " + tuitionBalance);
				break;
			}
			
			
		}
		
	}
	
	//method to view balance
	
	public int getBalance() {
		
		return this.tuitionBalance;
		
	}
	
	// A method to display the balance of Student
	
	public void viewBalance() {
		
		System.out.println("The balance for " + this.firstName + " " 
				+ this.lastName + " is " + this.getBalance());
	}
	
	//method to pay tuition and output new balance
	//payment must be an integer greater than zero
	
	public void payTuition() {
		
		System.out.print("Enter payment amount: ");
		Scanner input = new Scanner(System.in);
		int payment = input.nextInt();
		
		if (payment >= 0) {
			
			this.tuitionBalance -= payment;
			
		} else {
			System.out.println( "Balance must be greater than zero");
		}
		
		 System.out.println("Thank you for your payment of $" + payment
		  + ". The updated balance for " + this.firstName + " " + this.lastName + " is $"  + this.getBalance());
	}
	
	//method to display student name, ID, courses, and balance
	
	public void displayStudentInfo() {
		
		 		System.out.println("Name: " + this.firstName + " " + this.lastName + "\n" +
				"Grade Level: " + this.gradeYear + "\n" + 
				"ID: " + this.studentID + "\n" +
				"Courses: " + this.courses + "\n" + 
				"Balance " + this.getBalance());
				
	}

}

