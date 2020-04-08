public class QueueArray<T>
{
    private T [] data; // holds actual data
    private int head;
    private int tail;
    private int maxSize; 
    public QueueArray(Class<T> type, int size)
    {
        maxSize = size;
        // The next two lines create an array which is generic in a type safe 
        // manner.  Note that we turn off a warning about the type safety
        @SuppressWarnings("unchecked")
        T[] data = (T[]) java.lang.reflect.Array.newInstance(type, size); 
        this.data = data;
        head = 0;
        tail = 0;
    }
    public boolean enqueue(T item)
    {
        // If full, return false
        if(((tail + 1) % maxSize ) == head)
        {
            return false;
        }
        data[tail] = item;
        tail = (tail + 1) % maxSize;
        return true;
    }
    public T dequeue()
    {
        if(head == tail)
        {
            return null;
        }
        T tempValue = data[head];
        head = (head + 1) % maxSize;
        return tempValue;
    }
    public boolean isEmpty()
    {
        return (head == tail);
    }
    public int size()
    {
        return (head - tail) % maxSize;
    }
    public static void main(String[] argv)
    {
        QueueArray<Integer> s = new QueueArray<Integer>(Integer.class, 256);
        s.enqueue(5);
        s.enqueue(6);
        s.enqueue(7);
        System.out.println(s.dequeue());
        System.out.println(s.dequeue());
        System.out.println(s.dequeue());
        System.out.println(s.dequeue());
    }
}
