package first30;

import java.util.ArrayList;
import java.util.List;

public class EvenFibonacciNumbers {

	private static void run(){
		System.out.println(getEvenFibonaccisLessThan(4000000));
	}

	private static int getEvenFibonaccisLessThan(int maxLimit){
		List <Integer> liste = new ArrayList<>();
		liste.add(1); 
		liste.add(2);
		
		int sum=2; 
		int nextFib = 3;

		while (nextFib<maxLimit){
			liste.add(nextFib);
			int last = liste.get(liste.size()-1);
			int nextLast = liste.get(liste.size()-2);
			nextFib = last+nextLast;
			if (nextFib%2==0){
				sum+=nextFib;
			}
		} 
		return sum;
	}
	
	public static void main(String[] args) {
		run();
	}

}
