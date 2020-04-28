package org.programmers;

public class kakao_64062 {

	public static void main(String[] args) {
		int[] s = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		solution(s, 3);
		
	}
    public static int solution(int[] stones, int k) {
        int answer = 0;
        int min = 300000000;
        
        int[] arr = new int[k];
        int idx = 0;
        int maxIdx = 0, beforeIdx = 0;
        int start = 0;
        boolean keep_going = true;
        while(true) {
        	
        	int nowmax = 0;
        	for(int i=start; i<k; i++) {
        		if(idx+i >= stones.length) {
        			keep_going = false;
        			break;
        		}
        		arr[i] = stones[idx+i];
        		
        		if(nowmax < arr[i]) {
        			nowmax = arr[i];
        			maxIdx = idx+i;
        		}
        	}
        	if(keep_going==false)
        		break;
        	
        	min = Math.min(min, nowmax);
        	
        	arr = new int[k];
        	if(stones[beforeIdx] != nowmax) {
        		arr[0] = nowmax;
        		start = 1;
        		idx = maxIdx;
        		beforeIdx = maxIdx;
        	}
        	else {
        		start = 0;
        		idx = maxIdx+1;
        	}
        	
        }
        System.out.println(min);
        return answer;
    }
}
