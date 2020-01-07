package InterfacePart;

// "모든" 메서드가 추상메서드로 구현되어있다 -> java8부터는 default 키워드 이용가능
// 설계용으로 사용한다
// 형식적인 선언만 있고 구현은 없다
public interface Sort {

	public void ascending(int[] arr);
	public void descending(int[] arr);
	
	default void description() {
		System.out.println("숫자를 정렬하는 알고리즘 입니다 ");
	}
	
}
