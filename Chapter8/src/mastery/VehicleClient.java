package mastery;

import java.util.Scanner;

/*
program vehicleclient
menu to input and display vehicle data
*/

public class VehicleClient
{
    public static void main(String[] args)
    {
        // scanner for input
        Scanner input = new Scanner(System.in);

        // create vehicles
        Car car = new Car();
        Truck truck = new Truck();
        Minivan minivan = new Minivan();

        // main menu choice
        char mainChoice = 0;

        // loop main menu
        do
        {
            // print main menu
            System.out.println("\n--- Main Menu ---");
            System.out.println("(I)nput - enter vehicle data");
            System.out.println("(D)isplay - show vehicle data");
            System.out.println("(Q)uit - exit program");
            System.out.print("choose option: ");
            String line = input.nextLine();
            if (line.isEmpty())
            {
                System.out.println("invalid input try again");
                continue;
            }

            mainChoice = Character.toUpperCase(line.charAt(0));

            // input or display
            if (mainChoice == 'I' || mainChoice == 'D')
            {
                // select vehicle type
                System.out.println("\nselect vehicle type");
                System.out.println("1 - car");
                System.out.println("2 - truck");
                System.out.println("3 - minivan");
                System.out.print("enter 1 2 or 3: ");
                int typeChoice;
                try
                {
                    typeChoice = Integer.parseInt(input.nextLine());
                    if (typeChoice < 1 || typeChoice > 3)
                    {
                        System.out.println("invalid input must be 1 2 or 3");
                        continue;
                    }
                }
                catch (NumberFormatException e)
                {
                    System.out.println("invalid input must be a number");
                    continue;
                }

                Vehicle vehicle = null;
                // assign vehicle
                if (typeChoice == 1)
                    vehicle = car;
                else if (typeChoice == 2)
                    vehicle = truck;
                else
                    vehicle = minivan;

                // input data
                if (mainChoice == 'I')
                {
                    try
                    {
                        System.out.print("enter fuel economy city: ");
                        double city = Double.parseDouble(input.nextLine());
                        if (city < 0)
                        {
                            System.out.println("invalid value must be >=0");
                            continue;
                        }
                        vehicle.setFuelEconomyCity(city);

                        System.out.print("enter fuel economy highway: ");
                        double hwy = Double.parseDouble(input.nextLine());
                        if (hwy < 0)
                        {
                            System.out.println("invalid value must be >=0");
                            continue;
                        }
                        vehicle.setFuelEconomyHwy(hwy);

                        System.out.print("enter seating capacity: ");
                        int seats = Integer.parseInt(input.nextLine());
                        if (seats <= 0)
                        {
                            System.out.println("invalid value must be >0");
                            continue;
                        }
                        vehicle.setSeatingCapacity(seats);

                        System.out.print("enter cargo volume: ");
                        double cargo = Double.parseDouble(input.nextLine());
                        if (cargo < 0)
                        {
                            System.out.println("invalid value must be >=0");
                            continue;
                        }
                        vehicle.setCargoVolume(cargo);

                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("invalid input must be a number");
                        continue;
                    }
                }
                else // display
                {
                    vehicle.vehicleType();
                    System.out.printf("fuel economy city %.2f\n", vehicle.getFuelEconomyCity());
                    System.out.printf("fuel economy highway %.2f\n", vehicle.getFuelEconomyHwy());
                    System.out.println("seating capacity " + vehicle.getSeatingCapacity());
                    System.out.printf("cargo volume %.2f\n", vehicle.getCargoVolume());
                }
            }
            else if (mainChoice != 'Q')
            {
                System.out.println("invalid option choose i d or q");
            }

        } while (mainChoice != 'Q');

        // end program
        System.out.println("program terminated");
        input.close();
    }
}
