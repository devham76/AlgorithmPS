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
		// order�� �ν��Ͻ��� order�̴�
		// Ÿ�԰� ������ �ν��Ͻ��� �޼ҵ尡 �Ҹ���
		seller.sell();
		seller.order();
		
		
	}

}
