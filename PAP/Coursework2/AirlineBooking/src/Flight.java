import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Flight
{
    private int FlightNumber;
    private Aircraft Craft;
    private String StartLocation;
    private String EndLocation;
    private double Distance;

    public ArrayList<Seat> Seats;
    public ArrayList<CrewMember> crew;

    public Flight(int flightNumber, Aircraft craft, String startLocation, String endLocation, double distance)
    {
        FlightNumber = flightNumber;
        Craft = craft;
        StartLocation = startLocation;
        EndLocation = endLocation;
        Distance = distance;
        Seats = new ArrayList<Seat>();
        crew = new ArrayList<CrewMember>();

        // reading layout file
        try
        {
            // initialising scanner with layout file
            Scanner scanner = new Scanner(Craft.getLayoutFile());

            int row = 0;
            // looping through each line in the file
            while (scanner.hasNextLine())
            {
                // splitting line from the text file using the comma delimiter
                String[] newSeats = scanner.nextLine().split(",");
                int col = 0;
                // looping through each seat in the row
                for (String s : newSeats)
                {
                    Seat newSeat;
                    // initialising a new seat with the seat position and class
                    if (s.equals("F"))
                    {
                        newSeat = new Seat(row, col, "first");
                    } else
                    {
                        newSeat = new Seat(row, col, "economy");
                    }

                    // adding the new seat to the list of seats
                    Seats.add(newSeat);
                }
                row++;
            }

        } catch (FileNotFoundException e)
        {
            System.out.println("can't find layout file");
        }

    }

    public int bookSeat(Passenger passenger)
    {
        // searching for a seat that is free and the correct class
        for (int i = 0, seatsSize = Seats.size(); i < seatsSize; i++)
        {
            Seat seat = Seats.get(i);
            if (seat.getFlyingClass().equals(passenger.getFlightClass()) && seat.getAllocatedTo() == null)
            {
                // found seat for passenger with correct class and is free
                seat.setAllocatedTo(passenger);
                Seats.set(i, seat);
                return 1;
            }
        }

        // searching the first seat that's free
        for (int i = 0, seatsSize = Seats.size(); i < seatsSize; i++)
        {
            Seat seat = Seats.get(i);
            // if the seat is available
            if (seat.getAllocatedTo() == null)
            {
                seat.setAllocatedTo(passenger);
                Seats.set(i, seat);

                // has the passenger been upgraded or downgraded
                if (seat.getFlyingClass().equals("first") && passenger.getFlightClass().equals("economy"))
                {
                    return 2;
                }

                return 3;
            }
        }

        // not found
        return -1;
    }

    @Override
    public String toString()
    {
        int numberOfFirstClass = 0;
        int numberOfEconomyClass = 0;
        int numberOfUnallocated = 0;

        // counting number of first, economy and unallocated seats
        for (Seat seat : Seats)
        {
            if (seat.getFlyingClass().equals("first") && seat.getAllocatedTo() != null)
            {
                numberOfFirstClass++;
            } else
            {
                numberOfEconomyClass++;
            }

            if (seat.getAllocatedTo() == null)
            {
                numberOfUnallocated++;
            }
        }

        String crewNames = "";
        // concatenating all crew names
        for (CrewMember crewMember : crew)
        {
            crewNames += (crewMember.getName() + ", ");
        }

        // returning formatted string
        return String.format(Main.TEXT_BLUE + "********-Flight : %s-********\n" + Main.TEXT_WHITE + "From : %s \nTo : %s \nDistance : %s \nFirst Class Passengers : %s \nEconomy Class Passengers : %s \nUnallocated Seats : %s \nCrew : %s \n%s", FlightNumber, StartLocation, EndLocation, Distance, numberOfFirstClass, numberOfEconomyClass, numberOfUnallocated, crewNames, Craft.toString());
    }

    public double calculateTakeOffWeight()
    {
        double totalWeight = Craft.getCraftWeight();

        // adds the weight of all passengers to the weight total
        for (Seat seat : Seats)
        {
            Passenger passenger = seat.getAllocatedTo();
            if (passenger != null)
            {
                totalWeight += passenger.calculatePersonWeight();
            }
        }

        // adds the weight of all crew to the total
        for (CrewMember crewMember : crew)
        {
            totalWeight += crewMember.calculatePersonWeight();
        }

        // checks if the total exceeds the maximum of the aircraft
        if (totalWeight > Craft.getMaximumTakeoffWeight())
        {
            return -1;
        }

        return totalWeight;
    }

    public int getFlightNumber()
    {
        return FlightNumber;
    }

    public void setFlightNumber(int flightNumber)
    {
        FlightNumber = flightNumber;
    }

    public Aircraft getCraft()
    {
        return Craft;
    }

    public void setCraft(Aircraft craft)
    {
        Craft = craft;
    }

    public String getStartLocation()
    {
        return StartLocation;
    }

    public void setStartLocation(String startLocation)
    {
        StartLocation = startLocation;
    }

    public String getEndLocation()
    {
        return EndLocation;
    }

    public void setEndLocation(String endLocation)
    {
        EndLocation = endLocation;
    }

    public double getDistance()
    {
        return Distance;
    }

    public void setDistance(double distance)
    {
        Distance = distance;
    }
}
