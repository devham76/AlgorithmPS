package InterfacePart_Bookshelf;

import java.util.ArrayList;

public class Shelf {

	// 자식만 사용가능하다
	protected ArrayList<String> shelf;
	
	// 생성자
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
