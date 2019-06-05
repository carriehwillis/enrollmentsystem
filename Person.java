import java.util.*;

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
	protected String rank;
	private Random random;
	protected Scanner scanner;

/**
*	Create a Person object.
@param fName First name
@param lName Last name
*/

	public Person(String fName, String lName)
	{
		random = new Random();
		String error = "";
		if(Validator.validateName(fName))
		{
			this.fName = fName;
		}
		else
		{
			error += "First name invalid.\n";
		}
		if(Validator.validateName(lName))
		{
			this.lName = lName;
		}
		else
		{
			error += "Last name invalid.\n";
		}
		random = new Random();
		generateID();
	}

	public Person()
	{
		scanner = new Scanner(System.in);
		random = new Random();
		setFName();
		setLName();
		generateID();
		if(this instanceof Teacher)
		{
			setRank();
		}
	}

	public void setFName()
	{
		String fName = "";
		System.out.println("Please enter the person's first name: ");
		String isFName = scanner.next();
		if(Validator.validateName(isFName))
		{
			fName = isFName;
		}
		else
		{
			System.out.println("Please enter a first name.");
			setFName();
		}
	}

	public void setLName()
	{
		String lName = "";
		System.out.println("Please enter the person's last name: ");
		String isLName = scanner.next();
		if(Validator.validateName(isLName))
		{
			lName = isLName;
		}
		else
		{
			System.out.println("Please enter a last name.");
			setLName();
		}
	}

	public String setRank()
	{
		System.out.println("Select the faculty's rank:");
		System.out.println("Enter 1 for Professor");
		System.out.println("Enter 2 for Associate Professor");
		System.out.println("Enter 3 for Assistant Professor");
		String isRank = scanner.next();
		isRank = isRank.trim();
		if(Validator.validateRank(isRank) != null)
		{
			rank = isRank;
		}
		else
		{
			System.out.println("Please enter one of the given options.");
			setRank();
		}
		return rank;
	}
	/**
	*	Generate a random ID number between 0 and 999.
	@return An integer ID number
	*/

	private void generateID()
	{
		id = random.nextInt(999);
	}

	/**
	*	Get a Person's ID number
	@return An integer ID number
	*/
	public int getID()
	{
		return id;
	}

	/**
	*	Get the Person's name
	@return First and last name
	*/
	public String getName()
	{
		return fName + " " + lName;
	}

	public String toString()
	{
		String output = "";
		output += "Personal Information:\n" + "Name: " + getName() +"\n";
		output += "ID number: " + id + "\n";
		return output;
	}
}
