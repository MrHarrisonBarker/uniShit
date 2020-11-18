package com.company;

public class Main
{

    public static void main(String[] args)
    {
        // write your code here
//        nPrint("a", 4);
        System.out.println(foo(new int[]{0, 1, 3, 2, 4, 5, 3},3));
//        System.out.println(f(17));
        int max = 1;
        if (max != 0)
            System.out.println("LOL");
        else
            return;

    }

    public static boolean f(int number)
    {
        for (int divisor = 2; divisor <= number / 2; divisor++)
        {
            if (number % divisor == 0) return false;
        }
        Math.pow(2, 4);
        return true;
    }

    public static void nPrint(String msg, int n)
    {
        while (n > 0)
        {
            System.out.print(msg);
            n--;
        }
    }

    public static int foo(int[] a, int m)
    {
        int j;
        for (j = 0; j < a.length; j++)
        {
            if (a[j] == m) break;
        }
        return j;
    }
}
