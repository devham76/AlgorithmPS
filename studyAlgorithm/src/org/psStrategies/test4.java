package org.psStrategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test4 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());// 책상개수
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = -1;
		int end = 0;
		int diff = 0, max = 0;
		int candinate = 0;
		boolean is_start = false;
		for (int i = 0; i < n; i++) {
			int cur = Integer.parseInt(st.nextToken());
			// 사람있는곳을 찾는다.
			if (cur == 1) {
				
				if (is_start == false) { // 첫번째 사람있는곳을 찾는다
					start = i;
					// 0 0 0 1 왼쪽에 사람이 없는경우
					max = Math.max(diff, start);
					is_start = true;
				} else {	// 첫번째 이후에사람있는곳을 찾는다.
					end = i;
					candinate = start + (end - start) / 2;
					diff = candinate - start;
					diff = Math.min(diff, end - candinate);
					// System.out.println("start = "+start+" end="+end+" candinate="+candinate);
					max = Math.max(diff, max);
					start = i;
				}

			}

		}
		//  0 1 0 0 0 양쪽에 사람이 없는 경우
		if (end != (n - 1)) {
			diff = (n - 1) - start;
			max = Math.max(diff, max);
		}
// 0 0 0 0 0 1 0 0
		// 1 0 0 0 오른쪽에 사람이 없는 경우 
		if (end == 0) {
			System.out.println("end");
			max = n - 1;
		}

		System.out.println(max);
	}
}
