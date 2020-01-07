package ArrayList;

import java.util.ArrayList;

public class Student {
	String name;
	int id;
	ArrayList<Book> bookList;
	
	Student(int id, String name){
		this.name = name;
		this.id = id;
		// �л��� �����ɶ� ����Ʈ�� ����
		bookList = new ArrayList<>();
	}
	
	void addBook(String bookName, String author) {
		bookList.add(new Book(bookName, author));
	}
	
	public void showStudentInfo() {
		System.out.print(name+" �л��� ���� å�� : ");
		for(int i=0; i<bookList.size(); i++) {
			System.out.print(bookList.get(i).bookName+" ");
		}
		System.out.print("�Դϴ�");
		System.out.println();
	}
}
