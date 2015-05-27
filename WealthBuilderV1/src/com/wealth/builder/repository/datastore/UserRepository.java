package com.wealth.builder.repository.datastore;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.wealth.builder.repository.intf.IUserRepository;
import com.wealth.builder.util.DBUtil;
import com.wealth.builder.vo.User;

public class UserRepository implements IUserRepository {

	private static Logger logger =  Logger.getLogger("UserRepository");
	
	@Override
	public long saveUser(User user) throws Exception {
		
		logger.info("Entering saveUser ");
		
		DatastoreService datastoreService = 
				DatastoreServiceFactory.getDatastoreService();
		
		Entity userEntity = this.populateEntityFromUser(user);
		
		datastoreService.put(userEntity);
		
		logger.info("Returning saveUser - " + userEntity.getKey().getId());
		return userEntity.getKey().getId();
	}

	@Override
	public User retrieveUserByEmailId(String emailId) throws Exception {
		logger.info("Entering retrieveUserByEmailId - " + emailId);
		
		Filter emailFilter = new FilterPredicate(User.EMAIL_ID,FilterOperator.EQUAL,emailId);
		
		Query query =  new Query(User.ENTITY_NAME_USER).setFilter(emailFilter);
		
		DatastoreService datastoreService = 
				DatastoreServiceFactory.getDatastoreService();
		
		PreparedQuery preparedQuery = datastoreService.prepare(query);
		
		List<User> usersList =  new ArrayList<>();
		
		for (Entity result : preparedQuery.asIterable()) {
			
			usersList.add(this.populateUserFromEntity(result));
		}
		
		if(usersList.size() == 0){
			logger.info("Returning retrieveUserByEmailId - " + null);
			return null;
		}else	{
			
			logger.info("Returning retrieveUserByEmailId - " + usersList.get(0).getFirstName());
			return usersList.get(0);
		}
		
	}

	@Override
	public User[] retrieveAllUsers() throws Exception {
		
		logger.info("Entering retrieveAllUsers ");
		
		Query query =  new Query(User.ENTITY_NAME_USER);
		
		DatastoreService datastoreService = 
				DatastoreServiceFactory.getDatastoreService();
		
		PreparedQuery preparedQuery = datastoreService.prepare(query);
		
		List<User> usersList =  new ArrayList<>();
		
		for (Entity result : preparedQuery.asIterable()) {
			
			usersList.add(this.populateUserFromEntity(result));
		}
		
		logger.info("Returning retrieveAllUsers - " + usersList.size());
		return usersList.toArray(new User[0]);
	}
	
	private Entity populateEntityFromUser(User user)	{
		
		Entity entity =  new Entity(User.ENTITY_NAME_USER);
		
		entity.setProperty(User.FIRST_NAME, user.getFirstName());
		entity.setProperty(User.LAST_NAME, user.getLastName());
		entity.setProperty(User.EMAIL_ID, user.getEmaidId());
		entity.setProperty(User.MOBILE_NUMBER, user.getMobileNumber());
		entity.setProperty(User.ACTIVE, user.isActive());
		entity.setProperty(User.PASSWORD, user.getPassword());
		entity.setProperty(User.CREATED_DATE, user.getCreatedDate());
		entity.setProperty(User.UPDATED_DATE, user.getUpdatedDate());
		
		return entity;
	}
	
	private User populateUserFromEntity(Entity entity) throws ParseException {
		
		User user = new User();
		
		DBUtil dbUtil = new DBUtil(entity);
		user.setFirstName(dbUtil.getStringProperty(User.FIRST_NAME));
		user.setLastName(dbUtil.getStringProperty(User.LAST_NAME));
		user.setEmaidId(dbUtil.getStringProperty(User.EMAIL_ID));
		user.setMobileNumber(dbUtil.getStringProperty(User.MOBILE_NUMBER));
		user.setActive(dbUtil.getBooleanProperty(User.ACTIVE));
		user.setPassword(dbUtil.getStringProperty(User.PASSWORD));
		user.setCreatedDate(dbUtil.getDateProperty(User.CREATED_DATE));
		user.setUpdatedDate(dbUtil.getDateProperty(User.UPDATED_DATE));
		
		return user;
		
	}

}
