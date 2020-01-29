package org.programmers;

/*
 * 사각형 맵에서 최단 거리이동은 우측, 아래측 이동방향으로의 이동만 가능하다 !!!
 * 두가지 방향으로 이동하면서 우물이 있으면 가지않으면 된다
 * 
 * */
public class test42898_dp_goSchool {

	public static void main(String[] args) {
		test42898_dp_goSchool g = new test42898_dp_goSchool();
		int[][] puddles = {{2,2}};
		g.solution(4, 3, puddles);

	}
	static int[] dx = {1,0};
    static int[] dy = {0,1};
    
    static int[][] map;	public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        map = new int[m][n];
        for(int i=0; i<puddles.length; i++) {
        	map[ puddles[i][0]-1 ][ puddles[i][1]-1 ] = -1;
        }
        map[0][0] = 1;
        
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if( map[i][j] == -1 )
					continue;
				
				if( i-1 != -1) {
					if(map[i-1][j] > -1)
					map[i][j] += map[i-1][j] % 1000000007;
				}
				if(j-1 != -1) {
					if(map[i][j-1] > -1)
					map[i][j] += map[i][j-1] % 1000000007;
				}
			
			}
		}
		System.out.println(map[m-1][n-1]);
		return answer;
	}
	public int solution2(int m, int n, int[][] puddles) {
        int answer = 0;
        map = new int[m][n];
        for(int i=0; i<puddles.length; i++) {
        	map[ puddles[i][0]-1 ][ puddles[i][1]-1 ] = -1;
        }
        map[0][0] = 1;
        
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if( map[i][j] == -1 )
					continue;
				
				// 오른쪽, 아래쪽 으로 간다
				for(int k=0;k<2;k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					
				
					if(nx >= m || ny >=n)
						continue;
					if(map[nx][ny] == -1) 
						continue;
					
					map[nx][ny] += map[i][j];
				}
			}
		}
		
		System.out.println(map[m-1][n-1]);
		return answer;
	}
}
