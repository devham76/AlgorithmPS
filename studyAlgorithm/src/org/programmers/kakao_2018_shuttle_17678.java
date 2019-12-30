package org.programmers;

/*
 * 1. 어려웠던점
 * 예제 2번을 이해하는데 어려웠다
 * simpledateformat, calender 클래스를 처음 써봐서 헷갈렸다
 * 
 * */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class kakao_2018_shuttle_17678 {

	public static void main(String[] args) {
		kakao_2018_shuttle_17678 t = new kakao_2018_shuttle_17678();
		String[] timetable = {"08:00", "08:01", "08:03", "08:02"};
		t.solution(1, 1, 5, timetable);
		String[] titmeable2 = {"09:10", "09:09", "08:00"};
		t.solution(2, 10, 2, titmeable2);
		String[] t3= {"23:59","23:59"};
		t.solution(10, 60, 45, t3);
		String[] t4 = {"23:59"};
		t.solution(1, 1, 1, t4);

	}


	  public String solution(int n, int t, int m, String[] timetable) {
	      String answer = "";
	      // 크루들이 온 시간순으로 정리
	      Arrays.sort(timetable);
	      
	      int nowHour = 9, nowMin = 0;
	      int lastIn = 0, idx = 0;
	      String stringH="09" ,stringM="00" ;
	      while (n > 0) {
	    	  stringH = nowHour<10 ? "0"+nowHour : ""+nowHour;	
	    	  stringM= nowMin < 10 ? "0"+nowMin : ""+nowMin;  
	    	  
	    	  // 셔틀버스의 최대 탑승객수까지만 태운다
	    	  for (int i=0; i<m; i++) {
	    		  
	    		  // 당일 탑승할 모든 크루가 탑승했으면 끝난다 
	    		  if(idx >= timetable.length)
	    			  break;
	    		  
	    		  // 현재 시각 셔틀버스 이전에 온 크루인지 검사
	    		  if( (stringH+":"+stringM).compareTo(timetable[idx]) >= 0) {
	    			  idx++;
	    			  
	    			  // 마지막에 탄 크루 수를 계산한다
	    			  if(n==1) lastIn++;
	    		  }
	    	  }
	    	  
	    	  // 다음 셔틀버스 오는 시간
	    	  --n;
	    	  nowMin += t;
	    	  if (nowMin >= 60) {
	    		  nowHour += 1;
	    		  nowMin -= 60;
	    	  }

	      }
	      
	      // 마지막 셔틀에 탑승한 크루 수가 최대보다 작으면 빈자리가 있으므로 마지막에 온다
	      if (lastIn < m)
	    	  answer = stringH+":"+stringM;
	      // 마지막 셔틀에 빈자리가 없으면 마지막 크루보다 1분 일찍온다
	      else {
	    	  SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm");
	    	  Calendar cal = Calendar.getInstance();
	    	  try {
				cal.setTime(dateformat.parse(timetable[idx-1]));
				cal.add(Calendar.MINUTE, -1);
				answer = dateformat.format(cal.getTime());
	    	  } catch (ParseException e) {
				e.printStackTrace();
	    	  } 
	      }
	    	  
	      return answer;
	  }
}
