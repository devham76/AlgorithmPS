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
	
		/*
		 * 장점 1. 전체 클래스에서 한개만 생성되므로 메모리 아낄수있다
		 * 장점 2. 다른 객체들과 공유가 용이하다
		 * 
		 * 단점 1. 싱글톤으로 만든 객체가 복잡하다면, 객체간 결합도 높아진다
		 * */
	}
}