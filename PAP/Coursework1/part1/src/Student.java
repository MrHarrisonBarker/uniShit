import java.util.ArrayList;

public class Student
{
    private String Name;
    private String Department;
    private byte Age;
    private String UserName;
    private int StudentNumber;
    private boolean FullTime;

    public ArrayList<Grade> Grades;

    public Student(String name, String department, byte age, String userName, int studentNumber, boolean fullTime, ArrayList<Grade> grades)
    {
        Name = name;
        Department = department;
        Age = age;
        UserName = userName;
        StudentNumber = studentNumber;
        FullTime = fullTime;
        Grades = grades;
    }

    public double getAverageGrade()
    {
        double total = 0;
        for (Grade grade : Grades)
        {
            total += grade.getScore();
        }
        return total / Grades.size();
    }

    public boolean hasFailed()
    {
        for (Grade grade : Grades)
        {
            if (Grade.getLetterGrade(grade.getScore()) == 'F')
            {
                return true;
            }
        }
        return false;
    }

    public String getName()
    {
        return Name;
    }

    public void setName(String name)
    {
        Name = name;
    }

    public String getDepartment()
    {
        return Department;
    }

    public void setDepartment(String department)
    {
        Department = department;
    }

    public byte getAge()
    {
        return Age;
    }

    public void setAge(byte age)
    {
        Age = age;
    }

    public String getUserName()
    {
        return UserName;
    }

    public void setUserName(String userName)
    {
        UserName = userName;
    }

    public int getStudentNumber()
    {
        return StudentNumber;
    }

    public void setStudentNumber(int studentNumber)
    {
        StudentNumber = studentNumber;
    }

    public boolean isFullTime()
    {
        return FullTime;
    }

    public void setFullTime(boolean fullTime)
    {
        FullTime = fullTime;
    }
}
