package ObectPart;

class Book implements Cloneable{	// 해당 interface를 implements해줘야 clone()사용가능.
	String title;
	String author;
	Book(String title, String author){
		this.title = title;
		this.author = author;
	}
	
	// 마우스 오른쪽 -> source -> overriding 
	// Object classd의 toString()메서드를 오버라이딩 한다
	@Override
	public String toString() {
		//return super.toString(); (부모의 원형 호출)
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
		Book book = new Book("해리포터", "j.k.롤링");
		System.out.println(book.toString());
		Book book2 = (Book) book.clone();
		System.out.println(book2);
	}

}
