package first30;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NonAbundantSums {
	
	public static int sumOfDivisors (int num){
		List<Integer> divisors = new ArrayList<>();
		for (int i=1; i<num; i++){
			if (num%i==0){
				divisors.add(i);
			}
		}
		return divisors.stream().mapToInt(Integer::intValue).sum();
	}
	
	public static boolean isAbundant(int num, int sum){
		return sum>num;
	}
	
	public static List<Integer> getAbundantNumbers(int upperLim){
		List<Integer> ut = new ArrayList<>();
		for (int num=1; num<upperLim; num++){
			if (isAbundant(num, sumOfDivisors(num))){
				ut.add(num);
			}
		}
		return ut;
	}
	
	public static boolean isSumOfTwoAbundantNumbers(int num, int upperLim, Collection<Integer> abundantNumbers){
		for (int a1 : abundantNumbers){
			for (int a2 : abundantNumbers){
				if (a1 + a2 == num){
					System.out.println(a1 + " + " + a2 + " = " + num);
					return true;
				} else if (a1 + a2 > num){
					break;
				}
			}
		} return false;
	}
	
	public static void main(String[] args) {
		int upperLim = 28123;
		int sum = 0;
		List<Integer> abundantNumbers = getAbundantNumbers(upperLim);
		
		for (int num=1; num<upperLim; num++){
			System.out.println(num + " of 28123");
			if (!isSumOfTwoAbundantNumbers(num, upperLim, abundantNumbers)){
				sum += num;
			}
		}
		System.out.println(sum);
	}

}
