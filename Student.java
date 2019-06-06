/**
* A Student class for use in a University enrollment system.
@version 1.2
@author Carrie Willis
*/

public class Student extends Person
{
	private String major;

	/**
	*	Create a Student based on user input.
	*/

	public Student()
	{
		super();
		setMajor();
	}

	public void setMajor()
	{
	  System.out.println("Please enter the student's major.");
	  scanner.nextLine();
	  String isMajor = scanner.nextLine();
	  if(Validator.validateMajor(isMajor))
	  {
	    major = isMajor;
	  }
	  else
	  {
	    System.out.println("Invalid entry.");
	    setMajor();
	  }
	}

	/**
	*	Get the student's major.
	@return The student's major.
	*/
	public String getMajor()
	{
		return major;
	}
}
