package TemplateMethod;

public abstract class HouseTemplate {

	//final 선언으로 override 방지
	public final void buildHouse() {
		buildFoundation();
		buildPillars();
		buildWalls();
		buildWindows();
		System.out.println("House is built!");
	}

	// 기본으로 구현
	private void buildWindows() {
		System.out.println("창문은 방탄유리야!!-_-^");
	}

	// 서브클래스에서 직접 구현 할 메소드
	public abstract void buildWalls();
	public abstract void buildPillars();

	private void buildFoundation() {
		System.out.println("시멘트, 철, 모래, 돌이 필요합니다");
	}


}
