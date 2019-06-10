import java.util.*;
import java.util.regex.*;

public class Schedule
{
  private String days;
  private String startTime;
  private String endTime;
  private Scanner scanner;

  public Schedule()
  {
      scanner = new Scanner(System.in);
      days = "";
  }

  public String setRoom()
  {
    System.out.println("Please enter a location for this course (example: Rubloff 301)");
    System.out.println();
    String location = scanner.nextLine();
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

  public void setDays() throws NumberFormatException
  {
    System.out.println("Please select the days that the class meets:");
    System.out.println("Enter 1 for Monday/Wednesday/Friday");
    System.out.println("Enter 2 for Tuesday/Thursday");
    System.out.println("Enter 3 for custom");
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
        chooseDays(frequency);
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
  }

  public int getFrequency()
  {
    System.out.println("How many times a week does the class meet? Enter a number between 1 and 5.");
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
    return freq;
  }

  public void chooseDays(int frequency) throws NumberFormatException
  {
      List<String> ordinals = new ArrayList<String>();
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
  }
}
  public String setStartTime()
  {
    System.out.println("Please enter the time the course meets on " + days + ".");
    System.out.println("Please use 24-hour time (for example, for 9 AM, use 09:00).");
    System.out.println();
    scanner.nextLine();
    String isStartTime = scanner.nextLine();
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

  public String setEndTime()
  {
    System.out.println("Please enter the time the course ends.");
    System.out.println("Please use 24-hour time (for example, for 6 PM, use 18:00).");
    System.out.println();
    String isEndTime = scanner.nextLine();
    if(Pattern.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]", isEndTime) || Pattern.matches("([01]?[0-9]|2[0-3])[0-5][0-9]", isEndTime)))
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

   public String getDays()
   {
     setDays();
    return days;
    }
}
