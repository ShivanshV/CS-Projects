import java.sql.SQLOutput;
import java.util.Stack;

public class Stacktest {

    public static void main(String[] args)
    {
        Stack<Integer> stack = new Stack<>();
        System.out.println(stack.isEmpty());
        for(int i = 0 ; i < 5; i ++)
        {
            stack.push(i*10);
        }
        System.out.println(stack);
        for(int i = 0 ; i < 5; i ++)
        {
            stack.push(stack.pop());
        }
        System.out.println(stack);
        Stack<Integer> s = new Stack<>();
        while(!stack.isEmpty())
        {
            s.push(stack.pop());
        }
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(stack.pop());
    }
}
