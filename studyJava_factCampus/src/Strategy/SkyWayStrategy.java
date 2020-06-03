package Strategy;

public class SkyWayStrategy implements TransportStrategy{

	@Override
	public void transport() {
		System.out.println("하늘을 통해 이동");
	}
	
}
