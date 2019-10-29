package org.naver;

import java.util.Stack;

public class Test1 {
	static Stack<Object> perStack = new Stack<Object>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] record = {"RECEIVE abcd@naver.com", "RECEIVE zzkn@naver.com", "DELETE", "RECEIVE qwerty@naver.com", "SAVE", "RECEIVE QwerTY@naver.com"};

		Stack<Object> tmpStack = new Stack<Object>();		
		
		for(int i=0; i<record.length; i++) {
			String[] line =  record[i].split(" ");

				switch (line[0]) {
					case "RECEIVE" : 
						tmpStack.push(line[1]);
							
						break;
					case "DELETE" : 
						if(!tmpStack.isEmpty())
							tmpStack.pop();
						break;
					case "SAVE" : 
						//perStack = save(tmpStack);
						save(tmpStack);
					break;
				}
		}
		//String[] r = perStack.toArray();
		for(int i=0; i<perStack.size(); i++)
			System.out.println(perStack.get(i));
		
		String[] answer = new String[perStack.size()];
		for(int i=perStack.size()-1; i>=0; i--)
			answer[i] = (String) perStack.pop();
		for(int i=0; i<answer.length; i++)
			System.out.println(answer[i]);
		
	}
	static void save(Stack stack) {
		String[] result = new String[stack.size()];
		for (int i=stack.size()-1; i>=0; i--) 
			result[i] = (String) stack.pop();
		
		for (int i=0; i<result.length; i++) {
			perStack.push(result[i]);
		}
	}
	

}
