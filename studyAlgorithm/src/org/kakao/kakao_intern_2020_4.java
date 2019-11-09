package org.kakao;
//미 완료
import java.util.*;

public class kakao_intern_2020_4 {

	public static void main(String[] args) {
		long[] r = {1,3,4,1,3,1};
		solution(10, r);
		// 1,3,4,2,5,6
	}
	public static long[] solution(long k, long[] room_number) {
		long[] answer = new long[room_number.length];
		long[] fullRoom = new long[room_number.length];
		ArrayList<Long> check = new ArrayList<Long>();

		for (int i = 0; i < room_number.length; i++) {
			Arrays.sort(fullRoom, 0, i);
			int is_full = 0;
			// 큰 덩어리의 사이에 있는 값인지 확인한다.
			for (int c = 0; c < check.size()-1; c++) {
				if (check.get(c) <= room_number[i] && room_number[i] >= check.get(c+1)) {
					is_full = 1;
					answer[i] = check.get( c+1 )+1;
					fullRoom[i] = check.get( c+1 )+1;
					break;
				}		
			}
			if (is_full == 1) {
				continue;
			}

			
			int lastIndex = 0;
			for(int j=0; j<i; j++) {
				if(fullRoom[j] == 0)
					break;
				if (fullRoom[j] == room_number[i]+lastIndex) {
					lastIndex++;
				}
			}
			
			
			answer[i] = room_number[i]+lastIndex;
			fullRoom[i] = room_number[i]+lastIndex;
			if (lastIndex > 1) {
				
				check.add( room_number[i] );
				check.add( room_number[i]+lastIndex );
			}
			      

		}

/*
		for(Long e:answer)
			System.out.println(e);
		
		System.out.println();
		for (int i=0; i<check.size(); i++)
			System.out.print(check.get(i)+", ");
*/
		return answer;
	}
}
