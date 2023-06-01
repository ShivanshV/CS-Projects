import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class runner {
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		WordLadder wordLadder = new WordLadder();
		wordLadder.findLadder("dears", "fears");
		wordLadder.findLadder("heart", "heart");
		wordLadder.findLadder("sail", "ruin");
		wordLadder.findLadder("mikhail", "jeff");
		wordLadder.findLadder("slow", "fast");
		wordLadder.findLadder("blue", "pink");
		wordLadder.findLadder("bluw", "pink");
		wordLadder.findLadder("stone", "money");
		wordLadder.findLadder("money", "smart");
		wordLadder.findLadder("devil", "angel");
		wordLadder.findLadder("atlas", "zebra");
		wordLadder.findLadder("babes", "child");
		wordLadder.findLadder("mumbo", "ghost");
		wordLadder.findLadder("train", "bikes");
		wordLadder.findLadder("babies", "sleepy");
		wordLadder.findLadder("brewing", "whiskey");		

		
	}

}
