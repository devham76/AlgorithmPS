package org.naver;

import java.util.Arrays;

public class Test2 {
    public static void main(String[] ar){
        int n = 4;
        int[] arr = {1, 2, 3, 4};
        boolean[] visited = new boolean[n];

        System.out.println();
        
        for(int i=2; i<=n ;i++) {
            combination(arr, visited, 0, n, i);
        }
    }
    static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            print(arr, visited, n);
            return;
        } else {
            for(int i=start; i<n; i++) {
                visited[i] = true;
                combination(arr, visited, i + 1, n, r - 1);	
                	visited[i] = false;
            }
        }
    }

    static void print(int[] arr, boolean[] visited, int n) {

    	
    			for(int i=0; i<n; i++) {
                    if(visited[i] == true)
                    	System.out.print(arr[i] + " ");
    			}
    		
            
        System.out.println();
    }
}