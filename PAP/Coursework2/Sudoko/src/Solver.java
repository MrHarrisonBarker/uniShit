import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solver
{
    private Grid Grid;

    public Solver(File file)
    {
        try
        {
            Scanner scanner = new Scanner(file);

            Cell[][] cells = new Cell[9][9];

            int row = 0;
            while (scanner.hasNextLine())
            {
                String[] input = scanner.nextLine().split(",");
                for (int s = 0; s < 9; s++)
                {
                    int inputNum = Integer.parseInt(input[s]);
                    if (inputNum == 0)
                    {
                        cells[row][s] = new Cell(inputNum, true);
                    } else
                    {
                        cells[row][s] = new Cell(inputNum, false);
                    }
                }
                row++;
            }
            Grid = new Grid(cells);
            System.out.println("Loaded sudoku");
            System.out.println(Grid.toString());
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

    }

    public Grid Solve()
    {
        boolean solved = false;
        boolean backtrace = false;
        int cellIndex = 0;
        while (!solved)
        {
            Grid.Iterations++;

//            System.out.println(String.format("cell %s", cellIndex));

            boolean cellSolved = placeCell(Grid, cellIndex, backtrace);

            // if the cell is not solved backtrace
            if (!cellSolved)
            {
                if (cellIndex == 0)
                {
                    backtrace = false;
                } else
                {
                    backtrace = true;
                    cellIndex--;
                }
            } else
            {
                if (cellIndex == 80)
                {
                    solved = true;
                }

                backtrace = false;
                cellIndex++;
            }
        }

        return Grid;
    }

    private boolean placeCell(Grid grid, int cellIndex, boolean backtrace)
    {
        if (!grid.getCell(cellIndex).Editable && backtrace)
        {
            return false;
        }

        if (grid.getCell(cellIndex).Editable)
        {
            int n = backtrace ? grid.getCell(cellIndex).Number : 0;

            if (n == 9)
            {
                grid.setCell(cellIndex, 0);
                return false;
            }

            boolean cellSolved = false;
            while (n < 9 && !cellSolved)
            {
                n++;
                grid.setCell(cellIndex, n);
                cellSolved = grid.checkColumns() && grid.checkRows() && grid.checkInners();
                if (n == 9 && !cellSolved)
                {
//                    System.out.println("Cell not solved");
                    grid.setCell(cellIndex, 0);
                    return false;
                }
            }
//            System.out.println(grid.toString());
        }
        return true;
    }

}
