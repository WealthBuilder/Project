package com.wealth.builder.web.session;

import java.util.logging.Logger;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.wealth.builder.repository.datastore.LoggedUserRepository;
import com.wealth.builder.repository.intf.ILoggedUserRepository;
import com.wealth.builder.vo.User;

public class UserSessionListener implements  HttpSessionAttributeListener {

	private static Logger logger =  Logger.getLogger("UserSessionListener");
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		logger.info("Entering attributeRemoved");
		
		ILoggedUserRepository repository = new LoggedUserRepository();
		
		if ( event.getValue() instanceof User) 	{
			User user = (User) event.getValue(); 
			
			repository.logOutUser(user);
		}
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
