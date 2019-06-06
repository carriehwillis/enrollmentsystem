import java.util.*;

/**
* A class for University courses. Students are enrolled and appended to a list of students in the class.
* A single professor is assigned. The minimum number of students allowed in the class is half of the maximum number. The number of students enrolled is random.
@version 1.2
@author Carrie Willis
*/

public class Course
{
    private Random random;
    private Scanner scanner;
    private String courseID;
    private String courseName;
    private int maxStudents;
    private int enrollNo;

  /**
  * Create a new Course object based on user input.
  */
  public Course()
  {
      random = new Random();
      scanner = new Scanner(System.in);
      setCourseID();
      setCourseName();
      setMax();
      System.out.println("Course created.");
      getDetailedInfo();
  }
  /**
	* Prompt the user for the course ID number.
	*/
	public void setCourseID()
	{
		System.out.println("Please enter a 5-digit course ID number: ");
    String isID = scanner.next();
		if(Validator.validateCourseID(isID))
		{
			courseID = isID;
		}
		else
		{
			System.out.println("Course ID number must be 5 digits.");
			setCourseID();
		}
	}

	/**
	* Get the course name from the user.
	*/
	public void setCourseName()
	{
		System.out.println("Please enter the course name:");
		scanner.nextLine();
    String isName = scanner.nextLine();
		if(Validator.validateCourseName(isName))
		{
			courseName = isName;
		}
		else
		{
			System.out.println("Invalid entry.");
      System.out.println("Course name must contain letters. It can also contain special characters.");
			System.out.println();
      setCourseName();
		}
	}

	/**
	*	Set the max, minimum, and number of students in the course.
	*/
	public void setMax() throws NumberFormatException
	{
		System.out.println("What is the maximum class size?");
    try
      {
        String input = scanner.next();
        int isMax = Integer.parseInt(input);
    		if(Validator.validateCourseMax(isMax))
    		{
    			maxStudents = isMax;
          calculateNumbers(maxStudents);
    		}
    		else
    		{
          int min = Validator.getCourseMin();
          int max = Validator.getCourseMax();
          System.out.println("Maximum class size must be between " + min + " and " + max + " students.");
    			System.out.println();
          setMax();
  		  }
      }
    catch(NumberFormatException e)
    {
      System.out.println("Please enter only numbers. Try again.");
      System.out.println();
      setMax();
    }
	}

  /**
  * Calculates the minimum course size, maximum course size,
  * and randomly selects the number of students enrolled.
  @param max Maximum number of students able to enroll
  */
  public void calculateNumbers(int max)
  {
    int min = (maxStudents / 2);
    enrollNo = random.nextInt((maxStudents + 1) - min) + min;
  }

  /**
  * Generates a brief line of information on a course.
  @return Course ID, name, and professor assigned, in String format.
  */
    public String toString()
    {
        String info = courseName + " (Course ID: " + courseID + ")";
        return info;
    }

  /**
  * Generates more detailed information on a course.
  @return A string including the course ID and name, professor, and number of students enrolled.
  */
    public void getDetailedInfo()
    {
        String info = "======== Course Information ========\n";
        info += "Course " + courseID + " - \t" + courseName + "\n";
        info += enrollNo + " students can enroll.\n";
        // info += students.size() + " students enrolled:\n";
        // info += listStudents();
        System.out.println(info);
    }
}
