public class StackList<T>
{
    private class Node
    {
        private T item;
        private Node next;
    }
    private int size; 
    private Node head;
    public StackList()
    {
        size = 0;
        head = null;
    }
    public boolean push(T item)
    {
        Node tempNode = new Node();
        tempNode.item = item;
        tempNode.next = head;
        head = tempNode;
        size = size + 1;
        return true;
    }
    public T pop()
    {
        if(size <= 0)
        {
            return null;
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
    public static void main(String[] argv)
    {
        StackList<Integer> s = new StackList<Integer>();
        s.push(5);
        s.push(6);
        s.push(7);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
