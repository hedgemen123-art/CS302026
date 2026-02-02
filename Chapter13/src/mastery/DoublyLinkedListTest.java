package mastery;

/*
Program: DoublyLinkedListTest.java
Last Date of this Revision: January 29, 2026

Purpose: test doubly linked list methods
Author: Bilal Hajar
School: CHHS
Course: Computer Programming 30
*/

public class DoublyLinkedListTest
{

    public static void main(String[] args)
    {
        DoublyLinkedList list = new DoublyLinkedList();

        list.addAtFront("Raj");
        list.addAtEnd("Jeni");
        list.addAtEnd("Yuri");

        System.out.println("display forward");
        list.displayList();

        System.out.println("display reverse");
        list.displayReverseList();

        System.out.println("remove jeni");
        list.remove("Jeni");

        System.out.println("display forward");
        list.displayList();

        System.out.println("display reverse");
        list.displayReverseList();
    }
}
