import java.util.*;
public class Teacher extends Person
{
    private double salary;
    private String department;

    public Teacher(String fName, String lName, String email, double salary, String department)
    {
        super(fName, lName, email);
        this.salary = salary;
        this.department = department;
    }

    public double getSalary()
    {
        return salary;
    }

    public String getDepartment()
    {
        return department;
    }

    public void assignClasses(Course course)
    {
        courses.add(course);
    }
}