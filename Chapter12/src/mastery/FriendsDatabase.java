package mastery;

/*
Program: FriendsDatabase.java
Last Date of this Revision: January 29, 2026

Purpose: manage friends list
Author: Bilal Hajar
School: CHHS
Course: Computer Programming 30
*/

import java.io.*;
import java.util.ArrayList;

public class FriendsDatabase
{

    private ArrayList<Friend> friends;

    public FriendsDatabase()
    {
        friends = new ArrayList<Friend>();
    }

    // adds friend
    public void addFriend(Friend f)
    {
        friends.add(f);
    }

    // sorts by last name
    public void sortByLastName()
    {
        for (int i = 0; i < friends.size() - 1; i++)
        {
            int minIndex = i;

            for (int j = i + 1; j < friends.size(); j++)
            {
                if (friends.get(j).getLastName()
                    .compareToIgnoreCase(friends.get(minIndex).getLastName()) < 0)
                {
                    minIndex = j;
                }
            }

            Friend temp = friends.get(i);
            friends.set(i, friends.get(minIndex));
            friends.set(minIndex, temp);
        }
    }

    // sorts by first name
    public void sortByFirstName()
    {
        for (int i = 0; i < friends.size() - 1; i++)
        {
            int minIndex = i;

            for (int j = i + 1; j < friends.size(); j++)
            {
                if (friends.get(j).getFirstName()
                    .compareToIgnoreCase(friends.get(minIndex).getFirstName()) < 0)
                {
                    minIndex = j;
                }
            }

            Friend temp = friends.get(i);
            friends.set(i, friends.get(minIndex));
            friends.set(minIndex, temp);
        }
    }

    // finds friend
    public void findFriend(String first, String last)
    {
        boolean found = false;

        for (int i = 0; i < friends.size(); i++)
        {
            if (friends.get(i).getFirstName().equalsIgnoreCase(first)
                && friends.get(i).getLastName().equalsIgnoreCase(last))
            {
                System.out.println(friends.get(i));
                found = true;
            }
        }

        if (!found)
        {
            System.out.println("friend not found");
        }
    }

    // deletes friend
    public void deleteFriend(String first, String last)
    {
        int index = -1;

        for (int i = 0; i < friends.size(); i++)
        {
            if (friends.get(i).getFirstName().equalsIgnoreCase(first)
                && friends.get(i).getLastName().equalsIgnoreCase(last))
            {
                index = i;
            }
        }

        if (index != -1)
        {
            friends.remove(index);
            System.out.println("friend deleted");
        }
        else
        {
            System.out.println("friend not found");
        }
    }

    // displays friends
    public void display()
    {
        for (int i = 0; i < friends.size(); i++)
        {
            System.out.println(friends.get(i));
        }
    }

    // saves to file
    public void saveToFile() throws IOException
    {
        ObjectOutputStream out =
            new ObjectOutputStream(new FileOutputStream("friends.dat"));

        out.writeObject(friends);
        out.close();
    }

    // loads from file
    public void loadFromFile() throws IOException, ClassNotFoundException
    {
        ObjectInputStream in =
            new ObjectInputStream(new FileInputStream("friends.dat"));

        friends = (ArrayList<Friend>) in.readObject();
        in.close();
    }
}
