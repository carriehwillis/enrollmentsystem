import java.util.*;
import java.util.Scanner;
import java.io.*;
import java.nio.file.*;
import java.nio.charset.Charset;

/**
*   A student registration system which creates courses and teachers based on user input.
@version 1.2
@author Carrie Willis
*/

public class StudentEnrollmentSystem
{
private Scanner scanner;
private ArrayList<Student> students;
// The file that lists the students.
private static final String ENROLLMENT = "enrollment.txt";

/**
*   Create a Student Enrollment System item.
*/
public StudentEnrollmentSystem()
{
    students = new ArrayList<Student>();
    loadStudents();
}

    /**
* Loads a list of student names from a file.
* @throws FileNotFoundException if the file is not found
* @throws IOException if the file cannot be read.
*/
public void loadStudents()
{
 Charset charset = Charset.forName("US-ASCII");
 Path path = Paths.get(ENROLLMENT);
 try(BufferedReader reader = Files.newBufferedReader(path, charset))
 {
     String line = reader.readLine();
     while(line != null)
     {
      parseNames(line);
      line = reader.readLine();
     }
  }
  catch(FileNotFoundException e) {
      System.err.println("Unable to open " + ENROLLMENT);
  }
  catch(IOException e) {
      System.err.println("A problem was encountered reading " +
                         ENROLLMENT);
  }
}

/**
 * Parses names in the file in order to handle names in different
 * formats, like Last, First.
 * @param A line of the file.
 */
public void parseNames(String line)
{
    String[] parts = line.split(" ");
    String fName = null;
    String middle = null;
    String lName = null;
    int size = parts.length;
    if (line.length() < 2)
        {
          //do nothing. this is to account for the empty first line in the .txt file.
        }
        else if(line.contains(","))
        {
            processCommaName(line);
        }
        else if(size > 2)
        {
            //if there are more than two parts of the name (First Last), handle
            //middle names.
            fName = parts[0];
            lName = parts[size - 1];
            middle = parts[1];
            //handles middle names and multiple names. In this version, names like
            //Anna Maria Vasquez Moreno would be read as Anna / Maria Vasquez / Moreno.
            //That isn't very culturally sensitive, and assumes a traditionally Western
            //Firstname Lastname format. If the names were manually input, users could
            //be more specific about how the names would be handled. There's room for
            //improvement here.
            for(int i=2; i <(size - 1); i++)
            {
                middle += " " + parts[i];
            }
            processStudent(fName, middle, lName);
        }
        else
        {
            fName = parts[0];
            middle = null;
            lName = parts[1];
            processStudent(fName, middle, lName);
        }

}

/**
 * Process names in Lastname, Firstname format.
 * @param line A line of the file.
 */
private void processCommaName(String line)
{
    String fName = null;
    String middle = null;
    String lName = null;
    String[] parts = line.split(" ");
    int size = parts.length;
    for(String name : parts)
    {
        if(name.contains(",") && parts[0] == name)
        {
            lName = name.substring(0, name.length()-1);
        }
    }
    if(size == 2)
    {
        fName = parts[1];
        middle = "";
    }
    if(size > 2)
    {
        fName = parts[1];
        middle = parts[2];
        //handles middle names and multiple names. In this version, names like
            //Anna Maria Vasquez Moreno would be read as Anna / Maria Vasquez / Moreno.
            //That isn't very culturally sensitive, and assumes a traditionally Western
            //Firstname Lastname format. If the names were manually input, users could
            //be more specific about how the names would be handled. There's room for
            //improvement here.
        for(int i=3; i < (size); i++)
        {
             middle += parts[i] + " ";
        }
    }
    processStudent(fName, middle, lName);
}

/**
 * Creates new students and adds them to the list of students
 * to be enrolled into new classes.
 * @param fName The student's first name
 * @param middle The student's middle name
 * @param lName The student's last name
 */
private void processStudent(String fName, String middle, String lName)
{
    Student student = new Student(fName, middle, lName);
    students.add(student);
}

/**
 * Enroll the student in a course.
 * @param course The course to enroll the student in
 * @param student The student to enroll in the course
 */
private void enrollStudent(Course course, Student student)
{
    course.enroll(student);
}

/**
 * Enrolls the first n students in a course by reading them
 * from the list of students.
 * @param course The course to enroll students in
 * @param number The number of students to enroll
 */
public void enrollStudentByNumber(Course course, int number)
    {
        for(int i = 0; i < number ; i++)
        {
                course.enroll(students.get(i));
        }
    }

}
