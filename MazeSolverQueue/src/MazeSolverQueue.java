
public class MazeSolverQueue extends MazeSolver{
	private MyQueue worklist;
	
	public MazeSolverQueue(Maze m) {
		super(m);
		worklist = new MyQueue();
		add(m.getStart()); 
	}
	@Override
	public void add(Square s)
	{
		worklist.offer(s);
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
		return (Square) worklist.poll();
	}
	

}
