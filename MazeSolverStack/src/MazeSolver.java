import java.util.List;

public abstract class MazeSolver {
    private Maze maze;
    private boolean solved;
    private boolean reachable;
    


    public MazeSolver(Maze m)
    {
        maze = m;
        solved = false;
        reachable = true;
        
        
    }

    public abstract void makeEmpty();
    public abstract boolean isEmpty();
    public abstract void add(Square s);
    public abstract Square next();

    public boolean isSolved()
    {
        return solved;
    }

    public void step()
    {
        if(isEmpty())
        {
        	
            reachable = false;
            solved = true;
        }
        else
        {
            Square next = next();
            if(next.getType() == Square.EXIT)
            {
                solved = true;
                
            }
            else
            {
                List<Square> neighbors = maze.getNeighbors(next);
                
                for(Square s: neighbors)
                {
                    if(s.getType() != Square.WALL && s.getStatus() != Square.EXPLORED)
                    {
                        add(s);
                        s.setStatus(Square.WORKING);
                    }
                }
                next.setStatus(Square.EXPLORED);
            }
        }

    }

    public String  getPath()
    {
        if(!reachable && solved)
        	return "Maze is not solvable";
        if(reachable && !solved)
        	return "Maze is not yet solved";
        return "Maze is solved";
    }
    
    public void solve()
    {
        
    	while(!solved)
    		step();
    }



}