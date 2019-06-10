import java.util.*;
import java.util.regex.*;

/**
* A Person class to be used in a University enrollment program. Person is extended as Student and Teacher.
@version 1.3
@author Carrie Willis
*/

public class Person
{
    //utilities
    private Random random;
    protected Scanner scanner;

    //fields
    protected int id;
    protected String fName;
    protected String middle;
    protected String lName;
    protected String role;
    protected ArrayList<Person> people;

    //just need this to make sure the class can access static methods
    protected Database database;

/**
*   Create a Person object based on user input.
*/
    public Person()
    {
        people = new ArrayList<Person>();
        scanner = new Scanner(System.in);
        random = new Random();
        database = new Database();
        id = Database.generateID();
        setFName();
        setMiddle();
        setLName();
        Database.addPeople(this);
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
    id = Database.generateID();
	}

	/**
	 * Allows for setting a new ID if the first randomly-generated one
	 * was taken by another user.
	 */
  public void setID(int id)
  {
    this.id = id;
  }

  /**
   * Prompts the user to set the person's first name.
   */
    public void setFName()
    {
        System.out.println("First name: ");
        String isFName = scanner.next();
        //this regex covers letters in all scripts, including punctuation.
        //This allows for names like François, Müller, and Ja'Nelle.
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

    /**
     * Prompt the user for the person's middle name.
     */
    public void setMiddle()
    {
        System.out.println("Middle name:");
        System.out.println("For no middle name, press Enter.");
        scanner.nextLine();
        String isMiddle = scanner.nextLine();
        if(isMiddle.isEmpty() || isMiddle.equals(null))
        {
          middle = null;
        }
        //this regex covers letters in all scripts, including punctuation.
        //This allows for names like François, Müller, and Ja'Nelle.
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
        //this regex covers letters in all scripts, including punctuation.
        //This allows for names like François, Müller, and Ja'Nelle.
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
    @return First, middle (if applicable), and last name.
    */
    public String getName()
    {
      if(middle != null)
      {
        return fName + " " + middle + " " + lName;
      }
      else
      {
        return fName + " " + lName;
      }
    }

    /**
     * Get the user's role (faculty or student)
     * @return The user's role at the University.
     */
    //can be expanded in the future to other types of roles, like staff!
    public String getRole()
    {
      return role;
    }

    /**
     * Overrides the toString() method to print the user's ID name name.
     * @return The user's name and ID number.
     */
    public String toString()
    {
        String output = "";
        output += getName() + " (ID: " + id + ")";
        return output;
    }
}
