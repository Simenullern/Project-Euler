package first30;

public class QuadraticPrimes {


	private static boolean isPrime(int p){
		if (p<1){
			return false;
		}
		for (int i=2;i<Math.ceil(p);i++){
			if (p%i==0){
				return false;
			}
		}
		return true;
	}

	public static int calculateExpr(int n, int a, int b){
		return ((n*n) + (a*n) + b);
	}

	public static int run(int a, int b){
		int n = 0;
		while (isPrime(calculateExpr(n, a, b))){
			n++;
		}
		return n;
	}

	public static void main(String[] args) {
		int max_streak = 0;
		int max_a = 0;
		int max_b = 0;


		for (int a = -999; a < 1000; a ++){
			for (int b = -1000; b< 1001; b++){
				int n = run(a, b);
				if (n > max_streak){
					max_streak = n;
					max_a = a;
					max_b = b;
					System.out.println("new score with score: " + max_streak + ", a, b: " + max_a + ", " + max_b);
				}
			}
		}
		System.out.println("answ is: " + max_a*max_b);
	}

}
