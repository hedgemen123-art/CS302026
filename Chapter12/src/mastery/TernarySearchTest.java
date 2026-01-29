package mastery;

/*
Program: TernarySearchTest.java
Last Date of this Revision: January 29, 2026

Purpose: test ternary search using randomly generated numbers
Author: Bilal Hajar
School: CHHS
Course: Computer Programming 30
*/

import java.util.Random;
import java.util.Scanner;

public class TernarySearchTest
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        // get array size
        System.out.print("enter number of elements ");
        int size = input.nextInt();

        int[] numbers = new int[size];

        // fill array
        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = rand.nextInt(90) + 10;
        }

        // display unsorted
        System.out.print("unsorted: ");
        displayArray(numbers);

        // sort array
        Sorts.mergeSort(numbers, 0, numbers.length - 1);

        // display sorted
        System.out.print("sorted:   ");
        displayArray(numbers);

        // get search value
        System.out.print("enter number to search ");
        int target = input.nextInt();

        int index = Searches.ternarySearch(numbers, target, 0, numbers.length - 1);

        // output result
        if (index == -1)
        {
            System.out.println("number not in list");
        }
        else
        {
            System.out.println("number found at index " + index);
        }

        input.close();
    }

    // displays array values
    private static void displayArray(int[] items)
    {
        for (int i = 0; i < items.length; i++)
        {
            System.out.print(items[i] + " ");
        }

        System.out.println();
    }
}
