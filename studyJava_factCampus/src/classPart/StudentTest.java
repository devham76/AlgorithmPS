
package classPart;

// 함수를 호출할때 stack메모리를 사용한다 선입 후출 , 마지막에 부른 함수부터 처리한다
// 함수의 호출이 끝나면 차지하고있던 stack 메모리를 반환한다

// 인스턴스
// 클래스로부터 생성된 객체, 힙 메모리에 멤버 변수의 크기에 따라 메모리가 생성
// 멤번변수 : student1, student2... student student1 = new student();
// 힙 : 동적메모리 
// new 할때  (함수호출시 stack에 메모리 사용)stack에 student1변수 메모리가 생기고 heap에 student1의 사이즈 만큼 생긴다

// 지역변수는 함수가 끝나면 사라진다
// 가비지 컬렉터가 사용하지 않는 메모리를 수거한다

// class는대문자로 시작하자
public class StudentTest {

	public static void main(String[] args) {
		student s = new student(123,"이혜미","서울");
		s.showStudentInfo();
		s.address = "서울 성동구";
		s.name = "이혜미";
		s.showStudentInfo();
		
		// student s2 = new student(); 생성자를 지정해줬기 때문에 그 생성자에 맞춰서 생성해줘야 한다
		
		

	}

}
// public class student 하면 오류난다.
// public class~ 로 시작하는건 class 파ㄴ일 안에 하나만 있어야 한다
class student {
	//static 도 되고
	//public도 되는 이유가 뭘까
	public int id;
	static String name;
	public String address;
	
	student(int id, String name, String address){
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	// 기능은 메서드로 구현한다
	void showStudentInfo() {
		System.out.println("학번 : "+id+", 이름:"+name+", 주소:"+address);
	}
	
	
}
