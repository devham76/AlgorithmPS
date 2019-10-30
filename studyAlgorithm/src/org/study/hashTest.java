package org.study;

import java.util.HashMap;
import java.util.Iterator;

public class hashTest {

	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		// 값 넣기
		map.put(1, "아메리카노");
		map.put(2, "카푸치노");
		map.put(3, "카페라떼");
		// {1=아메리카노, 2=카푸치노, 3=카페라떼}
		System.out.println(map);
		
		// key 로 값을 가져오는 방법
		String val = map.get(3);
		// key값이 3인 데이터 :카페라떼
		System.out.println("key값이 3인 데이터 :"+val);

		// Iterator : 모든 컬렉션클래스에 데이터를 읽을때 사용
		// keySet() : key값들의 모음 , [1, 2, 3]
		Iterator<Integer> keySetIterator = map.keySet().iterator();
		while(keySetIterator.hasNext()) {
			int key = keySetIterator.next();
			System.out.println("key : "+key+", value : "+map.get(key));
		}
		//key : 1, value : 아메리카노
		//key : 2, value : 카푸치노
		//key : 3, value : 카페라떼
		
		//-- remove(key) : 특정값 삭제 후 삭제한 데이터 반환
		//-- clear() : 모든 객체 다 지우기
		int key = 3;
		Object value = map.remove(key);
		System.out.println("key 3 값 삭제 후 리턴받은 값 : "+value);
	}

}
