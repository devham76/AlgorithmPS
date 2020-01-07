package InterfacePart_Bookshelf;



public class BookShelfTest {
	public static void main(String[] args) {
		Queue bookQueue = new BookShelf();
		bookQueue.enQueue("해리포터1");
		bookQueue.enQueue("해리포터2");
		bookQueue.enQueue("해리포터3");
		
		System.out.println(bookQueue.deQueue());
		System.out.println(bookQueue.deQueue());
		System.out.println(bookQueue.deQueue());
		System.out.println(bookQueue.getSize());
		
	}
}
