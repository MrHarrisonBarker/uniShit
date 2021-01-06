import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grid
{
    private Cell[][] Cells;
    public int Iterations = 0;

    public Grid(Cell[][] cells)
    {
        this.Cells = cells;
    }

    public Cell getCell(int n)
    {
        return Cells[n / 9][n % 9];
    }

    public void setCell(int n, int num)
    {
        Cells[n / 9][n % 9].Number = num;
    }

    @Override
    public String toString()
    {
        String grid = "";
        for (int i = 0; i < 9; i++)
        {
            if (i % 3 == 0)
            {
                grid += " +-------+-------+-------+\n";
            }
            for (int j = 0; j < 9; j++)
            {
                if (j % 3 == 0)
                {
                    grid += (" | " + (Cells[i][j].Editable ? Main.TEXT_WHITE : Main.TEXT_BLUE) + Cells[i][j].Number + Main.TEXT_WHITE);
                } else
                {
                    grid += (" " + (Cells[i][j].Editable ? Main.TEXT_WHITE : Main.TEXT_BLUE) + Cells[i][j].Number + Main.TEXT_WHITE);
                }
            }
            grid += " |\n";
        }
        grid += " +-------+-------+-------+\n";
        grid += String.format("Iterations : %s", Iterations);
        return grid;
    }

    public boolean checkRows()
    {
        for (int row = 0; row < 9; row++)
        {
            int[] nums = new int[9];
            for (int col = 0; col < 9; col++)
            {
                final int cell = Cells[row][col].Number;
                if (Arrays.stream(nums).anyMatch(x -> x == cell && x != 0))
                {
//                    System.out.println(String.format("Row %s failed check",row));
                    return false;
                }
                nums[col] = Cells[row][col].Number;
            }
//            System.out.println(String.format("Row %s checked", row));
        }
        return true;
    }

    public boolean checkColumns()
    {
        for (int col = 0; col < 9; col++)
        {
            int[] nums = new int[9];
            for (int row = 0; row < 9; row++)
            {
                final int cell = Cells[row][col].Number;
                if (Arrays.stream(nums).anyMatch(x -> x == cell && x != 0))
                {
//                    System.out.println(String.format("Col %s failed check", col));
                    return false;
                }
                nums[row] = Cells[row][col].Number;
            }
//            System.out.println(String.format("Col %s checked", col));
        }
        return true;
    }

    public boolean checkInners()
    {
        for (int innerRow = 0; innerRow < 3; innerRow++)
        {
            for (int innerCol = 0; innerCol < 3; innerCol++)
            {
                List<Integer> inner = new ArrayList<>();
                for (int row = innerRow * 3; row < (innerRow * 3) + 3; row++)
                {
                    for (int col = innerCol * 3; col < (innerCol * 3) + 3; col++)
                    {
                        final int cell = Cells[row][col].Number;
                        if (inner.contains(cell) && cell != 0)
                        {
//                            System.out.println(String.format("inner %s * %s fails check", innerRow * 3, innerCol * 3));
                            return false;
                        }
                        inner.add(cell);
                    }
                }
//                System.out.println(String.format("inner %s * %s checked", innerRow * 3, innerCol * 3));
            }
        }
        return true;
    }
}
