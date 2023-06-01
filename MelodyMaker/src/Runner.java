import java.util.Arrays;
import java.util.LinkedList;
public class Runner {
    
    public static void main(String[] args) {
        QueueProbs qp = new QueueProbs();
        System.out.println(qp.evenFirst(new LinkedList<Integer>(Arrays.asList(3, 5,
4, 17, 6, 83, 1, 84, 16, 37))));
        System.out.println(qp.numPalindrome(new 
LinkedList<Integer>(Arrays.asList(3,2,2,3))));
        System.out.println(qp.numPalindrome(new 
LinkedList<Integer>(Arrays.asList(3,10,17,9,17,8,3))));
        System.out.println(qp.allPrime(1));
    }
    
}