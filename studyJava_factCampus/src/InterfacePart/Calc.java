package InterfacePart;

public interface Calc {
	int ERROR = -99999;
	public int add(int num1, int num2);
	public int substract(int num1, int num2);
	public int times(int num1, int num2);
	public int divide(int num1, int num2);
	
	// java8부터 사용가능
	default void description() {
		System.out.println("계산기를 구현한다.");
		// myMethod(); 
		// myStaticMethod(); 
		
	}
	
	
	// java8 
	static int total(int[] arr) {
		int total = 0;
		for (int number:arr) {
			total += number;
		}
		
		// myMethod(); (x) static메서드에서 일반메서드 호출x
		// myStaticMethod(); static메서드 호출가능
		return total;
	}
	
	// java9 , 구현한 메서드에서는 재정의 불가능하다
	/*
	private void myMethod() {
		System.out.println("private method");
	}
	private static void myStaticMethod(){
		System.out.println("private static method");
	}
	*/
}
