package org.study;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class test {

	public static void main(String[] args) {
		
//		Date date = new Date(System.currentTimeMillis());
//		System.out.println(date.toString());
//		
//	    Calendar cal = Calendar.getInstance() ;
//	    cal.setTime(date);
//	     
//	    int dayNum = cal.get(Calendar.DAY_OF_WEEK) ;
//	    System.out.println(dayNum);
//	    
//	   
//	    int gotoMonday = dayNum==1 ? -7 :(2-dayNum);
//	    cal.add(Calendar.DATE, gotoMonday);
//	    System.out.println("->"+cal.getTime());
//	 // 8. 하루전으로 설정된 날짜를 설정된 format으로 String 타입 변경
//
//	 //String y_date = formatter.format(cal.getTime());

	    
	    Date selectedDate = new Date(System.currentTimeMillis());
        Date start, end;
        Calendar calendar = Calendar.getInstance() ;
        calendar.setTime(selectedDate);

        // 선택된 날짜가 포함되어있는 월,일요일 구하기
        // 선택날짜가 월요일이면 start는 선택날짜
        int dayNum = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayNum == 2) {
            start = selectedDate;
        }
        // 아니라면 선택날짜가 포함되어있는 월요일 선택
        else{
            int gotoMonday = (dayNum==1) ? -7 :(2-dayNum);
            calendar.add(Calendar.DATE, gotoMonday);
            start = (Date) calendar.getTime();
        }
        // 종료날짜는 = 선택날짜 + 6 , 일요일까지
        calendar.add(Calendar.DATE, 6);
        end = (Date) calendar.getTime();
	}

}
