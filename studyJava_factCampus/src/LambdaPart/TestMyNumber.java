package LambdaPart;

public class TestMyNumber {

	public static void main(String[] args) {
		// MyMaxNumber�������̽��� �Լ��� �����Ұǵ�, (�Լ��̸��� �Ƚ��ش�)
		// max��� �̸����� ������ �ִ� x,y�� �������� �� ū�� ��ȯ�Ѵ�
		MyMaxNumber max = (x, y) -> (x >= y) ? x: y;
		System.out.println(max.getMaxNumber(10, 20));
	}

}
