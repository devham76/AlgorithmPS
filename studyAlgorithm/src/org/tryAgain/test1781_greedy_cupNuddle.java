package org.tryAgain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test1781_greedy_cupNuddle {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Long sum = 0l;
		int[][] arr = new int[n][2];
		int[][] answer = new int[n+1][2];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr,(o1,o2) ->{
			if(o1[0] == o2[0])
				return Integer.compare(o2[1], o1[1]);
			else
				return Integer.compare(o1[0], o2[0]);
		});
		
		int time = 1; int prev=0; int min=0; int minIdx = 1;
		for(int i=0; i<n; i++) {
			if(prev == arr[i][0]) {
				if(arr[i][1] > min) {
					answer[minIdx][0] = arr[i][0];
					answer[minIdx][1] = arr[i][1];
					
				}
			}
			
			if(time > arr[i][0]) continue;
			
			
			if(answer[time][0] == 0) {
				answer[time][0] = arr[i][0];
				answer[time][1] = arr[i][1];
				prev = arr[i][0];
				time++;
				continue;
			}
			
			
			
		}
	}

}
/*
 #include <iostream>
#include <algorithm>
#include <queue>
using namespace std;
pair<int,int> arr[200200];
int n;
 
int main(){
    //freopen("input.txt","r",stdin);
    scanf(" %d",&n);
    for(int i=0;i<n;i++) scanf(" %d %d",&arr[i].first,&arr[i].second);
    sort(arr,arr+n);
    priority_queue<int> pq;
    for(int i=0;i<n;i++){
        int d = arr[i].first;
        pq.push(-arr[i].second);
        while(d<pq.size()) pq.pop();
    }
    int ans=0;
    while(!pq.empty()) ans+=pq.top(),pq.pop();
    printf("%d\n",-ans);
 * */
 */