package mastery;
/*
Program: Searches.java
Last Date of this Revision: January 29, 2026

Purpose: provide search algorithms including ternary search
Author: Bilal Hajar
School: CHHS
Course: Computer Programming 30
*/

public class Searches
{

    /**
     * performs ternary search recursively
     * pre array sorted
     * post index or -1 returned
     */
    public static int ternarySearch(int[] items, int target, int left, int right)
    {
        if (left > right)
        {
            return -1;
        }

        int mid1 = left + (right - left) / 3;
        int mid2 = right - (right - left) / 3;

        // check mid points
        if (items[mid1] == target)
        {
            return mid1;
        }

        if (items[mid2] == target)
        {
            return mid2;
        }

        if (target < items[mid1])
        {
            return ternarySearch(items, target, left, mid1 - 1);
        }
        else if (target > items[mid2])
        {
            return ternarySearch(items, target, mid2 + 1, right);
        }
        else
        {
            return ternarySearch(items, target, mid1 + 1, mid2 - 1);
        }
    }
}
