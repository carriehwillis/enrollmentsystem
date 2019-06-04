import java.util.*;

public class Person
{
	protected int id;
	private String fName;
	private String lName;
	private String email;
	private Random random;
	protected ArrayList<Course> courses;


	public Person(String fName, String lName, String email)
	{
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		random = new Random();
		this.id = generateID();
		courses = new ArrayList<Course>();

	}

	private int generateID()
	{
		return random.nextInt(999);
	}

	public int getID()
	{
		return id;
	}

	public String getName()
	{
		return fName + " " + lName;
	}

	public String getEmail()
	{
		return email;
	}

	protected void addCourse(Course course)
	{
		courses.add(course);
	}

	public String getCourses()
	{
		String response = getName() + " is in the following courses: \n";
		for(Course course: courses)
        {
            response+= course.getInfo();
        }
        return response;
	}
}