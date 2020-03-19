package org.programmers;

public class test1832 {

	public static void main(String[] args) {
		int[][] map = {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}};
		solution(3, 6, map);
		int[][] map2 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
		//solution(3,3,map2);
	}
	 
	  static long sum = 0L;
	  static int[][] map;
	  static int M, N;
	  public static int solution(int m, int n, int[][] cityMap) {
	      int answer = 0;
	      int MOD = 20170805;
	      // i-1, j-1의 값을 불러오기 때문에 0인 경우에 인덱스 범위를 벗어나서
	      // if문을 넣어 계속 체크를 해주는 것보다는 0행과 0열에 0으로 된 값을 넣어서 해결했습니다.
	      
	                                   
	      int[][] down = new int[m+1][n+1];
	      int[][] right = new int[m+1][n+1];
	      
	      // 시작값에서 에서 아래, 오른쪽으로 갈수있다
	      down[1][1] = 1;
	      right[1][1] = 1;
	      
	      for (int i =1; i <= m; i++) {
	          for(int j = 1; j <= n; j++) {
	              if (cityMap[i-1][j-1] == 0) {
	                  //아래쪽, 오른쪽으로 갈 수있는 경우의 수를 구해야 한다. 
	                  right[i][j] += (right[i][j-1] + down[i-1][j] ) %MOD;
	                  down[i][j] += (down[i-1][j] + right[i][j-1]) %MOD;
	              }
	              else if (cityMap[i-1][j-1] == 1) {
	                  //더이상 나아갈 수 없다. 
	                  right[i][j] = 0;
	                  down[i][j] = 0;
	              } 
	              else if (cityMap[i-1][j-1] == 2){
	                  //현재 온방향으로 계속 나아간다. (이전 좌표의 값을 그대로 갖고 감 )
	                  right[i][j] = right[i][j-1];	// 이전왼쪽 값
	                  down[i][j] = down[i-1][j];	// 이전위 값
	              }
	          }
	      }
	      for (int i =0; i <= m; i++) {
	          for(int j = 0; j <= n; j++) {
	        	  System.out.print(down[i][j]+" ");
	          }
	          System.out.println();
	      }
	      System.out.println();
	      for (int i =0; i <= m; i++) {
	          for(int j = 0; j <= n; j++) {
	        	  System.out.print(right[i][j]+" ");
	          }
	          System.out.println();
	      }
	      answer = (right[m][n-1] + down[m-1][n]) %MOD;
	      System.out.println(answer);
	      return answer;
	  }

}
