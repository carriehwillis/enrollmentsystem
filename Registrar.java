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

	/**
	*	Create a registrar item.
	*/
	public Registrar()
	{
		scanner = new Scanner(System.in);
	}

	/**
	*	Prompt the user for information used to create the course and professor, then assign the professor to the course.
	*/
	public static void main()
	{
		System.out.println("====== COURSE DETAILS ======");
		Course course1 = new Course();
		System.out.println("====== PROFESSOR DETAILS ======");
		Teacher prof1 = new Teacher();
		course1.assignTeacher(prof1);
		System.out.println(prof1);
	}


}
