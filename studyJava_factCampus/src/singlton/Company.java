package singlton;

public class Company {

	private static Company instance = new Company();	
	// ��ü���� ���� ������ �ν��Ͻ�
	// �Ժη� ����Ǹ� �ȵǹǷ� private�� ����
	// �� �ϳ��� ������ ������ �ϹǷ� static���� ����

	// private �̹Ƿ� �ش� Ŭ���������� ���������ϴ�
	private Company() {}	
	
	// ��ü�� �������� �ʰ� �ش� �ν��Ͻ��� �θ��� �; static���� �����Ѵ�
	public static Company getInstace() {
		if (instance == null)
			instance = new Company();
		
		return instance;
	}
}
