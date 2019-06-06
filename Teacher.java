import java.util.*;

/**
* A Teacher class for use in a University enrollment system.
@version 1.2
@author Carrie Willis
*/

public class Teacher extends Person
{
      private String rank;
      private String department;
      private Scanner scanner;
    /**
    * Create Teacher object based entirely on user input
    */
    public Teacher()
    {
      super();
      scanner = new Scanner(System.in);
      setDepartment();
      setRank();

    }

    public String setRank()
  	{
  		System.out.println("Select the faculty's rank:");
      System.out.println();
  		System.out.println("Enter 1 for Professor");
  		System.out.println("Enter 2 for Associate Professor");
  		System.out.println("Enter 3 for Assistant Professor");
  		String isRank = scanner.next();
  		isRank = isRank.trim();
  		if(Validator.validateRank(isRank) != null)
  		{
  			rank = Validator.validateRank(isRank);
  		}
  		else
  		{
  			System.out.println("Please enter one of the given options.");
  			setRank();
  		}
  		return rank;
  	}

    public void setDepartment()
    {
      System.out.println("What department does the faculty belong to?");
      String dept = scanner.nextLine();
      if(Validator.validateDept(dept))
      {
        department = dept;
      }
      else
      {
        System.out.println("Invalid department name.");
        setDepartment();
      }
    }

    public String toString()
    {
      String output = "";
      output += rank + " " + getName() + " (ID: " + id + ")";
      return output;
    }

    /**
    * Get the department that the Teacher instructs for.
    @return The Teacher's department
    */
    public String getDepartment()
    {
        return department;
    }

}
