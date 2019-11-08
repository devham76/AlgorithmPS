package org.programmers;

import java.util.ArrayList;
import java.util.Collections;

public class kakao_2019_failPercentage {

	public static void main(String[] args) {
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		solution(5, stages);
		int[] stages2 = {4,4,4,4,4};
		solution(4, stages2);
	}
	
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] stagearr = new int[N+2];	// ���������� ����� ���Ѵ�
        ArrayList<stage> stageArr = new ArrayList<>();	// ���������� ���, ��������, ������ Ŭ����
        int manAllCnt = 0;	 // �� �ο�
        
        // ���������� ����� ���Ѵ�.
        for (int i=0; i<stages.length; i++){
        	stagearr[ stages[i] ] ++;
        	manAllCnt++;
        }
        // ��������, �������������, �������� ����
        for( int i=1; i<stagearr.length-1; i++) {
        	// int/double = int �� �����⶧���� double�� ����ȯ �ʿ�
        	stageArr.add( new stage(i, stagearr[i], (double)stagearr[i] / manAllCnt) );
        	manAllCnt -= stagearr[i];
        }
        
        // �������� ���� �������� ����
        Collections.sort(stageArr);
        
        for (int i=0; i<stageArr.size(); i++){
        	answer[i] = stageArr.get(i).getSeq();
        }
        
        return answer;
    }
}
class stage implements Comparable<stage>{
	int seq;
	int manCnt;
	double percentage;
	public stage(int seq, int manCnt, double percentage){
		this.seq =seq;
		this.manCnt = manCnt;
		this.percentage = percentage;
	}
	
	public int getSeq() {
		return this.seq;
	}
	public double getPercentage() {
		return this.percentage;
	}
	// �������� ���� �������� ����
    public int compareTo(stage s) {
        if (this.percentage > s.getPercentage()) {
            return -1;
        } else if (this.percentage < s.getPercentage()) {
            return 1;
        }
        return 0;
    }
}
