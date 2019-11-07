package org.programmers;

public class Level2_network_43162 {

	public static void main(String[] args) {
		int[][] c = { {1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		solution(3, c);
	}
	static int nowCnt= 0;
    static int network = 0;
	public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        findWay(0, computers, visited);
        System.out.println(network);
        return answer;
    }
    public static void findWay(int now, int[][] computers, boolean[] visited) {
    	System.out.println("now:"+now+", nowCnt:"+nowCnt+", network:"+network);
    	if(now == computers.length)
    		return;
    	for(int i=0; i< computers.length; i++) {
    		
    		if(now !=i && computers[now][i] == 1 && visited[i] == false) {
    			nowCnt++;
    			visited[i] = true;
    			findWay(i, computers, visited);
    		}
    	}
    	
    	if (nowCnt < computers.length) {
    		network ++;
    		findWay(now+1, computers, visited);
    	}
    }
}
