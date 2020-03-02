package org.tryAgain;

import java.io.*;
import java.util.*;

/*
 * 탐욕법 ; 당장최선의방법을 수행한다. 해당deadline까지 풀수있는 문제중에 컵라면수가 큰것만 고른다.
 * deadline의 오름차순으로 정렬
 * deadline 2일때 --> 1/3 , 2/8, 2/9 (데드라인/컵라면) 이면
 * deadline만큼의 문제만 풀수있기 때문에 1문제를 제거해야하고, 제일 컵라면 수가 적은 1/3문제이다
 * */
public class test1781_greedy_cupNuddle {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Long sum = 0l;
		int[][] arr = new int[n][2];
		
		List<Problem> problemList = new ArrayList<>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int deadLine = Integer.parseInt(st.nextToken());
			int nuddle	 = Integer.parseInt(st.nextToken());
			problemList.add(new Problem(deadLine,nuddle));
		}
		
		
		Collections.sort(problemList,(o1,o2) ->{
				return o1.deadLine-o2.deadLine;
		});

		
		PriorityQueue<Problem> problemQ = new PriorityQueue<>();
		for(int i=0; i<n; i++) {
			Problem problem = problemList.get(i);
			problemQ.offer(problem);
			int deadLine = problem.deadLine;
			// 데드라인 보다 문제를 많이 뽑았으면, 컵라면이 적은 문제를 제거한다
			// 데드라인이 2인데 1/3 , 2/8, 2/9 (데드라인/컵라면) 이 들어가있으면 1/3문제를 제거한다.
			while(deadLine < problemQ.size()) {
				problemQ.poll();
			}
		}
		while(!problemQ.isEmpty()) {
			sum += problemQ.poll().nuddle;
		}
		System.out.println(sum);
		
	}

}
class Problem implements Comparable<Problem>{
	int deadLine;
	int nuddle;
	Problem(int deadLine, int nuddle){
		this.deadLine = deadLine;
		this.nuddle = nuddle;
	}
	@Override
	public int compareTo(Problem arg) {
		return this.nuddle - arg.nuddle;
	}
}
