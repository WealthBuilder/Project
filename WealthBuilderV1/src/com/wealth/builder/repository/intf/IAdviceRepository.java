package com.wealth.builder.repository.intf;

import com.wealth.builder.vo.Advice;

public interface IAdviceRepository {
	
	long saveAdvice(Advice advice) throws Exception;
	
	Advice[] retrieveAllAdvices() throws Exception;
	
	Advice[] retrieveAdvicesByStatus(String status) throws Exception;
	
	Advice retrieveAdviceById(long tipId) throws Exception;
	
	void deleteAdviceById(long adviceId) throws Exception;
	
}
