package org.codility;

import java.util.Iterator;
import java.util.*;

// 이게 2번문제임

public class e2020_2 {

	public static void main(String[] args) {
		int[] A = {51, 17, 71, 42, 33, 170, 180, 1};
		List<number> list = new ArrayList<>();
		for(int i=0; i<A.length; i++) {
			list.add(new number(A[i], getDigit(A[i])));
		}
		System.out.println("--");
		Collections.sort(list);
		long max = 0;
		int prevSum = 0;
		for(int i=0; i<list.size();i++) {
			System.out.println(list.get(i).sum+" "+list.get(i).num);
		}
		for(int i=0; i<list.size()-1;i++) {
			number n1 = list.get(i);
			number n2 = list.get(i+1);
			
			if(prevSum == n1.sum)
				continue;
			
			if(n1.sum == n2.sum) {
				System.out.println("sum="+n1.sum +" 두개의 합="+(n1.num+n2.num));
				max = Math.max(max, n1.num+ n2.num);
				prevSum = n1.sum;
			}
		}
		
		if(max == 0)
			System.out.println(-1);
		else
			System.out.println(max);
	}
	static public int getDigit(int number) {
		int answer = 0;
		while(number >= 1) {
			answer += number%10;
			number = number/10;
		}
		return answer;
	}

}
class number implements Comparable<number>{
	int num;
	int sum;
	number(int num, int sum){
		this.num = num;
		this.sum = sum;
	}
	@Override
	public int compareTo(number number) {
		if(this.sum == number.sum) {
			return number.num - this.num;
		}
		else {
			return this.sum - number.sum;
		}
	}
	
}
