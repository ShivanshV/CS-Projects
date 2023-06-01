import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordLadder {
	
    public void findLadder(String start, String end) throws FileNotFoundException
    {
        Queue<Stack<String>> ladders = new LinkedList<>();
        Scanner console = new Scanner(new File("dictionary.txt"));
        Set<String> dictionary = new HashSet<>();
        boolean notFound = true;
        Set<String> used = new HashSet<>();
        while(console.hasNextLine())
            dictionary.add(console.nextLine());
        Stack<String> startLadder = new Stack<>();
        if(!dictionary.contains(start.toUpperCase()) || !dictionary.contains(end.toUpperCase()) || start.length() != end.length())
            System.out.println("No ladder between " + start + " and " +end);
        else
        {
        	
            used.add(start);
            startLadder.push(start);
            ladders.offer(startLadder);
            while(!ladders.isEmpty())
            {
                Stack<String> current = ladders.poll();
                if(current.peek().equalsIgnoreCase(end))
                {
                    System.out.println("Found a ladder! >>> " + current.toString());
                    
                    notFound = false;
                    break;
                }
                else
                {
                    ArrayList<String> possibleNeighbors = nextWord(current.peek());
                    for(int i = 0; i < possibleNeighbors.size(); i++)
                    {
                        if(dictionary.contains(possibleNeighbors.get(i).toUpperCase()) && !used.contains(possibleNeighbors.get(i)))
                        {
                        	used.add(possibleNeighbors.get(i));
                            Stack<String> neighbor_ladder = deepCopy(current, possibleNeighbors.get(i));
                            ladders.offer(neighbor_ladder);

                        }
                    }
                    
                }
            }
            if(ladders.isEmpty() && notFound)
            {
            	System.out.println("No ladder between " + start + " and " +end);
            }
        }

    }
    
    public static ArrayList<String> nextWord(String word)
    {
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < word.length(); i++)
        {
            for(char c = 'a'; c <= 'z'; c++)
            {
                String result = word.substring(0,i) + c + word.substring(i+1);
                if(!word.equalsIgnoreCase(result))
                    list.add(result);
            }
        }
        return list;

    }

    public Stack<String> deepCopy(Stack<String> stack, String word)
    {
    	
        Stack<String> deepStack = new Stack<String>();
        Stack<String> reverse = new Stack<String>();
        while(!stack.isEmpty())
        {
        	reverse.push(stack.pop());
        	
        }
        while(!reverse.isEmpty())
        {
        	stack.push(reverse.peek());
        	deepStack.push(reverse.pop());
        }
        deepStack.push(word);
        return deepStack;
    }


}