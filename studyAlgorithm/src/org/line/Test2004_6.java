package org.line;

import java.util.ArrayList;
import java.util.List;
// 디렉토리...망.......;;;
public class Test2004_6 {

	public static void main(String[] args) {
		String[] d = { "/", "/hello", "/hello/tmp", "/root", "/root/abcd", "/root/abcd/etc", "/root/abcd/hello" };
		String[] c = { "mkdir /root/tmp", "cp /hello /root/tmp", "rm /hello" };
		solution(d, c);
	}

	static List<dir> list = new ArrayList<>();

	public static String[] solution(String[] directory, String[] command) {

		String[] answer = {};
		//dir first = new dir("/");
	
		for (int i = 0; i < directory.length; i++) {
			String[] dirs = directory[i].split("/");
			for (int j = 0; j < dirs.length; j++)
				System.out.println(dirs[j] + " ");
				
			String nd = dirs[0];
			int idx = finddir(nd);
			if(idx != -1){
				list.get(idx).addChild(nd);
			}
			else {
				list.add(new dir(nd));
				idx = list.size()-1;
			}
			
			list.get(idx).addChild(dirs);
			
		}
		return answer;
	}

	static int finddir(String n) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).name.equals(n)) {
				return i;
			}
		}

		return -1;
	}
}

class dir {
	String name;
	List<dir> child;

	dir(String name) {
		this.name = name;
		this.child = new ArrayList<>();
	}

	void addChild(String[] dirs) {
		for(int i=1; i<dirs.length; i++) {
			int idx = find(dirs[i]);ss
			if (idx != -1) {
				child.add(new dir(n));
			}
			else
				
		}
	}

	int find(String n) {
		for (int i = 0; i < child.size(); i++) {
			if (child.get(i).equals(n)) {
				return i;
			}
		}

		return -1;
	}
}