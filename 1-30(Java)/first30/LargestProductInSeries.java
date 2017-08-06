package first30;

public class LargestProductInSeries {
	
	public static void run(){
		String number =
				"73167176531330624919225119674426574742355349194934"
				+ "96983520312774506326239578318016984801869478851843"
				+ "85861560789112949495459501737958331952853208805511"
				+ "12540698747158523863050715693290963295227443043557"
				+ "66896648950445244523161731856403098711121722383113"
				+ "62229893423380308135336276614282806444486645238749"
				+ "30358907296290491560440772390713810515859307960866"
				+ "70172427121883998797908792274921901699720888093776"
				+ "65727333001053367881220235421809751254540594752243"
				+ "52584907711670556013604839586446706324415722155397"
				+ "53697817977846174064955149290862569321978468622482"
				+ "83972241375657056057490261407972968652414535100474"
				+ "82166370484403199890008895243450658541227588666881"
				+ "16427171479924442928230863465674813919123162824586"
				+ "17866458359124566529476545682848912883142607690042"
				+ "24219022671055626321111109370544217506941658960408"
				+ "07198403850962455444362981230987879927244284909188"
				+ "84580156166097919133875499200524063689912560717606"
				+ "05886116467109405077541002256983155200055935729725"
				+ "71636269561882670428252483600823257530420752963450";
		
		long runner = 1;
		long a = 1;
		
		for (int j=0;j<number.length()-12;j++){
			// int is too small here, 34 bits required
			
			long one = Integer.parseInt(""+number.charAt(j));
			long two = Integer.parseInt(""+number.charAt(j+1));
			long three = Integer.parseInt(""+number.charAt(j+2));
			long four = Integer.parseInt(""+number.charAt(j+3));
			long five = Integer.parseInt(""+number.charAt(j+4));
			long six = Integer.parseInt(""+number.charAt(j+5));
			long seven = Integer.parseInt(""+number.charAt(j+6));
			long eight = Integer.parseInt(""+number.charAt(j+7));
			long nine = Integer.parseInt(""+number.charAt(j+8));
			long ten = Integer.parseInt(""+number.charAt(j+9));
			long eleven = Integer.parseInt(""+number.charAt(j+10));
			long twelve = Integer.parseInt(""+number.charAt(j+11));
			long thirteen = Integer.parseInt(""+number.charAt(j+12));
			
			runner = one * two * three * four * five * six * seven * eight * nine * ten * eleven * twelve * thirteen;
	
			if (runner>a){
				a = runner;
				System.out.println("Greater multiplicity " + runner);;
			}
		}
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
