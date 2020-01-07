package InterfacePart;

public class CompleteCalc extends Calculator {

	public int times(int num1, int num2) {
		return num1 * num2;
	}
	public int divide(int num1, int num2) {
		if(num2 == 0)
			return ERROR;
		return num1 / num2;
	}
	
	public void showInfo() {
		System.out.println("��� �����Ͽ���.");
	}
	
	@Override
	public void description() {
		System.out.println("Override�� description�̴�");
	}
}
