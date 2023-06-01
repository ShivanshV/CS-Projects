import java.util.*;
public class PrimePath {
	
	public static void main(String[] args)
	{
		ArrayList<Integer> primes = new ArrayList<>();
		for(int i = 1000; i < 10000; i++)
		{
			boolean isPrime = true;
			for(int j = 2; j <= Math.sqrt(i); j++)
			{
				if(i % j == 0)
				{
					isPrime = false;
					break;
				}
					
				
			}
			if(isPrime)
				primes.add(i);
			
		}
		
		ArrayList<Integer>[] adjMatrix = new ArrayList[10000];
		
		for(int i = 0; i < primes.size(); i++)
		{
			for(int j = 0; j<primes.size(); j++)
			{
				if(differOne(primes.get(i),primes.get(j)))
				{
					if(adjMatrix[primes.get(i)] == null)
						adjMatrix[primes.get(i)] = new ArrayList<Integer>();
					adjMatrix[primes.get(i)].add(primes.get(j));
				}
				
			}
		}
		
		Scanner console = new Scanner(System.in);
		int start = console.nextInt();
		int end = console.nextInt();
		
		if(adjMatrix[start] == null || adjMatrix[start] == null)
			System.out.println("One is not a prime number");
		else
		{
			int[] distance = new int[10000];
			Arrays.fill(distance, -1);
			
			distance[start] = 0;
			Queue<Integer> queue = new LinkedList<>();
			queue.offer(start);
			boolean found = false;
			while(!queue.isEmpty())
			{
				for(int i = 0; i < adjMatrix[queue.peek()].size(); i++)
				{
					if(distance[adjMatrix[queue.peek()].get(i)]== -1)
					{
						distance[adjMatrix[queue.peek()].get(i)] = distance[queue.peek()]+1;
						queue.offer(adjMatrix[queue.peek()].get(i));
						if(adjMatrix[queue.peek()].get(i) == end)
						{
							found = true;
							break;
						}
							
					}
				}
				queue.poll();
				if(found)
					break;
			}
			System.out.println(distance[end]);
		}
		
		
		
	}
	
	public static boolean differOne(int prime1, int prime2)
	{
		int count = 0;
		while(prime1 != 0)
		{
			if(prime1 % 10 != prime2 % 10)
			{
				count++;
			}
			if(count > 1)
				return false;
			prime1/=10;
			prime2/=10;
		}
		return count == 1;
		
	}

}
