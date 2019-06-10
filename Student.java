import java.util.regex.*;

/**
* A Student class for use in a University enrollment system.
@version 1.2
@author Carrie Willis
*/

public class Student extends Person
{
	private String role;

	/**
	*	Create a Student based on user input.
	*/

	public Student()
	{
		super();
		// setMajor();
	}

	public Student(String fName, String middle, String lName)
	{
		super(fName, middle, lName);
		role = "student";
	}

}
