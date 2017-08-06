package first30;

import java.util.ArrayList;
import java.util.Comparator;

public class SizeSorter implements Comparator<ArrayList<Integer>>{

	@Override
	public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
		if (o1.size() > o2.size()){
			return 1;
		} else return -1;
	}

	
	
}
