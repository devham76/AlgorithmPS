package org.baekjoon;

class C3 {
	int v = 10;
	
	void m() {
		int v = 20;
		System.out.println(v);		// ���������� �켱������ ���´�.
		System.out.println(this.v); // this�� �ν��Ͻ� �ڽ��� �ǹ��ϸ� �Լ� �ȿ��� �ν��Ͻ� ����v�� ����Ҽ� �ְ� �Ǿ���.
	}
}
public class test10951 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C3 c = new C3();
		c.m();
	}

}
