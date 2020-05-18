package org.line;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test2004_6_1 {

	public static void main(String[] args) {
		String[] d = { "/", "/hello", "/hello/tmp", "/root", "/root/abcd", "/root/abcd/etc", "/root/abcd/hello" };
		String[] c = { "mkdir /root/tmp", "cp /hello /root/tmp", "rm /hello" };
		solution(d, c);
	}

	static List<dir> list = new ArrayList<>();

	public static String[] solution(String[] directory, String[] command) {

		String[] answer = {};
		// dir first = new dir("/");

		for (int i = 0; i < directory.length; i++) {
			String[] dirs = directory[i].split("/");
			for (int j = 0; j < dirs.length; j++)
				System.out.println(dirs[j] + " ");

			String nd = dirs[0];
			int idx = finddir(nd);
			if (idx != -1) {
				list.get(idx).addChild(nd);
			} else {
				list.add(new dir(nd));
				idx = list.size() - 1;
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

class DirList {
	List<Dir> list;

	DirList() {
		list = new LinkedList<>();
	}

	void rm(String[] dirlist) {
		String lastDir = dirlist[dirlist.length - 1]; // 삭제할 마지막 디렉토리이름

		Dir location = findLastDir(dirlist, dirlist.length - 1, 0, list, null);// 해당 디렉토리 마지막
		List<Dir> dchild = location.child;
		for (int i = 0; i < dchild.size(); i++) {
			if (dchild.get(i).name.equals(lastDir)) {
				dchild.remove(i);
				break;
			}
		}
	}

	void mkdir(String[] dirlist) {
		Dir newdir = new Dir(dirlist[dirlist.length - 1]); // 마지막에 있는 디렉토리를 만든다
		Dir location = findLastDir(dirlist, dirlist.length - 1, 0, list, null);// 해당 디렉토리 마지막
		location.addChild(newdir);
	}

	void cp(String[] targets, String[] locations) {

		// list에 targets가 있는지 확인.
		// 있다면 마지막 dir의 child를 가져온다
		Dir targetList = findLastDir(targets, targets.length, 0, list, null);

		// list에 locations위치로 간후 마지막 dir의 child를 add한다.
		Dir location = findLastDir(locations, locations.length, 0, list, null);
		location.addChild(targetList);
	}

	Dir findLastDir(String[] locations, int depth, int now, List<Dir> dlist, Dir dir) {
		if (depth == 0) {
			return dir;
		}
		for (Dir d : dir.child) {
			if (d.name.equals(locations[now])) {
				findLastDir(locations, depth - 1, now + 1, d.child, d);
			}
		}
		return null;
	}

	public String toString(String name) {
		StringBuffer sb = new StringBuffer();
		for (Dir d : list) {
			if (d.equals(name)) {
				for (Dir dir : d.child) {
					sb.append(d.name + "/");
				}
			}
		}
		return new String(sb);
	}
}

class Dir {
	String name;
	List<Dir> child;

	Dir(String name) {
		this.name = name;
		this.child = new LinkedList<>();
	}

	// mkdir
	void addChild(Dir newDir) {
		child.add(newDir);
	}

	Dir find(String name) {
		for (Dir d : child) {
			if (d.name.equals(name)) {
				return d;
			}
		}
		return null;
	}
}
