package org.study;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class iteratorEx {
	public static void main(String[] args) {
		// 1.
		ArrayList<Integer> list = new ArrayList<>();
		for (int i=1; i<8; i++)
			list.add(i);
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		// 2.
		HashMap<String, String> hm = new HashMap<>();
		for(int i=1; i<8; i++) 
			hm.put("키"+i, "값"+i);
		Iterator<String> keys = hm.keySet().iterator();
		while( keys.hasNext() ) {
			String key = keys.next();
			System.out.println( String.format("키:%s, 값:%s", key, hm.get(key)));
		}
	}
}
