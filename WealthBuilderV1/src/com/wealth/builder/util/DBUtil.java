package com.wealth.builder.util;

import java.text.ParseException;
import java.util.Date;

import com.google.appengine.api.datastore.Entity;

public class DBUtil {
	
	Entity entity = null;
	
	public DBUtil(Entity entity)	{
		this.entity = entity;
	}
	
	public String getStringProperty(String propertyName)	{
		
		if (this.entity == null || this.entity.getProperty(propertyName) == null)	{
			return null;
		}else	{
			return entity.getProperty(propertyName).toString();
		}
	}
	
	public boolean getBooleanProperty(String propertyName)	{
		
		if (this.entity == null || this.entity.getProperty(propertyName) == null)	{
			return false;
		}else	{
			return Boolean.getBoolean(entity.getProperty(propertyName).toString());
		}
	}
	
	public Date getDateProperty(String propertyName) throws ParseException	{
		
		if (this.entity== null || this.entity.getProperty(propertyName) == null)	{
			return null;
		}else	{
			return DateUtil.parse(this.entity.getProperty(propertyName).toString());
		}
	}

}
