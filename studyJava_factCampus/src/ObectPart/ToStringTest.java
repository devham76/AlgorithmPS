package ObectPart;

class Book{
	String title;
	String author;
	Book(String title, String author){
		this.title = title;
		this.author = author;
	}
	
	// ���콺 ������ -> source -> overriding 
	// Object classd�� toString()�޼��带 �������̵� �Ѵ�
	@Override
	public String toString() {
		//return super.toString(); (�θ��� ���� ȣ��)
		return title + ", " + author;
	}
	
}
public class ToStringTest {
	public static void main(String[] args) {
		Book book = new Book("�ظ�����", "j.k.�Ѹ�");
		System.out.println(book.toString());
	}

}
