import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Scooby {

    public static void main(String[] args)
    {
        Scanner console;
        try
        {
            console = new Scanner(new File("scooby.dat"));
            int N = Integer.parseInt(console.nextLine());
            for(int i = 0; i < N; i++)
            {
                HashSet<Character> visited = new HashSet<>();
                HashMap<Character, ArrayList<Character>> edges = new HashMap<>();

                String input = console.nextLine();
                String output = console.nextLine();

                for(int j = 0 ; j < input.length()-1; j+=3)
                {
                    char key = input.substring(j,j+2).charAt(0);
                    char value = input.substring(j,j+2).charAt(1);
                    if(!edges.containsKey(key))
                        edges.put(key, new ArrayList<>());
                    if(!edges.containsKey(value))
                        edges.put(value, new ArrayList<>());
                    edges.get(key).add(value);
                    edges.get(value).add(key);

                }
                Stack<Character> path = new Stack<>();
                char end = output.charAt(1);
                char current = output.charAt(0);
                visited.add(current);
                path.push(current);
                if(edges.get(current) == null)
                {
                    System.out.println("no");
                }
                else
                {
                    boolean found = false;
                    while(!path.isEmpty())
                    {
                        if(path.peek() == end)
                        {
                            System.out.println("yes");
                            found = true;
                            break;
                        }

                        boolean fail = true;
                        for(int j = 0; j < edges.get(path.peek()).size(); j++)
                        {
                            if(!visited.contains(edges.get(path.peek()).get(j)))
                            {
                                visited.add(edges.get(path.peek()).get(j));
                                path.push(edges.get(path.peek()).get(j));
                                fail = false;
                                break;
                            }
                        }
                        if(fail)
                            path.pop();

                    }
                    if(!found)
                        System.out.println("no");

                }



            }
        }catch(FileNotFoundException e)
        {
            System.out.println("File not found");
        }


    }
}