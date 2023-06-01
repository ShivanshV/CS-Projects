import java.util.*;
public class QueueProbs {

    public Queue<Integer> evenFirst(Queue<Integer> nums) {
        Queue<Integer> evenFirst = new LinkedList<>();
        int size = nums.size();
        for(int i = 0; i < size; i++)
        {
            if(nums.peek() % 2 == 1)
                nums.offer(nums.poll());
            else
                evenFirst.offer(nums.poll());
        }
        while(!nums.isEmpty())
        {
            evenFirst.offer(nums.poll());
        }
        return evenFirst;
    }

    public boolean numPalindrome(Queue<Integer> nums)
    {
    	int size = nums.size();
        double middle = (nums.size()-1)/2.0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < size; i++)
        {
            if(i < middle)
            	stack.push(nums.poll());
            else if(i == middle)
            	nums.poll();
        }
        if(stack.isEmpty() && nums.isEmpty())
        	return true;
        while(!nums.isEmpty())
        {
        	if(stack.pop() != nums.poll())
        		return false;
        }
        return true;
    }
    
    public Stack<Integer> allPrime(int n)
    {
    	Stack<Integer> primes = new Stack<>();
    	if(n < 2)
    	{
    		return primes;
    	}
    	Queue<Integer> numbers = new LinkedList<>();
    	for(int i = 2; i <= n; i++)
    	{
    		numbers.offer(i);
    	}
    	while(!numbers.isEmpty())
    	{
    		primes.push(numbers.poll());
    		int size = numbers.size();
    		for(int i = 0; i < size; i++)
    		{
    			if(numbers.peek() % primes.peek() == 0)
    				numbers.poll();
    			else
    				numbers.offer(numbers.poll());
    		}
    	}
    	return primes;
    	
    }

}