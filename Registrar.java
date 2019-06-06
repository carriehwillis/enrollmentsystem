import java.util.*;
import java.util.Scanner;

/**
*	A registrar system which creates courses and teachers based on user input.
@version 1.2
@author Carrie Willis
*/

public class Registrar
{
	private Scanner scanner;
	private Database database;

	/**
	*	Create a registrar item.
	*/
	public Registrar()
	{
		scanner = new Scanner(System.in);
		database = new Database();
	}

	public static void main()
	{
		System.out.println("Welcome to the CAESAR+ Enrollment System.");
		System.out.println("Please enter the information below to create a new course.");
		System.out.println()
		Course course1 = new Course();
		System.out.println("Please enter the information below to add a new faculty member for this course.");
		System.out.println();
		Teacher prof1 = new Teacher();
		database.addClass(course, prof);
		database.printRoster(course1);
	}
}


}
