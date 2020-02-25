// https://minwoo-kang.github.io/A_8980/
// https://www.acmicpc.net/problem/8980
package org.baekjoon;

import java.io.*;
import java.util.*;

public class test8980_greedy_delivery2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numberOfPlace = Integer.parseInt(st.nextToken());
        int MAX_Capacity = Integer.parseInt(st.nextToken());
        int infoCount = Integer.parseInt(br.readLine());
        int answer = 0;
        List<SendInfo> sendInfoList = new ArrayList<>();
        int []places = new int[numberOfPlace+1];


        for (int i = 0; i < infoCount; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int boxes = Integer.parseInt(st.nextToken());
            sendInfoList.add(new SendInfo(start,end,boxes));
        }
        sendInfoList.sort((senInfo1,sendInfo2) -> (senInfo1.end == sendInfo2.end) ? (senInfo1.start - sendInfo2.start) : (senInfo1.end - sendInfo2.end));

        for (SendInfo sendInfo : sendInfoList){
            int placeCapacity=10001;
            int availableCapacity;
            
            System.out.println(sendInfo.start+"/ "+sendInfo.end);
            //출발 ~ 도착지 전까지 각 마을별로 최대한 많이 담아 갈 수 있는 화물의 무게 확인
            for (int i = sendInfo.start; i < sendInfo.end; i++) {
            	System.out.print("["+i+"] "+places[i]+" , ");
                placeCapacity = Math.min(placeCapacity, MAX_Capacity - places[i]);  
            }
            System.out.println();
            //화물 정보의 실제 무게와 마을의 여유 공간을 비교
            availableCapacity = Math.min(placeCapacity , sendInfo.boxes);   
            if (availableCapacity == 0)
                continue;
            else{
                answer += availableCapacity;
                for (int i = sendInfo.start; i < sendInfo.end; i++)    //마을에 적재한 화물만큼 추가
                    places[i] += availableCapacity;
            }
        }
        System.out.println(answer);
    }

    private static class SendInfo{
        int start,end,boxes;

        public SendInfo(int start, int end, int boxes) {
            this.start = start;
            this.end = end;
            this.boxes = boxes;
        }
    }
}
