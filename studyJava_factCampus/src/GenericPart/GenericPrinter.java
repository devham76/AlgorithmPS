package GenericPart;

// 3d������, ���� �پ��ϴ�
// T -> ������ ����Ҷ� ��Ḧ �����ڶ�� �ǹ� , ������ ���ɶ� ��ᰡ ��������

// ��Ḧ �������� ���� extends Meterial�Ѵ�, ��ӹ��� �͸� ��밡��!!!!!
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
