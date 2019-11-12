package org.programmers;

public class Level1_experessN_42895 {

	public static void main(String[] args) {
		solution(5 ,12);
	}
    public static int solution(int N, int number) {
    	dfs (N, number, 0, 0);
        return answer;
    }
    static int answer = -1;
    public static void dfs(int N, int number, int count, int current){
    	
    	if (count > 9) {
    		answer = -1;
    		return ;
    	}
    	if (current == number) {
    		// answer ���� �������� �ְų� answer���� count�� �� �ּڰ��̸� 
    		if (answer == -1 || answer > count)
    			answer = count;
    		return ;
    	}
    	int nn = N;
    	for (int i = 0; i < 8 - count; i++) {
    		// ���������� ����Ƚ�� + ���� �̷���� ��Ģ���� Ƚ��(1) + nn�� ���� �߻��� Ƚ��(i)
    		// ��ó���� nn�� N, �� ������ NN, NNN, NNNN..... ; ��������? 8 - ���� ���� Ƚ�� ��ŭ ���� �����Ѵ�. 
    		dfs(N, number, count+1+i, current+nn);
    		dfs(N, number, count+1+i, current-nn);
    		dfs(N, number, count+1+i, current/nn);
    		dfs(N, number, count+1+i, current*nn);
    		
    		nn = N*10 + N;	
    	}
    }
}
