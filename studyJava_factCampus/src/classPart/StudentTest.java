
package classPart;

// �Լ��� ȣ���Ҷ� stack�޸𸮸� ����Ѵ� ���� ���� , �������� �θ� �Լ����� ó���Ѵ�
// �Լ��� ȣ���� ������ �����ϰ��ִ� stack �޸𸮸� ��ȯ�Ѵ�

// �ν��Ͻ�
// Ŭ�����κ��� ������ ��ü, �� �޸𸮿� ��� ������ ũ�⿡ ���� �޸𸮰� ����
// ������� : student1, student2... student student1 = new student();
// �� : �����޸� 
// new �Ҷ�  (�Լ�ȣ��� stack�� �޸� ���)stack�� student1���� �޸𸮰� ����� heap�� student1�� ������ ��ŭ �����

// ���������� �Լ��� ������ �������
// ������ �÷��Ͱ� ������� �ʴ� �޸𸮸� �����Ѵ�

// class�´빮�ڷ� ��������
public class StudentTest {

	public static void main(String[] args) {
		student s = new student(123,"������","����");
		s.showStudentInfo();
		s.address = "���� ������";
		s.name = "������";
		s.showStudentInfo();
		
		// student s2 = new student(); �����ڸ� ��������� ������ �� �����ڿ� ���缭 ��������� �Ѵ�
		
		

	}

}
// public class student �ϸ� ��������.
// public class~ �� �����ϴ°� class �Ĥ��� �ȿ� �ϳ��� �־�� �Ѵ�
class student {
	//static �� �ǰ�
	//public�� �Ǵ� ������ ����
	public int id;
	static String name;
	public String address;
	
	student(int id, String name, String address){
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	// ����� �޼���� �����Ѵ�
	void showStudentInfo() {
		System.out.println("�й� : "+id+", �̸�:"+name+", �ּ�:"+address);
	}
	
	
}
