//-----> 실패, 다시 보기....
//https://blog.naver.com/PostView.nhn?blogId=neda712&logNo=221621436709&categoryNo=60&parentCategoryNo=0&viewDate=&currentPage=1&postListTopCurrentPage=1&from=search
// 점화식을 만드려고만 했음
// 코드화하기 전에 어떻게 풀면 해결할수 있을지 먼저 생각을 해볼것.

/*
 https://healthydeveloper.tistory.com/39?category=675593 [건강한개발자]
왼쪽부터 탐색하다가 전파가 닿지 않는 공간이 나왔을 때, 가능한 오른쪽에 배치하는게 가장 최적의 해입니다. (그리디)
따라서 n 위치가 전파가 닿지 않는다면 n+w에 기지국을 설치하고 n+w+w+1부터 탐색을 계속해 나가는 것이 최적 입니다.
s+w 위치에 기지국이 있다면 , 기지국을 설치할 수 있는 가장 오른쪽에 기지국을 설치합니다. 
*/

package org.programmers;

import java.util.ArrayList;

public class summercoding_2018_12979 {

	public static void main(String[] args) {
		int[] s = {1,11};
		solution(11, s, 1);

	}
	public static int solution(int n, int[] stations, int w) {
		int answer = 0;
		int idx = 0;
		int location = 1; // 현재 위치는 1
		while (location <= n) {
			// 현재 위치가 전파가 닿은 곳에 위치 한다면, 위치를 전파가 닿지 않는 곳 바로 옆으로 옮긴다
			if (location >= stations[idx]-w && idx<stations.length) {
				location = stations[idx] + w + 1;
				idx++; // 다음 기지국을 살피기 위해 +1 한다.
			} else {
				int newLocation = location + w;
				
				// 마지막 기지국 전의 idx 이전이고 && 위치가 다음 기지국 - w 보다 크거나 같을때 
				if( (idx <= stations.length - 2) && newLocation >= stations[idx+1]-w )
					newLocation = stations[idx+1] - w - 1;  


				// 현재 위치가 전파가 닿지 않는 곳이라면, 기지국을 설치하고 전파가 닿지 않을 바로 오른쪽으로 이동한다. 
				location = newLocation + w + 1;
				// 기지국을 설치했으므로
				++answer;
			}
		}
		return answer;
	}
}
