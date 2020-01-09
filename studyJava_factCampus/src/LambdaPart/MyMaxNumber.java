package LambdaPart;

// 함수형 인터페이스라고 지정
@FunctionalInterface
public interface MyMaxNumber {
	// 함수형 인터페이스는 함수 하나만 선언 !!
	int getMaxNumber(int x, int y);
}
