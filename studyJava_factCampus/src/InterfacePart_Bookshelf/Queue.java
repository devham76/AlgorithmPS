package InterfacePart_Bookshelf;

public interface Queue {
	void enQueue(String title);
	String deQueue();	// 하나 뺏을때 책이름을 반환한다
	
	int getSize(); // 큐의 사이즈 반환
}
