import java.util.*;
import java.io.*;

/**
* The CourseDatabase holds information about courses.
* @version 1.0
* @author Carrie Willis
*/

public class CourseDatabase
{
  private static HashMap<Course, ArrayList<Person>> roster;
  private Iterator it;
  private static Scanner scanner;

/**
 * Create a new Database object.
 **/
  public CourseDatabase()
  {
    roster = new HashMap<Course, ArrayList<Person>>();
    scanner = new Scanner(System.in);
  }


  public static void addCourse(Course course)
  {
      ArrayList<Person> people = new ArrayList<Person>();
      roster.put(course, people);
  }
/**
 * Add a person to the course roster. If the roster doesn't exist for a course, create one.
 * @param course The course the person should be added to
 * @param person The person to add to the course roster
 **/

  public synchronized void addToClass(Course course, Person person)
  {
    //check to see if the person is already listed in the course
    if(searchCourse(course, person))
    {
      System.out.println(person.getName() + " is already a member of " + course.toString());
      System.out.println();
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
//
// /**
//  * If a course already has a faculty member, verify that the user wants to add another faculty member.
//  * Supports courses with multiple professors.
//  * @param course The course the user is trying to add faculty to
//  * @param person The faculty member to add (if confirmed)
//  **/
// public void verifyAdd(Course course, Person person)
// {
//   System.out.println(printProf(course) + "is already assigned to " + course.toString() + ".");
//   System.out.println("Are you sure you want to add " + person.toString() + " as an additional faculty member for this course?");
//   System.out.println("Enter Yes or No.");
//   String response = scanner.nextLine();
//   if(response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y"))
//   {
//     roster.get(course).add(person);
//     System.out.println(person.toString() + " added as additional faculty member to " + course.toString());
//    }
//   else if(response.equalsIgnoreCase("no") || response.equalsIgnoreCase("n"))
//   {
//     System.out.println("Function cancelled. " + person.getName() + " was NOT added to " + course.toString() + ".");
//   }
//   else
//   {
//     System.out.println("Please enter either Yes or No.");
//     verifyAdd(course, person);
//   }
// }

/**
 * Confirms whether a course ID number is already in use.
 * @param id The ID to verify
 * @return A boolean value representing whether the supplied ID exists
 *
 */

 public static boolean courseIDExists(String id)
 {
   boolean found = false;
   if(roster.isEmpty() == false)
   {
       for(Course course : roster.keySet())
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
  * Search a course to see if a person is already enrolled in/teaching it.
  * @param course The course to check
  * @param person The person to search for
  * @return A boolean value representing whether the person was found in the course
  */
   private boolean searchCourse(Course course, Person person)
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
   private String printProf(Course course)
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
   private String printStudents(Course course)
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
   private int getNumberStudents(Course course)
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
   private int getNumberFaculty(Course course)
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
   public void printRoster(Course course)
   {
         System.out.println("Course: " + course);
         System.out.println("Faculty: " + printProf(course));
         System.out.println();
         System.out.println(getNumberStudents(course) + " students enrolled:");
         System.out.println(printStudents(course));
   }
}
