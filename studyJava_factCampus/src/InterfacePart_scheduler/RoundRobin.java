package InterfacePart_scheduler;

public class RoundRobin implements Scheduler {

	@Override
	public void getNextCall() {
		System.out.println("RoundRobin ���� �����´�");
	}

	@Override
	public void sendCallToAgent() {
		System.out.println("RoundRobin ���� �������� �ݴϴ�");
	}

	
}
