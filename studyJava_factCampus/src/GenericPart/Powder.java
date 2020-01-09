package GenericPart;

public class Powder extends Meterial {
	
	public String toString() {
		return "재료는 powder입니다";
	}

	@Override
	public void doPrinting() {
		System.out.println("powder로 프린팅한다");	
	}
}
