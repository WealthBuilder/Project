package com.wealth.builder.repository.intf;

import java.util.Date;
import java.util.List;

import com.wealth.builder.vo.User;

public interface IUserRepository {
	
	long saveUser(User user) throws Exception;
	
	User retrieveUserByEmailId(String emailId) throws Exception; 
	
	User[] retrieveAllUsers() throws Exception; 
	
	List<User> retrieveUsersCreatedAfter(Date createdDate) throws Exception;
	
}
