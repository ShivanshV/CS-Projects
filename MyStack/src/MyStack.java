import java.util.EmptyStackException;

public class MyStack {
    private Integer[] Stack;
    private int size;

    public MyStack()
    {
        this(2);
    }

    public MyStack(int initCap)
    {
        Stack = new Integer[initCap];
        size = 0;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public Integer peek()
    {
        if(isEmpty())
            throw new EmptyStackException();
        return Stack[size-1];
    }

    public Integer pop()
    {
        int top = peek();
        Stack[size-1] = null;
        size-=1;
        return top;
    }

    private void doubleCapacity()
    {
        Integer[] newStack = new Integer[size*2];
        for(int i = 0; i < size; i++)
            newStack[i] = Stack[i];
        Stack = newStack;
    }

    public void push(Integer item)
    {
        if(size == Stack.length)
            doubleCapacity();
        Stack[size] = item;
        size++;
    }

    @Override
    public String toString()
    {
        String str = "[";
        for(int i = 0; i< size; i++)
        {
            str+=Stack[i];
            if(i != size-1)
                str+=", ";
        }
        str+="]";
        return str;

    }




}
