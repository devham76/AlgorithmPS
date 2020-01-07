package InterfacePart_Bookshelf;


// 좋은 선반이 있어서 상속하고, queue의 기능을 강제로 구현하고싶다.
public class BookShelf extends Shelf implements Queue{

	
	@Override
	public void enQueue(String title) {
		// 부모 클래스 (Shelf)가 가지고 있는 변수를 사용
		shelf.add(title);
	}

	@Override
	public String deQueue() {
		return shelf.remove(0);
	}

	@Override
	public int getSize() {
		// 부모의 함수 사용
		// super.getCount();로 사용해도 가능
		return getCount();
	}

}
