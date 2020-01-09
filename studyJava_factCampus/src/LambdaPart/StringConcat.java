package LambdaPart;

//함수형 인터페이스라고 지정
@FunctionalInterface
public interface StringConcat {
	// 함수형 인터페이스는 ★함수 하나만★ 선언
	public void makeString(String s1,String s2);
}
