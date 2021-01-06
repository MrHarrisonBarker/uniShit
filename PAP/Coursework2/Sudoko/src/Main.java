import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{

    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_WHITE = "\u001B[0m";
    public static final String TEXT_GREEN = "\u001B[32m";

    public static void main(String[] args)
    {
        Solver solver = new Solver(new File("extensionPuzzle.txt"));
        System.out.println(solver.Solve().toString());
    }
}
