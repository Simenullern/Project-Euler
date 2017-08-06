package first30;

public class LargestPalindrome {

	public static void run(){
		int l�per = 0;
	    int palindrome = 0;
	    
	    for (int i=100;i<1000;i++){
	        for (int m=100;m<1000;m++){
	            l�per = i*m; // l�per gjennom alle kombinasjoner og unders�ker om det er et st�rre palindrom
	            if (isPalindrome(l�per + "")){
	                if (l�per>palindrome){
	                    palindrome = l�per;
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
