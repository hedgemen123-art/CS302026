package mastery;

import java.util.Scanner;

/*
program uemployeeclient
interactive employee info and pay
*/

public class UEmployeeClient
{
    public static void main(String[] args)
    {
        // scanner for input
        Scanner input = new Scanner(System.in);
        // main choice menu
        char mainChoice = 0;

        // hard coded managers
        Faculty[] managers = {
            new Faculty("Alice Johnson", 103000.0, "Management"),
            new Faculty("David Lee", 97000.0, "Management")
        };

        // hard coded staff
        Staff[] staff = {
            new Staff("John Smith", 16.0, "Staff"),
            new Staff("Mary Brown", 14.0, "Staff")
        };

        // main loop
        do
        {
            // print main menu
            System.out.println("\n--- Main Menu ---");
            System.out.println("(E)mployee - Check Employee Info");
            System.out.println("(P)ay - Calculate Pay");
            System.out.println("(Q)uit - Exit Program");
            // get main menu choice
            System.out.print("Choose an option: ");
            String line = input.nextLine();
            // check empty input
            if (line.isEmpty())
            {
                System.out.println("invalid input try again");
                continue;
            }

            // get first char
            mainChoice = Character.toUpperCase(line.charAt(0));

            // check valid action
            if (mainChoice == 'E' || mainChoice == 'P')
            {
                // select type
                System.out.println("\nSelect Employee Type:");
                System.out.println("1 - Manager");
                System.out.println("2 - Staff");
                System.out.print("Enter 1 or 2: ");
                int typeChoice;
                try
                {
                    // read type
                    typeChoice = Integer.parseInt(input.nextLine());
                    // check valid type
                    if (typeChoice != 1 && typeChoice != 2)
                    {
                        System.out.println("invalid input must be 1 or 2");
                        continue;
                    }
                }
                catch (NumberFormatException e)
                {
                    // type not number
                    System.out.println("invalid input must be a number");
                    continue;
                }

                // selected employee
                UEmployee employee = null;

                // select specific manager
                if (typeChoice == 1)
                {
                    System.out.println("\nSelect Manager:");
                    System.out.println("1 - " + managers[0].getName());
                    System.out.println("2 - " + managers[1].getName());
                    System.out.print("Enter 1 or 2: ");
                    try
                    {
                        // read manager choice
                        int empChoice = Integer.parseInt(input.nextLine());
                        if (empChoice != 1 && empChoice != 2)
                        {
                            System.out.println("invalid input must be 1 or 2");
                            continue;
                        }
                        // assign selected
                        employee = managers[empChoice - 1];
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("invalid input must be a number");
                        continue;
                    }
                }
                else
                {
                    // select specific staff
                    System.out.println("\nSelect Staff:");
                    System.out.println("1 - " + staff[0].getName());
                    System.out.println("2 - " + staff[1].getName());
                    System.out.print("Enter 1 or 2: ");
                    try
                    {
                        // read staff choice
                        int empChoice = Integer.parseInt(input.nextLine());
                        if (empChoice != 1 && empChoice != 2)
                        {
                            System.out.println("invalid input must be 1 or 2");
                            continue;
                        }
                        // assign selected
                        employee = staff[empChoice - 1];
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("invalid input must be a number");
                        continue;
                    }
                }

                // display employee info
                if (mainChoice == 'E')
                {
                    System.out.println("\nemployee info");
                    System.out.println("name " + employee.getName());
                    if (employee instanceof Faculty)
                    {
                        System.out.printf("salary $%.2f\n", employee.getSalary());
                        System.out.println("department " + ((Faculty) employee).getDepartment());
                    }
                    else
                    {
                        System.out.printf("hourly rate $%.2f\n", employee.getSalary());
                        System.out.println("job title " + ((Staff) employee).getJobTitle());
                    }
                }
                else
                {
                    // calculate pay
                    try
                    {
                        if (employee instanceof Faculty)
                        {
                            // ask weeks worked
                            System.out.print("enter weeks worked 0-52: ");
                            double weeks = Double.parseDouble(input.nextLine());
                            // check range
                            if (weeks < 0 || weeks > 52)
                            {
                                System.out.println("invalid weeks must be 0-52");
                                continue;
                            }
                            // compute pay
                            double pay = employee.calculatePay(weeks);
                            System.out.printf("faculty pay $%.2f\n", pay);
                        }
                        else
                        {
                            // ask hours worked
                            System.out.print("enter hours worked: ");
                            double hours = Double.parseDouble(input.nextLine());
                            // check positive
                            if (hours < 0)
                            {
                                System.out.println("invalid hours must be >=0");
                                continue;
                            }
                            // compute pay
                            double pay = employee.calculatePay(hours);
                            System.out.printf("staff pay $%.2f\n", pay);
                        }
                    }
                    catch (NumberFormatException e)
                    {
                        // invalid number input
                        System.out.println("invalid input must be a number");
                        continue;
                    }
                }
            }
            else if (mainChoice != 'Q')
            {
                // invalid main menu
                System.out.println("invalid option please choose e p or q");
            }

        } while (mainChoice != 'Q');

        // program end
        System.out.println("program terminated");
        input.close();
    }
}
