package com.wealth.builder.vo;

import java.util.Date;

public class User {
	
	public static final String ENTITY_NAME_USER = "USER";
	
	//System generated
	private long userId;
	
	public static final String FIRST_NAME="FIRST_NAME";
	private String firstName;
	
	public static final String LAST_NAME="LAST_NAME";
	private String lastName;
	
	public static final String EMAIL_ID="EMAIL_ID";
	private String emaidId;
	
	public static final String MOBILE_NUMBER="MOBILE_NUMBER";
	private String mobileNumber;
	
	public static final String PASSWORD="PASSWORD";
	private String password;
	
	public static final String ACTIVE="ACTIVE";
	private boolean active;
	
	public static final String CREATED_DATE="CREATED_DATE";
	private Date createdDate;
	
	public static final String UPDATED_DATE="UPDATED_DATE";
	private Date updatedDate;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmaidId() {
		return emaidId;
	}
	public void setEmaidId(String emaidId) {
		this.emaidId = emaidId;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
