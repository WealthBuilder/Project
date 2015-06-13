package com.wealth.builder.vo;

import java.io.Serializable;
import java.util.Date;


public class Advice implements Serializable , Comparable<Advice> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4346249815100462837L;

	public static final String ENTITY_NAME_ADVICE = "ADVICE";

	private long adviceId = 0l;

	public static final String STOCK_NAME="STOCK_NAME";
	private String stockName;
	
	public static final String STATUS="STATUS";
	private String status;
	
	public static final String ADVICE="ADVICE";
	private String advice;
	
	public static final String REMARK = "REMARK";
	private String remark;
	
	public static final String PROFIT="PROFIT";
	private String profit;
	
	public static final String CREATED_DATE="CREATED_DATE";
	private Date createdDate;
	
	public static final String UPDATED_DATE="UPDATED_DATE";
	private Date updatedDate;
	
	public static final String PROFILE="PROFILE";
	private String profile;
	
	public long getAdviceId() {
		return adviceId;
	}
	public void setAdviceId(long adviceId) {
		this.adviceId = adviceId;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAdvice() {
		return advice;
	}
	public void setAdvice(String advice) {
		this.advice = advice;
	}
	public String getProfit() {
		return profit;
	}
	public void setProfit(String profit) {
		this.profit = profit;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public int compareTo(Advice o) {
		
		return o.createdDate.compareTo(this.createdDate);
	}
}
