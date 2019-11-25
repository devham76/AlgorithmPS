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
		
		// �̱�� �� ���� ��ŭ �� �̾Ѵٸ� print
		if(r==0) {
			check(arr, visited, n);
			return;
		}
		else {
			// ������ �ε��� ���� �迭�� ������ ������
			for(int i=start; i<n; i++) {
				// �湮 �� true ǥ��.
				visited[i] = true;						
				// i+1; �湮�� �ε��� �� ���� ���� ������ / n���߿� �� ���� �湮 �Ѱ� �����Ƿ� r-1���� �̴´�
				combination(arr, visited, i+1, n, r-1);	
				// �湮 �Ϸ� �� false ǥ��.
				visited[i] = false; 					
			}
		}
	}
	
	// �迭 ���
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
