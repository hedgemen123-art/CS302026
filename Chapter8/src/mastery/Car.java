package mastery;

/*
car class
*/

public class Car extends Vehicle
{
    // extra for car if needed
    private String type = "Car";

    // constructor
    public Car()
    {
        super();
    }

    // type output
    public void vehicleType()
    {
        System.out.println("vehicle type car");
    }
}
