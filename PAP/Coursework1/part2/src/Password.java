import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Password
{

    static String allChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String allDigits = "0123456789";
    static String allSymbols = "!\"#$%&\\'()*+,-./:;<=>?@[\\\\]^_`{|}~";

    public static String NewPassword(int length, int symbols, int digits)
    {
        char[] password = new char[length];

        password = RandomAndPlace(length, symbols, password, allSymbols);
        password = RandomAndPlace(length, digits, password, allDigits);

        for (int i = 0; i < length; i++)
        {
            if (password[i] == 0)
            {
                char rand = allChars.charAt(new Random().nextInt(allChars.length()));
                password[i] = rand;
            }
        }

        return new String(password);
    }

    private static char[] RandomAndPlace(int length, int n, char[] password, String language)
    {
        Random random = new Random();
        int[] positions = new int[n];

        for (int i = 0; i < n; i++)
        {
            int rand = random.nextInt(length);
            while (password[rand] != 0)
            {
                rand = random.nextInt(length);
            }
            positions[i] = rand;

            password[rand] = language.charAt(new Random().nextInt(language.length()));
            System.out.println("random symbol = " + password[rand] + " pos = " + rand);
        }
        return password;
    }

    public static String ValidatePassword(String password)
    {

        int numOfSymbols = 0, numOfDigits = 0, numOfUpper = 0, numOfLower = 0;
        boolean failedCheck = false;

        for (char c : password.toCharArray())
        {
            if (Character.isLetter(c))
            {
                if (Character.isUpperCase(c))
                {
                    numOfUpper++;
                } else
                {
                    numOfLower++;
                }
            } else if (Character.isDigit(c))
            {
                numOfDigits++;
            } else
            {
                if (allSymbols.indexOf(c) != -1)
                {
                    numOfSymbols++;
                }
            }
        }

        if (CheckExcellent(password, numOfSymbols, numOfDigits, numOfUpper, numOfLower))
        {
            return "Excellent";
        }

        if (CheckGood(password, numOfSymbols, numOfDigits, numOfUpper, numOfLower))
        {
            return "Good";
        }

        if (CheckOk(password, numOfSymbols, numOfDigits, numOfUpper, numOfLower))
        {
            return "Ok";
        }

        if (CheckPoor(password, numOfSymbols, numOfDigits, numOfUpper, numOfLower))
        {
            return "Poor";
        }
        return "error";
    }

    private static boolean CheckExcellent(String password, int numOfSymbols, int numOfDigits, int numOfUpper, int numOfLower)
    {
        if (password.length() < 16)
        {
            return false;
        }

        if (numOfSymbols <= 4)
        {
            return false;
        }

        if (numOfDigits <= 4)
        {
            return false;
        }

        if (numOfUpper == 0 || numOfLower == 0)
        {
            return false;
        }

        return true;
    }

    private static boolean CheckGood(String password, int numOfSymbols, int numOfDigits, int numOfUpper, int numOfLower)
    {
        if (password.length() >= 16)
        {
            return false;
        }

        if (numOfSymbols <= 3)
        {
            return false;
        }

        if (numOfDigits <= 2)
        {
            return false;
        }

        if (numOfUpper == 0 || numOfLower == 0)
        {
            return false;
        }

        return true;
    }

    private static boolean CheckOk(String password, int numOfSymbols, int numOfDigits, int numOfUpper, int numOfLower)
    {
        if (password.length() >= 12)
        {
            return false;
        }

        if (numOfSymbols <= 1)
        {
            return false;
        }

        if (numOfDigits <= 2)
        {
            return false;
        }

        if (numOfUpper != 0 && numOfLower != 0)
        {
            return false;
        }

        return true;
    }

    private static boolean CheckPoor(String password, int numOfSymbols, int numOfDigits, int numOfUpper, int numOfLower)
    {
        if (password.length() >= 8)
        {
            return false;
        }

        if (numOfSymbols > 0)
        {
            return false;
        }

        if (numOfDigits > 0)
        {
            return false;
        }

        if (numOfUpper != 0 && numOfLower != 0)
        {
            return false;
        }

        return true;

    }
}
