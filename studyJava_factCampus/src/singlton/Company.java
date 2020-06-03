package singlton;

public class Company {

	private static Company instance = new Company();	
	// 전체에서 사용될 유일한 인스턴스
	// 함부로 변경되면 안되므로 private로 선언
	// 단 하나의 값만을 가져야 하므로 static으로 선언

	// private 이므로 해당 클래스에서만 생성가능하다
	private Company() {}	
	
	// 객체를 생성하지 않고 해당 인스턴스를 부르고 싶어서 static으로 선언한다
	public static Company getInstace() {
		if (instance == null)
			instance = new Company();
		
		return instance;
	}

}