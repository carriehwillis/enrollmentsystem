import java.util.*;
import java.io.*;
import java.util.regex.*;

/**
* A class for University courses. Students are enrolled by the Student
* Enrollment System and added to a list of students in the course. The
* minimum number of students allowed in the class is half of the
* maximum number. The number of students enrolled is random.
@version 2.0
@author Carrie Willis
*/

public class Course
{
    //utilities and helper classes needed
    private Random random;
    private Scanner scanner;
    private Schedule schedule;
    protected Database database;

    //fields for basic course information
    private String courseID;
    private String courseName;
    private int maxStudents;
    private int enrollNo;
    private ArrayList<Person> students;
    private ArrayList<Person> faculty;

    //for location data specifically
    private String location;
    private String sched;
    private String startTime;
    private String endTime;

    //sets the limits on character count for user inputs
    //these can be tuned according to the school's preferences
    private static final int maxCourseName = 60;
    private static final int courseMin = 5;
    private static final int courseMax = 200;

  /**
  * Create a new Course object entirely based on user input.
  */
  public Course()
  {
      random = new Random();
      scanner = new Scanner(System.in);
      schedule = new Schedule();
      database = new Database();

      students = new ArrayList<Person>();
      faculty = new ArrayList<Person>();

      promptUser();
      getDetailedInfo();
  }

  /**
   * Prompts the user for all relevant information needed for a course.
   */
public void promptUser()
{
  setCourseID();
  setCourseName();
  setMax();
  System.out.println("Course created.");
  System.out.println();
  setScheduleInfo();
}
  /**
    * Prompt the user for the course ID number.
    */
    public void setCourseID()
    {
        System.out.println("Please enter a 5-digit course ID number: ");
    String isID = scanner.next();
        if(Database.courseIDExists(isID))
    {
      System.out.println("The course ID number " + isID + " is taken.");
      setCourseID();
    }
    else
     if(Pattern.matches("\\d{5}", isID))
        {
            courseID = isID;
        }
        else
        {
            System.out.println("Course ID number must be 5 digits.");
            System.out.println();
      setCourseID();
        }
    }

/**
 * Get the ID number of the course.
 * @return The course ID.
 **/
  public String getCourseID()
  {
    return courseID;
  }

    /**
    * Get the course name from the user. Course name can contain letters, numbers,
    * and special characters, but must contain at least one letter.
    */
    public void setCourseName()
    {
        System.out.println("Please enter the course name:");
    scanner.nextLine();
    String isName = scanner.nextLine();
        //the logic behind this regex is to allow for course names such as "The Golden Age of Cinema: 1920-1935" but not "!!!!"
        if(Pattern.matches(".*[a-zA-Z]+.*", isName) && isName.length() > 0 && isName.length() < (maxCourseName + 1))
        {
            courseName = isName;
        }
        else
        {
            System.out.println("Invalid entry.");
      System.out.println("Course name must contain letters. It can also contain special characters.");
            System.out.println();
      setCourseName();
        }
    }

    /**
    *   Set the maximum number of students allowed in the course.
    */
    public void setMax() throws NumberFormatException
    {
        System.out.println("What is the maximum class size?");
    try
      {
        String input = scanner.next();
        int isMax = Integer.parseInt(input);
        if(isMax > (courseMin - 1) && isMax < (courseMax + 1))
        {
                maxStudents = isMax;
          calculateNumbers(maxStudents);
            }
            else
            {
          System.out.println("Maximum class size must be between " + courseMin + " and " + courseMax + " students.");
                System.out.println();
          setMax();
          }
      }
    catch(NumberFormatException e)
    {
      System.out.println("Please enter only numbers. Try again.");
      System.out.println();
      setMax();
    }
    }

    /**
     * References the Schedule helper object to set information
     * about when the course meets.
     */
  public void setScheduleInfo()
  {
    String days = schedule.setDays();
    String startTime = schedule.setStartTime();
    String endTime = schedule.setEndTime();
    sched = days + "\t" + startTime + "-" + endTime;
    location = schedule.setRoom();
  }

  /**
  * Calculates the minimum course size, maximum course size,
  * and randomly selects the number of students enrolled.
  @param max Maximum number of students able to enroll
  */
  public void calculateNumbers(int max)
  {
    int min = (maxStudents / 2);
    enrollNo = random.nextInt((maxStudents + 1) - min) + min;
  }

  /**
   * Returns the number of students enrolled.
   * @return The number of students enrolled in the course.
   */
  public int getEnrollNo()
  {
    return enrollNo;
  }

  /**
   * Enroll a student in the course. The person must have "student" in their
   * list of roles in order to be added to the course.
   * @param person The person to be added to the course.
   */
  public void enroll(Person person)
  {
      //using .contains() here instead of .equals() to allow for future functionality where someone can be both a
      //faculty member and a student (for example, a prof is taking a class for fun or professional development)
    if(person.getRole().contains("student") == false)
    {
      System.out.println(person.getName() + " is not a student. They cannot enroll in the course.");
      System.out.println();
    }
    else if(students.contains(person))
    {
      System.out.println(person.getName() + " is already a member of " + toString() + ".");
      System.out.println();
    }
    else
    {
        students.add(person);
    }
  }

  /**
   * Add a faculty member to the course. Allows for multiple faculty members teaching one course.
   * @param person The faculty member to be added to the course.
   */
  //allowing for multiple faculty members in case a large lecture class needs/wants two profs
  public void addFaculty(Person person)
  {
    if(! person.getRole().contains("faculty"))
    {
      System.out.println(person.getName() + " is not a faculty member.");
      System.out.println("They cannot be added as faculty for this course.");
      System.out.println();
    }
    else if(faculty.contains(person))
    {
      System.out.println(person.getName() + " is already a member of " + toString() + ".");
      System.out.println();
    }
    else
    {
        faculty.add(person);
    }
  }

  /**
   * Prints a list of individuals, either faculty members or students.
   * @param list An ArrayList<> of type Person.
   */
  public String printList(ArrayList<Person> list)
  {
    String people = "";
    for (Person person : list)
    {
      people += person.toString() + "\n";
    }
    return people;
}

  /**
  * Generates a brief line of information on a course.
  @return Course ID, name, and professor assigned, in String format.
  */
    public String toString()
    {
        String info = courseName + " (Course ID: " + courseID + ")";
        info += "Faculty: \n" + printList(faculty);
        return info;
    }

  /**
  * Generates more detailed information on a course.
  * @return A string including the course ID and name, professor, number of
  * students enrolled, and names of enrolled students.
  */
    public void getDetailedInfo()
    {
        String info = "======== Course Information ========\n";
        info += "Course " + courseID + " - \t" + courseName + "\n";
        if(faculty.size() == 0)
        {
            info += "No faculty assigned.\n";
        }
        if(faculty.size() > 0)
        {
            info += "Faculty: \n" + printList(faculty);
        }
        info += sched + "\n";
        info += location + "\n";
        if(students.size() == 0)
        {
            info += enrollNo + " students can enroll.\n";
        }
        if(students.size() > 0)
        {
           info += enrollNo + " students enrolled:\n";
           info += printList(students);
        }
        System.out.println(info);
    }
}
