/**
 *   A registrar system for use in a University enrollment system.
 *   @version 2.0
 *   @author Carrie Willis
 */

public class Registrar
{
    private static Database database;
    private static StudentEnrollmentSystem SES;

    /**
     * Create a Registrar item
     */
    public Registrar()
    {

    }

    /**
     * Prompt the user to create a new course, a new faculty member,
     * add the faculty member to the course, enroll as many students
     * as can be enrolled in the course, and then print the course roster.
     */
    public static void main(String[] args)
    {
      database = new Database();
      SES = new StudentEnrollmentSystem();
      System.out.println("Welcome to the CAESAR+ Enrollment System.");
      System.out.println("Please enter the information below to create a new course.");
      System.out.println();
      Course course1 = new Course();
      database.addCourse(course1);
      System.out.println("Please enter the information below to add a new faculty member for this course.");
      System.out.println();
      Teacher prof1 = new Teacher();
      course1.addFaculty(prof1);
      SES.enrollStudentByNumber(course1, course1.getEnrollNo());
      course1.getDetailedInfo();
    }
}
