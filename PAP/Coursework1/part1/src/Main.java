import java.util.ArrayList;
import java.util.Scanner;

public class Main
{

    private static ArrayList<Student> Students = new ArrayList<>()
    {
        {
            add(new Student("Bert Smith", "computing", (byte) 21, "bsmit001", 12345, true, new ArrayList<Grade>()
            {
                {
                    add(new Grade("programming", 52));
                    add(new Grade("web dev", 63));
                    add(new Grade("maths", 76));
                    add(new Grade("algorithms", 68));
                }
            }));
            add(new Student("Olivia Green", "computing", (byte) 19, "ogree001", 12346, true, new ArrayList<Grade>()
            {
                {
                    add(new Grade("programming", 73));
                    add(new Grade("web dev", 82));
                    add(new Grade("maths", 72));
                    add(new Grade("algorithms", 66));
                }
            }));
            add(new Student("Eloise Jones", "computing", (byte) 18, "ejone001", 12347, true, new ArrayList<Grade>()
            {
                {
                    add(new Grade("programming", 65));
                    add(new Grade("web dev", 63));
                    add(new Grade("maths", 37));
                    add(new Grade("algorithms", 40));
                }
            }));
            add(new Student("Ben Bird", "computing", (byte) 42, "bbird001", 12348, false, new ArrayList<Grade>()
            {
                {
                    add(new Grade("programming", 55));
                    add(new Grade("web dev", 29));
                    add(new Grade("maths", 56));
                    add(new Grade("algorithms", 38));
                }
            }));
            add(new Student("Karen Brown", "computing", (byte) 25, "kbrow002", 12349, false, new ArrayList<Grade>()
            {
                {
                    add(new Grade("programming", 62));
                    add(new Grade("web dev", 51));
                    add(new Grade("maths", 43));
                    add(new Grade("algorithms", 43));
                }
            }));
        }
    };

    private static Scanner input = new Scanner(System.in);

    public static void main(String args[])
    {
        PrintMenu();
    }

    // Method for printing the main menu
    private static void PrintMenu()
    {
        System.out.println("Student Records System");
        System.out.println("1. Student Report");
        System.out.println("2. Failed Students");
        System.out.println("3. Average Grades");
        System.out.println("q. Quit");
        String a = input.next();
        switch (a)
        {
            case "1":
                PrintStudentReportMenu();
                break;
            case "2":
                PrintFailedStudentsMenu();
                break;
            case "3":
                PrintAverageGradeMenu();
                break;
            case "q":
                System.out.println("quitting");
                break;
        }
    }

    // Method for printing the student record menu
    private static void PrintStudentReportMenu()
    {
        // prints all students with assigned number
        for (int i = 0; i < Students.size(); i++)
        {
            Student student = Students.get(i);
            System.out.println(String.format("%d. %s", i, student.getName()));
        }

        String s = ReturnMenu();

        // If the user inputs a valid student number the program will print their report
        if (Character.isDigit(s.charAt(0)) && Integer.parseInt(s) < Students.size())
        {
            PrintStudentReport(Students.get(Integer.parseInt(s)));
        }

    }

    // Method for printing failed students menu
    private static void PrintFailedStudentsMenu()
    {
        PrintFailedStudents();
        ReturnMenu();
    }

    // Method for printing average grade menu
    private static void PrintAverageGradeMenu()
    {
        PrintAverageGrades();
        ReturnMenu();
    }

    // method fro printing generic return menu, back or quit
    private static String ReturnMenu()
    {
        System.out.println("b. Back");
        System.out.println("q. Quit");
        String s = input.next();
        switch (s)
        {
            case "b":
                System.out.println("back");
                PrintMenu();
                break;
            case "q":
                System.out.println("quitting");
                break;
        }
        return s;
    }

    // Method for printing out student report
    private static void PrintStudentReport(Student student)
    {
        System.out.println(String.format("%s's Report", student.getName()));

        // Prints all students lettered grade for each subject
        System.out.println("--------------------------");
        for (Grade grade : student.Grades)
        {
            System.out.println(String.format("%s | %s", grade.getSubject(), Grade.getLetterGrade(grade.getScore())));
        }
        System.out.println("--------------------------");
        System.out.println("b. Back");
        System.out.println("q. Quit");
        String s = input.next();
        switch (s)
        {
            case "b":
                System.out.println("back");
                PrintStudentReportMenu();
                break;
            case "q":
                System.out.println("quitting");
                break;
        }
    }

    // Method for printing out all failed students
    private static void PrintFailedStudents()
    {
        System.out.println("These students have failed");
        System.out.println("--------------------------");
        for (Student student : Students)
        {
            if (student.hasFailed())
            {
                System.out.println(student.getName());
            }
        }
    }

    // Method for printing out all students average grades
    private static void PrintAverageGrades()
    {
        for (Student student : Students)
        {
            System.out.println(String.format("%s's average grade -> %.2f", student.getName(), student.getAverageGrade()));
        }
    }
}
