public class EnrollmentProgram
{
  public EnrollmentProgram()
  {

  }

  /**
	*	Prompt the user for information used to create the course and professor,
	* then assign the professor to the course.
	*/
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
