
public class MazeSolverStack extends MazeSolver{
	private MyStack worklist;
	
	public MazeSolverStack(Maze maze)
	{
		super(maze);
		worklist = new MyStack();
		add(maze.getStart()); //moved add method here instead of keeping in MazeSolver because the worklist was not initialized before the Square could be added
	}
	
	@Override
	public void add(Square s)
	{
		worklist.push(s);
	}
	
	@Override
	public void makeEmpty()
	{
		worklist.clear();
	}
	
	@Override
	public boolean isEmpty()
	{
		return worklist.isEmpty();
	}
	
	@Override
	public Square next()
	{
		return worklist.pop();
	}

}
