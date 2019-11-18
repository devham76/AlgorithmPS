package org.baekjoon;

import java.util.Scanner;

public class test11057_dp_acend {
public static long mod = 10007L;
    
    public static void main(String[] args)   {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        System.out.println(calc(n));
    }
 
    public static long calc(int n) {
        
        long[][] arr = new long[n+1][10];
        for(int i=0;i<10;i++) {
            arr[1][i]=1;
        }
        
        for(int i=2;i<=n;i++) {
            for(int j=0;j<10;j++) {
                arr[i][j]=0;
                for(int k=j;k<10;k++) {
                    arr[i][j] += arr[i-1][k];    
                }
                arr[i][j]%=mod;
            }
        }
        
        long result=0;
        for(int i=0;i<10;i++) {
            result += arr[n][i];
                
        }
        result %= mod;
        return result;
    }


}
