package mastery;

/*
Program: FriendsTester.java
Last Date of this Revision: January 29, 2026

Purpose: run friends database
Author: Bilal Hajar
School: CHHS
Course: Computer Programming 30
*/

import java.util.Scanner;
import java.io.IOException;

public class FriendsTester
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        FriendsDatabase database = new FriendsDatabase();

        try
        {
            database.loadFromFile();
        }
        catch (Exception e)
        {
            // file not found
        }

        int choice = 0;

        while (choice != 6)
        {
            displayMenu();
            choice = getChoice(input);

            if (choice == 1)
            {
                addFriend(input, database);
            }
            else if (choice == 2)
            {
                database.sortByLastName();
                database.display();
            }
            else if (choice == 3)
            {
                database.sortByFirstName();
                database.display();
            }
            else if (choice == 4)
            {
                findFriend(input, database);
            }
            else if (choice == 5)
            {
                deleteFriend(input, database);
            }
            else if (choice == 6)
            {
                save(database);
            }
        }

        input.close();
    }

    // shows menu
    private static void displayMenu()
    {
        System.out.println();
        System.out.println("1. add a friend");
        System.out.println("2. display friends by last name");
        System.out.println("3. display friends by first name");
        System.out.println("4. find a friend");
        System.out.println("5. delete a friend");
        System.out.println("6. quit");
    }

    // gets valid choice
    private static int getChoice(Scanner input)
    {
        int choice = 0;

        while (choice < 1 || choice > 6)
        {
            System.out.print("enter choice: ");

            if (input.hasNextInt())
            {
                choice = input.nextInt();
            }
            else
            {
                input.next();
            }
        }

        input.nextLine();
        return choice;
    }

    // adds friend
    private static void addFriend(Scanner input, FriendsDatabase database)
    {
        System.out.print("enter first name: ");
        String first = input.nextLine();

        System.out.print("enter last name: ");
        String last = input.nextLine();

        Friend f = new Friend(first, last);
        database.addFriend(f);
    }

    // finds friend
    private static void findFriend(Scanner input, FriendsDatabase database)
    {
        System.out.print("enter first name: ");
        String first = input.nextLine();

        System.out.print("enter last name: ");
        String last = input.nextLine();

        database.findFriend(first, last);
    }

    // deletes friend
    private static void deleteFriend(Scanner input, FriendsDatabase database)
    {
        System.out.print("enter first name: ");
        String first = input.nextLine();

        System.out.print("enter last name: ");
        String last = input.nextLine();

        database.deleteFriend(first, last);
    }

    // saves file
    private static void save(FriendsDatabase database)
    {
        try
        {
            database.saveToFile();
        }
        catch (IOException e)
        {
            System.out.println("error saving file");
        }
    }
}
