package InterfacePart_scheduler;

import java.io.IOException;

public class SchedulerTest {

	public static void main(String[] args) throws IOException {
		
		System.out.println("��ȭ ���� �Ҵ� ����� �����ϼ���");
		System.out.println("R : �Ѹ� ���ʴ��");
		System.out.println("L : ��Ⱑ ���� ���� �켱");
		System.out.println("P : �켱������ ���� ���켱 ���õ� ���� ����");
		
		int ch = System.in.read();
		Scheduler scheduler = null;
		
		// Scheduler interface�� �ִ°� ������ ���� �ȴ�
		if(ch == 'R'|| ch == 'r') {
			scheduler = new RoundRobin();
		}
		
		scheduler.getNextCall();
		scheduler.sendCallToAgent();
	}

}
