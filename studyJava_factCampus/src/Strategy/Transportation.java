package Strategy;

public class Transportation {

	private TransportStrategy transportStrategy;
	
	public void transport() {
		transportStrategy.transport();
	}
	
	public void setMovableStrategy(TransportStrategy transportStrategy) {
		this.transportStrategy = transportStrategy;
	}
}
