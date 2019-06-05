/**
* A Student class for use in a University enrollment system.
@version 1.2
@author Carrie Willis
*/

public class Student extends Person
{
	private String major;

	/**
	*	Create a Student.
	@param fName Student's first name
	@param lName Student's last name
	@param major Student's major
	*/
	public Student(String fName, String lName, String major)
	{
		super(fName, lName);
		this.major = major;
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
