package LambdaPart;

public class TestMyNumber {

	public static void main(String[] args) {
		// MyMaxNumber인터페이스의 함수를 구현할건데, (함수이름은 안써준다)
		// max라는 이름으로 구현된 애는 x,y가 들어왔을때 더 큰거 반환한다
		MyMaxNumber max = (x, y) -> (x >= y) ? x: y;
		System.out.println(max.getMaxNumber(10, 20));
	}

}
