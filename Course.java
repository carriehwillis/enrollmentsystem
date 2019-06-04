import java.util.*;
public class Course
{
    private String id;
    private String name;
    private String department;
    private int courseNo;
    private int credits;
    private int year;
    private String quarter;
    private int minStudents;
    private int maxStudents;
    private Teacher teacher;
    private ArrayList<Student> students;

    public Course(String name, String department, int courseNo, int credits, int year, String quarter, int maxStudents)
    {
        students = new ArrayList<Student>();
        this.name = name;
        this.department = department;
        this.courseNo = courseNo;
        this.credits = credits;
        this.year = year;
        this.quarter = quarter;
        this.maxStudents = maxStudents;
        minStudents = 10;
        teacher = null;
        id = generateID();
    }

    public String generateID()
    {
        String catID = "" + year + quarter.substring(0,2).toUpperCase() + "-";
        catID += department.substring(0,3).toUpperCase() + courseNo;
        return catID;
    }

    public void enroll(Student student)
    {
        students.add(student);
        student.addCourse(this);
    }

    public void assignTeacher(Teacher teacher)
    {
        this.teacher = teacher;
    }

    public String getInfo()
    {
        String info = id + "\t" + name + "\n" + "Teacher: " + teacher;
        return info;
    }
    
    public String getDetailedInfo()
    {
        String info = "======== Course Information ========\n";
        info += id + "\t" + name + "\t" + credits + " credits\n";
        info += "Teacher: " + teacher + "\n";
        info += "Department: " + department + "\n";
        info += students.size() + " students enrolled:\n";
        info += listStudents();
        return info;
    }

    public String listStudents()
    {
        String stds = "";
        for(Student student : students)
        {
            stds += student.getName() + "\n";
        }
        return stds;
    }
}