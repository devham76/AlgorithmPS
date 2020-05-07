package org.baekjoon;

import java.util.HashSet;
import java.util.Scanner;

public class test11723 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();

		int bitSet = 0;
		StringBuilder answer = new StringBuilder();

		for (int i = 0; i < t; i++) {
			String command = scanner.next();

			if ("add".equals(command)) {
				int n = scanner.nextInt();
				n--;
				bitSet = bitSet | (1 << n);
			} else if ("remove".equals(command)) {
				int n = scanner.nextInt();
				n--;
				bitSet = bitSet & ~(1 << n);
			} else if ("check".equals(command)) {
				int n = scanner.nextInt();
				n--;
				int result = (bitSet & (1 << n));
				if (result > 0)
					answer.append("1\n");
				else
					answer.append("0\n");
			} else if ("toggle".equals(command)) {
				int n = scanner.nextInt();
				n--;
				bitSet = bitSet ^ (1 << n);
			} else if ("all".equals(command)) {
				bitSet = (1 << 20) - 1;
			} else if ("all".equals(command)) {
				bitSet = 0;
			}
		}
		System.out.println(answer);
	}

	// 시간 초과난다.
	public void main2() {
		Scanner sc = new Scanner(System.in);
		int caseNum = 0;
		HashSet<Integer> hs = new HashSet<>();
		while (caseNum-- >= 0) {
			String line = sc.nextLine();
			if (line.length() == 0)
				continue;

			String command;
			int num = 0;
			if (line.contains(" ")) {
				String[] input = line.split(" ");
				command = input[0];
				num = Integer.parseInt(input[1]);
			} else
				command = line;

			switch (command) {
			case "add":
				hs.add(num);
				break;
			case "remove":
				if (hs.contains(num)) {
					hs.remove(num);
				}
				break;
			case "check":
				if (hs.contains(num))
					System.out.println(1);
				else
					System.out.println(0);
				break;

			case "toggle":
				if (hs.contains(num))
					hs.remove(num);
				else
					hs.add(num);
				break;
			case "all":
				for (int i = 1; i < 21; i++)
					hs.add(i);
				break;
			case "empty":
				hs = new HashSet<>();
				break;
			}
		}

	}

}
