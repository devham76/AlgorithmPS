package org.baekjoon;
import java.util.PriorityQueue;

class Vehicle implements Comparable<Vehicle>{
	
	private String  name;	// 탈것의 이름
	private int 	time;	// 탈것의 걸리는시간
	
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
	//오름차순 정렬
	public int compareTo(Vehicle target) {
		// 내값이 작으면(빠르면) -1
		// 내값과 같으면 0
		// 내값이 크면 (느리면) 1
		if (this.time < target.getTime()) return -1;
		else if (this.time > target.getTime()) return 1;
		return 0;
	}
}
public class TestPriority_Queue {
	
	public static void main(String[] args) {
		PriorityQueue<Vehicle> pQ = new PriorityQueue<Vehicle>();
		
		//-- Vehicle클래스의 객체가 생성되면서 오름차순으로 정렬되는듯?
		pQ.offer(new Vehicle("대중교통", 70));
		pQ.offer(new Vehicle("자가용" , 45));
		pQ.offer(new Vehicle("도보"  , 400));
		pQ.offer(new Vehicle("자전거" , 125));

		while(!pQ.isEmpty()) {
			Vehicle v = pQ.poll();
			System.out.println(v.getName() + " 시간 : "+v.getTime());
		}
		
	}
}
