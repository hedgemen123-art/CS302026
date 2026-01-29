package mastery;

/*
Program: Friend.java
Last Date of this Revision: January 29, 2026

Purpose: store friend name
Author: Bilal Hajar
School: CHHS
Course: Computer Programming 30
*/

import java.io.Serializable;

public class Friend implements Comparable<Friend>, Serializable
{

    private String firstName;
    private String lastName;

    public Friend(String first, String last)
    {
        firstName = first;
        lastName = last;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    // compares by last name
    public int compareTo(Friend other)
    {
        return lastName.compareToIgnoreCase(other.lastName);
    }

    public String toString()
    {
        return firstName + " " + lastName;
    }
}
