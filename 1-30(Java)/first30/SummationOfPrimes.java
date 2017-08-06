package first30;

public class SummationOfPrimes {
	
	public static void run(){
		long sum=2;
		
		for (long m=3;m<2000000;m+=2){
			if (isPrime(m)){
				System.out.println(m +" is prime");
				sum+=m;
			}
		}
		System.out.println("sum " + sum);
	}
	
	private static boolean isPrime(long p){
		// tilstrekkelig å sjekke opptil kvadratroten
		double sq = Math.sqrt(p);
		int limit = (int)sq;
		for (int i=2;i<limit+1;i++){
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
		long elapsedNs = endTime - startTime;
		double elapsedS = (double)elapsedNs / 1000000000.0; 
		System.err.println("\t" + "Took "+(elapsedNs) + " ns to run, which is " + elapsedS + " seconds"); ; 
	}

}
