package mastery;

/*
Program: Sorts.java
Last Date of this Revision: January 29, 2026

Purpose: provide selection insertion and merge sorting algorithms
Author: Bilal Hajar
School: CHHS
Course: Computer Programming 30
*/

public class Sorts
{

    /**
     * sorts an array using selection sort
     * pre array exists
     * post array sorted low to high
     */
    public static void selectionSort(int[] items)
    {
        for (int i = 0; i < items.length - 1; i++)
        {
            int minIndex = i;

            for (int j = i + 1; j < items.length; j++)
            {
                if (items[j] < items[minIndex])
                {
                    minIndex = j;
                }
            }

            // swap values
            int temp = items[i];
            items[i] = items[minIndex];
            items[minIndex] = temp;
        }
    }

    /**
     * sorts an array using insertion sort
     * pre array exists
     * post array sorted low to high
     */
    public static void insertionSort(int[] items)
    {
        for (int i = 1; i < items.length; i++)
        {
            int current = items[i];
            int previousIndex = i - 1;

            while (previousIndex >= 0 && items[previousIndex] > current)
            {
                // shift value right
                items[previousIndex + 1] = items[previousIndex];
                previousIndex--;
            }

            // place value
            items[previousIndex + 1] = current;
        }
    }

    /**
     * sorts items using merge sort
     * pre start and end valid
     * post items sorted low to high
     */
    public static void mergeSort(int[] items, int start, int end)
    {
        if (start < end)
        {
            int mid = (start + end) / 2;

            mergeSort(items, start, mid);
            mergeSort(items, mid + 1, end);
            merge(items, start, mid, end);
        }
    }

    /**
     * merges two sorted parts of array
     * pre parts sorted
     * post section merged
     */
    private static void merge(int[] items, int start, int mid, int end)
    {
        int[] temp = new int[items.length];

        int left = start;
        int right = mid + 1;
        int index = start;

        while (left <= mid && right <= end)
        {
            if (items[left] < items[right])
            {
                temp[index] = items[left];
                left++;
            }
            else
            {
                temp[index] = items[right];
                right++;
            }

            index++;
        }

        while (left <= mid)
        {
            temp[index] = items[left];
            left++;
            index++;
        }

        while (right <= end)
        {
            temp[index] = items[right];
            right++;
            index++;
        }

        // copy back
        for (int i = start; i <= end; i++)
        {
            items[i] = temp[i];
        }
    }
}
