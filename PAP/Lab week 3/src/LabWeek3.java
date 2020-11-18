public class LabWeek3
{

    public static void main(String args[])
    {
        double[] monthlySales = {5000.0, 5000.3, 97000.0, 23000.7, 5000.2, 6700.0, 12012.0, 12360.1, 102873.2, 76123.2, 127081.1, 12798.4};

        System.out.println(AnnualSales(monthlySales));
        System.out.println(AverageMonthlySales(monthlySales));
        System.out.println(HighestMonthlySale(monthlySales).printString());
        int g = 3;
        System.out.println(g++);

//        int x = 3;
//        if (x == 1) ;
//        System.out.println("lol");
//        System.out.println("lel");
//
//        for (int line = 1; line <= 5; line ++) {
//            for (int j = 1; j <= (-line + 5); j ++) {
//                System.out.print(".");
//            }
//            for (int k = 1; k <= line;k++) {
//                System.out.print(line);
//            }
//            System.out.println();
//        }

//        System.out.println((34/12);

    }

    public static double AnnualSales(double[] sales)
    {
        double total = 0.0;

        for (double sale : sales)
        {
            total += sale;
        }

        return total;
    }

    public static double AverageMonthlySales(double[] sales)
    {
        return AnnualSales(sales) / sales.length;
    }

    public static class HighLow
    {
        public double Highest;
        public double Lowest;

        public HighLow(double high, double low)
        {
            this.Highest = high;
            this.Lowest = low;
        }

        public String printString()
        {
            return "High: " + this.Highest + "Low: " + this.Lowest;
        }
    }

    public static HighLow HighestMonthlySale(double[] sales)
    {
        double highest = 0.0;
        double lowest = sales[0];
        for (double sale : sales)
        {
            if (sale > highest)
            {
                highest = sale;
            }
            if (sale < lowest)
            {
                lowest = sale;
            }
        }
        return new HighLow(highest, lowest);
    }

    public double Tax(double income)
    {
        double realIncome = income;
        double tax = 0;

        if (realIncome > 50000)
        {
            tax += (realIncome - 50000) * 0.40;
            realIncome = 50000;
            System.out.println("50000");
        }
        if (realIncome > 30000)
        {
            tax += (realIncome - 30000) * 0.20;
            realIncome = 30000;
            System.out.println("30000");
        }
        if (realIncome > 15000)
        {
            tax += (realIncome - 15000) * 0.05;
//            realIncome = 15000;
            System.out.println("15000");
        }

        return income - tax;
    }

    public double Account(double income)
    {
        if (income <= 15000)
        {
            return 0;
        } else if (income <= 30000)
        {
            return (income - 15000) * 0.05;
        } else if (income <= 50000)
        {
            return (income - 30000) * 0.2;
        } else
        {
            return (income - 50000) * 0.4;
        }
    }
}
