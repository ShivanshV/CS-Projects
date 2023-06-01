import java.util.Random;
public class GuitarString2 
{
    public static final int SAMPLING_RATE = 44100;
    private RingBuffer2 buffer; // ring buffer
    int time = 0;
    int N;
    
    /** create a guitar string of the given frequency */
    public GuitarString2(double frequency) {
        N = (int) Math.ceil(SAMPLING_RATE/frequency);
        buffer = new RingBuffer2(N);
        for (int i = 0; i < N; i++) {
            buffer.enqueue(0.0);
        }
    }
    /** create a guitar string with size & initial values given by the array */
    public GuitarString2(double[] init) {
        buffer = new RingBuffer2(init.length);
        for (double d : init) {
            buffer.enqueue(d);
        }
    }
    /** pluck the guitar string by replacing the buffer with white noise */
    public void pluck() {
        while (!buffer.isEmpty()) {
            buffer.dequeue();
        }
        for (int i = 0; i < N; i++) {
            buffer.enqueue(Math.random()-0.5);
        }
    }
    /** advance the simulation one time step */
    public void tic() {
        double a = buffer.dequeue();
        double b = buffer.peek();
        buffer.enqueue((a + b) * 0.5 * 0.996);
        time++;
    }
    /** return the current sample */
    public double sample() {
        return buffer.peek();
    }
    /** return number of times tic was called */
    public int time() {
        return time;
    }
    public static void main(String[] args) {
        int N = 25;
        double[] samples = { .2, .4, .5, .3, -.2, .4, .3, .0, -.1, -.3 };  
        GuitarString testString = new GuitarString(samples);
        for (int i = 0; i < N; i++) {
            int t = testString.time();
            double sample = testString.sample();
            System.out.printf("%6d %8.4f\n", t, sample);
            testString.tic();
        }
        /*
         * Your program should produce the following output when the main() 
         * method runs (DON'T WORRY ABOUT VERY MINOR DIFFERENCES, E.G. OFF BY 0.001):
                0   0.2000
			    1   0.4000
			    2   0.5000
			    3   0.3000
			    4  -0.2000
			    5   0.4000
			    6   0.3000
			    7   0.0000
			    8  -0.1000
			    9  -0.3000
			   10   0.2988
			   11   0.4482
			   12   0.3984
			   13   0.0498
			   14   0.0996
			   15   0.3486
			   16   0.1494
			   17  -0.0498
			   18  -0.1992
			   19  -0.0006
			   20   0.3720
			   21   0.4216
			   22   0.2232
			   23   0.0744
			   24   0.2232
         */
    }
}