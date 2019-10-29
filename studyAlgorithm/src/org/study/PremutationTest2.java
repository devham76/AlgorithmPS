package org.study;
import java.util.*;
public class PremutationTest2 {
	
	static boolean answer = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,1,2};
		solution(arr);
	}
	public static boolean solution(int[] arr) {
		
        int[] array 		= new int[arr.length]; 
        array = makeArr(arr.length);
        int[] output 		= new int[arr.length];
        boolean[] visited 	= new boolean[arr.length];
        
        perm(arr, array, output, visited, 0, arr.length, arr.length);
        return answer;
    }
	static void perm (int[] original, int[] array, int[] output, boolean[] visited, int depth, int num, int pick) {
		
		if (depth == pick) {
			if(Arrays.equals(original,output)) {
				answer = true;
			}
		}
		
		for (int i=0; i<num; i++) {
			if (visited[i] == false) {
				visited[i] 		= true;
				output[depth] 	= array[i];
				perm(original, array, output, visited, depth+1, num, pick);
				visited[i] 		= false;
			}
		}
		
	}
	static int[] makeArr(int n) {
		int[] arr = new int[n];
		for (int i=0; i<n; i++) {
			arr[i] = i+1;
		}
		return arr;
	}
}
