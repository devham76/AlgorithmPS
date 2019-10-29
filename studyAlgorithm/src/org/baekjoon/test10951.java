package org.baekjoon;

class C3 {
	int v = 10;
	
	void m() {
		int v = 20;
		System.out.println(v);		// 지역변수가 우선순위를 갖는다.
		System.out.println(this.v); // this는 인스턴스 자신을 의미하며 함수 안에서 인스턴스 변수v를 사용할수 있게 되었다.
	}
}
public class test10951 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C3 c = new C3();
		c.m();
	}

}
