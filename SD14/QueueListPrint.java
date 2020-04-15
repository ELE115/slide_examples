public class QueueListPrint<T>
{
    private class Node
    {
        private T item;
        private Node next;
    }
    private int size; 
    private Node head;
    private Node tail;
    public QueueListPrint()
    {
        size = 0;
        head = null;
        tail = null;
    }
    public boolean enqueue(T item)
    {
        Node tempNode = new Node();
        tempNode.item = item;
        tempNode.next = null; 
        if(tail != null)
        {
            tail.next = tempNode;
        }
        tail = tempNode;
        if(head == null)
        {
            head = tail;
        }
        size = size + 1;
        return true;
    }
    public T dequeue()
    {
        if(head == null)
        {
            return null;
        }
        if(head == tail)
        {
            tail = null;
        }
        T tempValue = head.item;
        head = head.next;
        size = size - 1;
        return tempValue;
    }
    public boolean isEmpty()
    {
        return (size > 0);
    }
    public int size()
    {
        return size;
    }
    public void print()
    {
        Node current = head;
        while(current != null)
        {
            System.out.println(current.item);
            current = current.next;
        }
    }
    public static void main(String[] argv)
    {
        QueueListPrint<Integer> s = new QueueListPrint<Integer>();
        s.enqueue(5);
        s.enqueue(6);
        s.enqueue(7);
        System.out.println(s.dequeue());
        System.out.println(s.dequeue());
        System.out.println(s.dequeue());
        System.out.println(s.dequeue());
        s.enqueue(9);
        s.enqueue(10);
        s.enqueue(11);
        s.print();
    }
}
