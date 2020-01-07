package InterfacePart_scheduler;

import java.io.IOException;

public class SchedulerTest {

	public static void main(String[] args) throws IOException {
		
		System.out.println("전화 상담원 할당 방식을 선택하세요");
		System.out.println("R : 한명씩 차례대로");
		System.out.println("L : 대기가 적은 상담원 우선");
		System.out.println("P : 우선순위가 높은 고객우선 숙련도 높은 상담원");
		
		int ch = System.in.read();
		Scheduler scheduler = null;
		
		// Scheduler interface에 있는걸 가져다 쓰면 된다
		if(ch == 'R'|| ch == 'r') {
			scheduler = new RoundRobin();
		}
		
		scheduler.getNextCall();
		scheduler.sendCallToAgent();
	}

}
