package GenericPart;

public class Plastic extends Meterial{

	// �������̵�, �θ� �Լ��� ���� �°� ������
	public String toString() {
		return "���� plastic�Դϴ�";
	}

	// �θ��� �߻�޼���� ������ �����ؾ��Ѵ�
	@Override
	public void doPrinting() {
		System.out.println("plastic���� �������Ѵ�");	
	}
}
