public class EnrollmentProgram
{
    public EnrollmentProgram()
    {

    }

    public static void main(String[] args)
    {
      System.out.println("Welcome to the CAESAR+ Enrollment System.");
      System.out.println("Please enter the information below to create a new course.");
      System.out.println();
      Course course1 = new Course();
      System.out.println("Please enter the information below to add a new faculty member for this course.");
      System.out.println();
      Teacher prof1 = new Teacher();
      Database.addToClass(course1, prof1);
      Database.printRoster(course1);
    }
}
