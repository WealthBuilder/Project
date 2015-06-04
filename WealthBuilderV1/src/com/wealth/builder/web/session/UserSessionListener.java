package com.wealth.builder.web.session;

import java.util.logging.Logger;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.wealth.builder.repository.datastore.LoggedUserRepository;
import com.wealth.builder.repository.intf.ILoggedUserRepository;
import com.wealth.builder.vo.User;

public class UserSessionListener implements HttpSessionListener {

	private static Logger logger =  Logger.getLogger("UserSessionListener");
	
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub

	} 

	@Override
	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		
		logger.info("Entering sessionDestroyed");
		
		ILoggedUserRepository repository = new LoggedUserRepository();
		
		User user = (User) sessionEvent.getSession().getAttribute("USER"); 
		
		repository.logOutUser(user);

	}

}
