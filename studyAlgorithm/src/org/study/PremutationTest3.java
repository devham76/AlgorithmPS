package org.study;
import java.util.*;
public class PremutationTest3 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,3,1,2};
		System.out.println(solution(arr));
		
	}
	public static boolean solution(int[] arr) {
		boolean answer = true;
		
		int[] chk = new int[arr.length+1];
		
		for(int i=0; i<arr.length; i++) {
			// 1. �迭 ��ü ���� ���� ū ���� �ְų�  ex) {4,1,2} / ��ü���� 3, ū�� 4
			// 2. �迭 ��ü ���� ���� ���� ���� �ߺ��Ǿ� ���� ��� ex) {3,1,3} / 3��  �ߺ� �Ǿ�����. 
			if(arr.length < arr[i] || chk[arr[i]-1] > 0)
				return false;
			else
				chk[arr[i]-1] = 1;
		}
        return answer;
    }
	
}
