package ObectPart;

class Book{
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
	
}
public class ToStringTest {
	public static void main(String[] args) {
		Book book = new Book("해리포터", "j.k.롤링");
		System.out.println(book.toString());
	}

}
