import java.util.*;
import java.io.*;

/**
* The Database holds information about courses and people in the enrollment system.
* @version 2.0
* @author Carrie Willis
*/

public class Database
{
  private static ArrayList<Course> courses;
  private static ArrayList<Person> people;
  private static Random random;

/**
 * Create a new Database object.
 **/
  public Database()
  {
    courses = new ArrayList<Course>();
    people = new ArrayList<Person>();
    random = new Random();
  }

/**
 * Add a course to the course list.
 * @param course The course to add.
 */
  public static void addCourse(Course course)
  {
      courses.add(course);
  }

/**
 * Confirms whether a course ID number is already in use.
 * @param id The ID to verify
 * @return A boolean value representing whether the supplied ID exists
 */

 public static boolean courseIDExists(String id)
 {
   boolean found = false;
   if(courses.isEmpty() == false)
   {
       for(Course course : courses)
   {
       if(course.getCourseID() == id)
       {
         found = true;
        }
   }
  }
   return found;
 }

 /**
 *Generate a random user ID number between 0 and 999.
 @return An integer user ID number
 */
 public static int generateID()
 {
     random = new Random();
     int id = random.nextInt(999);
     if(userIDExists(id) == true)
     {
         generateID();
     }
     else
         {
          return id;
         }
     return id;
       }
/**
* Add a Person to the list of people.
* @param person A person to add.
**/
 public static void addPeople(Person person)
 {
   people.add(person);
 }

/**
* List all of the people in the database split out by students and faculty.
**/
 public static void listPeople()
 {
   ArrayList<Person> students = new ArrayList<Person>();
   ArrayList<Person> faculty = new ArrayList<Person>();
   for(Person person : people)
   {
       //here people who are both students and faculty would be listed twice, once in each area.
       //if the business noted that it's common for people to have multiple roles, we could
       //create a third category for these folks in a future version.
     if(person.getRole().contains("student"))
     {
       students.add(person);
     }
     if(person.getRole().contains("faculty"))
     {
       faculty.add(person);
     }
   }
   System.out.println(students.size() + " students in database:");
   System.out.println(students);
   System.out.println();
   System.out.println(faculty.size() + " faculty in database:");
   System.out.println(faculty);
 }

 /**
  * Checks the list of people in the database to see if a user ID is already taken.
  * @param id The randomly-generated ID
  * @return A boolean value reflecting whether the ID is already taken.
  */
public static boolean userIDExists(int id)
 {
   boolean found = false;
   if(people.isEmpty() == false)
   {
       for(Person person : people)
       {
         if(person.getID() == id)
         {
           found = true;
         }
       }
}
   return found;
 }
}
