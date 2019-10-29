package org.programmers;

public class Test0921_2 {

	//[[1, 4], [3, 4], [3, 10]]	[1, 10]
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] v = {{1,4},{3,4}, {3,10}, {1,10}};
		solution(v);
	}
	public static int[] solution(int[][] v) {
        int[] answer = {};

        //x값 구하기
        int Px = v[0][0];
        int Py = v[0][1];
        
        int x=Px;
        int y=Py;
        
        for(int i=1;i<3;i++) {
        	if( Px != v[0][i] )
        		x = Px;
        	
        }
        System.out.println("Hello Java");

        return answer;
    }
}
