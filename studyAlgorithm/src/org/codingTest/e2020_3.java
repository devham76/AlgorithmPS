package org.codingTest;

import java.util.HashMap;

public class e2020_3 {

	public static void main(String[] args) {
		// 이메일 주소 만들기
		String S = "John Don; Peter Benjia Parke; Peter Benjia Parke; Marry Jane Waston-Parkek; John hey Don";
		String C = "Example";

		StringBuilder answer = new StringBuilder();
		String email = "@"+C.toLowerCase()+".com";
		
		
		String[] names = S.split("; ");
		
		HashMap<String, Integer> hm = new HashMap<>();
		for(String name:names) {
			int nameCount = 1;
			String original = name;
			name = name.toLowerCase();
			String[] namePart = name.replace("-", "").split(" ");
			String newName = namePart[namePart.length-1] + "_" + namePart[0];
			
			if(hm.containsKey(newName)) {
				nameCount = hm.get(newName)+1;
				hm.replace(newName, nameCount);
				
			}
			else {
				hm.put(newName, nameCount);
			}
			
			//System.out.println("original = "+name);
			if(nameCount > 1)
				newName += nameCount;
			//System.out.println("new = "+newName);
			
			if(answer.length() > 0) 
				answer.append("; ");
			answer.append(original + " <"+newName+email+">");
			//answer.append(name);
			
		}
		System.out.println(answer);
		String emailStr = answer.toString();

	}

}
