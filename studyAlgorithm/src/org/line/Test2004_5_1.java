package org.line;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*
 * datasource : 문서, 태그1태그2...
 * tags에 있는 태그를 가지고 있는 문서 나열.
 * */

public class Test2004_5_1 {

	public static void main(String[] args) {
		String[][] d = { { "doc1", "t1", "t2", "t3" }, { "doc2", "t0", "t2", "t3" }, { "doc3", "t1", "t6", "t7" },
				{ "doc4", "t1", "t2", "t4" }, { "doc5", "t6", "t100", "t8" } };
		String[] t = { "t1", "t2", "t3", "t" };
		solution(d, t);
	}

	static List<doc> list = new LinkedList<>();
	static HashSet<String> tagsh = new HashSet<>();

	public static String[] solution(String[][] dataSource, String[] tags) {

		// -- 1. doc마다 tag개수 세어주기

		// -- 개선
		// tags를 hashset에 넣어주고, doc의 태그드를 확인 ->
		for (String tag : tags) {
			tagsh.add(tag);
		}
		// ----

		int taglen = dataSource[0].length;
		for (int i = 0; i < dataSource.length; i++) {
			String docName = dataSource[i][0];
			int count = 0;
			for (int j = 1; j < taglen; j++) {
				if (tagsh.contains(dataSource[i][j])) {
					count++;
				}
			}
			if (count != 0)
				list.add(new doc(docName, count));

		}

		Comparator<doc> Comp = new Comparator<doc>() {
			public int compare(doc a, doc b) {
				if (a.cnt == b.cnt)
					return a.name.compareTo(b.name);
				else
					return b.cnt - a.cnt;
			}
		};
		list.sort(Comp);

		int maxLen = list.size() > 10 ? 10 : list.size();
		String[] answer = new String[maxLen];
		for (int i = 0; i < maxLen; i++) {
			answer[i] = list.get(i).name;
			System.out.println(list.get(i).name + " " + list.get(i).cnt);
		}
		return answer;
	}

	private static boolean find(String docName) {
		if (tagsh.contains(docName))
			return true;
		return false;
	}
}

class doc2 {
	String name;
	int cnt;

	doc2(String name, int cnt) {
		this.name = name;
		this.cnt = cnt;
	}

}