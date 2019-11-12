package org.programmers;
// https://www.welcomekakao.com/learn/courses/30/lessons/62049
public class witercoding_2019_origami {

	public static void main(String[] args) {
		//solution(3);
		solution(4);

	}
	static int[] answer;
	public static int[] solution(int n) {
		int[] design = {0};
		getDesign(n, 1, design);
		return answer;
	}
	public static void getDesign(int goal, int count, int[] prevDesign) {

		if (goal == count) {
			makeAnswer(prevDesign);
			return;
		}
		int[] design = new int[ prevDesign.length*2 + 1 ];
		for (int i = 0; i < prevDesign.length; i++) {
			// ���� ���� �������� �������� ����
			design[i] = prevDesign[i];
			// ���� ���� ������ �������� �ݴ��̴�
			design[ design.length -1 -i] = ( prevDesign[i] == 1) ? 0 : 1 ;
		}
		// ��� ���� ������ 0
		design[ prevDesign.length / 2] = 0;
		// �� ���� �� ���� �ݺ�
		getDesign( goal, count+1, design);
	}
	public static void makeAnswer(int[] arr) {
		answer = new int[arr.length];
		answer = arr.clone();
	}
}
