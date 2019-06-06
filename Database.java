import java.util.*;

public class Database
{
  private HashMap<Course, Teacher> courseAssignments;
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

  //when a new course is created, add it to roster, and add the prof to the arraylist

  public synchronized void addToClass(Course course, Person person)
  {
    if(roster.get(course) != null)
    {
      roster.get(course).add(person);
    }
    else
    {
      ArrayList<Person> people = new ArrayList<Person>();
      people.add(person);
      roster.put(course, people);
    }
  }

  public void listPeople()
    {
        Iterator it = roster.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry<Course, ArrayList<Person>> entry = (Map.Entry<Course, ArrayList<Person>>) it.next();
            String people = "";
            for(Person person : entry.getValue())
            {
                people += person + "\n";
              }
                System.out.println(entry.getKey() + " = " + people);
         }
        }


  public boolean isUniqueID(int id)
  {

      return true;

  }

  private String printProf(Course course)
  {
    if(roster.get(course) != null)
    {
      return roster.get(course).toString();
    }
    else
    {
      return "No professor assigned to this course.";
    }
  }

  public void printRoster(Course course)
  {
    	System.out.println("Course: " + course);
  		System.out.println("Faculty: " + printProf(course));
  		System.out.println("Students enrolled: ");
  }

}
