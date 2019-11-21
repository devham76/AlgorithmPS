package org.programmers;

public class summercoding_2017_12978_2 {

	public static void main(String[] args) {
		int N = 5;
		int[][] road = {{1,2,1},{2,3,3},{5,2,2}
		,{1,4,2},{5,3,1},{5,4,2}};
		int K = 3;
		solution(N, road, K);

	}
	public static int solution(int N, int[][] road, int K) {
		int answer = 0;

		int[][] weight = new int[N+1][N+1];
		int[] distance = new int[N+1];
		boolean[] visited = new boolean[N+1]; 


		// �ִ� �Ÿ��� 50 * 2000 �̻��ϼ� �����Ƿ� �ش簪���� �ʱ�ȭ (���Ѵ밪)
		for (int i = 0; i < weight.length; i++)
			for (int j = 0; j < weight.length; j++)
				weight[i][j] = 10000;	
		
		for (int i = 0; i < distance.length; i++)
			distance[i] = 10000;
		distance[1] = 0;
		
		for (int i = 0; i < road.length; i++) {
			weight[ road[i][0] ][ road[i][1] ] = road[i][2];
			if ( road[i][0] == 1)	distance[ road[i][1] ] = road[i][2];
			if ( road[i][1] == 1)	distance[ road[i][0] ] = road[i][2];
		}
		weight[1][1] = 0;
		visited[1] = true;
		


		for (int i = 0; i < weight.length; i++) {
			for (int j = 0; j < weight.length; j++)
				System.out.print (weight[i][j]+" ");
			System.out.println();
		}

		int minIndex = 1;
		for (int j = 0; j < N; j++) {
			int index = minIndex;
			for (int i = 1; i < weight.length; i++) {
				int min = 10000;
				System.out.println("index = "+index+", j:"+j);
				// minIndex���� i�� ���̿� ������ �ִٸ�
				if (weight[ index ][i] < 10000) {
					System.out.println("distance[index]:"+distance[index]+ ", distance[i]");
					distance[ index ] = Math.min(distance[ index ], distance[i] + weight[i][ index ]);

					if (visited[index] == false && min > distance[ index ]) {
						minIndex = index;
					}
				}
			}
			visited[minIndex] = true;
		}
		for (int e:distance) {
			System.out.println(e);
		}


		return answer;
	}
}
/*
public class DijkstraTest02 {
	 
    static int[][] ad;
    static int[] dist;
    static boolean[] visit;
    static int nE, nV;
    static final int inf = 1000000;
    
    public static void ssp(int start, int end){
        dist[start] = 0;    // ���� ���� �� distance �ʱ�ȭ
        String s = "";
        for( int j = 0; j < nV; j++) // dist ���� �ѹ� �ʱ�ȭ �����Ƿ� n-1���� ����
        {
            int min = inf+1;    // dist �ּҰ� ã�� ���� �ӽ� �� �ʱ�ȭ
            int index = -1;
            for(int k = 1; k <= nV; k++){
                if(visit[k] == false && min > dist[k]){
                    min = dist[k];
                    index = k;
                }
            }
            visit[index] = true;
            s += index + " ";  // ��θ� üũ�ϴ� ���
            
            for(int l = 1; l <= nV; l++){
                if(ad[index][l] != 0 && dist[l] > dist[index] + ad[index][l]){ //���� ����� �˻��Ͽ� ������ ���� ã��
                        dist[l] = dist[index] + ad[index][l];
                }
                
            }
        }
        
        for(int i = 1; i <= nV; i++){
            System.out.print(dist[i]);
        }
        System.out.println();
        System.out.println(s);
        
    }
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        nV = scan.nextInt();
        nE = scan.nextInt();
        
        ad = new int[nV+1][nV+1];
        dist = new int[nV+1];
        visit = new boolean[nV+1];
        
        for(int i = 1; i <= nV; i++){
            dist[i] = inf;   //������ ������ ������ �Ÿ��� �ʱ�ȭ
        }
        
        for(int i = 0; i < nE; i++){
            int t1, t2, t3;
            t1 = scan.nextInt();
            t2 = scan.nextInt();
            t3 = scan.nextInt();
            
            ad[t1][t2] = t3;
        }
        
        ssp(1,5);
    }
 
}


��ó: https://manducku.tistory.com/29 [Manducku`s Code]

��ó: https://manducku.tistory.com/29 [Manducku`s Code]

��ó: https://manducku.tistory.com/29 [Manducku`s Code]
	*/