import java.util.*;
import java.util.Scanner;
import java.io.*;
import java.nio.file.*;
import java.nio.charset.Charset;

/**
*   A registrar system which creates courses and teachers based on user input.
@version 1.2
@author Carrie Willis
*/

public class Registrar
{
    private Scanner scanner;

    // Used to map key words to responses.
    private ArrayList<Student> students;
    // The file that populates the response map.
    private static final String ENROLLMENT = "enrollment.txt";

    /**
    *   Create a registrar item.
    */
    public Registrar()
    {
        students = new ArrayList<Student>();
        loadStudents();
    }

        /**
   * Loads a list of word-response pairs into the response map
   * by reading from a text file.
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


    public void parseNames(String line)
    {
        String[] parts = line.split(" ");
        String fName = null;
        String middle = null;
        String lName = null;
        int size = parts.length;
        if (line.length() < 2)
            {
              //do nothing. this is for the empty first line in the .txt file.
            }
            else if(line.contains(","))
            {
                processCommaName(line);
            }
            else if(size > 2)
            {
                fName = parts[0];
                lName = parts[size - 1];
                middle = parts[1];
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
            for(int i=3; i < (size); i++)
            {
                 middle += parts[i] + " ";
            }
        }
        processStudent(fName, middle, lName);
    }


    private void processStudent(String fName, String middle, String lName)
    {
        Student student = new Student(fName, middle, lName);
        students.add(student);
    }


    private void enrollStudent(Course course, Student student)
    {
        course.enroll(student);
    }

	private void enrollStudentByNumber(Course course, Student student, int number)
	{
		for(int i = 0; i < number ; i++)
		{
				course.enroll(students.get(i));
		}
	}

}
