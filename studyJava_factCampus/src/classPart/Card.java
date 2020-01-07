package classPart;

public class Card {
	
	// 카드 번호는 카드당 하나 있다
	// static을 사용하면 모든 카드가 공유하므로 쓰면안된다
	// private로 외부에서 함부로 바꾸지 못하게 보호한다.
	//private static int cardNumber;
	private int cardNumber;
	
	// 카드시리얼 번호는  전체에 하나만있고, 함부로 바뀌면안된다
	private static int serialNumber = 10000;
	
	Card(){
		// 카드를 생성하면 카드 번호가 +1 된다
		serialNumber++;
		cardNumber = serialNumber;
	}
	
	// 카드의 번호를 건내준다
	public int getCardNumber() {
		return cardNumber;
	}


}
