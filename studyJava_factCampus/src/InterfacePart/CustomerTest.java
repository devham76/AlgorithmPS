package InterfacePart;

public class CustomerTest {

	public static void main(String[] args) {
		Customer customer = new Customer();
		
		customer.buy();
		customer.sell();
		customer.order();
		customer.sayhello();
		
		Buy buyer = new Customer();
		buyer.buy();
		buyer.order();
		
		Sell seller = new Customer();
		// order는 인스턴스의 order이다
		// 타입과 별개로 인스턴스의 메소드가 불린다
		seller.sell();
		seller.order();
		
		
	}

}
