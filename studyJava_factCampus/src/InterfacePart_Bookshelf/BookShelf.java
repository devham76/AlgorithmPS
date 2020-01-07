package InterfacePart_Bookshelf;


// ���� ������ �־ ����ϰ�, queue�� ����� ������ �����ϰ�ʹ�.
public class BookShelf extends Shelf implements Queue{

	
	@Override
	public void enQueue(String title) {
		// �θ� Ŭ���� (Shelf)�� ������ �ִ� ������ ���
		shelf.add(title);
	}

	@Override
	public String deQueue() {
		return shelf.remove(0);
	}

	@Override
	public int getSize() {
		// �θ��� �Լ� ���
		// super.getCount();�� ����ص� ����
		return getCount();
	}

}
