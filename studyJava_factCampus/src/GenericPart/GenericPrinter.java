package GenericPart;

// 3d프린터, 재료는 다양하다
// T -> 실제로 사용할때 재료를 정하자라는 의미 , 실제로 사용될때 재료가 정해진다

// 재료를 한정짓기 위해 extends Meterial한다, 상속받은 것만 사용가능!!!!!
public class GenericPrinter<T extends Meterial> {	

	private T material;

	public T getMaterial() {
		return material;
	}

	public void setMaterial(T material) {
		this.material = material;
	}
	
	public String toString() {
		return material.toString();
	}

	public void doPrinting() {
		material.doPrinting();
	}
	
}
