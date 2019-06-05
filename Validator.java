/**
*	A class used to validate information served by other classes, such as a name or ID number.
@version 1.0
@author Carrie Willis
*/

public class Validator
{

	/**
	*	Create a Validator object.
	*/
	public Validator()
	{

	}

	/**
	* Confirm that a name is valid (i.e., its length is non-zero and it has only letters in it.)
	@param name The name to be validated
	@return A boolean reflecting whether the name is valid
	*/
	public static boolean validateName(String name)
	{
		boolean isValid = false;
		if(name.length() > 0 && name.length() < 80)
		{
			isValid = true;
		}
		return isValid;
	}

	public static boolean validateCourseID(int id)
	{
		boolean isValid = false;
		if(id > 9999 && id < 100000)
		{
			isValid = true;
		}
		return isValid;
	}

	public static boolean validateCourseName(String name)
	{
		boolean isValid = false;
		if(name.length() > 0 && name.length() < 101)
		{
			isValid = true;
		}
		return isValid;
	}

	public static boolean validateCourseMax(int max)
	{
		boolean isValid = false;
		if(max > 9 && max < 201)
		{
			isValid = true;
		}
		return isValid;
	}

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
			rank = "Associate Professor";
		}
		else
		{
			rank = null;
		}
		return rank;
	}

}
