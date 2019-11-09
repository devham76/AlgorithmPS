package org.kakao;
// 미 완료

import java.util.ArrayList;

public class kakao_intern_2020_3 {

	public static void main(String[] args) {
		String[] u = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] b = {"fr*d*", "*rodo", "******", "******"};

				solution(u , b);
	}
    public static int solution(String[] user_id, String[] banned_id) {
        int answer = 1;
        int[][] banned = new int [banned_id.length][user_id.length];
        boolean[] visited = new boolean[user_id.length +1];
        int[] banned_cnt = new int[banned_id.length];
        for ( int i = 0; i< banned_id.length; i++) {
        	
        	for ( int j = 0; j < user_id.length; j++) {
        		int is_different = 0;
        		if (banned_id[i].length() != user_id[j].length())
        			continue;
        		// 한 글자씩 비교
        		for ( int k = 0; k < user_id[j].length(); k++) {
        			if (banned_id[i].charAt(k) == '*')
        				continue;
        			else {
        				if (banned_id[i].charAt(k) != user_id[j].charAt(k)) {
        					is_different = 1;
        					break;
        				}
        			}
        		}
        		if (is_different == 0) {
        			banned_cnt[i]++;
        			banned[i][ j ]  = j+1;
        		}
        	}
        }
        for(int i=0; i<banned.length; i++) {
        	for(int j=0; j<banned[1].length; j++)
        		System.out.print(banned[i][j]+" ");
        	System.out.println();
        }
        
        int[] get = new int[banned_id.length];
        fun(0, get, visited, banned);
        for(int e:banned_cnt) {
        	System.out.println(e);
        	answer *= e;
        }
        System.out.println(answer);
        return answer;
    }
    public static void fun(int start, int[] get, boolean[] visited, int[][] banned) {
    	//System.out.println("start :"+start);
    	if(start == banned.length) {
    		System.out.println("start!!");
    		for(int i=0; i<visited.length; i++) {
    			if (visited[i] == true) {
    				
    			}
    			System.out.print(i+" ");
    		}
    	}
    	
    	for(int i=start; i < banned.length; i++) {
    		for (int j=0; j<banned[0].length; j++) {
    			if(banned[i][j] == 0)
    				continue;
    			
    			if (visited[ banned[i][j] ] == false) {
    				//System.out.println("->"+banned[i][j]);
    				visited[ banned[i][j] ] = true;
    				get[start] =  banned[i][j];
    				fun (i+1, get, visited, banned);
    				visited[ banned[i][j] ] = false;
    			}
    		}
    	}
    }
}

