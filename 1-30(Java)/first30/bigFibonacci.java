package first30;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class bigFibonacci {
	
	public static List <BigInteger> mem = new ArrayList<>();
	
	public static BigInteger fib (int n){
		if (mem.size() < n){
			mem.add(fib(n-1).add(fib(n-2)));
		}
		return mem.get(n-1);
	}
	
	public static void main(String[] args) {
		
		mem.add(BigInteger.ONE);
		mem.add(BigInteger.ONE);
		
		int index = 0;
		
		while ((mem.get(mem.size()-1) + "").length() < 1000){
			index++;
			System.out.println(fib(index));
		}
		
		System.out.println("answ: " + mem.size());
	}
	

}
