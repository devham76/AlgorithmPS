package InterfacePart_Bookshelf;



public class BookShelfTest {
	public static void main(String[] args) {
		Queue bookQueue = new BookShelf();
		bookQueue.enQueue("�ظ�����1");
		bookQueue.enQueue("�ظ�����2");
		bookQueue.enQueue("�ظ�����3");
		
		System.out.println(bookQueue.deQueue());
		System.out.println(bookQueue.deQueue());
		System.out.println(bookQueue.deQueue());
		System.out.println(bookQueue.getSize());
		
	}
}
