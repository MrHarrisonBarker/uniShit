import java.util.Scanner;

public class Main
{
    private static Scanner input = new Scanner(System.in);

    public static void main(String args[])
    {
        PrintMenu();
    }

    // Method for printing the main menu of the program
    private static void PrintMenu()
    {
        System.out.println("Password Generate & Verify");
        System.out.println("1. Generate Password");
        System.out.println("2. Verify Password");
        System.out.println("q. Quit");
        String a = input.next();

        switch (a)
        {
            case "1":
                PrintGenerateMenu();
                break;
            case "2":
                PrintVerifyMenu();
                break;
            case "q":
                System.out.println("quitting");
                break;
        }
    }

    // Method for printing out the verify password menu
    private static void PrintVerifyMenu()
    {
        System.out.println("Enter your password");
        String password = input.next();
        System.out.println("Your password is " + new Password().ValidatePassword(password));
    }

    // Method for printing out the generate password menu
    private static void PrintGenerateMenu()
    {
        System.out.println("Enter number of characters?");
        int n = input.nextInt();
        System.out.println("Enter number of Symbols");
        int s = input.nextInt();
        System.out.println("Enter number of digits");
        int d = input.nextInt();
        System.out.println("Generated password -> " + new Password().NewPassword(n, s, d));
    }
}
