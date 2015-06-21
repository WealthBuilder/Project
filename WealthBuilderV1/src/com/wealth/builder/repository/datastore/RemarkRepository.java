package com.wealth.builder.repository.datastore;

import java.util.logging.Logger;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.wealth.builder.repository.intf.IRemarkRepository;

public class RemarkRepository implements IRemarkRepository {

	private static String ENTITY_NAME_WEEKLY_REMARK = "WEEKLY_REMARK";
	
	private static String ENTITY_PROP_REMARK = "REMARK";
	
	private static Logger logger =  Logger.getLogger("RemarkRepository");
	
	@Override
	public String getWeeklyRemark() {
		
		logger.info("Entering getWeeklyRemark");
		
		Query query =  new Query(RemarkRepository.ENTITY_NAME_WEEKLY_REMARK);
		
		DatastoreService datastoreService = 
				DatastoreServiceFactory.getDatastoreService();
		
		PreparedQuery preparedQuery = datastoreService.prepare(query);
		
		String remark = null;
		
		for (Entity result : preparedQuery.asIterable()) {
			
			remark = (String) result.getProperty(ENTITY_PROP_REMARK);
		}
		
		logger.info("Exiting getWeeklyRemark - " + remark);
		
		return remark;
	}

}
