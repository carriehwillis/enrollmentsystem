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
    protected String lName;
    private Random random;
    protected Scanner scanner;
    protected Database database;

/**
*   Create a Person object based on user input.
*/
		public Person()
    {
        scanner = new Scanner(System.in);
        random = new Random();
        database = new Database();
        setFName();
        setLName();
        generateID();
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
		Database.addPeople(this);
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
    *   Generate a random ID number between 0 and 999.
    @return An integer ID number
    */

    private void generateID()
    {
        int isID = random.nextInt(999);
        if(database.userIDExists(isID) == false)
        {
           id = isID;
        }
        else
            {
             generateID();
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
