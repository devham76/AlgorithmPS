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
//	 // 8. �Ϸ������� ������ ��¥�� ������ format���� String Ÿ�� ����
//
//	 //String y_date = formatter.format(cal.getTime());

	    
	    Date selectedDate = new Date(System.currentTimeMillis());
        Date start, end;
        Calendar calendar = Calendar.getInstance() ;
        calendar.setTime(selectedDate);

        // ���õ� ��¥�� ���ԵǾ��ִ� ��,�Ͽ��� ���ϱ�
        // ���ó�¥�� �������̸� start�� ���ó�¥
        int dayNum = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayNum == 2) {
            start = selectedDate;
        }
        // �ƴ϶�� ���ó�¥�� ���ԵǾ��ִ� ������ ����
        else{
            int gotoMonday = (dayNum==1) ? -7 :(2-dayNum);
            calendar.add(Calendar.DATE, gotoMonday);
            start = (Date) calendar.getTime();
        }
        // ���ᳯ¥�� = ���ó�¥ + 6 , �Ͽ��ϱ���
        calendar.add(Calendar.DATE, 6);
        end = (Date) calendar.getTime();
	}

}
