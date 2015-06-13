package com.wealth.builder.repository.intf;

import java.util.List;

import com.google.appengine.api.datastore.Entity;
import com.wealth.builder.vo.User;

public interface ILoggedUserRepository { 
	
	long logInUser(User user);

	Entity retrieveLoggedInUser(long userId);
	
	void logOutUser(User user);

	List<Entity> retrieveTodayLoggedInUser();

}
