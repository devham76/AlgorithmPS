package Strategy;

public class LoadStrategy implements TransportStrategy{

	@Override
	public void transport() {
		System.out.println("도로를 통해 이동");
	}

	
}
