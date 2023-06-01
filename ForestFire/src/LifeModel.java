import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.Timer;

public class LifeModel implements ActionListener
{

    /*
     *  This is the Model component.
     */

    private static int SIZE = 60;
    private LifeCell[][] grid;

    LifeView myView;
    Timer timer;

    /** Construct a new model using a particular file */
    public LifeModel(LifeView view, String fileName) throws IOException
    {
        int r, c;
        grid = new LifeCell[SIZE][SIZE];
        for ( r = 0; r < SIZE; r++ )
            for ( c = 0; c < SIZE; c++ )
                grid[r][c] = new LifeCell();

        if ( fileName == null ) //use random population
        {
            for ( r = 0; r < SIZE; r++ )
            {
                for ( c = 0; c < SIZE; c++ )
                {
                    if ( Math.random() > 0.85) //15% chance of a cell starting alive
                        grid[r][c].setAliveNow(true);
                }
            }
        }
        else
        {
            Scanner input = new Scanner(new File(fileName));
            int numInitialCells = input.nextInt();
            for (int count=0; count<numInitialCells; count++)
            {
                r = input.nextInt();
                c = input.nextInt();
                grid[r][c].setAliveNow(true);
            }
            input.close();
        }

        myView = view;
        myView.updateView(grid);

    }

    /** Constructor a randomized model */
    public LifeModel(LifeView view) throws IOException
    {
        this(view, null);
    }

    /** pause the simulation (the pause button in the GUI */
    public void pause()
    {
        timer.stop();
    }

    /** resume the simulation (the pause button in the GUI */
    public void resume()
    {
        timer.restart();
    }

    public void randomize(boolean x)
    {
        myView.setRandomize(x);
        myView.updateView(grid);
    }



    /** run the simulation (the pause button in the GUI */
    public void run()
    {
        timer = new Timer(50, this);
        timer.setCoalesce(true);
        timer.start();
    }

    /** called each time timer fires */
    public void actionPerformed(ActionEvent e)
    {
        oneGeneration();
        myView.updateView(grid);
    }

    /** main logic method for updating the state of the grid / simulation */
    private void oneGeneration()
    {
       for(int r = 0; r < grid.length; r++)
       {
           for(int c = 0; c < grid[r]. length; c++)
           {
               if(grid[r][c].isAliveNow())
               {
                   if((numOccupied(r,c) >= 0 && numOccupied(r,c) <= 1) || (numOccupied(r,c) >= 4 && numOccupied(r,c) <= 8))
                       grid[r][c].setAliveNext(false);
                   else
                       grid[r][c].setAliveNext(true);
               }
               else
               {
                   if(numOccupied(r,c) == 3)
                       grid[r][c].setAliveNext(true);
               }

           }
       }

        for(int r = 0; r < grid.length; r++)
        {
            for (int c = 0; c < grid[r].length; c++)
            {
                grid[r][c].setAliveNow(grid[r][c].isAliveNext());
            }
        }
    }

    private int numOccupied(int row, int col)
    {
        int occupied = 0;
        if(grid[row][col].isAliveNow())
            occupied-=1;
        for(int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++)
            {
                try
                {
                    if(grid[row+i][col+j].isAliveNow())
                        occupied++;
                }catch(ArrayIndexOutOfBoundsException e){}

            }
        }
        return occupied;
    }
}