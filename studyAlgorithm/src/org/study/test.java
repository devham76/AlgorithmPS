package org.study;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class test {

	public static void main(String[] args) throws ParseException {
		
		Date date = new Date("Sun Feb 16 00:00:00 GMT 2020"); 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
		// yyyy-MM-dd HH:mm:ss 
		String format = formatter.format(date);
		System.out.println(format);


		//System.out.println("[findByRecordDateBetween start]--selectedDate="+selectedDate);
        Date start, end;
        Calendar calendar = Calendar.getInstance() ;
        calendar.setTime(date);

        // 선택된 날짜가 포함되어있는 월,일요일 구하기
        // 선택날짜가 월요일이면 start는 선택날짜
        int dayNum = calendar.get(Calendar.DAY_OF_WEEK);

        // 일요일이면 저번주 일요일로, 아니면 이번주 일요일로 이동
        int gotoMonday = (dayNum==1) ? -7 :(1-dayNum);
        System.out.println("해당 요일 :  "+dayNum+" , 월요일로 가려면 :"+gotoMonday);
        calendar.add(Calendar.DATE, gotoMonday);
        start = (Date) calendar.getTime();

        // 종료날짜는 = 선택날짜 + 7 , 일요일까지
        calendar.add(Calendar.DATE, 7);
        end = (Date) calendar.getTime();

        System.out.println("---------------start="+start);
        System.out.println("---------------end="+end);
        
        SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //String format2 = transFormat.format("2020-01-02");
        Date today = transFormat.parse("2020-2-2 00:00:00");
        System.out.println(today);
        calendar.setTime(today);
        int endYear = calendar.get(Calendar.YEAR);
        int endMonth = calendar.get(Calendar.MONTH)+1;
        int endDate  = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        String endString = endYear+"-"+endMonth+"-"+endDate+" 00:00:00";
        System.out.println(endYear+"-"+endMonth+"-"+endDate);
        Date endD = transFormat.parse(endString);
        System.out.println(endD);
    
        user u1 = new user("hyemi",27);
        
        ObjectMapper mapper = new ObjectMapper();
	}

}
class user{
	public user(String name, int age) {
		this.name = name;
		this.age = age;
	}
	String name;
	int age;
}
