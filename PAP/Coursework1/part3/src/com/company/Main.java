package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        // try and open file if any exceptions then catch and print
        try
        {
            // Instantiate scanner with file path
            File textFile = new File("src/com/company/text.txt");
            Scanner reader = new Scanner(textFile);

            String text = null;
            // Read and save through entire text file until nothing left
            while (reader.hasNextLine())
            {
                text += reader.nextLine();
            }
            reader.close();

            // Instantiate tree with the text collected from file
            Tree tree = new Tree(text);

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

    }

}
