public abstract class Person
{
    private String Name;
    private int PassportNumber;

    public Person(String name, Integer passportNumber)
    {
        Name = name;
        PassportNumber = passportNumber;
    }

    public String getName()
    {
        return Name;
    }

    public void setName(String name)
    {
        Name = name;
    }

    public int getPassportNumber()
    {
        return PassportNumber;
    }

    public void setPassportNumber(int passportNumber)
    {
        PassportNumber = passportNumber;
    }

    public abstract double calculatePersonWeight();
}
