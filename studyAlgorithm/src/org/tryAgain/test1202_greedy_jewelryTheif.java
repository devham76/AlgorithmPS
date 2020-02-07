https://dundung.tistory.com/88
	다시할것
	//https://www.acmicpc.net/problem/1202
package org.tryAgain;

import java.util.*;

public class test1202_greedy_jewelryTheif {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int jewelryCount = sc.nextInt();
		int bagCount = sc.nextInt();
		
		PriorityQueue<jewerly> jQueue = new PriorityQueue<jewerly>();
		
		Long[] bags = new Long[bagCount];
		
		int sum=0;
		
		for (int i=0; i<jewelryCount; i++) {
			jewerly j = new jewerly(sc.nextInt(), sc.nextInt());
			jQueue.offer( j );
		}
	
		for (int i=0; i<bags.length; i++)
			bags[i] = sc.nextLong();
		Arrays.sort(bags);
		boolean[] is_taken = new boolean[bagCount]; 
		
		for (int i=0; i<jewelryCount; i++) {
			jewerly bestJ = jQueue.poll();
			for(int j=0; j<bags.length; j++) {
				if(bestJ.weight < bags[j] && is_taken[j] == false) {
					sum+= bestJ.price;
					is_taken[j] = true;
					break;
				}
			}
		}

		System.out.println(sum);
	}
}

class jewerly implements Comparable<jewerly> {
	int weight;
	int price;
	
	jewerly(int weight, int price){
		this.weight = weight;
		this.price = price;
	}
	public int getPrice() {
		return this.price;
	}
	
	public int compareTo(jewerly target) {
        if (this.price > target.price) {
            return -1;
        } else if (this.price < target.price) {
            return 1;
        }
        return 0;
	}
}

// -- 값을 입력 받은 후에 정렬
//public static void main(String[] args) {
//	Scanner sc = new Scanner(System.in);
//	int jewelryCount = sc.nextInt();
//	int bagCount = sc.nextInt();
//	Long[][] jewelrys = new Long[jewelryCount][2];
//	Long[] bags = new Long[bagCount];
//	
//	int sum=0;
//	
//	for (int i=0; i<jewelrys.length; i++) {
//		jewelrys[i][0] = sc.nextLong();
//		jewelrys[i][1] = sc.nextLong();
//	}
//	
//	for (int i=0; i<bags.length; i++)
//		bags[i] = sc.nextLong();
//	
//	sortJewerlys(jewelrys);
//	Arrays.sort(bags);
//	
//	
//	for (int i=0; i<bags.length; i++) {
//		int jIdx = 0;
//		for (int j=jIdx; j<jewelrys.length; j++) {
//			
//			if(jewelrys[j][0] < bags[i]) {
//				jIdx = j+1;
//				sum += jewelrys[j][1];
//				break;
//			}
//		}
//		
//	}
//	System.out.println(sum);
//}
//
//private static void sortJewerlys(Long[][] jewelrys) {
//	Arrays.sort(jewelrys, new Comparator<Long[]>(){
//
//		@Override
//		public int compare(Long[] arg0, Long[] arg1) {
//			return ((Comparable) arg1[1]).compareTo(arg0[1]);
//		}
//	});
//	
//}
