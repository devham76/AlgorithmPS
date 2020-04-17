package org.programmers;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Level2_42583 {

	public static void main(String[] args) {
		int[] t1 = {7,4,5,6};
		solution(2, 10, t1);
		int[] t2  = {10,10,10,10,10,10,10,10,10,10};
		solution(100, 100, t2);

	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;

		Queue<Truck> truckq = new LinkedList<>();
		int time = 1;
		int allWeight = truck_weights[0];
		int idx = 0;
		truckq.add(new Truck(truck_weights[0], 1));
		
		while (!truckq.isEmpty()) {
			time++;
			
			// 모든 트럭 1이동
			Iterator it = truckq.iterator();
			while (it.hasNext()) {
				Truck t = (Truck) it.next();
				t.addLocation();
			}

			// 맨앞에있는 트럭이 다리를 건너면 다리에서 제거
			if (truckq.peek().location > bridge_length) {
				Truck endT = truckq.poll();
				allWeight -= endT.weight;
			}


			// 다리위에 트럭이 꽉 찾지 않았을 때.
			if (truckq.size() < bridge_length) {

				// 대기중인 트럭이 있고, 전체 트럭무게가 한계이하일때 -> 트럭을 올린다
				if (idx < truck_weights.length - 1) {
					
					if (allWeight + truck_weights[idx+1] <= weight) {
						++idx;
						truckq.add(new Truck(truck_weights[idx], 1));
						allWeight += truck_weights[idx];
					}
				}

			}
			
		}
		return time;
	}
}
class Truck {
	int weight;
	int location;

	Truck(int weight, int location) {
		this.weight = weight;
		this.location = location;
	}

	void addLocation() {
		this.location++;
	}
}
