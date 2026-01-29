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

    // adds item to queue
    public void enqueue(Object item)
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

    // removes item from queue
    public Object dequeue()
    {
        Object item = null;

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

    // returns front item
    public Object peek()
    {
        Object item = null;

        if (!isEmpty())
        {
            item = front.data;
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

    // node class
    private class Node
    {
        private Object data;
        private Node next;

        public Node(Object d)
        {
            data = d;
            next = null;
        }
    }
}
