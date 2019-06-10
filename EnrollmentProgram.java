public class EnrollmentProgram
{
    private static CourseDatabase courseDB;
    private static PeopleDatabase peopleDB;

    public EnrollmentProgram()
    {

    }

    public static void main(String[] args)
    {
      courseDB = new CourseDatabase();
      peopleDB = new PeopleDatabase();
      System.out.println("Welcome to the CAESAR+ Enrollment System.");
      System.out.println("Please enter the information below to create a new course.");
      System.out.println();
      Course course1 = new Course();
      System.out.println("Please enter the information below to add a new faculty member for this course.");
      System.out.println();
      Teacher prof1 = new Teacher();
      courseDB.addToClass(course1, prof1);
      courseDB.printRoster(course1);
    }
}
