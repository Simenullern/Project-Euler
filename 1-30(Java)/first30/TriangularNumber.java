package first30;

public class TriangularNumber {

	public static void run(){
		long triangleNum = 1;

		for (int j=2;j<Long.MAX_VALUE;j++){
			triangleNum +=j;

			if (countDivisors(triangleNum) > 500){
				System.out.println("answ is " + triangleNum);
				break;
			}
		}
	}

	private static int countDivisors (long num){
		int count=1;
		double max = Math.sqrt(num);

		for (int i=2;i<=(int)max;i++){
			if (num%i==0){
				count+=2;
			}
		}
		// if the number is a square
		if (max * max == num) {
			count--;
		}

		System.out.println(num + " with " + count + " divisors");
		return count;
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
