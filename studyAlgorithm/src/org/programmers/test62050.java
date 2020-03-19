package org.programmers;

import java.util.*;

public class test62050 {

	public static void main(String[] args) {
		int[][] land = {{1, 4, 8, 10}, {5, 5, 5, 5},
				{10, 10, 10, 10}, {10, 10, 10, 20}};
		//solution(land,3);
		int[][] land3 = {{10, 11, 10, 11}, {2, 21, 20, 10},
				{1, 20, 21, 11}, {2, 1, 2, 1}};
		int[][] land2 = {{ 20, 20, 20, 20 },
			        	 { 26, 20, 20, 40 },
			        	 { 26, 20, 20, 40 },
			        	 { 15, 15, 20, 40 }};
		solution(land2, 1);

	}

	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
    public static int solution(int[][] land, int height) {
        int answer = 0;
        int N = land.length;
        boolean[][] visited = new boolean[N][N];
        Queue<Land> landNoLadder = new LinkedList<Land>();
        PriorityQueue<Land> landNeedLadder = new PriorityQueue<Land>();
        landNoLadder.offer(new Land(0, 0, 0));
        
        while (!landNoLadder.isEmpty()){
            Land curr = landNoLadder.poll();
            if (!visited[curr.row][curr.col]) {
            	System.out.println("*** ["+curr.row+"]["+curr.col+"]="+curr.cost);
                visited[curr.row][curr.col] = true;
                answer += curr.cost;
                
                //check left
                if (curr.col > 0) {
                    //사다리없이 이동 가능한 경우
                    if (Math.abs(land[curr.row][curr.col] - land[curr.row][curr.col - 1]) <= height) { 
                        landNoLadder.offer(new Land(curr.row, curr.col - 1, 0));
                    } 
                    //이동에 사다리가 필요한 경우
                    else {
                        landNeedLadder.offer(new Land(curr.row, curr.col - 1, 
                                                      Math.abs(land[curr.row][curr.col] - land[curr.row][curr.col - 1])));
                    }
                }
                //check right
                if (curr.col < N - 1) {
                    //사다리없이 이동 가능한 경우
                    if (Math.abs(land[curr.row][curr.col] - land[curr.row][curr.col + 1]) <= height) { 
                        landNoLadder.offer(new Land(curr.row, curr.col + 1, 0));
                    } 
                    //이동에 사다리가 필요한 경우
                    else {
                        landNeedLadder.offer(new Land(curr.row, curr.col + 1, 
                                                      Math.abs(land[curr.row][curr.col] - land[curr.row][curr.col + 1])));
                    }
                }
                //check up
                if (curr.row > 0) {
                    //사다리없이 이동 가능한 경우
                    if (Math.abs(land[curr.row][curr.col] - land[curr.row - 1][curr.col]) <= height) { 
                        landNoLadder.offer(new Land(curr.row - 1, curr.col, 0));
                    } 
                    //이동에 사다리가 필요한 경우
                    else {
                        landNeedLadder.offer(new Land(curr.row - 1, curr.col, 
                                                      Math.abs(land[curr.row - 1][curr.col] - land[curr.row][curr.col])));
                    }
                }
                //check down
                if (curr.row < N - 1) {
                    //사다리없이 이동 가능한 경우
                    if (Math.abs(land[curr.row][curr.col] - land[curr.row + 1][curr.col]) <= height) { 
                        landNoLadder.offer(new Land(curr.row +1, curr.col, 0));
                    } 
                    //이동에 사다리가 필요한 경우
                    else {
                        landNeedLadder.offer(new Land(curr.row + 1, curr.col, 
                                                      Math.abs(land[curr.row + 1][curr.col] - land[curr.row][curr.col])));
                    }
                }
            }
            
            
            //더이상 사다리없이 이동 가능한 공간이 없을때 가장 낮은값으로 이동할 수 있는 공간을 추가한다
            if (landNoLadder.isEmpty()) {
            	Iterator it = landNeedLadder.iterator();
            	while(it.hasNext()) {
            		System.out.println(it.next().toString());
            	}

            	System.out.println("-------------");
            	Land l = landNeedLadder.poll();
            	System.out.println("-->["+l.row+"]["+l.col+"] = "+l.cost);
                if (!landNeedLadder.isEmpty()) landNoLadder.offer(l);
            }   
        }
        System.out.println(answer);
        return answer;
    }
}
class Land implements Comparable<Land> {
    int row;
    int col;
    int cost;
    public Land(int row, int col, int cost) {
        this.row = row;
        this.col = col;
        this.cost = cost;
    }
    public String toString() {
    	return "["+row+"]["+col+"] = "+cost;
    }
    //PriorityQueue에 cost가 낮은 순으로 정열하기 위한 메소드
    @Override
    public int compareTo(Land l) {
        if (this.cost < l.cost) {
            return -1;
        }
        else if (this.cost > l.cost) {
            return 1;
        }
        return 0;
    }
}