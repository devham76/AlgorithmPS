package classPart;
	
	
public class CardCompany {
	
	// 외부에서 바로 접근 못하게 private
	// 하나만 있어야 하므로 static
	private static CardCompany instance = new CardCompany();
	// 외부에서 생성못하게 private
	private CardCompany(){}
	
	// 외부에서 사용해야하므로 public
	// 외부에서 인스턴스 안만들고 함수에 바로 접근해야 하므로 static
	public static CardCompany getInstance() {
		if (instance == null)
			instance = new CardCompany();
		
		return instance;
	}
	
	// 이 회사에서 카드를 발급한다
	// 외부에서 접근해야 하므로 public
	// 인스턴스 없이 사
	public Card createCard() {
		Card card  = new Card();
		return card;
	}


	
}
	
