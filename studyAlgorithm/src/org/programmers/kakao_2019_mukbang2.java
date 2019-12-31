// 틀림
package org.programmers;

import java.util.*;


public class kakao_2019_mukbang2 {

	public static void main(String[] args) {
		kakao_2019_mukbang2 k = new kakao_2019_mukbang2();
		int[] food_times = {1,1, 2, 2, 3,5,8 };
		k.solution(food_times, 10);
		System.out.println();
		int[] food_times2 = { 3,1,2 };
		k.solution(food_times2, 5);
	}

	class food {
		int idx;
		int times;

		food(int idx, int times) {
			this.idx = idx;
			this.times = times;
		}
	}
	
	Comparator<food> CompTime = new Comparator<food>() {
		public int compare(food a, food b) {
			return a.times - b.times;
		}
	};
	Comparator<food> CompIdx = new Comparator<food>() {
		public int compare(food a, food b) {
			return a.idx - b.idx;
		}
	};
	public int solution(int[] food_times, long k) {
		int answer = 0;
		List<food> foodList = new LinkedList<>();
		for (int i=0; i<food_times.length; i++) {
			foodList.add(new food(i+1, food_times[i]));
		}
		
		Collections.sort(foodList, CompTime);
		int min=foodList.get(0).times;
		int minIdx = 0;
		
		for(int i=0; i<foodList.size();i++)
			System.out.print(foodList.get(i).idx+" ");
		System.out.println();
		for(int i=0; i<foodList.size();i++)
			System.out.print(foodList.get(i).times+" ");
		
		System.out.println();
		long nowTime = 0;
		while (nowTime < k) {
			System.out.println("nowTime :"+nowTime+", minIdx:"+minIdx);
			for(int i=0; i<min; i++) {
				if (nowTime + foodList.size()-minIdx <= k) {
					nowTime += foodList.size()-minIdx;
				}
				else {
					System.out.println("k:"+k+", nowTime:"+nowTime);
					// 먹을 음식이 남아있는 순서부터 끝까지만 남긴다.
					List<food> foodList2 = foodList.subList(minIdx,foodList.size());
					foodList2.sort(CompIdx);
					System.out.println("size : "+foodList2.size());
					// 원래 음식이 나열되어있던 순서로 정렬한다.
					answer = foodList2.get((int) (k-nowTime+minIdx % food_times.length )).idx;
					nowTime = k;
					break;
				}
			}
			
				
			min = foodList.get(minIdx+1).times;
				
				minIdx++;
		}
		System.out.println("answer : "+answer);
		return answer;
	}

}