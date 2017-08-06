package first30;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class AmicableNumbers {

	public static void run(int upperLim){
		Map <Integer, Integer> map = new HashMap<>();
		int amicSum = 0;

		Collection <Integer> amicableNums = new HashSet<>();

		for (int i=1; i<upperLim; i++){
			map.put(i, getEvenDivisorsSum(i));
		}

		for (int key: map.keySet()){
			if (map.containsKey(map.get(key)) && map.get(map.get(key))== key && key!=map.get(key)){
				if (!amicableNums.contains(key)){
					amicableNums.addAll(Arrays.asList(key, map.get(key)));
					amicSum += (key + map.get(key));
					System.out.println(key + " , " + map.get(key));
					System.out.println("\t "+ getEvenDivisorsSum(key) + ", " + getEvenDivisorsSum(map.get(key)));
				}
			}
		}
		
		System.out.println(amicSum);
	}

	public static int getEvenDivisorsSum(int num){
		int sum = 0;

		for (int j=1 ; j<num; j++){
			if (Integer.remainderUnsigned(num, j) == 0){
				sum += j;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		AmicableNumbers.run(10000);
	}


}



