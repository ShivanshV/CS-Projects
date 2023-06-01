import java.util.*;
import java.io.*;
public class HuffmanTree {
    Node root;
    public HashMap<Integer, String> dictionary;
    private HashMap<String, Integer> inverseDict;
    public HuffmanTree(int[] counts)
    {
        dictionary = new HashMap<>();
        inverseDict = new HashMap<>();
        Queue<Node> HuffmanQueue = new PriorityQueue<Node>();
        for(int i = 0 ; i < counts.length; i++)
        {
            if(counts[i] > 0)
            {
                HuffmanQueue.offer(new Node(i,counts[i]));
            }
        }
        HuffmanQueue.offer(new Node(256,1)); //EOF

        while(HuffmanQueue.size() > 1)
        {
            Node temp1 = HuffmanQueue.remove();
            Node temp2 = HuffmanQueue.remove();
            HuffmanQueue.add(new Node(temp2.freq+temp1.freq, temp1,
                    temp2));
        }
        root = HuffmanQueue.remove();
    }

    HuffmanTree(String codeFile) throws FileNotFoundException {
        dictionary = new HashMap<>();
        inverseDict = new HashMap<>();	
        root = new Node(0);
        Scanner console = null;
        try {
            console = new Scanner(new File(codeFile));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        while (console.hasNextLine())
        {
            int n = Integer.parseInt(console.nextLine());
            String code = console.nextLine();
            dictionary.put(n,code);
            inverseDict.put(code,n);
            HuffmanTreeHelper(n, code, root);
        }
        
    }
    void HuffmanTreeHelper(int n, String code, Node root)
    {
        if (code.length() == 0)
        {
            root.value = n;
        }
        else if (code.charAt(0) == '0')
        {
            if (root.left == null)
            {
                root.left = new Node(0);
            }
            HuffmanTreeHelper(n, code.substring(1), root.left);
        }
        else
        {
            if (root.right == null)
            {
                root.right = new Node(0);
            }
            HuffmanTreeHelper(n, code.substring(1), root.right);
        }
    }
    public void write(String fileName) throws FileNotFoundException
    {
        PrintWriter output = new PrintWriter(new File(fileName));
        write(output,root,"");
        output.close();
    }
    private void write(PrintWriter output, Node node, String s)
    {
        if(node == null)
        {
            return;
        }
        if(!node.isLeaf())
        {
            write(output,node.left, s + "0");
            write(output,node.right, s + "1");
        }
        if(node.isLeaf())
        {
            dictionary.put(node.value,s);
            inverseDict.put(s,node.value);
            output.println(node.value);
            output.println(s);
        }
    }
    public void encode(BitOutputStream out, String filename) throws IOException
    {
        Scanner console = null;
        String coded = "";
        try
        {
            console = new Scanner(new File(filename));
        }catch(FileNotFoundException e)
        {
            System.out.println("File not found");
        }
        while(console.hasNextLine())
        {
            String line = console.nextLine();

            for(int i = 0; i < line.length(); i++)
            {
                coded+=dictionary.get((int)line.charAt(i));
            }
            coded+=dictionary.get(13);


        }
        coded+=dictionary.get(256);
        System.out.println(coded);

        for(int i = 0; i < coded.length(); i++)
        {
            if(coded.substring(i,i+1).equals("0"))
            {
                out.writeBit(0);
            }
            if(coded.substring(i,i+1).equals("1"))
            {
                out.writeBit(1);
            }
        }
    }

    public void decode(BitInputStream in, String outFile) throws FileNotFoundException {
        String decoded = "";
        PrintWriter output = new PrintWriter(new File(outFile));
        while(true)
        {
            decoded += in.readBit();
            if(decoded.equals(dictionary.get(256)))
            {
                break;
            }
            if(dictionary.containsValue(decoded))
            {
                output.print((char)(int)inverseDict.get(decoded));
                decoded = "";
            }
        }
        output.close();
    }
}

