package first30;

import java.util.ArrayList;
import java.util.Collections;

public class LargestPrimeFactor {

	public static void run(){
		long value = 600851475143L;
		System.out.println("Our value is: " + value);
		
		ArrayList<Integer> primeFactors = new ArrayList<>();		

		for (int i=2;i<value;i++){
			if (isPrime(i) && value%i==0){
				System.out.println("Prime factor " + i);
				primeFactors.add(i);
				if (isFinished(primeFactors, value)) {
					break;
				}
			}
		}
		System.out.println("Primefactors: " + primeFactors);
		System.out.println("Largest primefactor: " + Collections.max(primeFactors));
	}

	private static boolean isPrime(long p){
		for (int i=2;i<p-1;i++){
			if (p%i==0){
				return false;
			}
		}
		return true;
	}
	
	private static boolean isFinished (ArrayList<Integer> pfactors, long cap){
		long sum=1;
		for (long i:pfactors){
			sum*=i;
		}
		System.out.println("Current multiple is " + sum);
		return sum==cap;
	}

	public static void main(String[] args) {
		run();
	}


}
