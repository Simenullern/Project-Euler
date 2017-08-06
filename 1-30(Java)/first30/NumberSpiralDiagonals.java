package first30;

public class NumberSpiralDiagonals {
	
	public static int halfDiagonal(int toAdd){
		// either upleft, upright, downleft, downright related to center
		int sum = 0;
		int num = 1;
		
		for (int i=1 ; i<501; i++){
			num += toAdd;
			sum += num;
			toAdd += 8;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int upRight = halfDiagonal(8);
		int upLeft = halfDiagonal(6);
		int downLeft = halfDiagonal(4);
		int downRight = halfDiagonal(2);
		int answ = upRight + upLeft + downLeft + downRight + 1; // count center as 1 too
		System.out.println(answ);
		
	}
	

}
