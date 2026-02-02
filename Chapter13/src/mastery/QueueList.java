package mastery;

/*
Program: QueueList.java
Last Date of this Revision: January 29, 2026

Purpose: implement a queue using a linked list
Author: Bilal Hajar
School: CHHS
Course: Computer Programming 30
*/

public class QueueList
{

    private Node front;
    private Node rear;
    private int size;

    public QueueList()
    {
        front = null;
        rear = null;
        size = 0;
    }

    // adds item to front
    public void enqueueFront(String item)
    {
        Node newNode = new Node(item);

        if (isEmpty())
        {
            front = newNode;
            rear = newNode;
        }
        else
        {
            newNode.next = front;
            front = newNode;
        }

        size++;
    }

    // adds item to rear
    public void enqueueRear(String item)
    {
        Node newNode = new Node(item);

        if (isEmpty())
        {
            front = newNode;
            rear = newNode;
        }
        else
        {
            rear.next = newNode;
            rear = newNode;
        }

        size++;
    }

    // removes item from front
    public String dequeue()
    {
        String item = null;

        if (!isEmpty())
        {
            item = front.data;
            front = front.next;
            size--;

            if (front == null)
            {
                rear = null;
            }
        }

        return item;
    }

    // checks if queue empty
    public boolean isEmpty()
    {
        return size == 0;
    }

    // returns queue size
    public int size()
    {
        return size;
    }

    // displays queue
    public void displayQueue()
    {
        if (isEmpty())
        {
            System.out.println("queue is empty");
            return;
        }

        Node current = front;

        System.out.print("queue front -> ");

        while (current != null)
        {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println("<- rear");
    }

    // node class
    private class Node
    {
        private String data;
        private Node next;

        public Node(String d)
        {
            data = d;
            next = null;
        }
    }
}
