package first30;

import java.util.ArrayList;
import java.util.Collection;

public class DigitFifthPowers {
	
	public static void main(String[] args) {
		
		Collection <Integer> nums = new ArrayList<>();
		
		for (int i=2; i<355000; i++){
			int sumOfFifthPowers = 0;
			for (char c: (""+i).toCharArray()){
				sumOfFifthPowers += (Math.pow(Character.getNumericValue(c), 5));
			}
			if (i==sumOfFifthPowers){
				nums.add(i);
			}
		}
		
		int answ = nums.stream().reduce((a, b) -> a + b).get();
		System.out.println(answ);
		
	}

}
