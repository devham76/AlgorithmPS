package org.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class kakao_64064 {

	public static void main(String[] args) {
		String[] u = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
		String[] b = { "fr*d*", "*rodo", "******", "******" };
		solution(u, b);

	}

	static boolean[] visited;
	static HashSet<String> hs;
	static int[][] idx_arr;
	static int answer = 0;

	public static int solution(String[] user_id, String[] banned_id) {

		idx_arr = new int[banned_id.length][user_id.length];

		for (int bidx = 0; bidx < banned_id.length; bidx++) {
			String banned = banned_id[bidx];
			int arridx = 0;
			for (int uidx = 0; uidx < user_id.length; uidx++) {
				String user = user_id[uidx];

				// 길이가 다르면 끝.
				if (user.length() != banned.length())
					continue;

				boolean is_banned = true;
				// 문자 하나씩비교
				for (int i = 0; i < banned.length(); i++) {
					if (banned.charAt(i) == '*')
						continue;

					if (banned.charAt(i) != user.charAt(i)) {
						is_banned = false;
						break;
					}
				}

				// 만약 불량이라면 idx_arr에 인덱스+1값을 넣어준다.
				if (is_banned == true) {
					idx_arr[bidx][arridx++] = uidx + 1;
				}
			}
		}

		visited = new boolean[user_id.length + 1];
		hs = new HashSet<>();

		for (int i = 0; i < idx_arr[0].length; i++) {
			if (idx_arr[0][i] == 0)
				break;

			List<Integer> list = new ArrayList<>();

			list.add(idx_arr[0][i]);
			visited[idx_arr[0][i]] = true;

			find_combination(list, 1);

			list.remove(0);
			visited[idx_arr[0][i]] = false;
		}

		System.out.println(answer);
		return answer;
	}

	private static void find_combination(List<Integer> list, int depth) {
		
		if (depth == idx_arr.length && list.size() == idx_arr.length) {
			List<Integer> copyList = new ArrayList<>();
			copyList.addAll(list);
			Collections.sort(copyList);
			StringBuilder sb = new StringBuilder();
			for (Integer l : copyList) {
				sb.append(l + ",");
			}
			
			String s = new String(sb);
			if (!hs.contains(s)) {
				hs.add(s);
				answer++;
			}

			return;
		}

		for (int i = 0; i < idx_arr[0].length; i++) {
			if (visited[idx_arr[depth][i]] == true || idx_arr[depth][i] == 0)
				continue;

			list.add(idx_arr[depth][i]);
			visited[idx_arr[depth][i]] = true;

			find_combination(list, depth + 1);

			list.remove(list.size() - 1);
			visited[idx_arr[depth][i]] = false;
		}

	}
}
