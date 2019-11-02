package org.programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class kakao_2020_openchat {

	public static void main(String[] args) {
		String[] record = {
				"Enter uid1234 Muzi", 
				"Enter uid4567 Prodo",
				"Leave uid1234",
				"Enter uid1234 Prodo",
				"Change uid4567 Ryan"
		};

		solution(record);

	}
	public static String[] solution(String[] record) {
		ArrayList<String> answer = new ArrayList<String>();
		HashMap<String, String> user = new HashMap<>();
		for (int i=0; i<record.length; i++) {
			String[] splitRecord = record[i].split(" ");
			// 명령문 비교
			switch (splitRecord[0]) {
			//아이디, 닉네임
			case "Enter" : 
				//if ( !user.containsKey(splitRecord[1]) )
				user.put(splitRecord[1], splitRecord[2]); 
				break;
			case "Change" : 
				user.put(splitRecord[1], splitRecord[2]); break;
			}
		}
		
		for (int i=0; i<record.length; i++) {
			String[] splitRecord = record[i].split(" ");
			String nickName = user.get( splitRecord[1] );
			switch (splitRecord[0]) {
			case "Enter" : 
				answer.add(nickName+"님이 들어왔습니다."); break;
			case "Leave" : 
				answer.add(nickName+"님이 나갔습니다."); break;
			}}

		String[] array = new String[answer.size()];

		for (int i=0; i<answer.size(); i++)
			array[i] = answer.get(i);
		
		return array;
	}
}
