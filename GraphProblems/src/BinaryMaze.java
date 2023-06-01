import java.util.*;
import java.io.*;

public class BinaryMaze {

	public static void main(String[] args)
	{
		try {
			Scanner console = new Scanner(new File("maze.dat"));
			int R = console.nextInt();
			int C = console.nextInt();
			int T = console.nextInt();
			
			
			
				int[][] maze = new int[R][C];
				for(int r = 0; r < R; r++)
				{
					for(int c  = 0; c< C; c++)
					{
						maze[r][c] = console.nextInt();
					}
				}
				
				boolean[][] matrix = new boolean[R*C][R*C];
				for(int r = 0; r< maze.length; r++)
				{
					for(int c = 0; c<maze[r].length; c++)
					{
						if (maze[r][c] == 1) {
	                        if (r > 0 && maze[r - 1][c] == 1) {
	                            matrix[r*C+c][(r - 1)*C+c] = true;
	                        }
	                        if (r < maze.length - 1 && maze[r + 1][c] == 1) {
	                        	 matrix[r*C+c][(r + 1)*C+c] = true;
	                        }
	                        if (c > 0 && maze[r][c - 1] == 1) {
	                        	 matrix[r*C+c][r*C+(c-1)] = true;
	                        }
	                        if (c < maze[r].length - 1 && maze[r][c + 1] == 1) {
	                        	 matrix[r*C+c][r*C+(c+1)] = true;
	                        }
	                    }
					}
				}
				for(int i = 0; i < T; i++)
				{
				
				int startR = console.nextInt();
				int startC = console.nextInt();
				int startIndex = startR*C + startC;
				int endR = console.nextInt();
				int endC = console.nextInt();
				int endIndex = endR*C + endC;
				
				int[] distance = new int[R*C];
				for(int j = 0; j < distance.length; j++)
				{
					distance[j] = -1;
				}
				distance[startIndex] = 0;
				Queue<Integer> queue = new LinkedList<>();
				queue.offer(startIndex);
				boolean found = false;
				while(!queue.isEmpty())
				{
					for(int c = 0; c < matrix[queue.peek()].length; c++)
					{
						if(matrix[queue.peek()][c] && distance[c] == -1)
						{
							distance[c] = distance[queue.peek()]+1;
							queue.offer(c);
							if(c == endIndex)
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
				System.out.println(distance[endIndex]);
			}
			
			
		}catch(FileNotFoundException e)
		{
			System.out.println("File not found");
		}
		
	}
}
