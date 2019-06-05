import java.util.*;

/**
* A Teacher class for use in a University enrollment system.
@version 1.2
@author Carrie Willis
*/

public class Teacher extends Person
{
      private String rank;
      private Scanner scanner;

    /**
    * Create a Teacher object.
    @param fName First name
    @param lName Last name
    @param rank Professor's Rank (Professor, Associate Professor, Assistant Professor)
    */
    public Teacher(String fName, String lName, String rank)
    {
        super(fName, lName);
        this.rank = rank;
    }

    /**
    * Create Teacher object based entirely on user input
    */
    public Teacher()
    {
      super();
    }


    // /**
    // * Return the Teacher's salary.
    // @return The teacher's salary
    // */
    // public double getSalary()
    // {
    //     return salary;
    // }
    //
    // /**
    // * Get the department that the Teacher instructs for.
    // @return The Teacher's department
    // */
    // public String getDepartment()
    // {
    //     return department;
    // }

}
