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
import com.wealth.builder.repository.intf.ITipRepository;
import com.wealth.builder.util.DBUtil;
import com.wealth.builder.vo.Tip;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Query.FilterOperator;

public class TipRepository implements ITipRepository {

	private static Logger logger =  Logger.getLogger("TipRepository");
	
	@Override
	public long saveTip(Tip tip) throws Exception {
		
		logger.entering("saveTip", tip.getTip());
		DatastoreService datastoreService = 
				DatastoreServiceFactory.getDatastoreService();
		
		Entity tipEntity = pupulateEntityFromTip(tip);

		datastoreService.put(tipEntity);
		
		logger.info("Saved tip to datastore " + tipEntity.getKey().getId());
		return tipEntity.getKey().getId();
		
	}

	@Override
	public Tip[] retrieveAllTips() throws Exception {
		
		Query query =  new Query(Tip.ENTITY_NAME_TIP);
		
		DatastoreService datastoreService = 
				DatastoreServiceFactory.getDatastoreService();
		
		PreparedQuery preparedQuery = datastoreService.prepare(query);
		
		List<Tip> tipsList =  new ArrayList<>();
		
		for (Entity result : preparedQuery.asIterable()) {
			
			tipsList.add(populateTipFromEntity(result));
		}
		
		return tipsList.toArray(new Tip[0]);
	}

	@Override
	public Tip[] retrieveTipsByStatus(String status) throws Exception {
		
		Filter statusFilter = new FilterPredicate(Tip.STATUS,FilterOperator.EQUAL,status);
		
		// Use class Query to assemble a query
		Query query = new Query(Tip.ENTITY_NAME_TIP).setFilter(statusFilter);
		
		DatastoreService datastoreService = 
				DatastoreServiceFactory.getDatastoreService();
		
		PreparedQuery preparedQuery = datastoreService.prepare(query);
		
		List<Tip> tipsList =  new ArrayList<>();
		
		for (Entity result : preparedQuery.asIterable()) {
			
			tipsList.add(populateTipFromEntity(result));
		}
		
		return tipsList.toArray(new Tip[0]);
	}

	@Override
	public void updateTip(Tip tip) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Tip retrieveTipById(long tipId) throws Exception {
		
		
		Entity entity = new Entity(Tip.ENTITY_NAME_TIP,tipId);
		
		Key searchKey = entity.getKey();
		
		DatastoreService datastoreService = 
				DatastoreServiceFactory.getDatastoreService();
		
		entity = datastoreService.get(searchKey);
		
		Tip tip = populateTipFromEntity(entity);
		
		return tip;
	}
	
	private Tip populateTipFromEntity(Entity entity) throws ParseException	{
		
		Tip tip = new Tip();
		
		tip.setTipId(entity.getKey().getId());
		
		DBUtil dbUtil = new DBUtil(entity);
		
		tip.setStatus(dbUtil.getStringProperty(Tip.STATUS));
		tip.setTip(dbUtil.getStringProperty(Tip.TIP));
		
		tip.setCreatedDate(dbUtil.getDateProperty(Tip.CREATED_DATE));
		
		tip.setUpdatedDate(dbUtil.getDateProperty(Tip.UPDATED_DATE));
		
		tip.setNewlyAddedLine(dbUtil.getStringProperty(Tip.TIP_NEW_LINE));
		tip.setNewLineAddedDate(dbUtil.getDateProperty(Tip.NEW_LINE_ADDED_DATE));
		
		tip.setProfile(dbUtil.getStringProperty(Tip.PROFILE));
		
		return tip;
		
	}
	
	private Entity pupulateEntityFromTip(Tip tip) {
		
		Entity entity = new Entity(Tip.ENTITY_NAME_TIP);
		
		entity.setProperty(Tip.STATUS, tip.getStatus());
		entity.setProperty(Tip.TIP, tip.getTip());
		entity.setProperty(Tip.CREATED_DATE, tip.getCreatedDate());
		entity.setProperty(Tip.TIP_NEW_LINE, tip.getNewlyAddedLine());
		entity.setProperty(Tip.NEW_LINE_ADDED_DATE, tip.getNewLineAddedDate());
		entity.setProperty(Tip.UPDATED_DATE, tip.getUpdatedDate());
		entity.setProperty(Tip.PROFILE, tip.getProfile());
		
		return entity;
		
	}

}
