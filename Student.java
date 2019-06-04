public class Student extends Person
{
	private String major;

	public Student(String fName, String lName, String email, String major)
	{
		super(fName, lName, email);
		this.major = major;
	}

	public String getMajor()
	{
		return major;
	}
}