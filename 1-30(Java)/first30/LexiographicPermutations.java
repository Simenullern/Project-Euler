package first30;

import java.util.ArrayList;
import java.util.List;

public class LexiographicPermutations {
	
	static int count = 1;
	
	public static void permutation(String str) { 
	    permutation("", str); 
	}

	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    
	    if (n == 0 && count < 1000001){
	    	System.out.println(count + ". " + prefix);
	    	count++;
	    }
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
	
	public static void main(String[] args) {
			permutation("0123456789");
		}
	}

