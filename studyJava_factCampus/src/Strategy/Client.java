package Strategy;

public class Client {

	public static void main(String[] args) {
		Transportation bus = new Bus();
		Transportation airplane = new Airplane();
		
		// 이동방식 선택
		bus.setMovableStrategy(new LoadStrategy());
		airplane.setMovableStrategy(new SkyWayStrategy());
		
		// 이동
		bus.transport();
		airplane.transport();
		
		
		// 만약, 하늘을 나는 버스가 개발된다면???
		bus.setMovableStrategy(new SkyWayStrategy());
		bus.transport();
		
	}

}
