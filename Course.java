import java.util.*;

/**
* A class for University courses. Students are enrolled and appended to a list of students in the class. A single Teacher is assigned. The minimum number of students allowed in the class is half of the maximum number. The number of students enrolled is random.
@version 1.2
@author Carrie Willis
*/

public class Course
{
    private Validator validator;
    private Random random;
    private Scanner scanner;
    private int courseID;
    private String courseName;
    // private String department;
    // private int courseNo;
    // private int credits;
    // private int year;
    // private String quarter;
    private int maxStudents;
    private int enrollNo;
    private Teacher teacher;

    // private ArrayList<Student> students;
  //
  // /**
  // * Create a course.
  // @param name The name of the course
  // @param department The department sponsoring the course
  // @param courseNo The course number in the course catalog
  // @param credits The number of credits earned by completing the course
  // @param quarter The academic quarter (Fall, Winter, Spring, Summer) in which the course takes place
  // @param maxStudents The maximum number of students enrolled in the course.
  // */
  //   public Course(int id, String name, String department, int courseNo, int credits, int year, String quarter, int maxStudents)
  //   {
  //       scanner = new Scanner(System.in);
  //       students = new ArrayList<Student>();
  //       this.id = id;
  //       this.name = name;
  //       this.department = department;
  //       this.courseNo = courseNo;
  //       this.credits = credits;
  //       this.year = year;
  //       this.quarter = quarter;
  //       this.max = maxStudents;
  //       teacher = null;
  //       // id = generateID();
  //   }

  /**
  * Create a course based entirely on user input.
  */
  public Course()
  {
      validator = new Validator();
      random = new Random();
      scanner = new Scanner(System.in);
      setCourseID();
      setCourseName();
      setMax();
  }
  /**
	* Get the ID number of the course from the user.
	*/
	public void setCourseID()
	{
		System.out.println("Please enter a 5-digit course ID number: ");
		int isID = scanner.nextInt();
		if(validator.validateCourseID(isID))
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
		System.out.println("Please enter the course name: ");
		scanner.nextLine();
    String isName = scanner.nextLine();
		if(validator.validateCourseName(isName))
		{
			courseName = isName;
		}
		else
		{
			System.out.println("Please enter a course name.");
			setCourseName();
		}
	}

	/**
	*	Set the max, minimum, and number of students in the course.
	*/
	public void setMax()
	{
		System.out.println("What is the maximum number of students for this course?");
		String input = scanner.next();
    int isMax = Integer.parseInt(input);
		if(validator.validateCourseMax(isMax))
		{
			maxStudents = isMax;
      calculateNumbers(maxStudents);
		}
		else
		{
			System.out.println("Maximum number of students must be at least 10 and at most 200.");
			setMax();
		}
	}

  /**
  * Calculates the minimum number of students in the class and the number of students enrolled.
  @param max Maximum number of students able to enroll
  */
  public void calculateNumbers(int max)
  {
    int min = (maxStudents / 2);
    enrollNo = random.nextInt((maxStudents + 1) - min) + min;
  }


  // /**
  // *  Generates a course ID based on the year, quarter, department name, and course number. Example: 2019SP-MAT101. Needs to be modified to use a specific pre-determined code rather than the first 3 characters.
  // @return A course ID in String format.
  // */
  //   public String generateID()
  //   {
  //       String catID = "" + year + quarter.substring(0,2).toUpperCase() + "-";
  //       catID += department.substring(0,3).toUpperCase() + courseNo;
  //       return catID;
  //   }

  // /**
  // * Enrolls a student in a course and adds the course to the student's list of courses.
  // @param student A student to enroll in the course.
  // */
  //   public void enroll(Student student)
  //   {
  //       students.add(student);
  //       student.addCourse(this);
  //   }

  /**
  * Assigns a teacher to a course. Only one teacher is accepted per course.
  @param teacher The teacher assigned to a course.
  */
    public void assignTeacher(Teacher teacher)
    {
        this.teacher = teacher;
    }

  /**
  * Generates a brief line of information on a course.
  @return Course ID, name, and teacher assigned, in String format.
  */
    public void getInfo()
    {
        String info = courseName + " (" + courseID + ")\n";
        info += "Teacher: " + teacher + "\n";
        System.out.println(info);
    }

  /**
  * Generates more detailed information on a course.
  @return A string including the course ID and name, teacher, and number of students enrolled.
  */
    public void getDetailedInfo()
    {
        String info = "======== Course Information ========\n";
        info += "Course " + courseID + "- \t" + courseName + "\n";
        info += "Teacher: " + teacher + "\n";
        info += enrollNo + " students enrolled.\n";
        // info += students.size() + " students enrolled:\n";
        // info += listStudents();
        System.out.println(info);
    }

  // /**
  // *  Print the name of all students in a course.
  // @return A list of the names of students enrolled in a course.
  // */
  //   public String listStudents()
  //   {
  //       String stds = "";
  //       for(Student student : students)
  //       {
  //           stds += student.getName() + "\n";
  //       }
  //       return stds;
  //   }
}
