package GenericPart;

public class Plastic extends Meterial{

	// 오버라이딩, 부모 함수를 나에 맞게 재정의
	public String toString() {
		return "재료는 plastic입니다";
	}

	// 부모의 추상메서드는 무조건 구현해야한다
	@Override
	public void doPrinting() {
		System.out.println("plastic으로 프린팅한다");	
	}
}
