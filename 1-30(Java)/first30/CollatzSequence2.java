package first30;

public class CollatzSequence2 {
	
	public static void run(){
		int reach = 1000000;
		 
		int sequenceLength = 0;
		int startingNumber = 0;
		long sequence;
		 
		int[] cache = new int[reach + 1];
		//Initialise cache 
		for (int i = 0; i < cache.length; i++) {
		    cache[i] = -1;
		}
		cache[1] = 1;
		 
		for (int i = 2; i <= reach; i++) {
		    sequence = i;
		    int k = 0;
		    while (sequence != 1 && sequence >= i) {
		        k++;
		        if ((sequence % 2) == 0) {
		            sequence = sequence / 2;
		        } else {
		            sequence = sequence * 3 + 1;
		        }
		    }
		    //Store result in cache
		    cache[i] = k + cache[(int) sequence];
		 
		    //Check if sequence is the best solution
		    if (cache[i] > sequenceLength) {
		        sequenceLength = cache[i];
		        startingNumber = i;
		    }
		}
		System.out.println("Answer: " + sequenceLength + " with number " + startingNumber);
	}
	
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		run();
		long endTime = System.nanoTime();
		long elapsedNs = endTime - startTime;
		double elapsedS = (double)elapsedNs / 1000000000.0; 
		System.err.println("\t" + "Took "+(elapsedNs) + " ns to run program, which is " + elapsedS + " seconds"); 
	}

}
