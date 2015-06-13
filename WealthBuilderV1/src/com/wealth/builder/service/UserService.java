package com.wealth.builder.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import com.wealth.builder.repository.intf.ILoggedUserRepository;
import com.wealth.builder.repository.intf.IUserRepository;
import com.wealth.builder.vo.User;

public class UserService {
	
	private static final Logger logger =  Logger.getLogger("UserService");
	
	IUserRepository userRepository;
	
	ILoggedUserRepository loggedUserRepository;
	
	public UserService(IUserRepository ur , ILoggedUserRepository lr)	{
		this.userRepository = ur;
		this.loggedUserRepository = lr;
	}
	
	public int getCountAllUsers() throws Exception	{
		
		return this.userRepository.retrieveAllUsers().length;
	}
	
	public int getCountUsersRegisteredToday() throws Exception	{
		
		logger.info("Entering getCountUsersRegisteredToday");
		
		Calendar todayCalendar =  Calendar.getInstance();
		
		todayCalendar.set(Calendar.HOUR, 23);
		todayCalendar.set(Calendar.MINUTE, 59);
		todayCalendar.set(Calendar.SECOND, 59);
		
		todayCalendar.add(Calendar.DATE, -2);
		
		Date today = todayCalendar.getTime();
		
		List<User> userList = this.userRepository.retrieveUsersCreatedAfter(today);
		
		logger.info("Returning getCountUsersRegisteredToday - " + userList.size());
		
		return userList.size();
	}
	
	public int getCountUsersRegisteredLastWeek() throws Exception	{
		
		logger.info("Entering getCountUsersRegisteredLastWeek");
		
		Calendar todayCalendar =  Calendar.getInstance();
		
		todayCalendar.set(Calendar.DAY_OF_WEEK, 01);
		
		todayCalendar.set(Calendar.HOUR, 23);
		todayCalendar.set(Calendar.MINUTE, 59);
		todayCalendar.set(Calendar.SECOND, 59);
		
		todayCalendar.add(Calendar.DATE, -1);
		Date today = todayCalendar.getTime();
		
		List<User> userList = this.userRepository.retrieveUsersCreatedAfter(today);
		
		logger.info("Returning getCountUsersRegisteredLastWeek - " + userList.size());
		
		return userList.size();
	}
	
	public int getCountUsersRegisteredInMonth() throws Exception	{
		
		logger.info("Entering getCountUsersRegisteredInMonth");
		
		Calendar todayCalendar =  Calendar.getInstance();
		
		todayCalendar.set(Calendar.DAY_OF_MONTH, 00);
		
		todayCalendar.set(Calendar.HOUR, 00);
		todayCalendar.set(Calendar.MINUTE, 00);
		todayCalendar.set(Calendar.SECOND, 00);
		
		todayCalendar.add(Calendar.DATE, -1);
		
		Date today = todayCalendar.getTime();
		
		List<User> userList = this.userRepository.retrieveUsersCreatedAfter(today);
		
		logger.info("Returning getCountUsersRegisteredInMonth - " + userList.size());
		
		return userList.size();
	}
	
	public int getCountTodayLoggedInUser() throws Exception	{
		
		return this.loggedUserRepository.retrieveTodayLoggedInUser().size();

	}

}
