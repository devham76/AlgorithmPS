package InterfacePart;

public class QuickSort implements Sort,Sort2 {

	@Override
	public void ascending(int[] arr) {
		System.out.println("QuickSort ascending");
	}

	@Override
	public void descending(int[] arr) {
		System.out.println("QuickSort dscending");	
	}
	
	
	// default void description() ���� �����ϸ� ��������
	public void description() {
		Sort.super.description();
		System.out.println("QuickSort �Դϴ� ");
	}
	
}
