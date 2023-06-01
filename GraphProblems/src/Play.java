import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Play {

    public static void main(String[] args)
    {
        Scanner console;
        try {
            console = new Scanner(new File("play.dat"));
            int N = Integer.parseInt(console.nextLine());
            for(int i = 0; i < N; i++)
            {
            	int numDom = console.nextInt()+1;
                boolean[][] dominoes = new boolean[numDom][numDom];
                int order = console.nextInt();
                int startNum = console.nextInt();
                console.nextLine();
                for(int j = 0; j < order; j++)
                {
                	
             
                	dominoes[console.nextInt()][console.nextInt()] = true;
                	
                }
                console.nextLine();
                int count = 0;
                HashSet<Integer> knocked = new HashSet<>();
                for(int j = 0; j < startNum; j++)
                {
                	Queue<Integer> queue = new LinkedList<>();
                	count+=1;
                	queue.offer(Integer.parseInt(console.nextLine()));
                	knocked.add(queue.peek());
                	while(!queue.isEmpty())
                	{
                		for(int c = 1; c < dominoes[queue.peek()].length; c++)
                    	{
                			if(knocked.contains(c) && dominoes[queue.peek()][c])
                				dominoes[queue.peek()][c] = false;
                    		if(dominoes[queue.peek()][c])
                    		{
                    			count+=1;
                    			queue.offer(c);
                    			dominoes[queue.peek()][c] = false;
                    		}
                    	}
                		queue.poll();
                	}
                	
                	
                }
                System.out.println(count);
            }
        }catch(FileNotFoundException e)
        {
            System.out.println("File not found");
        }
    }
}