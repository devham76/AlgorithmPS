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
	
	
	// default void description() 으로 선언하면 오류난다
	public void description() {
		Sort.super.description();
		System.out.println("QuickSort 입니다 ");
	}
	
}
