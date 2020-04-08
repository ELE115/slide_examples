public class StackArray<T>
{
    private T [] data; // holds actual data
    private int tos; // top of stack
    private int maxSize; 
    public StackArray(Class<T> type, int size)
    {
        maxSize = size;
        // The next two lines create an array which is generic in a type safe 
        // manner.  Note that we turn off a warning about the type safety
        @SuppressWarnings("unchecked")
        T[] data = (T[]) java.lang.reflect.Array.newInstance(type, size); 
        this.data = data;
        tos = -1;
    }
    public boolean push(T item)
    {
        // What should we do if we push more than the maxSize? return false
        if(tos + 1 == maxSize)
        {
            return false;
        }
        tos = tos + 1;
        data[tos] = item;
        return true;
    }
    public T pop()
    {
        if(tos == -1)
        {
            return null;
        }
        T tempValue = data[tos];
        tos = tos - 1;
        return tempValue;
    }
    public boolean isEmpty()
    {
        return (tos == -1);
    }
    public int size()
    {
        return tos;
    }
    public static void main(String[] argv)
    {
        StackArray<Integer> s = new StackArray<Integer>(Integer.class, 256);
        s.push(5);
        s.push(6);
        s.push(7);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
