package first30;

import java.math.BigInteger;

public class PowerDigitSum {
	
	public static void run(){
		
		int result = 0;
		String bigNum = BigInteger.valueOf(2).pow(1000) + "";
		System.out.println(bigNum);

		for(char a : bigNum.toCharArray()){
		    result = result + Character.getNumericValue(a);
		}
		System.out.println("answer: " + result);
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
