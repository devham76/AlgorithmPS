package InterfacePart;

public class Customer implements Buy, Sell {

	@Override
	public void sell() {
		System.out.println("Customer sell");	
	}

	@Override
	public void buy() {
		System.out.println("Customer buy");		
	}

	public void order() {
		//Buy.super.order();
		System.out.println("Customer order");	
	}
	
	public void sayhello() {
		System.out.println("customer hello!");
	}
}
