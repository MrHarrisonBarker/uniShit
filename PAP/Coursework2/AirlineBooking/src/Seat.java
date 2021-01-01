public class Seat
{
    private int Row;
    private int Seat;
    private String FlyingClass;
    private Passenger AllocatedTo;

    public Seat(int row, int seat, String flyingClass)
    {
        Row = row;
        Seat = seat;
        FlyingClass = flyingClass;
    }

    public int getRow()
    {
        return Row;
    }

    public void setRow(int row)
    {
        Row = row;
    }

    public int getSeat()
    {
        return Seat;
    }

    public void setSeat(int seat)
    {
        Seat = seat;
    }

    public String getFlyingClass()
    {
        return FlyingClass;
    }

    public void setFlyingClass(String flyingClass)
    {
        FlyingClass = flyingClass;
    }

    public Passenger getAllocatedTo()
    {
        return AllocatedTo;
    }

    public void setAllocatedTo(Passenger allocatedTo)
    {
        AllocatedTo = allocatedTo;
    }
}
