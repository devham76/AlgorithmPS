package org.study;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class test {

	public static void main(String[] args) {
		
		Date date = new Date("Sat Dec 01 00:00:00 GMT 2012"); 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
		// yyyy-MM-dd HH:mm:ss 
		String format = formatter.format(date);
		System.out.println(format);
//	    Date selectedDate = new Date(System.currentTimeMillis());
//        Date start, end;
//        Calendar calendar = Calendar.getInstance() ;
//        calendar.setTime(selectedDate);
//        
//        SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd" );
//        calendar.setTime(selectedDate);
//
//        System.out.println("utilDate : "+selectedDate);
//        java.util.Date utilDate = new java.util.Date();
//        java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
//        System.out.println("sqlDate:"+sqlDate);
//        
//			try {
//				Date day1 = format.parse( "2020-02-10" );
//				String day1s = format.format(day1);
//				String day2 = format.format(selectedDate);
//				int compare = day2.compareTo(day1s);
//				System.out.println(compare);
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//            
//			
//      SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd" );
//      //String date  =  format.format("Mon Feb 10 16:44:47 KST 2020");
//      try {
//		Date to = format.parse("Mon Feb 10 16:44:47 KST 2020");
//		System.out.println("to: ");
//	} catch (ParseException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//
//		Calendar calendar = Calendar.getInstance() ;
//	        //calendar.setTime();
//	        Date start = (Date) calendar.getTime();
//	        System.out.println(start);
               
//        // ���õ� ��¥�� ���ԵǾ��ִ� ��,�Ͽ��� ���ϱ�
//        // ���ó�¥�� �������̸� start�� ���ó�¥
//        int dayNum = calendar.get(Calendar.DAY_OF_WEEK);
//        if (dayNum == 2) {
//            start = selectedDate;
//            System.out.println("start : "+start);
//        }
//        // �ƴ϶�� ���ó�¥�� ���ԵǾ��ִ� ������ ����
//        else{
//            int gotoMonday = (dayNum==1) ? -7 :(2-dayNum);
//            calendar.add(Calendar.DATE, gotoMonday);
//            start = (Date) calendar.getTime();
//        }
//        // ���ᳯ¥�� = ���ó�¥ + 6 , �Ͽ��ϱ���
//        calendar.add(Calendar.DATE, 6);
//        end = (Date) calendar.getTime();
	}

}
