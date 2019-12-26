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
        
        // ASF, �����층, ó���ð��� ª�� �ͺ��� ó���Ѵ�.
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
        		// ó���� ��ũ�� ��û�ð��� ����ð��� ���ų� �۴ٸ� ó���Ѵ�.
        		if(jobs[i][0] <= now && check[i] == false) {
        			// ���ð� (����ð� - ��û�ð� ) + ó���ð�
        			answer += (now - jobs[i][0]) + jobs[i][1]; 
        			// ����ð�  = ������ ����ð�  + ó���ð� 
        			now += jobs[i][1];
        			// ����ð��� ��ũ�� ó�������� ǥ��
        			exist = true;
        			all--;
        			check[i] = true;
        			break;
        		}
        	}
        	
        	// ó���� ��ũ�� ��û�ð��� ����ð����� ũ�ٸ� 
        	// ���� ó�� ��û�ϴ� �ð��� 0�� �ƴ϶�� 1�ʸ� ����������� ���� ��û ��ũ�� �������� Ȯ���Ѵ�. 
        	if (exist == false)
        		now ++;
        	
        }

        return answer;
    }
}
