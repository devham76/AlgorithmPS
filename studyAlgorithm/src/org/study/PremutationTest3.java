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
			// 1. 배열 전체 길이 보다 큰 값이 있거나  ex) {4,1,2} / 전체길이 3, 큰값 4
			// 2. 배열 전체 길이 보다 작은 값이 중복되어 있을 경우 ex) {3,1,3} / 3이  중복 되어있음. 
			if(arr.length < arr[i] || chk[arr[i]-1] > 0)
				return false;
			else
				chk[arr[i]-1] = 1;
		}
        return answer;
    }
	
}
