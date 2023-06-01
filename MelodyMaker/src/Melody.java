import java.util.*;

public class Melody {
	private Queue<Note> notes;
	
	public Melody(Queue<Note> song)
	{
		notes = new LinkedList<>();
		while(!song.isEmpty())
			notes.offer(song.poll());
		
	}
	
	public double getTotalDuration()
	{
		int size = notes.size();
		double total = 0;
		boolean repeat = false;
		for(int i = 0; i < size; i++)
		{
			boolean start = false;
			if(notes.peek().isRepeat() && !repeat)
			{
				repeat = true;
				start = true;
			}
			if(repeat)
				total+=(notes.peek().getDuration()*2);
			else
				total+=notes.peek().getDuration();
			if(!start && notes.peek().isRepeat() && repeat)
				repeat = false;
			notes.offer(notes.poll());
		}
		return total;
	}
	
	public Queue<Note> getNotes() {
        return notes;
    }
	
	@Override
	public String toString()
	{
		String output = "";
		for(int i = 0; i < notes.size(); i++)
		{
			output+=notes.peek() + "\n";
			notes.offer(notes.poll());
		}
		return output;
	}
	
	public void changeTempo(double tempo)
	{
		for(int i = 0; i < notes.size(); i++)
		{
			Note note = notes.poll();
			note.setDuration(note.getDuration()/tempo);
			notes.offer(note);
		}
	}
	
	public void reverse()
	{
		Stack<Note> reverse = new Stack<>();
		while(!notes.isEmpty())
		{
			reverse.push(notes.poll());
		}
		while(!reverse.isEmpty())
		{
			notes.offer(reverse.pop());
		}
	}
	
	public void append(Melody other)
	{
		while(!other.getNotes().isEmpty())
		{
			notes.offer(other.getNotes().poll());
		}
	}
	
	public void play()
	{
		Queue<Note> repeat = new LinkedList<>();
		boolean repeated = false;
		for(int i = 0; i < notes.size(); i++)
		{
			boolean start = false;
			if(notes.peek().isRepeat() && !repeated)
			{
				repeated = true;
				start = true;
			}
			notes.peek().play();
			if(repeated)
			{
				repeat.offer(notes.peek());
				
			}
			if(repeated && !start && notes.peek().isRepeat())
			{
				repeated = false;
				while(!repeat.isEmpty())
				{
					repeat.poll().play();
				}
			}
			notes.offer(notes.poll());
		}
 	}
	
	
	

}
