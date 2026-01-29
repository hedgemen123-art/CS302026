package mastery;

import java.util.Scanner;

/*
program accountclient
tests personal and business accounts
*/

public class AccountClient
{
    public static void main(String[] args)
    {
        // scanner for input
        Scanner input = new Scanner(System.in);
        // menu choice
        char choice;

        // hard coded accounts
        PersonalAcct personal = new PersonalAcct(150.0, "john", "smith");
        BusinessAcct business = new BusinessAcct(600.0, "mary", "brown");

        // main loop
        do
        {
            // print menu
            System.out.println("\n--- main menu ---");
            System.out.println("1 personal account");
            System.out.println("2 business account");
            System.out.println("q quit");
            System.out.print("select option: ");
            String line = input.nextLine();
            if (line.isEmpty())
            {
                System.out.println("invalid input try again");
                choice = 'x';
            }
            else
            {
                choice = Character.toLowerCase(line.charAt(0));
            }

            // select personal
            if (choice == '1')
            {
                handleAccount(personal, input);
            }
            // select business
            else if (choice == '2')
            {
                handleAccount(business, input);
            }
            // invalid menu
            else if (choice != 'q')
            {
                System.out.println("invalid selection");
            }

        } while (choice != 'q');

        // end program
        System.out.println("program terminated");
        input.close();
    }

    // account actions
    public static void handleAccount(Account acct, Scanner input)
    {
        // action loop
        boolean done = false;

        while (!done)
        {
            // print action menu
            System.out.println("\n(e) deposit");
            System.out.println("(w) withdraw");
            System.out.println("(v) view balance");
            System.out.println("(b) back");
            System.out.print("choose action: ");
            String line = input.nextLine();
            if (line.isEmpty())
            {
                System.out.println("invalid input");
            }
            else
            {
                char action = Character.toLowerCase(line.charAt(0));

                // deposit money
                if (action == 'e')
                {
                    System.out.print("enter deposit amount: ");
                    try
                    {
                        double amt = Double.parseDouble(input.nextLine());
                        acct.deposit(amt);
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("invalid number");
                    }
                }
                // withdraw money
                else if (action == 'w')
                {
                    System.out.print("enter withdrawal amount: ");
                    try
                    {
                        double amt = Double.parseDouble(input.nextLine());
                        acct.withdrawal(amt);
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("invalid number");
                    }
                }
                // view balance
                else if (action == 'v')
                {
                    System.out.println(acct.toString());
                }
                // go back
                else if (action == 'b')
                {
                    done = true;
                }
                else
                {
                    System.out.println("invalid action");
                }
            }
        }
    }
}
