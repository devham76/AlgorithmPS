package InterfacePart;

public interface Calc {
	int ERROR = -99999;
	public int add(int num1, int num2);
	public int substract(int num1, int num2);
	public int times(int num1, int num2);
	public int divide(int num1, int num2);
	
	// java8���� ��밡��
	default void description() {
		System.out.println("���⸦ �����Ѵ�.");
		// myMethod(); 
		// myStaticMethod(); 
		
	}
	
	
	// java8 
	static int total(int[] arr) {
		int total = 0;
		for (int number:arr) {
			total += number;
		}
		
		// myMethod(); (x) static�޼��忡�� �Ϲݸ޼��� ȣ��x
		// myStaticMethod(); static�޼��� ȣ�Ⱑ��
		return total;
	}
	
	// java9 , ������ �޼��忡���� ������ �Ұ����ϴ�
	/*
	private void myMethod() {
		System.out.println("private method");
	}
	private static void myStaticMethod(){
		System.out.println("private static method");
	}
	*/
}
