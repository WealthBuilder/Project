package com.wealth.builder.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DisplayUtil {
	
	public static String getDisplayableDate(Date date)	{
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMMM");
		
		return simpleDateFormat.format(date);
	}
	
	public static String getDisplayableString(String value){
		
		if (value == null || "null".equalsIgnoreCase(value)){
			return "";
		}
		return value;
	}

}
