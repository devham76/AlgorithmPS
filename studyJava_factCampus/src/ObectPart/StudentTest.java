package ObectPart;

public class StudentTest {

	public static void main(String[] args) {
		Student studentLee = new Student(100,"������");
		Student studentLee2 = studentLee;
		Student studentham = new Student(100,"������");

		
		System.out.println(studentLee.equals(studentLee2));
		
		
		// equals()�� �����ε� ���������� studentLee.equals(studentham) ������ ���� �ּҰ� �ٸ��Ƿ� false�� ���´�
		// equals()�� �����ε��� : Student.id�� ������ true����ȯ
		System.out.println(studentLee.equals(studentham));
		
		// �ν��Ͻ� ����� ����ӽ��� �ּҸ� 10������ ��ȯ
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
			Student s = (Student)obj; // Student�� �ٿ�ĳ����
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