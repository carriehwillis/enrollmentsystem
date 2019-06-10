import java.util.*;
import java.util.regex.*;

/**
* A Person class to be used in a University enrollment program. Person is extended as Student and Teacher.
@version 1.2
@author Carrie Willis
*/

public class Person
{
    protected int id;
    protected String fName;
    protected String middle;
    protected String lName;
    private PeopleDatabase db;
    private Random random;
    protected Scanner scanner;

/**
*   Create a Person object based on user input.
*/
		public Person()
    {
        db = new PeopleDatabase();
        scanner = new Scanner(System.in);
        random = new Random();
        id = db.generateID();
        setFName();
        setLName();
    }

/**
 * Create a Person object.
 * @param fName First name
 * @param middle Middle name or initial
 * @param lName Last name
 **/

	public Person(String fName, String middle, String lName)
	{
		this.fName = fName;
		this.middle = middle;
		this.lName = lName;
	}

  public void setID(int id)
  {
    this.id = id;
  }
    public void setFName()
    {
        System.out.println("First name: ");
        String isFName = scanner.next();
        if(Pattern.matches("^[\\p{L} .'-]+$", isFName))
        {
            fName = isFName;
        }
        else
        {
            System.out.println("Invalid entry.");
            setFName();
        }
    }

    public void setMiddle()
    {
        System.out.println("Middle name:");
        System.out.println("For no middle name, press Enter.");
        String isMiddle = scanner.next();
        if(isMiddle.equals("") || isMiddle.equals(null))
        {
          middle = "";
        }
        else if(Pattern.matches("^[\\p{L} .'-]+$", isMiddle))
        {
            middle = isMiddle;
        }
        else
        {
            System.out.println("Invalid entry.");
            setMiddle();
        }
    }

    public void setLName()
    {
        System.out.println("Last name: ");
        String isLName = scanner.next();
        if(Pattern.matches("^[\\p{L} .'-]+$", isLName))
        {
            lName = isLName;
        }
        else
        {
            System.out.println("Invalid entry.");
            setLName();
        }
    }

    /**
    *   Get a Person's ID number
    @return An integer ID number
    */
    public int getID()
    {
        return id;
    }

    /**
    *   Get the Person's name
    @return First and last name
    */
    public String getName()
    {
        return fName + " " + lName;
    }

    public String toString()
    {
        String output = "";
        output += getName() + " (ID: " + id + ")";
        return output;
    }
}
