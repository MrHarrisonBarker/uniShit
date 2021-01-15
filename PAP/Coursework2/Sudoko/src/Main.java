import java.io.File;

public class Main
{
    public static void main(String[] args)
    {
        Solver solver = new Solver(new File("extensionPuzzle.txt"));
        System.out.println(solver.Solve().toString());
    }
}
