package com.wealth.builder.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static Date parse(String dateString) throws ParseException{
		
		SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
		
		return formatter.parse(dateString);
		
	}

}
