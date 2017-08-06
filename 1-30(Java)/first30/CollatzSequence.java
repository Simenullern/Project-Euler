package first30;

public class CollatzSequence {
	// brute
	
	public static void run(){
		long longest=1;
		
		for (int j=2;j<1000000;j++){
			long length = findCollatzLength(j);
			if (length>longest){
				longest=length;
				System.out.println(j + " is a longer Collatz-sequence with " + length + " terms");
			}
		}
		System.out.println("answ: " + longest + " terms ");
	}
	
	private static long findCollatzLength(long i){
		long terms=1;
		long result = i;
		
		while (result != 1){
			if (result%2==0){
				result = result/2;
			} else {
				result = (result*3)+1;
			}
			terms++;
		}
		
		return terms;
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
