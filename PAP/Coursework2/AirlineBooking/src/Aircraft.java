import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Aircraft
{
    private String Make;
    private String Model;
    private String TailNumber;
    private double CraftWeight;
    private double MaximumTakeoffWeight;
    private File LayoutFile;

    public Aircraft(String make, String model, String tailNumber, double craftWeight, double maximumTakeoffWeight, File layoutFile)
    {
        Make = make;
        Model = model;
        TailNumber = tailNumber;
        CraftWeight = craftWeight;
        MaximumTakeoffWeight = maximumTakeoffWeight;
        LayoutFile = layoutFile;
    }

    @Override
    public String toString()
    {
        // creating array of each line
        String[] strings = {String.format("| %s %s, %s ", Make, Model, TailNumber), String.format("| Weight : %s ", CraftWeight), String.format("| Maximum : %s ", MaximumTakeoffWeight)};

        // length of the largest line
        int max = Arrays.stream(strings).map(String::length).max(Integer::compareTo).get();

        // fills in the gaps with spaces and ends the line
        for (int i = 0; i < strings.length; i++)
        {
            for (int spaces = max - strings[i].length(); spaces > 0; spaces--)
            {
                strings[i] += " ";
            }
            strings[i] += "|\n";
        }

        // creates start and end line
        String line = "";
        for (int i = max+1; i > 0; i--)
        {
            line += "-";
        }
        line += "\n";

        // adds a line to the start and end
        List<String> list = new ArrayList<String>(Arrays.asList(strings));
        list.add(0,line);
        list.add(line);
        strings = list.toArray(new String[0]);

        // returns a string of all strings in the array joined together
        return String.join("", strings);
    }

    public String getMake()
    {
        return Make;
    }

    public void setMake(String make)
    {
        Make = make;
    }

    public String getModel()
    {
        return Model;
    }

    public void setModel(String model)
    {
        Model = model;
    }

    public String getTailNumber()
    {
        return TailNumber;
    }

    public void setTailNumber(String tailNumber)
    {
        TailNumber = tailNumber;
    }

    public double getCraftWeight()
    {
        return CraftWeight;
    }

    public void setCraftWeight(double craftWeight)
    {
        CraftWeight = craftWeight;
    }

    public double getMaximumTakeoffWeight()
    {
        return MaximumTakeoffWeight;
    }

    public void setMaximumTakeoffWeight(double maximumTakeoffWeight)
    {
        MaximumTakeoffWeight = maximumTakeoffWeight;
    }

    public File getLayoutFile()
    {
        return LayoutFile;
    }

    public void setLayoutFile(File layoutFile)
    {
        LayoutFile = layoutFile;
    }
}
