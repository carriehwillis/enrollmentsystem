import java.util.*;
import java.util.regex.*;
/**
*	A class used to validate information served by other classes based on
* pre-determined rules.
@version 1.0
@author Carrie Willis
*/

public class Validator
{
	private static final int maxCharCourseName = 60;
	private static final int maxCharMajor = 40;
	private static final int maxCharDept = 50;
	private static final int courseMin = 5;
	private static final int courseMax = 200;

	/**
	*	Create a Validator object.
	*/
	public Validator()
	{

	}

/**
 * Return the minimum number of individuals allowed in a course, used for input validation.
 * @return The course minimum.
 **/
	public static int getCourseMin()
	{
		return courseMin;
	}

/**
 * Return the maximum number of individuals allowed in a course, used for input validation.
 * @return The course maximum.
 **/
	public static int getCourseMax()
	{
		return courseMax;
	}

/**
 * Return the maximum number of characters allowed in a course name, used for input validation.
 * @return The maximum number of characters allowed in a course name.
 **/
	public static int getMaxCourseName()
	{
		return maxCharCourseName;
	}

/**
 * Return the maximum number of characters allowed in a major, used for input validation.
 * @return The maximum number of characters allowed in major.
 **/
	public static int getMaxCharMajor()
	{
		return maxCharMajor;
	}

	public static int getMaxCharDept()
	{
		return maxCharDept;
	}

/**
*	Validate that a string has a length between 0 and a provided maximum length (inclusive)
@param string The string to validate
@param maxLength The maximum length (inclusive) to test against
*/
	private static boolean lengthValid(String string, int maxLength)
	{
		boolean isValid = false;
		if(string.length() > 0 && string.length() < (maxLength + 1))
		{
			isValid = true;
		}
		return isValid;
	}

/**
*	Verifies that the input has only non-numeric alphabetical characters.
*	Supports international names and characters such as hyphen, apostrophe, etc.
@param string A string to validate
@return A boolean value of whether or not the string meets the criteria.
*/
	private static boolean lettersOnly(String string)
	{
		boolean isValid = false;
		if (Pattern.matches("^[\\p{L} .'-]+$", string))
		{
			isValid = true;
		}
		return isValid;
	}

/**
 * Verifies that the input has at least one letter in it.
 * @param string A string to validate
 * @return A boolean value of whether or not the string meets the criteria
 **/
	private static boolean atLeastOneLetter(String string)
	{
		boolean isValid = false;
		if (Pattern.matches(".*[a-zA-Z]+.*", string))
		{
			isValid = true;
		}
		return isValid;
	}

	/**
	* Confirm that a first or last name is valid
	* (i.e., its length is non-zero and it has only letters in it.)
	@param name The name to be validated
	@return A boolean reflecting whether the name is valid
	*/
	public static boolean validateName(String name)
	{
		boolean valid = (name.length()>0 && lettersOnly(name));
		return valid;
	}

	/**
	* Confirm that a major is valid (i.e., its length is non-zero and it has only letters in it.)
	@param major The name to be validated
	@return A boolean reflecting whether the major matches the criteria.
	*/
	public static boolean validateMajor(String major)
	{
		boolean isValid = (lengthValid(major, maxCharMajor) && lettersOnly(major));
		return isValid;
	}

	/**
	* Confirm that a department name is valid (i.e., its length is non-zero and it has only letters in it.)
	@param dept The name to be validated
	@return A boolean reflecting whether the department name matches the criteria.
	*/
	public static boolean validateDept(String dept)
	{
		boolean isValid = (lengthValid(dept, maxCharDept) && lettersOnly(dept));
		return isValid;
	}

	/**
	*	Validates that a course ID is 5 digits.
	@param id The course ID provided
	@return A boolean reflecting whether the course ID matches the criteria.
	*/
	public static boolean validateCourseID(String id)
	{
		boolean isValid = false;
		if(Pattern.matches("\\d{5}", id))
		{
			isValid = true;
		}
		return isValid;
	}

/**
 * Validate that a course name has a valid length (between 0 and the course name maximum.)
 * @param name The name of the course
 * @return A boolean representing whether the criteria are met.
 **/
	public static boolean validateCourseName(String name)
	{
		boolean isValid = false;
		if(lengthValid(name, maxCharCourseName) && atLeastOneLetter(name))
		{
			isValid = true;
		}
		return isValid;
	}

/**
 * Validate that the maximum number of students allowed in a course is between the
 * approved minimum and maximum student numbers.
 * @param max The maximum number of students suggested by the user
 * @return A boolean representing whether the criteria are met.
 **/
	public static boolean validateCourseMax(int max)
	{
		boolean isValid = false;
		if(max > (courseMin - 1) && max < (courseMax + 1))
		{
			isValid = true;
		}
		return isValid;
	}

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
