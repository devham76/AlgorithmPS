package InterfacePart;

// "���" �޼��尡 �߻�޼���� �����Ǿ��ִ� -> java8���ʹ� default Ű���� �̿밡��
// ��������� ����Ѵ�
// �������� ���� �ְ� ������ ����
public interface Sort {

	public void ascending(int[] arr);
	public void descending(int[] arr);
	
	default void description() {
		System.out.println("���ڸ� �����ϴ� �˰��� �Դϴ� ");
	}
	
}
