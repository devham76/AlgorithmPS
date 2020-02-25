package org.baekjoon;

import java.io.*;
import java.util.*;

public class test8980_greedy_delivery {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());	// 마을 수 
		int c = Integer.parseInt(st.nextToken());	// 트럭용량
		int m = Integer.parseInt(br.readLine());	// 트럭용량
		List<Info> infoList = new ArrayList<>();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());	
			int r = Integer.parseInt(st.nextToken());	
			int b = Integer.parseInt(st.nextToken());
			infoList.add(new Info(s, r, b));
		}
		infoList.sort((senInfo1,sendInfo2) -> 
		
		(senInfo1.send == sendInfo2.send) ? 
				(senInfo1.receive - sendInfo2.receive) : (senInfo1.send - sendInfo2.send));
	
		int[] truck = new int[n+1];
		int answer = 0;
		int nowBox = 0;
		int idx=0;
		for(int town=1; town<n+1; town++) {
			
			// 내릴것이 있는지 확인
			if(town > 1 && truck[town] > 0) {
				//System.out.println("truck["+town+"] ="+truck[town]);
				answer += truck[town];
				nowBox -= truck[town];
			}
			for(;idx<infoList.size(); idx++) {
				//System.out.println("idx:"+idx);
				Info info = infoList.get(idx);
				// 보내는 정보가 현재 마을인것 모두 확인
				if(info.send == town ) {
					if( nowBox < c) {
						int addBox = c - nowBox < info.box ? c-nowBox : info.box;
						//System.out.println("nowBox : "+nowBox +", receive:"+info.receive+"addBox;"+addBox);
						nowBox += addBox;
						truck[info.receive] += addBox;
					}
						
				}
				// 보내는 정보가 현재마을이 아닐때 중지
				else 
					break;
				
			}
		}
		System.out.println(answer);
	}

}
class Info {
	int send;
	int receive;
	int box;
	Info(int send, int receive, int box){
		this.send = send;
		this.receive = receive;
		this.box = box;
	}
	
	public int getSend() {
		return send;
	}

	public int getReceive() {
		return receive;
	}

	public int getBox() {
		return box;
	}
	public String toString() {
		return send+" / "+receive+" / "+box;
	}
}

	
