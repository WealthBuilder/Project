package com.wealth.builder.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import com.wealth.builder.constants.WealthConstants;
import com.wealth.builder.repository.datastore.AdviceRepository;
import com.wealth.builder.repository.intf.IAdviceRepository;
import com.wealth.builder.vo.Advice;

public class AdviceService {
	
	private static Logger logger =  Logger.getLogger("AdviceService");
	
	public Advice[] getAdvicesForUser() throws Exception	{
		
		logger.info("Entering getAdvicesForUser");
		
		IAdviceRepository adviceRepository = new AdviceRepository();
		
		List<Advice> adviceList = new ArrayList<Advice>();
		
		Advice [] retrivedArray =  adviceRepository.retrieveAdvicesByStatus(
				WealthConstants.ADVICE_STATUS_NEW);
		
		Arrays.sort(retrivedArray);
		
		adviceList.addAll(Arrays.asList(retrivedArray));
		
		logger.info("Advice with status - " + WealthConstants.ADVICE_STATUS_NEW  
				+ " - " + adviceList.size());
		
		retrivedArray =  adviceRepository.retrieveAdvicesByStatus(
							WealthConstants.ADVICE_STATUS_RUNNING);
		
		Arrays.sort(retrivedArray);
		
		adviceList.addAll(Arrays.asList(retrivedArray));
		
		logger.info("Advice with status - " + WealthConstants.ADVICE_STATUS_RUNNING  
				+ " - " + adviceList.size());
	
		retrivedArray =  adviceRepository.retrieveAdvicesByStatus(
						WealthConstants.ADVICE_STATUS_CLOSED);
		
		Arrays.sort(retrivedArray);
		
		adviceList.addAll(Arrays.asList(retrivedArray));
		
		logger.info("Advice with status - " + WealthConstants.ADVICE_STATUS_RUNNING  
				+ " - " + adviceList.size());
		
		return adviceList.toArray(new Advice[0]);
		
	}

}

