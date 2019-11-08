package org.programmers;

import java.util.LinkedList;

public class kakao_2019_mukbang {

	public static void main(String[] args) {
		int[] f = {3, 1, 2};
		solution(f, 5);
	}
    public static int solution(int[] food_times, long k) {
        int answer = 0;
        LinkedList<food> flist = new LinkedList<>();
        int food_cnt = food_times.length;
        
        for (int i=0; i<food_cnt; i++)
        	flist.add( new food(i+1, food_times[i]) );
        
        int index = 0;
        for (int i = 0; i < k; i++) {
        	System.out.println("½Ã°£ : "+i+", size : "+flist.size()+" , index:"+index);
        	flist.get(index).time--;
        	if ( flist.get(index).time == 0 ) {
        		flist.remove(index);
        		food_cnt--;
        	}
        	System.out.println("food cnt : "+food_cnt);
        	if (food_cnt == 0){
        		answer = -1;
        		break;
        	}
        	else {
        		index = (index+1) % food_cnt;
        		answer = index+1;
        	}
        }
        
        System.out.println(answer);
        return answer;
    }
}
class food {
	int seq;
	int time;
	food(int seq, int time){
		this.seq = seq;
		this.time = time;
	}
}