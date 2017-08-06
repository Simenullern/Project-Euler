package first30;

public class SumSquareDifference {
	
	public static void main(String[] args) {
		int sumOfSquares=0;
		int squareOfSum=0;
		
		for (int i=0;i<101;i++){
			sumOfSquares += (i*i);
			squareOfSum += i;
		}
		System.out.println((squareOfSum*squareOfSum)-sumOfSquares);
	}
	

}
