
public class GuitarHero {
	
	 public static void main(String[] args) {
		 
		 String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
		 GuitarString[] notes = new GuitarString[37];
		 for(int i = 0; i < notes.length; i++)
		 {
			 notes[i] = new GuitarString(440*Math.pow(1.05956, i-24));
		 }

	      
	        while (true) {

	            // check if the user has typed a key, and, if so, process it
	            if (StdDraw.hasNextKeyTyped()) {

	                // the user types this character
	                char key = StdDraw.nextKeyTyped();

	                // pluck the corresponding string
	                try {
	                	int index = keyboard.indexOf(key);
	                	notes[index].pluck();
	                }catch(IndexOutOfBoundsException e)
	                {
	                	System.out.println("Invalid Key");
	                }
	                
	            }

	            // compute the superposition of the samples
	            double sample = 0;
	            for(int i = 0; i < notes.length; i++)
	            {
	            	sample += notes[i].sample();
	            }

	            // send the result to standard audio
	            StdAudio.play(sample);

	            // advance the simulation of each guitar string by one step
	            for(int i=0; i < notes.length; i++)
	            {
	            	notes[i].tic();
	            }
	        }
	 }

}
