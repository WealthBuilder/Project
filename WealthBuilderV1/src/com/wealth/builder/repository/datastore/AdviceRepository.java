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

	private static Logger logger =  Logger.getLogger("AdviceRepository");
	
	@Override
	public long saveAdvice(Advice advice) throws Exception {
		
		logger.info("Entering saveAdvice - " + advice.getStatus());
		DatastoreService datastoreService = 
				DatastoreServiceFactory.getDatastoreService();
		
		Entity tipEntity = pupulateEntityFromTip(advice);

		datastoreService.put(tipEntity);
		
		logger.info("Saved advice to datastore " + tipEntity.getKey().getId());
		return tipEntity.getKey().getId();
		
	}

	@Override
	public Advice[] retrieveAllAdvices() throws Exception {
		
		logger.info("Entering retrieveAllAdvices");
		
		Query query =  new Query(Advice.ENTITY_NAME_ADVICE);
		
		DatastoreService datastoreService = 
				DatastoreServiceFactory.getDatastoreService();
		
		PreparedQuery preparedQuery = datastoreService.prepare(query);
		
		List<Advice> tipsList =  new ArrayList<>();
		
		for (Entity result : preparedQuery.asIterable()) {
			
			tipsList.add(populateTipFromEntity(result));
		}
		
		logger.info("Returning retrieveAllAdvices  - " + tipsList.size());
		return tipsList.toArray(new Advice[0]);
	}

	@Override
	public Advice[] retrieveAdvicesByStatus(String status) throws Exception {
		
		logger.info("Entering retrieveAdvicesByStatus - " + status);
		Filter statusFilter = new FilterPredicate(Advice.STATUS,FilterOperator.EQUAL,status);
		
		// Use class Query to assemble a query
		Query query = new Query(Advice.ENTITY_NAME_ADVICE).setFilter(statusFilter);
		
		DatastoreService datastoreService = 
				DatastoreServiceFactory.getDatastoreService();
		
		PreparedQuery preparedQuery = datastoreService.prepare(query);
		
		List<Advice> tipsList =  new ArrayList<>();
		
		for (Entity result : preparedQuery.asIterable()) {
			
			tipsList.add(populateTipFromEntity(result));
		}
		logger.info("Returning retrieveAdvicesByStatus  - " + tipsList.size());
		return tipsList.toArray(new Advice[0]);
	}


	@Override
	public Advice retrieveAdviceById(long tipId) throws Exception {
		
		logger.info("Entering retrieveAdviceById - " + tipId);
		Entity entity = new Entity(Advice.ENTITY_NAME_ADVICE,tipId);
		
		Key searchKey = entity.getKey();
		
		DatastoreService datastoreService = 
				DatastoreServiceFactory.getDatastoreService();
		
		entity = datastoreService.get(searchKey);
		
		Advice advice = populateTipFromEntity(entity);
		
		logger.info("Returning retrieveAdviceById - " + advice.getStockName());
		return advice;
	}
	
	private Advice populateTipFromEntity(Entity entity) throws ParseException	{
		
		Advice advice = new Advice();
		
		advice.setAdviceId(entity.getKey().getId());
		
		DBUtil dbUtil = new DBUtil(entity);
		
		advice.setStatus(dbUtil.getStringProperty(Advice.STATUS));
		advice.setAdvice(dbUtil.getStringProperty(Advice.ADVICE));
		advice.setCreatedDate(dbUtil.getDateProperty(Advice.CREATED_DATE));
		advice.setUpdatedDate(dbUtil.getDateProperty(Advice.UPDATED_DATE));
		advice.setRemark(dbUtil.getStringProperty(Advice.REMARK));
		advice.setProfile(dbUtil.getStringProperty(Advice.PROFILE));
		advice.setStockName(dbUtil.getStringProperty(Advice.STOCK_NAME));
		advice.setProfit(dbUtil.getStringProperty(Advice.PROFIT));
		
		return advice;
		
	}
	
	private Entity pupulateEntityFromTip(Advice advice) {
		
		Entity entity = null;
				
		if(advice.getAdviceId() == 0l)	{
			entity = new Entity(Advice.ENTITY_NAME_ADVICE);
		}else	{
			entity = new Entity(Advice.ENTITY_NAME_ADVICE,advice.getAdviceId());
		}
		
		entity.setProperty(Advice.STOCK_NAME, advice.getStockName());
		entity.setProperty(Advice.STATUS, advice.getStatus());
		entity.setProperty(Advice.ADVICE, advice.getAdvice());
		entity.setProperty(Advice.PROFIT, advice.getProfit());
		entity.setProperty(Advice.CREATED_DATE, advice.getCreatedDate());
		entity.setProperty(Advice.UPDATED_DATE, advice.getUpdatedDate());
		entity.setProperty(Advice.REMARK, advice.getRemark());
		entity.setProperty(Advice.PROFILE, advice.getProfile());
		
		return entity;
		
	}

	@Override
	public void deleteAdviceById(long adviceId) throws Exception {
		logger.info("Entering deleteAdviceById - " + adviceId);
		
		Entity entity = new Entity(Advice.ENTITY_NAME_ADVICE,adviceId);
		
		DatastoreService datastoreService = 
				DatastoreServiceFactory.getDatastoreService();
		
		datastoreService.delete(entity.getKey());
		
		logger.info("Returning deleteAdviceById");
	}

}
