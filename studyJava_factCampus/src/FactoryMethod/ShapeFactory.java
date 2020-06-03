package FactoryMethod;

public class ShapeFactory {

	// 팩토리 메소드 - 객체 생성 후 반환
	public Shape getShap(String shapeType) {
		if(shapeType==null)
			return null;
		
		if(shapeType.equalsIgnoreCase("CIRCLE"))
			return new Circle();
		else if(shapeType.equalsIgnoreCase("RECTANGLE"))
			return new Rectangle();
		
		return null;
		
	}
}
