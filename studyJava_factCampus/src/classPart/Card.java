package classPart;

public class Card {
	
	// ī�� ��ȣ�� ī��� �ϳ� �ִ�
	// static�� ����ϸ� ��� ī�尡 �����ϹǷ� ����ȵȴ�
	// private�� �ܺο��� �Ժη� �ٲ��� ���ϰ� ��ȣ�Ѵ�.
	//private static int cardNumber;
	private int cardNumber;
	
	// ī��ø��� ��ȣ��  ��ü�� �ϳ����ְ�, �Ժη� �ٲ��ȵȴ�
	private static int serialNumber = 10000;
	
	Card(){
		// ī�带 �����ϸ� ī�� ��ȣ�� +1 �ȴ�
		serialNumber++;
		cardNumber = serialNumber;
	}
	
	// ī���� ��ȣ�� �ǳ��ش�
	public int getCardNumber() {
		return cardNumber;
	}


}
