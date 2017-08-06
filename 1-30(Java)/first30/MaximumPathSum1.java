package first30;

public class MaximumPathSum1 {
	//brute force
	
	int[][] triangle;
	
	public void setup(){
		int[] row01 = {75};
		int[] row02 = {95, 64};
		int[] row03 = {17, 47, 82};
		int[] row04 = {18, 35, 87, 10};
		int[] row05 = {20, 4, 82, 47, 65};
		int[] row06 = {19, 0, 23, 75, 3, 34};
		int[] row07 = {88, 2, 77, 73, 7, 63, 67};
		int[] row08 = {99, 65, 4, 28, 6, 16, 70, 92};
		int[] row09 = {41, 41, 26, 56, 83, 40, 80, 70, 33};
		int[] row10 = {41, 48, 72, 33, 47, 32, 37, 16, 94, 29};
		int[] row11 = {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14};
		int[] row12 = {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57};
		int[] row13 = {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48};
		int[] row14 = {63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31};
		int[] row15 = {4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 04, 23};
		
		triangle = new int[][] {row01, row02, row03, row04, row05, row06, row07
			, row08, row09, row10, row11 , row12, row13, row14, row15};
	}
	
	public void dynamicRun(){
		int lines=15;
		for (int i = lines - 2; i >= 0; i--) { //starter nest nederste rad 
		    for (int j = 0; j <= i; j++) { // går gjennom alle posibilites med de to nederste radene
		        triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);
		        // verdiene på nest nederste rad blir omgjort til sine max potensialer
		        
		    }
		}
		// algoritmen går til vi har skrumpet trekanten til et tall
		System.out.println(triangle[0][0]);
	}
	
	
	public void bruteRun(){
		int maxTotal = 0; int runner = 0;
		
		for (int r1=0;r1<1;r1++){
			for (int r2=r1;r2<r1+2;r2++){
				for (int r3=r2;r3<r2+2;r3++){
					for (int r4=r3;r4<r3+2;r4++){
						for (int r5=r4;r5<r4+2;r5++){
							for (int r6=r5;r6<r5+2;r6++){
								for (int r7=r6;r7<r6+2;r7++){
									for (int r8=r7;r8<r7+2;r8++){
										for (int r9=r8;r9<r8+2;r9++){
											for (int r10=r9;r10<r9+2;r10++){
												for (int r11=r10;r11<r10+2;r11++){
													for (int r12=r11;r12<r11+2;r12++){
														for (int r13=r12;r13<r12+2;r13++){
															for (int r14=r13;r14<r13+2;r14++){
																for (int r15=r14;r15<r14+2;r15++){
																	runner = triangle[0][r1] + triangle[1][r2]+ triangle[2][r3]+ triangle[3][r4]+ triangle[4][r5]+ triangle[5][r6]+ triangle[6][r7]+ triangle[7][r8]+ triangle[8][r9]+ triangle[9][r10]+ triangle[10][r11]+ triangle[11][r12]+ triangle[12][r13]+ triangle[13][r14]+ triangle[14][r15];
																	if (runner>maxTotal){
																		maxTotal = runner;
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
				
			}
		}
		
		System.out.println("answ: " + maxTotal);
		
		
	}
	
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		MaximumPathSum1 program = new MaximumPathSum1();
		program.setup();
		program.bruteRun();
		program.dynamicRun();
		long endTime = System.nanoTime();
		long elapsedNs = endTime - startTime;
		double elapsedS = (double)elapsedNs / 1000000000.0; 
		System.err.println("\t" + "Took "+(elapsedNs) + " ns to run program, which is " + elapsedS + " seconds");
	}
	
	

}
