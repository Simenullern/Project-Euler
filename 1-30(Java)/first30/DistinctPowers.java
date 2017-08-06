package first30;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;

public class DistinctPowers {
	
	public static void main(String[] args) {
		
		Collection <BigInteger> list = new ArrayList<>();
		
		for (int num=2; num<=100; num++){
			for (int exp=2; exp<=100; exp++){
				list.add(BigInteger.valueOf(num).pow(exp));
			}
		}
		int answ = (int) list.stream().distinct().count();
		System.out.println(answ);	
	}

}
