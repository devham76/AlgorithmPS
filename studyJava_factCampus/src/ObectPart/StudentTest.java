package ObectPart;

public class StudentTest {

	public static void main(String[] args) {
		Student studentLee = new Student(100,"이혜미");
		Student studentLee2 = studentLee;
		Student studentham = new Student(100,"이혜미");

		
		System.out.println(studentLee.equals(studentLee2));
		
		
		// equals()를 오버로딩 하지않으면 studentLee.equals(studentham) 했을때 둘의 주소가 다르므로 false가 나온다
		// equals()를 오버로딩함 : Student.id가 같으면 true를반환
		System.out.println(studentLee.equals(studentham));
		
		// 인스턴스 저장된 가상머신의 주소를 10진수로 반환
		System.out.println(studentLee.hashCode());
		System.out.println(studentLee2.hashCode());
		
	}

}
class Student {
	int id;
	String name;
	Student(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if( obj instanceof Student) {
			Student s = (Student)obj; // Student로 다운캐스팅
			return (this.id == s.id);
		}
		return false;
	}


	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	
	
	
}