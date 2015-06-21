package com.wealth.builder.service;

import com.wealth.builder.repository.intf.IRemarkRepository;

public class RemarkService {
	
	private IRemarkRepository remarkRepository = null;
			
	public RemarkService(IRemarkRepository rr){
		this.remarkRepository = rr;
	}
	
	public String getWeeklyRemark(){
		
		return this.remarkRepository.getWeeklyRemark();
	}

}
