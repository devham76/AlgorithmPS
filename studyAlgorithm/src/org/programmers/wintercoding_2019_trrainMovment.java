package org.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// welcomekakao.com/learn/courses/30/lessons/62050 -----> 다시풀기
public class wintercoding_2019_trrainMovment {

	public static void main(String[] args) {
		int[][] land = {{1, 4, 8, 10}, {5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}};
		int[][] land2 = {{10, 11, 10, 11}, {2, 21, 20, 10}, {1, 20, 21, 11}, {2, 1, 2, 1}};
		solution(land2, 3);
	}
	public static int solution(int[][] land, int height) {
		int answer = 0;
		int[][] visited = new int[ land.length ][ land[0].length ];
		ArrayList<Integer> minArr = new ArrayList<>();
		Queue<dot> q = new LinkedList<dot>();
		int team = 0;
		
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0 ,0, 1, -1};
		for (int i = 0; i < land.length; i++) {
			for (int j = 0; j < land[0].length; j++) {
				if (visited[i][j] > 0)
					continue;

				// BFS로 사다리 없이 이동 할 수 있는 지역을 방문한다.
				q.offer(new dot(i,j));
				team++;
				int[][] diffArr = new int[ land.length ][ land[0].length ];
				while (!q.isEmpty()) {
					dot nowQ = q.poll();
					// 상하 좌우 이동 하며 방문한다.
					for (int k = 0; k < 4; k++) {
						if (nowQ.x + dx[k] < 0 || nowQ.x + dx[k] >= land.length || nowQ.y + dy[k] < 0 || nowQ.y + dy[k] >= land[0].length)
							continue;
						
						int diff = Math.abs( land[ nowQ.x + dx[k] ][ nowQ.y + dy[k] ] - land[ nowQ.x ][ nowQ.y ]);
						if (diff > height && visited[ nowQ.x + dx[k] ][ nowQ.y + dy[k] ] != team) {							
							diffArr[ nowQ.x + dx[k]][ nowQ.y + dy[k] ] = diff;
							continue;
						}
						
						if (visited[ nowQ.x + dx[k] ][ nowQ.y + dy[k] ] > 0 )
							continue;
						
				
						
						visited[ nowQ.x + dx[k] ][ nowQ.y + dy[k] ] = team;
						q.offer( new dot ( nowQ.x + dx[k] , nowQ.y + dy[k] ) );
					}

				}
				
				int min = 10000;
				for (int x=0; x< diffArr.length ; x++) {
					for (int y=0; y <diffArr[0].length; y++) {
						System.out.print(diffArr[x][y] + " ");
						if (diffArr[x][y] != 0) {
							min = Math.min(min, diffArr[x][y]);
						}
					}
					System.out.println();
				}
				minArr.add(min);
				System.out.println("-------------");
			}
		}
		for (int i=0; i<minArr.size()-1; i++)
			answer += minArr.get(i);
		System.out.println("answer :"+answer);
		return answer;
	}
}
