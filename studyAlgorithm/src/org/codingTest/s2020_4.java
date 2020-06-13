package org.codingTest;

import java.util.*;

public class s2020_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int count = sc.nextInt();

		String str = sc.next();
		List<Info> list = new ArrayList<>();
		char alphabet = str.charAt(0);
		int num = 0;
		int start = 0;
		for (int i = 0; i < length; i++) {S
			System.out.print(str.charAt(i) + ", ");
			if (alphabet != str.charAt(i)) {
				list.add(new Info(alphabet, start, i - 1, num));
				num = 1;
				start = i;
				alphabet = str.charAt(i);

			} else {
				num++;
			}
		}
		list.add(new Info(str.charAt(length - 1), start, length - 1, num));

		Collections.sort(list);
		System.out.println();
		System.out.println("size--->" + list.size());
		for (int i = 0; i < list.size(); i++) {
			Info info = list.get(i);
			System.out.println(info.alphabet + " start:" + info.start + " end:" + info.end + " count:" + info.count);
		}

		while (count-- > 0) {
			int s = sc.nextInt() - 1;
			int e = sc.nextInt() - 1;
			char startAlphabet = str.charAt(s);
			char endAlphabet = str.charAt(e);
			System.out.println("start alphabet:" + startAlphabet);

			char answer = 'A';
			int max = 0;
			for (int i = 0; i < list.size(); i++) {
				Info info = list.get(i);

				if (info.start > e || info.end < s)
					continue;

				int cnt = info.count;

				if (info.alphabet == startAlphabet)
					cnt = info.end - s + 1;
				else if (info.alphabet == endAlphabet)
					cnt = e - info.start + 1;

				if (info.alphabet == startAlphabet && info.alphabet == endAlphabet)
					cnt = e - s + 1;

				System.out
						.println("alphabet:" + info.alphabet + " , cnt:" + cnt + " , answer=" + answer + " max:" + max);

				if (max == cnt && answer - info.alphabet > 0) {
					System.out.println("answer:" + answer + ", new alpa:" + info.alphabet);
					answer = info.alphabet;
				}
				if (max < cnt) {
					answer = info.alphabet;
					max = cnt;
				}
			}
			System.out.println(answer);
		}

	}

}

class Info implements Comparable<Info> {
	char alphabet;
	int start;
	int end;
	int count;

	Info(char alphabet, int start, int end, int count) {
		this.alphabet = alphabet;
		this.start = start;
		this.end = end;
		this.count = count;
	}

	@Override
	public int compareTo(Info info) {
		if (this.count == info.count)
			return this.alphabet - info.alphabet;
		else {
			return info.count - this.count;
		}
	}

}