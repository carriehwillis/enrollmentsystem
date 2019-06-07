import java.util.*;
import java.io.*;

/**
* The Database holds information about courses, teachers, students, and the relationships between these objects.
* @version 1.2
* @author Carrie Willis
*/

public class Database
{
  private static HashMap<Course, ArrayList<Person>> roster;
  private static ArrayList<Person> people;
  private Iterator it;
  private static Scanner scanner;

/**
 * Create a new Database object.
 **/
  public Database()
  {
    roster = new HashMap<Course, ArrayList<Person>>();
    people = new ArrayList<Person>();
    scanner = new Scanner(System.in);
  }

/**
 * Add a newly-created Person to the list of people.
 * @param person A person to add.
 **/
  public static void addPeople(Person person)
  {
    people.add(person);
  }

/**
 * List all of the people in the database split out by students and faculty.
 **/
  public void listPeople()
  {
    ArrayList<Person> students = new ArrayList<Person>();
    ArrayList<Person> faculty = new ArrayList<Person>();
    for(Person person : people)
    {
      if(person instanceof Student)
      {
        students.add(person);
      }
      if(person instanceof Teacher)
      {
        faculty.add(person);
      }
    }
    System.out.println("Students in database:");
    System.out.println(students);
    System.out.println("Faculty in database:");
    System.out.println(faculty);
  }


/**
 * Add a person to the course roster. If the roster doesn't exist for a course, create one.
 * @param course The course the person should be added to
 * @param person The person to add to the course roster
 **/

  public static synchronized void addToClass(Course course, Person person)
  {
    //check to see if the person is already listed in the course
    if(searchCourse(course, person))
    {
      System.out.println(person.getName() + " is already a member of " + course.toString());
      System.out.println();
    }
    if(person instanceof Teacher && getNumberFaculty(course) > 0)
    {
        verifyAdd(course, person);
    }
    else if(roster.get(course) != null)
    {
      roster.get(course).add(person);
    }
    //create a roster for a course that doesn't have one yet
    else
    {
      ArrayList<Person> people = new ArrayList<Person>();
      people.add(person);
      roster.put(course, people);
    }
  }

/**
 * If a course already has a faculty member, verify that the user wants to add another faculty member.
 * Supports courses with multiple professors.
 * @param course The course the user is trying to add faculty to
 * @param person The faculty member to add (if confirmed)
 **/
public static void verifyAdd(Course course, Person person)
{
  System.out.println(printProf(course) + "is already assigned to " + course.toString() + ".");
  System.out.println("Are you sure you want to add " + person.toString() + " as an additional faculty member for this course?");
  System.out.println("Enter Yes or No.");
  String response = scanner.nextLine();
  if(response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y"))
  {
    roster.get(course).add(person);
    System.out.println(person.toString() + " added as additional faculty member to " + course.toString());
   }
  else if(response.equalsIgnoreCase("no") || response.equalsIgnoreCase("n"))
  {
    System.out.println("Function cancelled. " + person.getName() + " was NOT added to " + course.toString() + ".");
  }
  else
  {
    System.out.println("Please enter either Yes or No.");
    verifyAdd(course, person);
  }
}
/**
 * Confirms whether a randomly-generated user ID number is in use by another person.
 * @param id The ID to verify
 * @return A boolean value representing whether the supplied ID exists
 *
 */

public static boolean userIDExists(int id)
  {
    boolean found = false;
    for(Person person : people)
    {
      if(person.getID() == id)
      {
        found = true;
      }
    }
    return found;
  }

public static boolean courseIDExists(int id)
{
  boolean found = false;
  // Iterator it = roster.EntryMap().iterator();
  // while(it.hasNext())
  // {
    // if(roster.get(course) != null)
    // {
      // if(it.getValue(course).contains(person))
      // {
        // found = true;
      // }
    // }
  // }
  return found;
}
/**
 * Search a course to see if a person is already enrolled in/teaching it.
 * @param course The course to check
 * @param person The person to search for
 * @return A boolean value representing whether the person was found in the course
 */
  private static boolean searchCourse(Course course, Person person)
  {
     boolean found = false;
     if(roster.get(course) != null)
     {
       if(roster.get(course).contains(person))
       {
         found = true;
       }
     }
     return found;
  }

/**
 * Return the name of the faculty teaching the course. If there are multiple, returns comma-separated names.
 * @param course The course to print faculty information for
 * @return The list of faculty associated with a course
 **/
  private static String printProf(Course course)
  {
    if(roster.get(course) != null)
    {
        String faculty = "";
        for(Person person : roster.get(course))
        {
          if(person instanceof Teacher)
          {
            //adds a comma between faculty members if there are more than one
            if(faculty.length() > 1)
            {
              faculty += ", ";
            }
            faculty += person.toString();
          }
        }
        return faculty;
    }
    else
    {
      return "No professor assigned to this course.";
    }
  }

/**
 * Return the names of students enrolled in a course, separated by a new line.
 * @param course The course to get enrollment information from
 * @return A list of students
 **/
  private static String printStudents(Course course)
  {
    if(roster.get(course) != null)
    {
        String students = "";
        for(Person person : roster.get(course))
        {
            if(person instanceof Student)
            {
                students += person.toString() + "\n";
            }
        }
        return students;
    }
    else
    {
      return "";
    }
  }

/**
 * Get the number of students enrolled in a class.
 * @param course The course to check for enrollment size
 * @return An integer value corresponding to the total number of students enrolled in the class.
 **/
  private static int getNumberStudents(Course course)
  {
    if(roster.get(course) != null)
    {
        int studentNo = 0;
        for(Person person : roster.get(course))
        {
            if(person instanceof Student)
            {
                studentNo++;
            }
        }
        return studentNo;
      }
    else
    {
      return 0;
    }
  }

  /**
   * Get the number of faculty members associated with a class.
   * @param course The course to check for faculty number
   * @return An integer value corresponding to the total number of faculty associated with the class.
   **/
  private static int getNumberFaculty(Course course)
  {
    if(roster.get(course) != null)
    {
        int facNo = 0;
        for(Person person : roster.get(course))
        {
            if(person instanceof Teacher)
            {
                facNo++;
            }
        }
        return facNo;
      }
    else
    {
      return 0;
    }
  }

/**
 * Prints the course roster for a single course, including the  course name, any faculty involved,
 * and all students enrolled.
 * @param course The course to print information on.
 **/
  public static void printRoster(Course course)
  {
        System.out.println("Course: " + course);
        System.out.println("Faculty: " + printProf(course));
        System.out.println();
        System.out.println(getNumberStudents(course) + " students enrolled:");
        System.out.println(printStudents(course));
  }

}
