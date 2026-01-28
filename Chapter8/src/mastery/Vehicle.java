package mastery;

/*
abstract vehicle class
*/

public abstract class Vehicle
{
    // fuel economy city
    protected double fuelEconomyCity;
    // fuel economy highway
    protected double fuelEconomyHwy;
    // seating capacity
    protected int seatingCapacity;
    // cargo volume
    protected double cargoVolume;

    // constructor
    public Vehicle()
    {
        fuelEconomyCity = 0;
        fuelEconomyHwy = 0;
        seatingCapacity = 0;
        cargoVolume = 0;
    }

    // set fuel economy city
    public void setFuelEconomyCity(double city)
    {
        fuelEconomyCity = city;
    }

    // set fuel economy highway
    public void setFuelEconomyHwy(double hwy)
    {
        fuelEconomyHwy = hwy;
    }

    // set seating capacity
    public void setSeatingCapacity(int seats)
    {
        seatingCapacity = seats;
    }

    // set cargo volume
    public void setCargoVolume(double cargo)
    {
        cargoVolume = cargo;
    }

    // get fuel economy city
    public double getFuelEconomyCity()
    {
        return fuelEconomyCity;
    }

    // get fuel economy highway
    public double getFuelEconomyHwy()
    {
        return fuelEconomyHwy;
    }

    // get seating capacity
    public int getSeatingCapacity()
    {
        return seatingCapacity;
    }

    // get cargo volume
    public double getCargoVolume()
    {
        return cargoVolume;
    }

    // abstract method placeholder for extra info
    public abstract void vehicleType();
}
