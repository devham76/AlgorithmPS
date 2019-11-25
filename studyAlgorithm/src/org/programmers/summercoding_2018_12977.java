package org.programmers;

public class summercoding_2018_12977 {

	public static void main(String[] args) {
		int[] nums = {1,2,7,6,4};
		solution(nums);

	}
	static int answer;
    public static int solution(int[] nums) {
        answer = 0;
        boolean[] visited = new boolean[nums.length];
		
		combination(nums, visited, 0, nums.length, 3);		
        return answer;
    }
    static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
		
		// 뽑기로 한 개수 만큼 다 뽑앗다면 print
		if(r==0) {
			check(arr, visited, n);
			return;
		}
		else {
			// 기준점 인덱스 부터 배열의 끝까지 뒤진다
			for(int i=start; i<n; i++) {
				// 방문 후 true 표시.
				visited[i] = true;						
				// i+1; 방문한 인덱스 이 후의 값을 뒤진다 / n개중에 좀 전에 방문 한개 했으므로 r-1개를 뽑는다
				combination(arr, visited, i+1, n, r-1);	
				// 방문 완료 후 false 표시.
				visited[i] = false; 					
			}
		}
	}
	
	// 배열 출력
	static void check(int[] arr, boolean[] visited, int n) {
		int sum = 0;
		for(int i=0; i<n; i++) {
			if(visited[i] == true)
				sum += arr[i];
		}
		
		boolean is_ok = true;
		for ( int i = 2; i < sum; i++) {
			if ( sum % i == 0) {
				is_ok = false;
				break;
			}
		}
		if (is_ok == true)
			answer++;
	}
	
}
