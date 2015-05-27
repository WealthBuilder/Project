package com.wealth.builder.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.wealth.builder.repository.datastore.TipRepository;
import com.wealth.builder.vo.Tip;

public class TipRespositoryTest {

	  private final static LocalServiceTestHelper helper =
		      new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
	  
	public static void main(String[] args) throws Exception {
		helper.setUp();
		
		TipRepository tipRepository = new TipRepository();
		
		Tip tip = new Tip();
		
		tip.setTip("BUT INFOSYS at 2300 Rs");
		
		Calendar today = Calendar.getInstance();
		
		today.setTimeZone(TimeZone.getTimeZone("IST"));
		
		System.out.println(today.getTime());
		tip.setCreatedDate(today.getTime());
		tip.setStatus("Running");
		tip.setUpdatedDate(today.getTime());
		
		tipRepository.saveTip(tip);
		
		tip.setStatus("Closed");
		
		tipRepository.saveTip(tip);
		
		tip = tipRepository.retrieveTipById(1);
		
		System.out.println(tipRepository.retrieveTipsByStatus("a").length);
		
		helper.tearDown();
		

	}

}
