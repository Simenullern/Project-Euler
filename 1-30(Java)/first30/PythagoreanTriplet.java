package first30;

public class PythagoreanTriplet {
	
	public static void run(){
		for (int a=1;a<1000;a++){
			for (int b=1;b<1000;b++){
				int aSq = a*a;
				int bSq= b*b;
				double cSq = aSq+bSq;
				double c = Math.sqrt(cSq);
				
				if (a+b+c==1000){
					System.out.println("abc: " + a + " " + b + " " + (int)c);
					System.out.println("product " + (int)(a*b*c));
					return;
				}
			}
		}
		System.out.println("fail");
	}
	
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		run();
		long endTime = System.nanoTime();
		long elapsedNs = endTime - startTime;
		double elapsedS = (double)elapsedNs / 1000000000.0; 
		System.err.println("\t" + "Took "+(elapsedNs) + " ns to run, which is " + elapsedS + " seconds"); ; 
	}

}
