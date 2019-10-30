package org.study;

import java.util.HashMap;
import java.util.Iterator;

public class hashTest {

	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		// �� �ֱ�
		map.put(1, "�Ƹ޸�ī��");
		map.put(2, "īǪġ��");
		map.put(3, "ī���");
		// {1=�Ƹ޸�ī��, 2=īǪġ��, 3=ī���}
		System.out.println(map);
		
		// key �� ���� �������� ���
		String val = map.get(3);
		// key���� 3�� ������ :ī���
		System.out.println("key���� 3�� ������ :"+val);

		// Iterator : ��� �÷���Ŭ������ �����͸� ������ ���
		// keySet() : key������ ���� , [1, 2, 3]
		Iterator<Integer> keySetIterator = map.keySet().iterator();
		while(keySetIterator.hasNext()) {
			int key = keySetIterator.next();
			System.out.println("key : "+key+", value : "+map.get(key));
		}
		//key : 1, value : �Ƹ޸�ī��
		//key : 2, value : īǪġ��
		//key : 3, value : ī���
		
		//-- remove(key) : Ư���� ���� �� ������ ������ ��ȯ
		//-- clear() : ��� ��ü �� �����
		int key = 3;
		Object value = map.remove(key);
		System.out.println("key 3 �� ���� �� ���Ϲ��� �� : "+value);
	}

}
