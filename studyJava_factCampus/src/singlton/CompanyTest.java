package singlton;

import java.util.Calendar;

public class CompanyTest {

	public static void main(String[] args) {
		Company c1 = Company.getInstace();
		Company c2 = Company.getInstace();
		
		// �ּ� ���� ����
		System.out.println(c1+" "+c2);
	
		// ����
		//Calendar cal = new Calendar(); 
		// ������ ����. �޷��� �̹� ������� �Ѱ��� �޷��� �������Ҽ��ִ�.
		Calendar calendar = Calendar.getInstance();
		calendar.getTime();	// Calendar�� ���� �޼ҵ� ��� ����
	}
}
