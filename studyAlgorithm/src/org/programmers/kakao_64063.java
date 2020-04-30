package org.programmers;

import java.util.HashMap;
import java.util.Iterator;

public class kakao_64063 {

	public static void main(String[] args) {
		long[] r = {1,1,1,1,1,1,1};
		long k = 10;
		solution(k,r);
	}

	public static long[] solution(long k, long[] room_number) {
		long[] answer = new long[room_number.length];
		boolean[] visited = new boolean[(int)k+1];
		HashMap<Long, Long> hm = new HashMap<>();

		for (int i = 0; i < room_number.length; i++) {
			
			long room = room_number[i];
			System.out.println("--------------");
			Iterator it = hm.keySet().iterator();
			while(it.hasNext()) {
				Long k2 = (Long) it.next();
			
				System.out.println("key="+k2+" value="+hm.get(k2));
			}
			
			if(hm.containsKey(room)) {
				long realRoom = hm.get(room)+1;
				
				while(hm.containsKey(realRoom)) {
					realRoom = hm.get(realRoom)+1;
				}
				System.out.println("real->"+realRoom);
				answer[i] = realRoom;
				hm.replace(room, realRoom);
				hm.put(realRoom, realRoom);
			}
			else {
				answer[i] = room;
				hm.put(room, room);
			}
		}
		
		for(Long a : answer)
			System.out.print(a+" ");
		return answer;

	}

	// 문제 그대로 푼것. 효율성 2/5
	public long[] solution2(long k, long[] room_number) {
		long[] answer = new long[room_number.length];
		boolean[] visited = new boolean[(int) (k + 1)];
		for (int i = 0; i < room_number.length; i++) {
			int room = (int) room_number[i];
			if (visited[room] == false) {
				visited[room] = true;
				answer[i] = room;
			} else {
				int next = room;
				while (true) {
					if (visited[next] == true)
						next++;
					else {
						visited[next] = true;
						answer[i] = next;
						break;
					}

				}
			}
		}
		return answer;
	}
}
