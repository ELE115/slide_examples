public class DequeList<T>
{
    private class Node
    {
        private T item;
        private Node next;
        private Node previous;
    }
    private int size; 
    private Node head;
    private Node tail;
    public DequeList()
    {
        size = 0;
        head = null;
        tail = null;
    }
    public boolean pushBack(T item)
    {
        Node tempNode = new Node();
        tempNode.item = item;
        tempNode.next = null; 
        tempNode.previous = tail;
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
    public boolean pushFront(T item)
    {
        Node tempNode = new Node();
        tempNode.item = item;
        tempNode.next = head; 
        tempNode.previous = null;
        if(head != null)
        {
            head.previous = tempNode;
        }
        head = tempNode;
        if(tail == null)
        {
            tail = head;
        }
        size = size + 1;
        return true;
    }
    public T popFront()
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
        head.previous = null;
        size = size - 1;
        return tempValue;
    }
    public T popBack()
    {
        if(tail == null)
        {
            return null;
        }
        if(tail == head)
        {
            head = null;
        }
        T tempValue = tail.item;
        tail = tail.previous;
        tail.next = null;
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
    public void printForward()
    {
        Node current = head;
        while(current != null)
        {
            System.out.println(current.item);
            current = current.next;
        }
    }
    public void printBackward()
    {
        Node current = tail;
        while(current != null)
        {
            System.out.println(current.item);
            current = current.previous;
        }
    }
    public static void main(String[] argv)
    {
        DequeList<Integer> s = new DequeList<Integer>();
        s.pushFront(5);
        s.pushFront(6);
        s.pushFront(7);
        s.pushBack(4);
        s.pushBack(3);
        s.pushBack(2);
        s.pushBack(1);
        s.printForward();
        System.out.println();
        s.printBackward();
        System.out.println();
        System.out.println(s.popFront());
        System.out.println(s.popFront());
        System.out.println(s.popBack());
        System.out.println(s.popBack());
        System.out.println();
        s.printForward();
    }
}
