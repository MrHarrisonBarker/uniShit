public class Passenger extends Person
{
    private int HoldBags;
    private String FlightClass;

    public Passenger(String name, int passportNumber, String flightClass, int holdBags)
    {
        super(name, passportNumber);
        HoldBags = holdBags;
        FlightClass = flightClass;
    }

    @Override
    public double calculatePersonWeight()
    {
        if (FlightClass.equals("first"))
        {
            return 87.5 + (25 * HoldBags);
        }

        return 80 + (25 * HoldBags);
    }

    public int getHoldBags()
    {
        return HoldBags;
    }

    public void setHoldBags(int holdBags)
    {
        HoldBags = holdBags;
    }

    public String getFlightClass()
    {
        return FlightClass;
    }

    public void setFlightClass(String flightClass)
    {
        FlightClass = flightClass;
    }
}
