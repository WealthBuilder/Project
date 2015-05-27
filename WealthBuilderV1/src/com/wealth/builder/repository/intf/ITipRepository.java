package com.wealth.builder.repository.intf;

import com.wealth.builder.vo.Tip;

public interface ITipRepository {
	
	long saveTip(Tip tip) throws Exception;
	
	Tip[] retrieveAllTips() throws Exception;
	
	Tip[] retrieveTipsByStatus(String status) throws Exception;
	
	void updateTip(Tip tip) throws Exception;
	
	Tip retrieveTipById(long tipId) throws Exception;

}
