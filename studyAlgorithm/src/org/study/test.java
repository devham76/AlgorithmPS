package org.study;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class test {

	public static void main(String[] args) {
		Date start = new Date();
		Calendar calendar = Calendar.getInstance() ;
        calendar.setTime(start);    // 시작일은 일요일이다
        calendar.add(Calendar.DATE, 1); // 시작일+1 => 월요일로 설정
        start = (Date) calendar.getTime();
        
        java.sql.Date sqlDate = new java.sql.Date(start.getTime());
        System.out.println(sqlDate);

        calendar.add(Calendar.DATE, 1);
        start = (Date) calendar.getTime();
        sqlDate = new java.sql.Date(start.getTime());
        System.out.println(sqlDate);
	}

}
