package InterfacePart_scheduler;

public class RoundRobin implements Scheduler {

	@Override
	public void getNextCall() {
		System.out.println("RoundRobin 콜을 가져온다");
	}

	@Override
	public void sendCallToAgent() {
		System.out.println("RoundRobin 콜을 상담원에게 줍니다");
	}

	
}
