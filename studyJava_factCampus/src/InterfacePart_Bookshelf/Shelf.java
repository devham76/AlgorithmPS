package InterfacePart_Bookshelf;

import java.util.ArrayList;

public class Shelf {

	// �ڽĸ� ��밡���ϴ�
	protected ArrayList<String> shelf;
	
	// ������
	public Shelf() {
		shelf = new ArrayList<String>();
	}
	
	public ArrayList<String> getshelf(){
		return shelf;
	}
	
	public int getCount() {
		return shelf.size();
	}
}
