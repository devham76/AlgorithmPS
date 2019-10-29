package org.baekjoon;
import java.util.PriorityQueue;

class Vehicle implements Comparable<Vehicle>{
	
	private String  name;	// Ż���� �̸�
	private int 	time;	// Ż���� �ɸ��½ð�
	
	public Vehicle(String name, int time) {
		this.name = name;
		this.time = time;
	}
	public String getName() {
		return this.name;
	}
	public int getTime() {
		return this.time;
	}
	
	@Override
	//�������� ����
	public int compareTo(Vehicle target) {
		// ������ ������(������) -1
		// ������ ������ 0
		// ������ ũ�� (������) 1
		if (this.time < target.getTime()) return -1;
		else if (this.time > target.getTime()) return 1;
		return 0;
	}
}
public class TestPriority_Queue {
	
	public static void main(String[] args) {
		PriorityQueue<Vehicle> pQ = new PriorityQueue<Vehicle>();
		
		//-- VehicleŬ������ ��ü�� �����Ǹ鼭 ������������ ���ĵǴµ�?
		pQ.offer(new Vehicle("���߱���", 70));
		pQ.offer(new Vehicle("�ڰ���" , 45));
		pQ.offer(new Vehicle("����"  , 400));
		pQ.offer(new Vehicle("������" , 125));

		while(!pQ.isEmpty()) {
			Vehicle v = pQ.poll();
			System.out.println(v.getName() + " �ð� : "+v.getTime());
		}
		
	}
}
