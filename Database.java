import java.util.*;
import java.io.*;

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


  public void addPeople(Person person)
  {
    people.add(person);
  }

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

  // public void loadStudents()
  // {
    // File file = "enrollment.txt";
    // BufferedReader reader = new BufferedReader(FileReader(file));

  // }

  //when a new course is created, add it to roster, and add the prof to the arraylist

  public synchronized void addToClass(Course course, Person person)
  {
    if(roster.get(course) != null && searchCourse(course, person) == false)
    {
      roster.get(course).add(person);
    }
    else if(roster.get(course) != null && searchCourse(course, person))
    {
      System.out.println(person.getName() + " is already a member of " + course.toString());
      System.out.println();
    }
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

  private int getClassSize(Course course)
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

  public void printRoster(Course course)
  {
        System.out.println("Course: " + course);
        System.out.println("Faculty: " + printProf(course));
        System.out.println();
        System.out.println(getClassSize(course) + " students enrolled:");
        System.out.println(printStudents(course));
  }

}
