package FactoryMethod;

public class FactoryPattenTest {

	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();
		
		Shape shape1 = shapeFactory.getShap("CIRCLE");
		shape1.draw();
		
		Shape shape2 = shapeFactory.getShap("RECTANGLE");
		shape2.draw();
	}

}
