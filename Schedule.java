import java.util.*;
import java.util.regex.*;

/**
 * A helper class that prompts the user for information related
 * to the schedule of a Course.
 * @version 2.0
 * @author Carrie Willis
 */
public class Schedule
{
  private Scanner scanner;

  /**
   * Create a new Schedule object.
   */

  public Schedule()
  {
      scanner = new Scanner(System.in);
  }

  /**
   * Prompts the user for the location of the class.
   * @return A string with the user-submitted room assignment.
   */
  public String setRoom()
  {
    System.out.println("Please enter a location for this course (example: Rubloff 301)");
    System.out.println();
    String location = scanner.nextLine();
    //this regex allows for letters, numbers, and hyphens (supports RUBLOFF 1-301, Rub301, Rubloff Atrium, etc)
    if(Pattern.matches(".*[a-zA-Z]+.*", location))
    {
      return location;
      }
    else
    {
      setRoom();
    }
    return location;
}

/**
 * Prompts the user for the number of days that the class meets, with
 * options to select common schedules.
 * @return The days that the course meets, in abbreviated format.
 */
  public String setDays() throws NumberFormatException
  {
    System.out.println("Please select the days that the class meets:");
    System.out.println("Enter 1 for Monday/Wednesday/Friday");
    System.out.println("Enter 2 for Tuesday/Thursday");
    System.out.println("Enter 3 for custom");
    String days = "";
    try
    {
      int selection = scanner.nextInt();
      if(selection == 1)
      {
        days = "MWF";
      }
      else if(selection == 2)
      {
        days = "TuTh";
      }
      else if(selection == 3)
      {
        int frequency = getFrequency();
        days = chooseDays(frequency);
      }
      else
      {
        System.out.println("Please choose one of the available options.");
        setDays();
      }
    }
    catch(NumberFormatException e)
    {
      System.out.println("Please choose one of the available options.");
      setDays();
    }
    return days;
}

  /**
   * Prompts the user for how many days per week the course meets.
   * Used if the user selects "custom" when prompted for the schedule.
   * @return The number of days per week a class meets.
   */
  public int getFrequency() throws InputMismatchException, NumberFormatException
  {
    System.out.println("How many times a week does the class meet?");
    System.out.println("Enter a number between 1 and 5.");
    int freq = 0;
    try
    {
      int frequency = scanner.nextInt();
      if(frequency > 5 || frequency < 1)
        {
          System.out.println("Classes must meet between 1 and 5 times a week.");
          getFrequency();
        }
        else
        {
          freq = frequency;
        }
    }
    catch(NumberFormatException e)
    {
      System.out.println("Invalid input.");
      getFrequency();
    }
    catch(InputMismatchException e)
    {
      System.out.println("Invalid input.");
      getFrequency();
    }
    return freq;
  }

  /**
   * Prompts the user to select which days the course meets. Prompts
   * the user once for every day the course meets per week.
   * @param frequency The number of times per week the course meets.
   * @return The days that the course meets.
   */
  public String chooseDays(int frequency) throws NumberFormatException, InputMismatchException
  {
      List<String> ordinals = new ArrayList<String>();
      String days = "";
      //not scalable for really large ordinal lists (like 101st) but OK since the limit is 5!
      ordinals.addAll(Arrays.asList("1st", "2nd", "3rd", "4th", "5th"));
      for(int i = 0; i < frequency; i++)
      {
        System.out.println("Please enter the " + ordinals.get(i) + " day the class meets:" );
        System.out.println("Enter 1 for Monday");
        System.out.println("Enter 2 for Tuesday");
        System.out.println("Enter 3 for Wednesday");
        System.out.println("Enter 4 for Thursday");
        System.out.println("Enter 5 for Friday");
        try
        {
          int selection = scanner.nextInt();
          if(selection == 1)
          {
            days += "M";
          }
          else if(selection == 2)
          {
            days += "Tu";
          }
          else if(selection == 3)
          {
            days += "W";
          }
          else if(selection == 4)
          {
            days += "Th";
          }
          else if(selection == 5)
          {
            days += "F";
          }
        }
        catch(NumberFormatException e)
        {
          System.out.println("Please enter one of the available selections.");
          chooseDays(frequency);
        }
        catch(InputMismatchException e)
        {
          System.out.println("Please enter one of the available selections.");
          chooseDays(frequency);
        }

  }
  return days;
}
/**
 * Prompts the user to set the start time of the course, in 24-hour format.
 * @return The time the course starts.
 */
  public String setStartTime()
  {
    System.out.println("Please enter the time the course meets.");
    System.out.println("Please use 24-hour time (for example, for 9 AM, use 09:00).");
    System.out.println();
    scanner.nextLine();
    String isStartTime = scanner.nextLine();
    //regex only supports between 0000 (or 00:00) and 2359 (or 23:59)
    if(Pattern.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]", isStartTime) || Pattern.matches("([01]?[0-9]|2[0-3])[0-5][0-9]", isStartTime))
    {
      return isStartTime;
    }
    else
    {
        System.out.println("Format not accepted.");
        setStartTime();
    }
    return isStartTime;
  }

  /**
   * Prompts the user for the time the course ends.
   * @return The time the course ends.
   */
  public String setEndTime()
  {
    System.out.println("Please enter the time the course ends.");
    System.out.println("Please use 24-hour time (for example, for 6 PM, use 18:00).");
    System.out.println();
    String isEndTime = scanner.nextLine();
    if(Pattern.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]", isEndTime) || Pattern.matches("([01]?[0-9]|2[0-3])[0-5][0-9]", isEndTime))
    {
        return isEndTime;
    }
    else
    {
        System.out.println("Format not accepted.");
        setEndTime();
    }
    return isEndTime;
  }

}
