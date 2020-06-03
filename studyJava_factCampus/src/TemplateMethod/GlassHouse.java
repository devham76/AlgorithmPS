package TemplateMethod;

public class GlassHouse extends HouseTemplate {

	@Override
	public void buildWalls() {
		System.out.println("유리로 벽을 만들어야지~~~");
	}

	@Override
	public void buildPillars() {
		System.out.println("유리로 기둥을 만들었다능");
	}

}
