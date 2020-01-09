package LambdaPart;

interface PrintString{
	void showString(String str);
}

public class TestLambda {

	public static void main(String[] args) {
		PrintString lambdaStr = s->System.out.println(s);
		lambdaStr.showString("hi");
	
		showMyString(lambdaStr);
		
		// 구현부가 대입된다
		PrintString test = returnString();
		test.showString("hi3");
	}
	
	// 매개변수로 활용되었고, 바로 구현된것이 실행된다
	public static void showMyString(PrintString p) {
		p.showString("hi2");
	}
	
	// 함수의 구현부가 마치 변수 처럼 반환될수있다
	public static PrintString returnString() {
		return s->System.out.println(s+"!!!");
	}
}
