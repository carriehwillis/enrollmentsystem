import java.util.*;
import java.io.*;

/**
* The Database holds information about courses, teachers, students, and the relationships between these objects.
* @version 1.2
* @author Carrie Willis
*/

public class Database
{
  private HashMap<Course, ArrayList<Person>> roster;
  private ArrayList<Person> people;
  private Iterator it;

/**
 * Create a new Database object.
 **/
  public Database()
  {
    roster = new HashMap<Course, ArrayList<Person>>();
    people = new ArrayList<Person>();
  }

/**
 * Add a newly-created Person to the list of people.
 * @param person A person to add.
 **/
  public void addPeople(Person person)
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

  public synchronized void addToClass(Course course, Person person)
  {
    //check to see if the person is already listed in the course
    if(roster.get(course) != null && searchCourse(course, person) == false)
    {
      roster.get(course).add(person);
    }
    else if(roster.get(course) != null && searchCourse(course, person))
    {
      System.out.println(person.getName() + " is already a member of " + course.toString());
      System.out.println();
    }
    //create a roster for a course that doesn't have one yet
    else
    {
      ArrayList<Person> people = new ArrayList<Person>();
      people.add(person);
      roster.put(course, people);
    }
  }

public boolean isUniqueID(int id)
  {
      //search the list of people in the people list (btw Person class needs to add to the database as part of constructor)
      //anyway search the lsit of people in the people list using .getID() . if it returns true, (and this is back in the generateID() method in Person),
      //then retry generateID().
      return true;

      }

/**
 * Search a course to see if a person is already enrolled in/teaching it.
 * @param course The course to check
 * @param person The person to search for
 * @return A boolean value representing whether the person was found in the course
 **/
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
