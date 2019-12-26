package org.programmers;

import java.util.Arrays;
import java.util.Comparator;

public class test42627_diskController {

	public static void main(String[] args) {
		test42627_diskController t = new test42627_diskController();
		//9
		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
		t.solution(jobs);
		System.out.println("----`");
		int[][] jobs2 = {{1, 3}, {2, 9}, {14, 1}};
		t.solution(jobs2);
	}
    public int solution(int[][] jobs) {
        int answer = 0;
        
        // ASF, 스케쥴링, 처리시간이 짧은 것부터 처리한다.
        Arrays.sort(jobs, new Comparator<int[]>() {
        	public int compare(final int[] entry1, final int[] entry2) {
        		final int time1 = entry1[1];
        		final int time2 = entry2[1];
        		return Integer.compare(time1, time2);
        	}
        });
        
        boolean[] check = new boolean[jobs.length];
        int all = jobs.length;
        int now = 0;
        while (all > 0) {
        	boolean exist = false;
        	
        	for(int i=0; i<jobs.length;i++) {
        		// 처리할 디스크의 요청시간이 현재시간과 같거나 작다면 처리한다.
        		if(jobs[i][0] <= now && check[i] == false) {
        			// 대기시간 (현재시간 - 요청시간 ) + 처리시간
        			answer += (now - jobs[i][0]) + jobs[i][1]; 
        			// 현재시간  = 이전의 현재시간  + 처리시간 
        			now += jobs[i][1];
        			// 현재시간에 디스크를 처리했음을 표시
        			exist = true;
        			all--;
        			check[i] = true;
        			break;
        		}
        	}
        	
        	// 처리할 디스크의 요청시간이 현재시간보다 크다면 
        	// 가장 처음 요청하는 시간이 0이 아니라면 1초를 흘려보내보고 다음 요청 디스크가 들어오는지 확인한다. 
        	if (exist == false)
        		now ++;
        	
        }

        return answer;
    }
}
