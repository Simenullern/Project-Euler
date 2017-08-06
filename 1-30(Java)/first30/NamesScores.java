package first30;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class NamesScores {


	public static void run(){
		HashMap <Character, Integer> values = new HashMap<>();
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		int val = 1;
		for (char c:alphabet.toCharArray()){
			values.put(c, val);
			val++;
		}
		
		List<String> names = new ArrayList<>();
		InputStream is = NamesScores.class.getResourceAsStream("p022_names.txt");
		Scanner sc = new Scanner(is);
		sc.useDelimiter(",");

		while (sc.hasNext()){
			String next = sc.next();
			names.add(next.substring(1, next.length()-1));
		}
		Collections.sort(names);
		
		int totalScore = 0;
		
		for (int i=0; i<names.size(); i++){
			String name = names.get(i);
			int nameScore = 0;
			for (char c : name.toCharArray()){
				nameScore += values.get(Character.toLowerCase(c));
			}
			totalScore += (nameScore* (i+1));
		}
		
		System.out.println(totalScore);

	}

	public static void main(String[] args){
		run();
	}



}
