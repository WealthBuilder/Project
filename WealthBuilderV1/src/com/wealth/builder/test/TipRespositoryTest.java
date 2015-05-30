package com.wealth.builder.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.wealth.builder.repository.datastore.AdviceRepository;
import com.wealth.builder.vo.Advice;

public class TipRespositoryTest {

	  private final static LocalServiceTestHelper helper =
		      new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
	  
	public static void main(String[] args) throws Exception {
		helper.setUp();
		
		AdviceRepository adviceRepository = new AdviceRepository();
		
		Advice advice = new Advice();
		
		advice.setTip("BUT INFOSYS at 2300 Rs");
		
		Calendar today = Calendar.getInstance();
		
		today.setTimeZone(TimeZone.getTimeZone("IST"));
		
		System.out.println(today.getTime());
		advice.setCreatedDate(today.getTime());
		advice.setStatus("Running");
		advice.setUpdatedDate(today.getTime());
		
		adviceRepository.saveTip(advice);
		
		advice.setStatus("Closed");
		
		adviceRepository.saveTip(advice);
		
		advice = adviceRepository.retrieveTipById(1);
		
		System.out.println(adviceRepository.retrieveTipsByStatus("a").length);
		
		helper.tearDown();
		

	}

}
