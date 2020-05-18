package org.line;

import java.util.Iterator;
import java.util.TreeMap;

/*
 * snapshots 원본
 * transactions 기록
 * 이름, 숫자 구하기
 * */
public class Test2004_4_1 {

	public static void main(String[] args) {
		String[][] snapshots = { { "ACCOUNT1", "100" }, { "ACCOUNT2", "150" }, { "AACOUNT0", "150" } };
		String[][] transactions = { { "1", "SAVE", "ACCOUNT2", "100" }, { "2", "WITHDRAW", "ACCOUNT1", "50" },
				{ "1", "SAVE", "ACCOUNT2", "100" }, { "4", "SAVE", "ACCOUNT3", "500" },
				{ "3", "WITHDRAW", "ACCOUNT2", "30" } };

		solution(snapshots, transactions);
	}

	/*
	 * 수정전 
	 * linkedList -> O(N) 
	 * 수정후 
	 * hashmap O(1) treemap O(logN)
	 */
	static TreeMap<String, Long> accounts = new TreeMap<>();

	public static String[][] solution(String[][] snapshots, String[][] transactions) {

		for (int i = 0; i < snapshots.length; i++) {
			accounts.put(snapshots[i][0], Long.parseLong(snapshots[i][1])); // name, price
		}

		boolean[] visited = new boolean[transactions.length + 1];

		for (int i = 0; i < transactions.length; i++) {
			int id = Integer.parseInt(transactions[i][0]);
			String type = transactions[i][1]; // save, withdraw
			String accountName = transactions[i][2];
			long accountPrice = Long.parseLong(transactions[i][3]);

			if (visited[id] == true)
				continue;

			visited[id] = true;
			if (accounts.containsKey(accountName)) {
				long price = accounts.get(accountName);
				if (type.equals("SAVE"))
					price += accountPrice;
				else
					price -= accountPrice;

				accounts.replace(accountName, price);
			} else {
				accounts.put(accountName, accountPrice);
			}
		}
		String[][] answer = new String[accounts.size()][2];
		Iterator<String> iterKey = accounts.keySet().iterator();
		int idx = 0;
		while (iterKey.hasNext()) {
			String accountName = iterKey.next();
			answer[idx][0] = accountName;
			answer[idx][1] = accounts.get(accountName) + "";

			System.out.println(accountName + " " + answer[idx][1]);
			idx++;
		}

		return answer;
	}

}
