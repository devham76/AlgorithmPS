package org.baekjoon;

import java.io.*;
import java.util.*;

public class test1138 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<person> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int idx = i+1;
			int num = Integer.parseInt(st.nextToken());
			list.add(new person(idx, num));
		}
		
		Comparator arrySort = new Comparator<person>() {

			@Override
			public int compare(person p1, person p2) {
				if(p1.num == p2.num)
					return Integer.compare(p1.idx , p2.idx);
				else
					return Integer.compare(p1.num , p2.num);
			}

		};
		
		int[] answer = new int[n];
		int i=0;
		while(list.size() > 0) {
			
			Collections.sort(list, arrySort);
			answer[i++] = list.get(0).idx;
			list.remove(0);
			for(int j=0; j<list.size(); j++) {
				if(list.get(j).idx < answer[i-1])
					list.get(j).minus();
			}
		
		}
		for(Integer k:answer)
			System.out.print(k+" ");
		
	}

}
class person{
	int idx;
	int num;
	person(int idx, int num){
		this.idx = idx;
		this.num = num;
	}
	public void minus() {
		this.num--;
	}
}


/*
다른 사람 풀이
키가 큰순서데로 넣으면된다...
public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] tall = new int[n+1];
        List<Integer> ans = new ArrayList<>();
 
        for(int i=1; i<=n; i++) {
            tall[i] = scan.nextInt();
        }
 
        for(int i=n; i>=1; i--) {
            ans.add(tall[i], i);
        }
 
        for(int k : ans) {
            System.out.print(k+" ");
        }
    }
 * */
 