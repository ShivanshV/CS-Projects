import java.util.EmptyStackException;

public class MyStack implements StackADT{
    private Square[] Stack;
    private int size;

    public MyStack()
    {
        this(2);
    }

    public MyStack(int initCap)
    {
        Stack = new Square[initCap];
        size = 0;
    }

    public int size()
    {
        return size;
    }

    @Override
    public void clear() {
        Stack = new Square[2];
        size = 0;
    }

    public  boolean isEmpty()
    {
        return size == 0;
    }

    public Square peek()
    {
        if(isEmpty())
            throw new EmptyStackException();
        return Stack[size-1];
    }

    public Square pop()
    {
        Square top = peek();
        Stack[size-1] = null;
        size-=1;
        return top;
    }

    private void doubleCapacity()
    {
        Square[] newStack = new Square[size*2];
        for(int i = 0; i < size; i++)
            newStack[i] = Stack[i];
        Stack = newStack;
    }

    public void push(Square item)
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
        str+="] <--- TOP";
        return str;

    }




}