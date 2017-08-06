package first30;


public class A10001stPrime {
	// brute
	
	public static void run(){
		
		int num=2;
		int counter=1;
		
		while (counter<10001){
			num++;
			if (isPrime(num)) {
				counter++;
			}
		}
		System.out.println("10001th prime is " + num);
	}
	
	private static boolean isPrime(long p){
		for (int i=2;i<p-1;i++){
			if (p%i==0){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		run();
		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		System.out.println("Took "+(elapsedTime) + " ns to run"); 
		double seconds = (double)elapsedTime / 1000000000.0; 
		System.out.println("Which is " + seconds + " seconds"); 
	}

}
