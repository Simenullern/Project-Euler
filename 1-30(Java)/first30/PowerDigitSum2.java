package first30;

public class PowerDigitSum2 {
	// multiplcation of big numbers using ripple multiply

	public static void run(){
		int sum = 0;

		int[] arr = new int[400]; // initializes your array elements to 0
		//Just a wild guess about the number of digits that 2 ^ 1000 will have
		// hver posisjon i arrayet vil være ETT siffer, hele arrayet representeret det store tallet

		arr[0] = 2;
		int carry = 0;
		

		for (int j = 1; j < 1000; j++){ 
			for (int i = 0; i < arr.length; i++){  // første gjennomgang vil tilsvare 2^1 osv. 
				int tempno = arr[i] * 2;

				if (tempno > 9){
					arr[i] = (tempno % 10) + carry;                    
					carry = 1;
				} else {
					arr[i] = tempno + carry;                    
					carry = 0;
				}
			}
		}        

		for (int i = 0; i < arr.length; i++)        
		{
			sum += arr[i];            
			System.out.println(arr[i]);
		}

		System.out.println(" sum of digits " + sum);
	}

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		run();
		long endTime = System.nanoTime();
		long elapsedNs = endTime - startTime;
		double elapsedS = (double)elapsedNs / 1000000000.0; 
		System.err.println("\t" + "Took "+(elapsedNs) + " ns to run program, which is " + elapsedS + " seconds");
	}

}
