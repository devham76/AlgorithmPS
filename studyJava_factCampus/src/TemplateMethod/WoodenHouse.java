package TemplateMethod;

public class WoodenHouse extends HouseTemplate {

	@Override
	public void buildWalls() {
		System.out.println("나무 벽을 만들어야지~~~");
	}

	@Override
	public void buildPillars() {
		System.out.println("나무 기둥을 만들었다능");
	}


}
