package first30;

import java.math.BigInteger;

public class FactorialDigitSum {
	
	public static BigInteger factorial(BigInteger n) {
	    BigInteger result = BigInteger.ONE;

	    while (!n.equals(BigInteger.ZERO)) {
	        result = result.multiply(n);
	        n = n.subtract(BigInteger.ONE);
	    }
	    return result;
	}
	
	public static void run(){
		String bigString = factorial(BigInteger.valueOf(100)) + "";
		System.out.println(bigString);
		
		int sum=0;
		for (char c:bigString.toCharArray()){
			sum += Character.getNumericValue(c);
		}
		
		System.out.println("answ: " + sum);
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
