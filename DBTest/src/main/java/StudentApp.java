import java.util.Scanner;

import exception.ServiceException;
import modals.Student;
import services.StudentService;

public class StudentApp {
	
	private static StudentService studentService;

	public static void main(String[] args) {
		
				

		
		String input=" ";
		
		do{
			displayOptions();
			
			Scanner sc=new Scanner(System.in);
			 input=sc.next();

			switch (input) {
			
			case "1":
				addStudent();
				break;
				
			case "x":
					
				break;

			default:
				System.out.println("Invalid Choice. Please try again..");
				break;
			}

		} while(!input.equalsIgnoreCase("x"));
		
		
	}
	
	public static void addStudent()
	{
		Student student=new Student();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the rollnumber:");
		student.setRollno(sc.nextInt());
		
		System.out.println("Enter the First name:");
		student.setFirstname(sc.nextLine());
		
		System.out.println("Enter the Lastname:");
		student.setLastname(sc.nextLine());
		
		System.out.println("Enter the Age:");
		student.setAge(sc.nextInt());
		
		System.out.println("Enter the City");
		
		try {
			student.setCity(sc.nextLine());
			studentService.save(student);
			System.out.println("Save the data successfully");
		} catch (ServiceException e) {
			
			System.out.println(e.getLocalizedMessage());
		}
		
	}
	
	public static void displayOptions()
	{
		System.out.println("Enter the choice..");
		
		System.out.println("1.Add Student");
		System.out.println("2.Edit Student");
		System.out.println("3.Delete Student");
		System.out.println("4.Display All Student");
		System.out.println("x.Exit");
		System.out.println("------------------------------------------");
	}

}
