import java.util.*;
import java.util.regex.*;

/**
* A Teacher class for use in a University enrollment system.
@version 1.2
@author Carrie Willis
*/

public class Teacher extends Person
{
      private String rank;
      // private String department;  <-- can use this in a future version with database queries!
      private Scanner scanner;

      //used for input validation
      private static final int maxDept = 50;
    /**
    * Create a Teacher object based entirely on user input
    */
    public Teacher()
    {
      super();
      scanner = new Scanner(System.in);
      // setDepartment();
      role = "faculty";
      setRank();

    }

    /**
     * Prompt the user for the faculty member's rank.
     * @return The rank of the faculty member.
     */
    //can be improved with enums
    public String setRank()
  	{
  		System.out.println("Select the faculty's rank:");
      System.out.println();
  		System.out.println("Enter 1 for Professor");
  		System.out.println("Enter 2 for Associate Professor");
  		System.out.println("Enter 3 for Assistant Professor");
  		String isRank = scanner.next();
  		isRank = isRank.trim();
  		if(validateRank(isRank) != null)
  		{
  			rank = validateRank(isRank);
  		}
  		else
  		{
  			System.out.println("Please enter one of the given options.");
  			setRank();
  		}
  		return rank;
  	}

    // public void setDepartment()
    // {
    //   System.out.println("What department does the faculty belong to?");
    //   String dept = scanner.nextLine();
    //   if(Pattern.matches(".*[a-zA-Z]+.*", dept) && (dept.length()>0 && dept.length() < maxDept + 1))
    //   {
    //     department = dept;
    //   }
    //   else
    //   {
    //     System.out.println("Invalid department name.");
    //     setDepartment();
    //   }
    // }

    /**
     * Overrides the toString() method to print the faculty member's
     * name, rank, and ID number.
     * @return The faculty member's rank, name, and ID number.
     */
    public String toString()
    {
      String output = "";
      output += rank + " " + getName() + " (ID: " + id + ")";
      return output;
    }

    // /**
    // * Get the department that the Teacher instructs for.
    // @return The Teacher's department
    // */
    // public String getDepartment()
    // {
    //     return department;
    // }

    /**
     * Validate that the rank input by the user is one of the accepted numbers.
     * @param selection The string that the user inputted.
     * @return The rank corresponding to the user's selection, or null if the selection is invalid.
     **/
    	public static String validateRank(String selection)
    	{
    		String rank = null;
    		if(selection.equals("1"))
    		{
    				rank = "Professor";
    		}
    		else if (selection.equals("2"))
    		{
    			rank = "Associate Professor";
    		}
    		else if (selection.equals("3"))
    		{
    			rank = "Assistant Professor";
    		}
    		else
    		{
    			rank = null;
    		}
    		return rank;
    	}
}
