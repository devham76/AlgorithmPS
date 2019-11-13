package org.programmers;

public class wintercoding_2019_fineRectangle {

	public static void main(String[] args) {
		solution(8, 12);
	}
	public static long solution(int w,int h) {

		// y = h/w x
		getRectangle(w, h,  1);
		System.out.println(waste);
		long answer = w*h - waste;
		return answer;
	}
	static long waste =0;
	public static void getRectangle(double w, double h,  int nowX) {
		
		if (nowX == w+1)
			return;
		
		double prev = h/w * (nowX-1);
		double now = h/w * nowX;

		waste = waste + (int) ( Math.ceil(now) - Math.floor(prev));

		
		//System.out.println("현재값 : "+(h / w * nowX) +", 이전값의 올림: "+ prev+" , answer: "+answer);
		
		getRectangle(w, h, nowX+1);
		
	}
}
