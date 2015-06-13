package com.wealth.builder.standalone;

import java.util.Calendar;
import java.util.Date;


public class SendMailStandalone {

	public static void main(String[] args) {
		
		Calendar todayCalendar =  Calendar.getInstance();
		
		todayCalendar.set(Calendar.HOUR, 23);
		todayCalendar.set(Calendar.MINUTE, 59);
		todayCalendar.set(Calendar.SECOND, 59);
		
		todayCalendar.add(Calendar.DATE, -2);
		Date today = todayCalendar.getTime();
		
		System.out.println(today.toString());

	}

}
