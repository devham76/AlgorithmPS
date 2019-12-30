package org.programmers;

/*
 * 1. ���������
 * ���� 2���� �����ϴµ� �������
 * simpledateformat, calender Ŭ������ ó�� ����� �򰥷ȴ�
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
	      // ũ����� �� �ð������� ����
	      Arrays.sort(timetable);
	      
	      int nowHour = 9, nowMin = 0;
	      int lastIn = 0, idx = 0;
	      String stringH="09" ,stringM="00" ;
	      while (n > 0) {
	    	  stringH = nowHour<10 ? "0"+nowHour : ""+nowHour;	
	    	  stringM= nowMin < 10 ? "0"+nowMin : ""+nowMin;  
	    	  
	    	  // ��Ʋ������ �ִ� ž�°��������� �¿��
	    	  for (int i=0; i<m; i++) {
	    		  
	    		  // ���� ž���� ��� ũ�簡 ž�������� ������ 
	    		  if(idx >= timetable.length)
	    			  break;
	    		  
	    		  // ���� �ð� ��Ʋ���� ������ �� ũ������ �˻�
	    		  if( (stringH+":"+stringM).compareTo(timetable[idx]) >= 0) {
	    			  idx++;
	    			  
	    			  // �������� ź ũ�� ���� ����Ѵ�
	    			  if(n==1) lastIn++;
	    		  }
	    	  }
	    	  
	    	  // ���� ��Ʋ���� ���� �ð�
	    	  --n;
	    	  nowMin += t;
	    	  if (nowMin >= 60) {
	    		  nowHour += 1;
	    		  nowMin -= 60;
	    	  }

	      }
	      
	      // ������ ��Ʋ�� ž���� ũ�� ���� �ִ뺸�� ������ ���ڸ��� �����Ƿ� �������� �´�
	      if (lastIn < m)
	    	  answer = stringH+":"+stringM;
	      // ������ ��Ʋ�� ���ڸ��� ������ ������ ũ�纸�� 1�� ����´�
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
