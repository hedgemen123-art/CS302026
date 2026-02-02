package mastery;

import java.util.Scanner;

/*
Program: QueueListTest.java
Last Date of this Revision: January 29, 2026

Purpose: test QueueList with menu
Author: Bilal Hajar
School: CHHS
Course: Computer Programming 30
*/

public class QueueListTest
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        QueueList queue = new QueueList();

        int choice = 0;

        while (choice != 4)
        {
            System.out.println("\nQUEUE MENU");
            System.out.println("1. add item");
            System.out.println("2. remove item from front");
            System.out.println("3. display queue");
            System.out.println("4. quit");
            System.out.print("enter choice ");

            choice = input.nextInt();
            input.nextLine();

            if (choice == 1)
            {
                System.out.println("add to");
                System.out.println("1. front");
                System.out.println("2. rear");
                System.out.print("enter choice ");

                int addChoice = input.nextInt();
                input.nextLine();

                System.out.print("enter string ");
                String item = input.nextLine();

                if (addChoice == 1)
                {
                    queue.enqueueFront(item);
                }
                else if (addChoice == 2)
                {
                    queue.enqueueRear(item);
                }
            }
            else if (choice == 2)
            {
                if (!queue.isEmpty())
                {
                    System.out.println("removed " + queue.dequeue());
                }
                else
                {
                    System.out.println("queue is empty");
                }
            }
            else if (choice == 3)
            {
                queue.displayQueue();
                System.out.println("size " + queue.size());
            }
        }

        input.close();
    }
}
