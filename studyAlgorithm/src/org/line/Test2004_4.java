package org.line;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test2004_4 {

	public static void main(String[] args) {
		String[][] snapshots = { { "ACCOUNT1", "100" }, { "ACCOUNT2", "150" } };
		String[][] transactions = { 
				{"1", "SAVE", "ACCOUNT2", "100"},
{"2", "WITHDRAW", "ACCOUNT1", "50"}, 
{"1", "SAVE", "ACCOUNT2", "100"}, 
{"4", "SAVE", "ACCOUNT3", "500"}, 
	{"3", "WITHDRAW", "ACCOUNT2", "30"}};

		solution(snapshots,transactions);
	}
	static List<info> list = new ArrayList<>();
	public static String[][] solution(String[][] snapshots, String[][] transactions) {
		
		

		for (int i = 0; i < snapshots.length; i++) {
			list.add(new info(snapshots[i][0], Long.parseLong(snapshots[i][1])));
		}

		boolean[] visited = new boolean[transactions.length + 1];
		
		for (int i = 0; i < transactions.length; i++) {
			int id = Integer.parseInt(transactions[i][0]);
			String type = transactions[i][1]; // save, withdraw
			String accountName = transactions[i][2];
			long accountPrice = Long.parseLong(transactions[i][3]);
			
			if(visited[id] == true)
				continue;
			
			visited[id] = true;
			int idx = find(accountName);
			if(idx == -1) {
				list.add(new info(accountName, accountPrice));
			}else {
				if(type.equals("SAVE"))
					list.get(idx).savePrice(accountPrice);
				else 
					list.get(idx).withPrice(accountPrice);
			}
		}
		
		list.sort((info1,info2) -> 
		 info1.name.compareTo(info2.name));
		String[][] answer = new String[list.size()][2];
		for(int i=0; i<list.size(); i++) {
			answer[i][0] = list.get(i).name;
			answer[i][0] = list.get(i).price+"";
			
			System.out.println(list.get(i).name+", "+list.get(i).price);
		}
		
		return answer;
	}
	private static int find(String accountName) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).name.equals(accountName)) {
				return i;
			}
		}
		return -1;
	}
}

class info implements Comparator<info>{
	String name;
	long price;

	info(String name, long price) {
		this.name = name;
		this.price = price;
	}

	long savePrice(long p) {
		return price += p;
	}
	long withPrice(long p) {
		return price -= p;
	}

	@Override
	public int compare(info arg0, info arg1) {
		
		return arg0.name.compareTo(arg1.name);
	}
}
