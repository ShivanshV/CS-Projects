import java.util.*;

public class scramble {
	
	public static void main(String[] args)
	{
		wordScramble("amazing");
	}
	
	public static void wordScramble(String line)
    {
        String[] s = line.split(" "); 
        String result = "";
        for (int k = 0; k < s.length;k++)
        {
          result = "";
        int indexStart = -1;
        int indexEnd = -1;
        char[] charsOne = s[k].toCharArray();
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            for (int i = 0; i <s[k].length();i++)
            {
                for (int j =0; j < alphabet.length();j++)
                {
                    if (charsOne[i] == alphabet.charAt(j))
                  {
                      indexStart = i;
                      break;
                  }
                  if (indexStart >=0)
                      break;
                }
            }
            for (int i = s[k].length() -1; i >=0 ;i--)
            {
                for (int j =0; j < alphabet.length();j++)
                {
                    if (charsOne[i] == alphabet.charAt(j))
                  {
                      indexEnd = i;
                      break;
                  }
                  if (indexEnd >=0)
                      break;
                  
                }
            }
          if (indexStart == indexEnd || indexStart == (indexEnd- 1) || indexStart == (indexEnd -2))
              System.out.print(s[k] + " ");
          else
          {
              char[] charsTwo = s[k].substring((indexStart + 1), indexEnd).toCharArray();
              int[] randomNumber = new int[charsTwo.length];
              for (int i = 0; i < randomNumber.length; i++)
              {
                  Random randomGen = new Random();
                  boolean isUnique = false;
                  while (!isUnique)
                  {
                      randomNumber[i] = randomGen.nextInt(charsTwo.length);
                      for (int j = 0; j < randomNumber.length;j++)
                      {
                          if (randomNumber[i] == randomNumber[j] && i!=j)
                              {
                                  isUnique = false;
                                  break;
                              }
                          else
                              isUnique = true;
                      }
                  }
              }
              
              if (k == 1)
              {
                 for (int i = 0; i < randomNumber.length;i++)
              {
                  System.out.print(randomNumber[i]);
                  System.out.println();
              }
               
              }
              
              for (int i = 0; i< charsTwo.length;i++)
              {
                  result = result + charsTwo[randomNumber[i]];
              }
              System.out.println(s[k]);
              System.out.print((s[k].substring(0,indexStart+1)) + result + (s[k].substring(indexEnd)) + " ");
              
          }
          
          
        }          
        
    }

}
