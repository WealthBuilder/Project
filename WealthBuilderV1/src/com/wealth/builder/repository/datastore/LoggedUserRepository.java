package com.wealth.builder.repository.datastore;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.CompositeFilterOperator;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.wealth.builder.repository.intf.ILoggedUserRepository;
import com.wealth.builder.vo.User;

public class LoggedUserRepository implements ILoggedUserRepository {

	private static String ENTITY_NAME_LOGGED_USERS = "LOGGED_USERS";
	
	private static String ENTITY_PROP_USER_ID = "USER_ID";
	
	private static String ENTITY_PROP_USER_NAME = "USER_NAME";
	
	private static String ENTITY_PROP_CREATED_DATE = "CREATED_DATE";
	
	private static String ENTITY_PROP_LOGGED_IN = "LOGGED_IN_FLAG";
	
	private static Logger logger =  Logger.getLogger("LoggedUserRepository");
	
	@Override
	public long logInUser(User user) {
		
		logger.info("logInUser - " + user.getUserId());
		
		DatastoreService datastoreService = 
				DatastoreServiceFactory.getDatastoreService(); 
		
		Entity entity = this.retrieveLoggedInUser(user.getUserId());
		
		if(entity == null) {
			entity = new Entity(ENTITY_NAME_LOGGED_USERS);
		}
		
		entity.setProperty(ENTITY_PROP_USER_ID, user.getUserId());
		entity.setProperty(ENTITY_PROP_USER_NAME, user.getFirstName());
		
		Date today = Calendar.getInstance().getTime();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMMM-YY");
		
		entity.setProperty(ENTITY_PROP_CREATED_DATE, simpleDateFormat.format(today));
		entity.setProperty(ENTITY_PROP_LOGGED_IN, "Y");
		
		Key key = datastoreService.put(entity);
		
		logger.info("Saved logged user to datastore " + key.getId());
		return key.getId();
	}

	@Override
	public Entity retrieveLoggedInUser(long userID) {
		
		logger.info("retrieveLoggedInUser - " + userID);
		
		Filter idFilter = new FilterPredicate(ENTITY_PROP_USER_ID,FilterOperator.EQUAL,userID);

		Date today = Calendar.getInstance().getTime();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMMM-YY");
		
		Filter dateFilter =
		  new FilterPredicate(ENTITY_PROP_CREATED_DATE,
		                      FilterOperator.EQUAL,
		                      simpleDateFormat.format(today));

		//Use CompositeFilter to combine multiple filters
		Filter idAndDateFilter =
		  CompositeFilterOperator.and(idFilter, dateFilter);
				
		// Use class Query to assemble a query
		Query query = new Query(ENTITY_NAME_LOGGED_USERS).setFilter(idAndDateFilter);
		
		DatastoreService datastoreService = 
				DatastoreServiceFactory.getDatastoreService();
		
		
		PreparedQuery preparedQuery = datastoreService.prepare(query);
		
		if(preparedQuery.asIterable().iterator().hasNext()){
			return preparedQuery.asIterable().iterator().next();
		}
		
		logger.info("retrieveLoggedInUser - " + null);
		
		return null;
	}
	
	@Override
	public List<Entity> retrieveTodayLoggedInUser() {
		
		logger.info("retrieveTodayLoggedInUser");
		

		Date today = Calendar.getInstance().getTime();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMMM-YY");
		
		Filter dateFilter =
		  new FilterPredicate(ENTITY_PROP_CREATED_DATE,
		                      FilterOperator.EQUAL,
		                      simpleDateFormat.format(today));

		// Use class Query to assemble a query
		Query query = new Query(ENTITY_NAME_LOGGED_USERS).setFilter(dateFilter);
		
		DatastoreService datastoreService = 
				DatastoreServiceFactory.getDatastoreService();
		
		
		PreparedQuery preparedQuery = datastoreService.prepare(query);
		
		List<Entity> entityList = new ArrayList<Entity>();
		
		while(preparedQuery.asIterable().iterator().hasNext()){
			entityList.add(preparedQuery.asIterable().iterator().next());
		}
		
		logger.info("retrieveTodayLoggedInUser - " + entityList.size());
		
		return entityList;

	}
	

	@Override
	public void logOutUser(User user) {
		
		logger.info("logOutUser - " + user.getUserId());
		
		DatastoreService datastoreService = 
				DatastoreServiceFactory.getDatastoreService(); 
		
		Entity entity = this.retrieveLoggedInUser(user.getUserId());
		
		if(entity == null) {
			entity = new Entity(ENTITY_NAME_LOGGED_USERS);
		}
		
		entity.setProperty(ENTITY_PROP_LOGGED_IN, "N");
		
		datastoreService.put(entity);
		
		logger.info("logged out user " + user.getFirstName());
		
	}

}
