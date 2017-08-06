package first30;

public class LargestPalindrome {

	public static void run(){
		int løper = 0;
	    int palindrome = 0;
	    
	    for (int i=100;i<1000;i++){
	        for (int m=100;m<1000;m++){
	            løper = i*m; // løper gjennom alle kombinasjoner og undersøker om det er et større palindrom
	            if (isPalindrome(løper + "")){
	                if (løper>palindrome){
	                    palindrome = løper;
	                    System.out.println(palindrome + " with numbers " + m +" and " + i);
	                }
	            }
	        }
	    }
	    System.out.println("line above is greatest six digit answer.");
	}

	private static boolean isPalindrome (String word){
		String reverse="";
		for (int i=word.length()-1;i>-1;i--){
			reverse+=word.charAt(i);
		}
		return word.equals(reverse);
	}


	public static void main(String[] args) {
		run();
	}

}
