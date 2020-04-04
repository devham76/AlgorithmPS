package org.line;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Line2019_1_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cony = sc.nextInt();	// C, C + 1, C + 3, C + 6, ...
		int brown = sc.nextInt();	// B – 1, B + 1, 2 * B 

		if (cony != brown) {
			System.out.println(solve(cony, brown));
		} else
			System.out.println(0);

	}

	static int solve(int conyPosition, int brownPosition) {
		int time = 0;
		boolean[][] visit = new boolean[200001][2];
		Queue<int[]> queue = new LinkedList<>();
		int[] arr = { brownPosition, 0 };	// 브라운위치 , 시간
		queue.offer(arr);
		
		while (true) {
			// 코니의 위치 = 코니이전위치 + 시간 
			conyPosition += time;
			
			if (conyPosition > 200000)	// 위치 p는 조건 0 <= x <= 200,000을 만족한다.
				return -1;
			
			// 항상 visit에는 visit[brownPosition][time]으로 넣어줬다. 
			// time%2시간에 브라운이 있었을때, 코니도 있으면 해당 시간을 리턴.
			if (visit[conyPosition][time % 2]) 
				return time;
			
			
			// time 시간일때 한번씩 움직일 위치만큼만 실행.
			for (int i = 0, size = queue.size(); i < size; i++) {
				int[] arr2 = queue.poll();
				int currentPosition = arr2[0];
				int newTime = (arr2[1] + 1) % 2; // 새로운 시간 : arr2[1]+1 이지만, 홀/짝에 따라서 나누기때문에 %2한다.
				int newPosition;
				
				// 1.  브라운의 새로운 위치 = B-1
				newPosition = currentPosition - 1;
				// 위치가 0보다 크거나 같고 , 이시간에 이자리를 방문한적이 없다면.
				if (newPosition >= 0 && !visit[newPosition][newTime]) {
					visit[newPosition][newTime] = true;
					int[] newarr = { newPosition, newTime };	// 새로운 위치, 새로운 시간.
					queue.offer(newarr);
				}
				
				// 2.  브라운의 새로운 위치 = B+1
				newPosition = currentPosition + 1;
				if (newPosition < 200001 && !visit[newPosition][newTime]) {
					visit[newPosition][newTime] = true;
					int[] newarr = { newPosition, newTime };
					queue.offer(newarr);
				}
				
				// 3.  브라운의 새로운 위치 = B*2
				newPosition = currentPosition * 2;
				if (newPosition < 200001 && !visit[newPosition][newTime]) {
					visit[newPosition][newTime] = true;
					int[] newarr = { newPosition, newTime };
					queue.offer(newarr);
				}
			}
			time++;
		}

		
	}

}
