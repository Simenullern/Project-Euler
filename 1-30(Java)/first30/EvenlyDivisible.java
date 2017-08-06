package first30;

public class EvenlyDivisible {
	
	public static void run(){
		int num = 1;
		
		while (true){
			if (!evenlyDivisible(num)){
				num++;
			} else {
				System.out.println(num);
				break;
			}
		}
	}
	
	private static boolean evenlyDivisible(int num){
		for (int i=1;i<20;i++){
			if (num%i!=0){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		run();
	}
	
}
