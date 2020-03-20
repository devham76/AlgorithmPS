package org.programmers;

public class test12979 {

	public static void main(String[] args) {
		int n = 16;
		int[] st = {9};
		int w = 2;
		solution(n, st, w);

	}
	public static int solution(int n, int[] stations, int w) {
		int answer = 0;
		double ok = w*2+1;
		for(int i=0; i<stations.length; i++) {
			
			if(i == 0 &&  stations[i]-w-1 > 0) 
				answer += Math.ceil(( stations[i]-w) /  ok);
			
			if (i < stations.length+1) {
				int next = n;
				if (i != stations.length-1)
					next = stations[i+1]-w;
				
				int diff = next - ( stations[i]+w+1);
				
				answer += Math.ceil(diff/ok); 
			}
		}
		System.out.println(answer);
		return answer;
	}
}
/*
 		int answer = 0;
		boolean[] arr = new boolean[n+1];
		for(int i=0; i<stations.length; i++) {
			int station = stations[i];
			for(int j=station-w; j<=station+w; j++) {
				if(j < 1 || j > n) {
					continue;
				}
				arr[j] = true;
			}
		}

		for(int i=1; i<arr.length; i++) {
			if(arr[i] == false) {
				for(int next=i; next<=w*2+i; next++) {
					
					if(next < 1 || next > n) {
						continue;
					}
					
					arr[next] = true;
				}
				
				answer++;
			}
		}
		
		System.out.println("--->"+answer);
		return answer;

 */