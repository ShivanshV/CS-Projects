import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class ShortestPath {
public static void main(String[] args) {
try
{
Scanner console = new Scanner(new File("usa.txt"));
int N = console.nextInt();
int P = console.nextInt();
Vertices[] vertices = new Vertices[N];
for(int i = 0; i < N; i++)
{
int index = console.nextInt();
vertices[index] = new Vertices(index, console.nextInt(),
console.nextInt());
}
ArrayList<Integer>[] adjList = new ArrayList[N];
for(int i = 0; i < P; i++)
{
int index = console.nextInt();
if(adjList[index] == null)
adjList[index] = new ArrayList<>();
int value = console.nextInt();
adjList[index].add(value);
if(adjList[value] == null)
adjList[value] = new ArrayList<>();
adjList[value].add(index);
}
//int startIndex = console.nextInt();
//int endIndex = console.nextInt();
vertices[0].setDistance(0);
Queue<Vertices> queue = new PriorityQueue<>();
for(int i = 0; i < N; i++)
{
queue.offer(vertices[i]);
}
while(!queue.isEmpty())
{
Vertices vertex = queue.poll();
vertex.visited = true;
for(int i = 0; i < adjList[vertex.index].size(); i++)
{
Vertices next = vertices[adjList[vertex.index].get(i)];
double d = vertex.getDistance() + vertex.distanceBetween(next);
if(vertex.getDistance() + vertex.distanceBetween(next) <
next.getDistance() && !next.visited)
{
next.setDistance(vertex.getDistance()+
vertex.distanceBetween(next));
next.setPred(vertex);
queue.remove(next);
queue.offer(next);
}
}
}
for(Vertices v: vertices)
{
	System.out.println(v.index + " " + v.getDistance());
}

}catch(FileNotFoundException e)
{
System.out.println("File not found");
}
}
}