package org.programmers;

import java.util.Arrays;
import java.util.Comparator;

public class test42884_greedy {

	public static void main(String[] args) {
		int[][] routes = {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}, {3,10}};
		solution(routes);
	}
    public static int solution(int[][] routes) {
        int answer = 1;
        
        Comparator<int[]> routeCom = (a,b)->{
        	return b[0] - a[0];
        };
        
        //Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        Arrays.sort(routes, routeCom);
        
        int cam = routes[0][0];
        for(int i=1; i<routes.length; i++) {
        	// 카메라 설치 시점 뒤에서 나가버린다면 
        	// 기존 카메라 지점 보다 뒤에, 시작지점에서  하나 더 설치한다
        	if(cam > routes[i][1] ) {
        		cam = routes[i][0];
        		answer++;
        	}
        	
        }
        System.out.println(answer);
        return answer;
    }

}
