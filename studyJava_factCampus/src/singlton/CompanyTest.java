package singlton;

import java.util.Calendar;

public class CompanyTest {

	public static void main(String[] args) {
		Company c1 = Company.getInstace();
		Company c2 = Company.getInstace();
		
		// 주소 값이 같다
		System.out.println(c1+" "+c2);
	
		// 예시
		//Calendar cal = new Calendar(); 
		// 컴파일 에러. 달력은 이미 만들어진 한개의 달력을 참조만할수있다.
		Calendar calendar = Calendar.getInstance();
		calendar.getTime();	// Calendar의 여러 메소드 사용 가능
	}
}
