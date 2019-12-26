package org.programmers;

public class test12901_2016year {

	public static void main(String[] args) {
		test12901_2016year s = new test12901_2016year();
		System.out.println(s.solution(5,24));		

	}
	  public String solution(int a, int b) {
	      String answer = "";
	      int[] dayArr = {0,31,29,31,30,31,30,31,31,30,31,30,31};
	      int days = b;
	      int week;
	      for (int i=0; i<a; i++) {
	    	  days += dayArr[i];
	      }
	      week = days % 7;
	      
	      switch (week) {
	      case 4: answer = "MON"; break;
	      case 5: answer = "TUE"; break;
	      case 6: answer = "WED"; break;
	      case 0: answer = "THU"; break;
	      case 1: answer = "FRI"; break;
	      case 2: answer = "SAT"; break;
	      case 3: answer = "SUN"; break;
	      }
	      
	      return answer;
	  }

}
