import java.util.regex.*;

/**
* A Student class for use in a University enrollment system.
@version 1.2
@author Carrie Willis
*/

public class Student extends Person
{
    private String role;
    //private String major <-- can be used in a future version with database queries or to
    //                          auto-enroll students in specific classes based on major

    /**
    *   Create a Student based on user input.
    */

    public Student()
    {
        super();
        role = "student";
        // setMajor();
    }

    /**
     * Create a Student object.
     * @param fName The student's first name
     * @param middle The student's middle name
       * @param lName The student's last name
     */
    public Student(String fName, String middle, String lName)
    {
        super(fName, middle, lName);
        role = "student";
    }

    /**
     * Get a student's role.
     * @return The student's role at the University.
     */
    public String getRole()
    {
       return role;
    }
}
