public class Node implements Comparable<Node>{
    public Node left;
    public Node right;
    public int freq;
    public int value;
    public Node(int v, int c)
    {
        freq = c;
        value = v;
    }
    public Node(int c)
    {
        this(-1,c);
    }
    public Node(int i, Node temp1, Node temp2) {
        this(-1,i);
        left = temp1;
        right = temp2;
    }
    public String toString()
    {
        return (char)value + ": " + freq;
    }
    public int compareTo(Node other)
    {
        if(freq == other.freq)
        {
            return value - other.value;
        }
        return freq - other.freq;
    }
    public boolean isLeaf()
    {
        return value != -1;
    }
}