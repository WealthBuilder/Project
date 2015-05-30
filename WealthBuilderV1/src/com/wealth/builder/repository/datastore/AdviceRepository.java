package com.wealth.builder.repository.datastore;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.wealth.builder.repository.intf.IAdviceRepository;
import com.wealth.builder.util.DBUtil;
import com.wealth.builder.vo.Advice;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Query.FilterOperator;

public class AdviceRepository implements IAdviceRepository {

	private static Logger logger =  Logger.getLogger("TipRepository");
	
	@Override
	public long saveTip(Advice advice) throws Exception {
		
		logger.entering("saveTip", advice.getTip());
		DatastoreService datastoreService = 
				DatastoreServiceFactory.getDatastoreService();
		
		Entity tipEntity = pupulateEntityFromTip(advice);

		datastoreService.put(tipEntity);
		
		logger.info("Saved tip to datastore " + tipEntity.getKey().getId());
		return tipEntity.getKey().getId();
		
	}

	@Override
	public Advice[] retrieveAllTips() throws Exception {
		
		Query query =  new Query(Advice.ENTITY_NAME_TIP);
		
		DatastoreService datastoreService = 
				DatastoreServiceFactory.getDatastoreService();
		
		PreparedQuery preparedQuery = datastoreService.prepare(query);
		
		List<Advice> tipsList =  new ArrayList<>();
		
		for (Entity result : preparedQuery.asIterable()) {
			
			tipsList.add(populateTipFromEntity(result));
		}
		
		return tipsList.toArray(new Advice[0]);
	}

	@Override
	public Advice[] retrieveTipsByStatus(String status) throws Exception {
		
		Filter statusFilter = new FilterPredicate(Advice.STATUS,FilterOperator.EQUAL,status);
		
		// Use class Query to assemble a query
		Query query = new Query(Advice.ENTITY_NAME_TIP).setFilter(statusFilter);
		
		DatastoreService datastoreService = 
				DatastoreServiceFactory.getDatastoreService();
		
		PreparedQuery preparedQuery = datastoreService.prepare(query);
		
		List<Advice> tipsList =  new ArrayList<>();
		
		for (Entity result : preparedQuery.asIterable()) {
			
			tipsList.add(populateTipFromEntity(result));
		}
		
		return tipsList.toArray(new Advice[0]);
	}

	@Override
	public void updateTip(Advice advice) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Advice retrieveTipById(long tipId) throws Exception {
		
		
		Entity entity = new Entity(Advice.ENTITY_NAME_TIP,tipId);
		
		Key searchKey = entity.getKey();
		
		DatastoreService datastoreService = 
				DatastoreServiceFactory.getDatastoreService();
		
		entity = datastoreService.get(searchKey);
		
		Advice advice = populateTipFromEntity(entity);
		
		return advice;
	}
	
	private Advice populateTipFromEntity(Entity entity) throws ParseException	{
		
		Advice advice = new Advice();
		
		advice.setTipId(entity.getKey().getId());
		
		DBUtil dbUtil = new DBUtil(entity);
		
		advice.setStatus(dbUtil.getStringProperty(Advice.STATUS));
		advice.setTip(dbUtil.getStringProperty(Advice.TIP));
		
		advice.setCreatedDate(dbUtil.getDateProperty(Advice.CREATED_DATE));
		
		advice.setUpdatedDate(dbUtil.getDateProperty(Advice.UPDATED_DATE));
		
		advice.setNewlyAddedLine(dbUtil.getStringProperty(Advice.TIP_NEW_LINE));
		advice.setNewLineAddedDate(dbUtil.getDateProperty(Advice.NEW_LINE_ADDED_DATE));
		
		advice.setProfile(dbUtil.getStringProperty(Advice.PROFILE));
		
		return advice;
		
	}
	
	private Entity pupulateEntityFromTip(Advice advice) {
		
		Entity entity = new Entity(Advice.ENTITY_NAME_TIP);
		
		entity.setProperty(Advice.STATUS, advice.getStatus());
		entity.setProperty(Advice.TIP, advice.getTip());
		entity.setProperty(Advice.CREATED_DATE, advice.getCreatedDate());
		entity.setProperty(Advice.TIP_NEW_LINE, advice.getNewlyAddedLine());
		entity.setProperty(Advice.NEW_LINE_ADDED_DATE, advice.getNewLineAddedDate());
		entity.setProperty(Advice.UPDATED_DATE, advice.getUpdatedDate());
		entity.setProperty(Advice.PROFILE, advice.getProfile());
		
		return entity;
		
	}

}
