package LambdaPart;

interface PrintString{
	void showString(String str);
}

public class TestLambda {

	public static void main(String[] args) {
		PrintString lambdaStr = s->System.out.println(s);
		lambdaStr.showString("hi");
	
		showMyString(lambdaStr);
		
		// �����ΰ� ���Եȴ�
		PrintString test = returnString();
		test.showString("hi3");
	}
	
	// �Ű������� Ȱ��Ǿ���, �ٷ� �����Ȱ��� ����ȴ�
	public static void showMyString(PrintString p) {
		p.showString("hi2");
	}
	
	// �Լ��� �����ΰ� ��ġ ���� ó�� ��ȯ�ɼ��ִ�
	public static PrintString returnString() {
		return s->System.out.println(s+"!!!");
	}
}
