package mastery;

/*
Program: DoublyLinkedList.java
Last Date of this Revision: January 29, 2026

Purpose: implement a doubly linked list
Author: Bilal Hajar
School: CHHS
Course: Computer Programming 30
*/

public class DoublyLinkedList
{

    private Node head;
    private Node tail;

    public DoublyLinkedList()
    {
        head = null;
        tail = null;
    }

    // adds node to front
    public void addAtFront(String value)
    {
        Node newNode = new Node(value);

        if (head == null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // adds node to end
    public void addAtEnd(String value)
    {
        Node newNode = new Node(value);

        if (tail == null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // removes first matching value
    public void remove(String value)
    {
        Node current = head;

        while (current != null)
        {
            if (current.data.equals(value))
            {
                if (current == head)
                {
                    head = current.next;
                }
                else
                {
                    current.prev.next = current.next;
                }

                if (current == tail)
                {
                    tail = current.prev;
                }
                else
                {
                    current.next.prev = current.prev;
                }
            }

            current = current.next;
        }
    }

    // displays list forward
    public void displayList()
    {
        Node current = head;

        while (current != null)
        {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    // displays list backward
    public void displayReverseList()
    {
        Node current = tail;

        while (current != null)
        {
            System.out.print(current.data + " ");
            current = current.prev;
        }

        System.out.println();
    }

    // node class
    private class Node
    {
        private String data;
        private Node next;
        private Node prev;

        public Node(String d)
        {
            data = d;
            next = null;
            prev = null;
        }
    }
}
