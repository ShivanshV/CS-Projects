import java.util.*;
import java.io.*;
public class HuffmanCompressor {

    public static void main(String[] args) throws IOException {
        compress("hamlet.txt");
        exapnd("write.txt","encode.short");
    }

    public static void compress(String filename) throws IOException {
       Scanner console;
        int[] frequency = new int[256];
        try {
            console = new Scanner(new File(filename));
            while (console.hasNextLine())
            {
                String line = console.nextLine();
                for(int i  = 0 ; i < line.length(); i++)
                {
                    frequency[(int)line.charAt(i)]+=1;
                }
                frequency[13]+=1; //CR
            }
        }catch(FileNotFoundException e)
        {
            System.out.println("File not found");
        }
        HuffmanTree huffman = new HuffmanTree(frequency);
        huffman.write("write.txt");
        BitOutputStream out = new BitOutputStream("encode.short");
        huffman.encode(out,filename);
        out.close();

    }

    public static void exapnd(String codeFile, String fileName) throws FileNotFoundException //.txt , .short
    {
        HuffmanTree huffman = new HuffmanTree(codeFile);
        BitInputStream in = new BitInputStream(fileName);
        huffman.decode(in,"output.txt");
    }
}