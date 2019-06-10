import java.util.*;
import java.io.*;

/**
* The PeopleDatabase holds information about people, including teachers and students.
* @version 1.0
* @author Carrie Willis
*/

public class PeopleDatabase
{
  private static ArrayList<Person> people;
  private static Random random;
  private Iterator it;
  private static Scanner scanner;

/**
 * Create a new Database object.
 **/
  public PeopleDatabase()
  {
    people = new ArrayList<Person>();
    random = new Random();
    scanner = new Scanner(System.in);
  }


  /**
  *Generate a random ID number between 0 and 999.
  @return An integer ID number
  */

  public int generateID()
  {
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

public boolean userIDExists(int id)
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

}
