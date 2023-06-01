import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Maze {

    private Square[][] maze;
    private Square start;
    private Square exit;

    public Maze()
    {

    }


    public boolean loadMaze(String filename)
    {
        try{
            Scanner input = new Scanner(new File(filename));
            maze = new Square[input.nextInt()][input.nextInt()];
            for(int r = 0; r < maze.length; r++)
            {
                for(int c = 0; c < maze[r].length; c++)
                {
                    maze[r][c] = new Square(r,c,input.nextInt());
                    if(maze[r][c].getType() == Square.START)
                        start = maze[r][c];
                    if(maze[r][c].getType() == Square.EXIT)
                        exit = maze[r][c];
                }
            }

        }catch (FileNotFoundException e)
        {
            System.out.println("File not Found!");
            return false;
        }
        return true;
    }

    public List<Square> getNeighbors(Square s) //start here and redo
    {
        ArrayList<Square> list = new ArrayList<>();
        int row = s.getRow();
        int col = s.getCol();
        if(!outOfBounds(row-1,col))
            list.add(maze[row-1][col]);
        if(!outOfBounds(row,col+1))
            list.add(maze[row][col+1]);
        if(!outOfBounds(row+1,col))
            list.add(maze[row+1][col]);
        if(!outOfBounds(row,col-1))
            list.add(maze[row][col-1]);
        return list;


    }
    private boolean outOfBounds(int r, int c)
    {
        return r >= maze.length || r < 0 || c >= maze[r].length || c< 0;
    }

    public Square getStart()
    {
       return start;
    }
    public Square getExit()
    {
        return exit;
    }

    public void reset()
    {
        for(int r = 0; r < maze.length; r++)
        {
            for(int c = 0; c < maze[r].length; c++)
            {
                maze[r][c].reset();
            }
        }
    }
    public String toString()
    {
        String output = "";
        for(Square[] array: maze)
        {
            for(Square s: array)
            {
                output += s.toString();
            }
            output+='\n';
        }
        return output;
    }




}