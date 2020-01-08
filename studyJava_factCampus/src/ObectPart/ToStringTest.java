package ObectPart;

class Book implements Cloneable{	// �ش� interface�� implements����� clone()��밡��.
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

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
}
public class ToStringTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		Book book = new Book("�ظ�����", "j.k.�Ѹ�");
		System.out.println(book.toString());
		Book book2 = (Book) book.clone();
		System.out.println(book2);
	}

}
