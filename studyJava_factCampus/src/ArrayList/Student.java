package ArrayList;

import java.util.ArrayList;

public class Student {
	String name;
	int id;
	ArrayList<Book> bookList;
	
	Student(int id, String name){
		this.name = name;
		this.id = id;
		// 학생이 생성될때 리스트도 생성
		bookList = new ArrayList<>();
	}
	
	void addBook(String bookName, String author) {
		bookList.add(new Book(bookName, author));
	}
	
	public void showStudentInfo() {
		System.out.print(name+" 학생이 읽은 책은 : ");
		for(int i=0; i<bookList.size(); i++) {
			System.out.print(bookList.get(i).bookName+" ");
		}
		System.out.print("입니다");
		System.out.println();
	}
}
