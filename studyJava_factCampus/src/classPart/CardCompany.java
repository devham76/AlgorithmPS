package classPart;
	
	
public class CardCompany {
	
	// �ܺο��� �ٷ� ���� ���ϰ� private
	// �ϳ��� �־�� �ϹǷ� static
	private static CardCompany instance = new CardCompany();
	// �ܺο��� �������ϰ� private
	private CardCompany(){}
	
	// �ܺο��� ����ؾ��ϹǷ� public
	// �ܺο��� �ν��Ͻ� �ȸ���� �Լ��� �ٷ� �����ؾ� �ϹǷ� static
	public static CardCompany getInstance() {
		if (instance == null)
			instance = new CardCompany();
		
		return instance;
	}
	
	// �� ȸ�翡�� ī�带 �߱��Ѵ�
	// �ܺο��� �����ؾ� �ϹǷ� public
	// �ν��Ͻ� ���� ��
	public Card createCard() {
		Card card  = new Card();
		return card;
	}


	
}
	
