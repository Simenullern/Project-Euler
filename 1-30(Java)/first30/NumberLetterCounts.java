package first30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JSpinner.ListEditor;
import javax.xml.bind.Marshaller.Listener;

public class NumberLetterCounts {
	
	private List <String> liste = new ArrayList<>();
	
	public  void setUp(){	
		
		liste.addAll(Arrays.asList("one", "two", "three", "four", "five", "six",
				"seven", "eight", "nine", "ten", "eleven","twelve", "thirteen"
				, "fourteen", "fifteen", "seventeen", "eighteen", "nineteen", "twenty"));
		
		add1("twenty"); liste.add("thirty");
		add1("thirty"); liste.add("forty");
		add1("forty"); liste.add("fifty");
		add1("fifty"); liste.add("sixty");
		add1("sixty"); liste.add("seventy");
		add1("seventy"); liste.add("eighty");
		add1("eighty"); liste.add("ninety");
		add1("ninty"); liste.add("one hundred");
		add2("one hundred"); liste.add("two hundred");
		add2("two hundred"); liste.add("three hundred");
		add2("three hundred"); liste.add("four hundred");
		add2("four hundred"); liste.add("five hundred");
		add2("five hundred"); liste.add("six hundred");
		add2("six hundred"); liste.add("seven hundred");
		add2("seven hundred"); liste.add("eight hundred");
		add2("eight hundred"); liste.add("nine hundred");
		add2("nine hundred"); liste.add("one thousand");
	}
	
	public void add1(String tiertall){
		for (int i=0;i<9;i++){
			liste.add(tiertall + "-" + liste.get(i));
		}
	}
	
	public void add2(String hundretall){
		for (int i=0;i<98;i++){
			liste.add(hundretall + " and " + liste.get(i));
		}
	}
	
	public void run(){
		int count=0;
		for (String s:liste){
			System.out.println(s);
			for (char c:s.toCharArray()){
				if (c==' ' || c=='-'){
					continue;
				} else {
					count++;
				}
			}
		}
		System.out.println("answ: " + count);
		
	}
	
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		NumberLetterCounts nlc = new NumberLetterCounts();
		nlc.setUp();
		nlc.run();
		long endTime = System.nanoTime();
		long elapsedNs = endTime - startTime;
		double elapsedS = (double)elapsedNs / 1000000000.0; 
		System.err.println("\t" + "Took "+(elapsedNs) + " ns to run program, which is " + elapsedS + " seconds");
	}

}
