package com.wealth.builder.repository.intf;

import com.wealth.builder.vo.Advice;

public interface IAdviceRepository {
	
	long saveTip(Advice advice) throws Exception;
	
	Advice[] retrieveAllTips() throws Exception;
	
	Advice[] retrieveTipsByStatus(String status) throws Exception;
	
	void updateTip(Advice advice) throws Exception;
	
	Advice retrieveTipById(long tipId) throws Exception;

}
