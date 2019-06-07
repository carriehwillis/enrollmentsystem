import java.util.*;
import java.util.Scanner;
import java.io.*;
import java.nio.file.*;

/**
*	A registrar system which creates courses and teachers based on user input.
@version 1.2
@author Carrie Willis
*/

public class Registrar
{
	private Scanner scanner;
	private String fName;
	private String middle;
	private String lName;

	/**
	*	Create a registrar item.
	*/
	public Registrar()
	{
		scanner = new Scanner(System.in);
	}


		// /**
   // * Loads a list of word-response pairs into the response map
   // * by reading from a text file.
   // * @throws FileNotFoundException if the file is not found
   // * @throws IOException if the file cannot be read.
   // */
  // public void loadResponseMap()
  // {
     // Charset charset = Charset.forName("US-ASCII");
     // Path path = Paths.get(ENROLLMENT);
     // try(BufferedReader reader = Files.newBufferedReader(path, charset))
     // {
         // String response = reader.readLine();
         // while(response != null)
         // {
             // String response2 = reader.readLine();
             // responseMap.put(response, response2);
             // response = reader.readLine();
         // }
      // }
      // catch(FileNotFoundException e) {
          // System.err.println("Unable to open " + ENROLLMENT);
      // }
      // catch(IOException e) {
          // System.err.println("A problem was encountered reading " +
                             // ENROLLMENT);
      // }
  // }
	public void parseNames(String line)
	{
		String[] parts = line.split(" ");
		int size = parts.length;
		for(String name : parts)
		{
			if(name.contains(","))
			{
				processCommaName(line);
				break;
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
			}
			else
			{
				fName = parts[0];
				middle = null;
				lName = parts[1];
			}
		}
	}

	private void processCommaName(String line)
	{
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
			middle = null;
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
	}

}
